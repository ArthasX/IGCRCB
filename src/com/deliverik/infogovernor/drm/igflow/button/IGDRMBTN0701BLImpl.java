package com.deliverik.infogovernor.drm.igflow.button;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
/**
 * ͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
 * @author zhangbo
 *2016��9��21��
 */
public class IGDRMBTN0701BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL{

	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo info)
			throws BLException {
		Integer prid = info.getLogInfo().getPrid();
		//�����ַͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
		IGDRMEmergencyTools.changeSystemState(prid, "ҵ��ϵͳ", "0",null);
	}

}
