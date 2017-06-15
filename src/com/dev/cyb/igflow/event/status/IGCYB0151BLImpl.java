/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.cyb.igflow.event.status;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
/**
 * ���񹤵�����    ����ڵ�ǰ����BL
 * @author �Ž�
 *
 */
public class IGCYB0151BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	 static Log log = LogFactory.getLog(IGCYB0151BLImpl.class);
	private FlowSetBL flowSetBL;
	
	
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	public void afterTreatmentExecute(
			WorkFlowStatusEventBeanInfo workflowstatuseventbeaninfo)
			throws BLException {
	}
	/***
	 * ǰ����  
	 * ������̷�����Ϊ��ǰ�ڵ������
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)throws BLException {	
		
			//
			StatusParticipant statusParticipant = new StatusParticipant(bean.getLogInfo());
			statusParticipant.setStatusname("����");
			statusParticipant.setRoleid(bean.getCrtroleid());
			statusParticipant.setUserid(bean.getCrtuserid());
			flowSetBL.setStatusParticipant(statusParticipant);
		
		
	}

	
}
