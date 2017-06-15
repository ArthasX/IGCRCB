/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.fxk.bl.IGFXK03BLType;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台-风险计划待发起节点处理
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @version 1.0
 */
public class IGFXK0301BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGFXK0301BLImpl.class);
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;
	
	/** 更新类API */
	protected FlowSetBL flowSetBL;

	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 更新类API设定
	 * @param flowSetBL 更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("==============风险计划待发起节点生成计划编号操作开始==============");
		//获取流程主键
		Integer prid = bean.getLogInfo().getPrid();
		//获取编号信息
		String number = flowSearchBL.searchPublicProcessInfo(prid, "计划编号");
		
		//当计划编号不存在时
		if(StringUtils.isEmpty(number)){
			//获取当前日期
			String nowDate = IGStringUtils.getCurrentDate();
			//查询风险计划当天发起的数量
			StringBuffer startTime = new StringBuffer();
			startTime.append(nowDate).append(" 00:00");
			List<ProcessRecordInfo> lst_process = flowSearchBL.searchProcessInfo(IGFXK03BLType.PROCESS_RISK_PDID, startTime.toString(), null);
			if(lst_process != null ){
				//将当前流程从查询到的流程集合中移除
				for (ProcessRecordInfo processRecord : lst_process) {
					if(processRecord.getPrid().equals(prid)){
						lst_process.remove(processRecord);
						break;
					}
				}
			}
			//生成风险计划编号
			StringBuffer riskNum = new StringBuffer();
			riskNum.append("PL");
			riskNum.append(IGStringUtils.getCurrentDate().replaceAll("/", ""));
			if(lst_process != null ){
				//生成编号时，判断是否需要在编号前补“0”
				if(lst_process.size() > 8){
					riskNum.append(lst_process.size() + 1);
				}else{
					riskNum.append("0").append(lst_process.size()+1);
				}
			}else{
				riskNum.append("01");
			}
			
			//实例化表单值对象
			PublicProcessInfoValue value = new PublicProcessInfoValue(bean.getLogInfo());
			value.setFormname("计划编号");
			value.setFormvalue(riskNum.toString());
			//设置表单值
			flowSetBL.setPublicProcessInfoValue(value);
		}
		
		
		log.debug("==============风险计划待发起节点生成计划编号操作结束==============");
	}

}
