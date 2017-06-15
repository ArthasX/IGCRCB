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

public class IGCYB0108BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGCYB0108BLImpl.class);
    private FlowSetBL flowSetBL;

    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        log.debug("========�������ɽ�������ӵ�ǰ��ΪĬ������˿�ʼ========");
        
        //��־������Ϣ�趨
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //��װ����״̬����
        participant.setStatusname("�쵼���");
        //ɾ��ԾǨ�ڵ��ԭ�в�����
        flowSetBL.deleteStatusParticipant(participant);
        
        StatusParticipant participant1 = new StatusParticipant(bean.getLogInfo());
        participant1.setStatusname("�쵼���");
        participant1.setUserid(bean.getLogInfo().getExecutorid());
        participant1.setRoleid(bean.getLogInfo().getExecutorRoleid());
        this.flowSetBL.setStatusParticipant(participant1);
        
        log.debug("========�������ɽ�������ӵ�ǰ��ΪĬ������˿�ʼ========");
    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }
}
