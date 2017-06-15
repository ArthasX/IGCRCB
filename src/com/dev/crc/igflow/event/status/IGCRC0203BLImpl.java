/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.igflow.event.status;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.crc.bl.task.IgalarmBL;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCondImpl;
import com.deliverik.infogovernor.crc.model.entity.IgalarmTB;

/***
 * 事件流程 - 待发起节点后处理
 * 功能： 判断是否关联告警，如果有，将事件单编号更新入告警表
 * @time 2014/07/22
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IGCRC0203BLImpl implements WorkFlowEventHandlerBL{
	
	/** 日志对象取得 */
	protected static final Log log = LogFactory.getLog(IGCRC0203BLImpl.class);
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;
	
	/** 集成告警表业务逻辑BL */
	private IgalarmBL igalarmBL;

	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * 集成告警表业务逻辑BL设置
	 * @param igalarmBL 集成告警表业务逻辑BL
	 */
	public void setIgalarmBL(IgalarmBL igalarmBL) {
		this.igalarmBL = igalarmBL;
	}

	/**
	 * 前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

	/**
	 * 后处理
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("========事件流程待发起节点后处理开始========");
		//查询表格式表单内容
		ArrayList<LinkedHashMap> alarmList = (ArrayList<LinkedHashMap>)flowSearchBL.searchPublicTableValue("告警信息", bean.getLogInfo().getPrid(), "");
		String lasttime = ""; 
		//获取告警ID
		String alarmShowId = "";
		for(int i=0;i<alarmList.size();i++){
			if(StringUtils.isEmpty(lasttime)){
				lasttime = (String) alarmList.get(i).get("触发时间");
				alarmShowId = (String) alarmList.get(i).get("告警ID");
			}else{
				String s1 = lasttime;
				String s2 = (String) alarmList.get(i).get("触发时间");
				int res = s1.compareTo(s2);
				if(res < 0){
					lasttime = (String) alarmList.get(i).get("触发时间");
					alarmShowId = (String) alarmList.get(i).get("告警ID");
				}
			}
		}
		for(int i=0;i<alarmList.size();i++){
			//获取告警ID
			String alarmId = (String) alarmList.get(i).get("告警ID");
			if(!"".equals(alarmId)){
				//告警信息查询
				IgalarmSearchCondImpl cond = new IgalarmSearchCondImpl();
				cond.setSerial(alarmId);
				cond.setLasttime((String) alarmList.get(i).get("触发时间"));
				List<IgalarmInfo> igalarms = igalarmBL.searchIgalarm(cond);
				for (IgalarmInfo igalarmInfo : igalarms) {
					IgalarmTB tb = (IgalarmTB)SerializationUtils.clone(igalarmInfo);
					//查询流程基本信息
					List<ProcessRecordInfo> infos = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), "");
					//将状态更新为关闭
					tb.setPedeventid(infos.get(0).getPrserialnum());
					/** 
					 * 2014-9-9 wanglei
					 * 常熟农商行信息科技风险管理平台需求调整列表_20140901.xls
					 * 47-1
					 * 
					 * 	多条告警生成事件后，合并为一条；
					 * （例如20条告警，生成1条事件后，只显示一条总的告警），点击该总告警，
					 * 	可以查看到所有合并的告警信息，对于关联到该事件流程的告警，关联后也
					 * 	需要合并进来】
					 */
					// IsShow字段值为0时显示，为1时不显示
					if(!tb.getLasttime().equals(lasttime)){
						tb.setIsShow("1");
					}else{
						if(!tb.getSerial().equals(alarmShowId)){
							tb.setIsShow("1");
						}
					}
					/** 
					 * 2014-9-16 wanglei
					 * 常熟农商银行信息科技风险管理平台测试问题列表_0916
					 * 132
					 * 133
					 * 	多条告警信息合并成一条事件单后，应该只显示一条，但是现在显示了两条，（这两条告警的触发时间是一样的，，但是告警编号不一样）
					 * 生成事件单后，“”是否生成事件单“”应该为是，现在还是为否
					 */
					tb.setIsCreateOrder("1");
					igalarmBL.updateIgalarm(tb);
				}
			}
		}
		log.debug("========事件流程待发起节点后处理结束========");
	}

}
