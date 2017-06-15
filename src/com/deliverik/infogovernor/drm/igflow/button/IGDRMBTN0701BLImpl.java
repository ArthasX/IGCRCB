package com.deliverik.infogovernor.drm.igflow.button;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
/**
 * 通过业务系统ID更新业务系统应急演练状态
 * @author zhangbo
 *2016年9月21日
 */
public class IGDRMBTN0701BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL{

	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo info)
			throws BLException {
		Integer prid = info.getLogInfo().getPrid();
		//请求地址通过业务系统ID更新业务系统应急演练状态
		IGDRMEmergencyTools.changeSystemState(prid, "业务系统", "0",null);
	}

}
