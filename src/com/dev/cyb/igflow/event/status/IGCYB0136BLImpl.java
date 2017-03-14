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

public class IGCYB0136BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGCYB0136BLImpl.class);
    /** ���¹���API�� */
    private FlowSetBL flowSetBL;

    /**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	 log.debug("========������������������˽ڵ���ӷ�����Ϊ��˽ڵ�����߿�ʼ========");

         //��־������Ϣ�趨
         StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
         
         //��װ����״̬����
         participant.setStatusname("�����뿪ȷ��");
         //ɾ��ԾǨ�ڵ��ԭ�в�����
         flowSetBL.deleteStatusParticipant(participant);
         
         StatusParticipant participant1 = new StatusParticipant(bean.getLogInfo());
         participant1.setStatusname("�����뿪ȷ��");
         participant1.setUserid(bean.getCrtuserid());
         participant1.setRoleid(bean.getCrtroleid());
         this.flowSetBL.setStatusParticipant(participant1);
         
         log.debug("========������������������˽ڵ���ӷ�����Ϊ��˽ڵ�����߽���========");
    }
}
