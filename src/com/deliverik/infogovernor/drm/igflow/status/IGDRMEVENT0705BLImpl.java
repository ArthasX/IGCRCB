package com.deliverik.infogovernor.drm.igflow.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
/**
 * ͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
 * @author zhangbo
 *2016��9��21��
 */
public class IGDRMEVENT0705BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	static Log log = LogFactory.getLog(IGDRMEVENT0705BLImpl.class);
	
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * ���������������
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		Integer prid = bean.getLogInfo().getPrid();
		//�����ַͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
		
		IGDRMEmergencyTools.changeSystemState(prid, "ҵ��ϵͳ", "1",null);
	}

}
