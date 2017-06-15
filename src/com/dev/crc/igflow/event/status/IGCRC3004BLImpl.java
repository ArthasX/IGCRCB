package com.dev.crc.igflow.event.status;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;

public class IGCRC3004BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	/**
	 * 变更执行节点前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		Integer prid = bean.getLogInfo().getPrid();
		//请求地址通过业务系统ID更新业务系统应急演练状态
		String desc = IGDRMEmergencyTools.getDesc(prid);
		IGDRMEmergencyTools.changeFlowSystemState(prid, "5",desc);
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		// TODO Auto-generated method stub
		Integer prid = bean.getLogInfo().getPrid();
		//请求地址通过业务系统ID更新业务系统应急演练状态
		IGDRMEmergencyTools.changeFlowSystemState(prid, "4",null);
	}

}
