/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;

/**
 * 组内流程发起处理BL
 */
public class WorkFlowGroupProcessLaunchBLImpl extends BaseBLImpl implements WorkFlowGroupProcessLaunchBL {
	
	/** 流程处理功能API */
	public FlowOptBL flowOptBL;
	
	/**
	 * 流程处理功能API设定
	 * @param flowOptBL 流程处理功能API
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * 组内流程发起处理
	 * 
	 * @return 流程ID
	 * @throws BLException
	 */
	public final Integer launchProcess(Integer groupID, String groupDefID, String pdid, String title, 
			String executorID, Integer executorRoleID) throws BLException {
		//日志信息
    	WorkFlowLog logInfo = new WorkFlowLog();
    	logInfo.setAuthuserid(null);
    	logInfo.setExecutorid(executorID);
    	//流程信息
		ProcessRecord processRecord = new ProcessRecord(logInfo);
		//暂不校验流程定义是否停用???????????????????????????????????????????
		processRecord.setDefid(pdid);
		logInfo.setExecutorRoleid(executorRoleID);
		processRecord.setLogInfo(logInfo);
		processRecord.setTitle(title);
		//processRecord.setDescription(processGroupInfo.getDescription());
		processRecord.setDefstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//流程定义必须启用状态
		processRecord.setGroupID(groupID);//流程组实例ID
		processRecord.setGroupDefID(groupDefID);//流程组定义ID
		
		//设置自定义流程信息
		setProcessRecord(processRecord);
		
		//发起流程
		return flowOptBL.initProcessAction(processRecord);
	}
	
	/**
	 * 设置流程发起参数信息，可重写
	 * 
	 * @throws BLException
	 */
	public void setProcessRecord(ProcessRecord processRecord) throws BLException {
		
	};

}
