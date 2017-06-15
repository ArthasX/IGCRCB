package com.dev.crc.igflow.event.status;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;

public class IGCRC3004BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	/**
	 * ���ִ�нڵ�ǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		Integer prid = bean.getLogInfo().getPrid();
		//�����ַͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
		String desc = IGDRMEmergencyTools.getDesc(prid);
		IGDRMEmergencyTools.changeFlowSystemState(prid, "5",desc);
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		// TODO Auto-generated method stub
		Integer prid = bean.getLogInfo().getPrid();
		//�����ַͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
		IGDRMEmergencyTools.changeFlowSystemState(prid, "4",null);
	}

}
