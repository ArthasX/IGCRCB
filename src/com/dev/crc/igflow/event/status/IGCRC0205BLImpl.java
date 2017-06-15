/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.igflow.event.status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.crc.bl.task.IgalarmBL;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCondImpl;
import com.deliverik.infogovernor.crc.model.entity.IgalarmTB;

/***
 * 事件流程 - 关闭节点后处理
 * 功能： 判断是否关联告警，如果有，将事相关告警状态修改为关闭
 * @time 2014/09/04
 * @author wanglei
 * @version 1.0
 * @mail wanglei@deliverik.com
 */
public class IGCRC0205BLImpl implements WorkFlowEventHandlerBL{
	
	/** 日志对象取得 */
	protected static final Log log = LogFactory.getLog(IGCRC0205BLImpl.class);
	
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("========事件流程关闭节点后处理开始========");
		//查询表格式表单内容
		ArrayList<LinkedHashMap> alarmList = (ArrayList<LinkedHashMap>)flowSearchBL.searchPublicTableValue("告警信息", bean.getLogInfo().getPrid(), "");
		String var = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "故障原因");
		if(StringUtils.isEmpty(var)){
			var = "";
		}
		for(int i=0;i<alarmList.size();i++){
			//获取告警ID
			String alarmId = (String) alarmList.get(i).get("告警ID");
			if(StringUtils.isNotEmpty(alarmId)){
				//告警信息查询
				IgalarmSearchCondImpl cond = new IgalarmSearchCondImpl();
				cond.setSerial(alarmId);
				cond.setLasttime((String) alarmList.get(i).get("触发时间"));
				List<IgalarmInfo> igalarms = igalarmBL.searchIgalarm(cond);
				for (IgalarmInfo igalarmInfo : igalarms) {
					IgalarmTB tb = (IgalarmTB)SerializationUtils.clone(igalarmInfo);
					
					//在流程关闭之前，修复告警来了，那么该告警记录为自动修复  by wangxing 2015/11/17
					if("0".equals(tb.getStatus())){
						tb.setStatus("2");
						SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						tb.setRecoveryTime(df.format(new Date()));
					}
					
					//如果描述+故障原因的长度超过1000，截取前996位+'...'
					String description = "";
					if(StringUtils.isEmpty(tb.getDescription())){
						description = var;
					}else{
						description = tb.getDescription() + var;
					}
					if(description.length()>1000){
						description = description.substring(0,995)+"...";
					}
					tb.setDescription(description);
					igalarmBL.updateIgalarm(tb);
				}
			}
		}
		log.debug("========事件流程关闭节点后处理结束========");
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
