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
 * ���˹�������    ����ڵ�ǰ����BL
 * @author �Ž�
 *
 */
public class IGCYB0152BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	 static Log log = LogFactory.getLog(IGCYB0152BLImpl.class);
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
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {

        // ��־������Ϣ�趨
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());

        // ��װ����״̬����
        participant.setStatusname("ȷ��");
        // ɾ��ԾǨ�ڵ��ԭ�в�����
        flowSetBL.deleteStatusParticipant(participant);

        //
        StatusParticipant statusParticipant = new StatusParticipant(bean.getLogInfo());
        statusParticipant.setStatusname("ȷ��");
        statusParticipant.setRoleid(bean.getCrtroleid());
        statusParticipant.setUserid(bean.getCrtuserid());
        flowSetBL.setStatusParticipant(statusParticipant);

    }

	
}
