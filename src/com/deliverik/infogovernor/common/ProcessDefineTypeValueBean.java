package com.deliverik.infogovernor.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;

public class ProcessDefineTypeValueBean {
	/** 记录日志 */
	private static Log log = LogFactory.getLog(ProcessDefineTypeValueBean.class);
	
	private static WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");

	/**
	 * 获取流程当前状态显示名称
	 * 
	 * @param prid 流程ID
	 * @return 当前状态显示名称
	 */
	public static String getConfigInfo(Integer prid) {
		try {
			//查询当前流程
			IG500Info process = workFlowOperationBL.searchProcessRecordByKey(prid);
			if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(process.getPrstatus())){
				return "中止";
			}else{
				return workFlowOperationBL.searchCurrentStatusName(prid);
			}
		} catch (Exception e) {
			log.error("状态显示异常", e);
			return "";
		}
	}

}
