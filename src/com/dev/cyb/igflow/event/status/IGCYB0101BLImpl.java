/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.cyb.igflow.event.status;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

public class IGCYB0101BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGCYB0101BLImpl.class);
    private FlowSetBL flowSetBL;
    private FlowSearchBL flowSearchBL;

    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        log.debug("========������������Ӳ����߿�ʼ========");
        //��־������Ϣ�趨
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //��װ����״̬����
        participant.setStatusname("�������");
        //ɾ��ԾǨ�ڵ��ԭ�в�����
        flowSetBL.deleteStatusParticipant(participant);
        
        //�������ڵ���ӷ�����
        participant.setUserid(bean.getCrtuserid());
        participant.setRoleid(bean.getCrtroleid());
        this.flowSetBL.setStatusParticipant(participant);
       
//        //����к�������Ӻ����˵�����ڵ�
//        List<ParticipantInfo> p1InfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "������ȷ��");
//        if ((p1InfoList != null) && (p1InfoList.size() > 0)) {
//            for (ParticipantInfo pInfo : p1InfoList) {
//                participant = new StatusParticipant(bean.getLogInfo());
//                participant.setStatusname("�������");
//                participant.setUserid(pInfo.getUserid());
//                participant.setRoleid(pInfo.getRoleid());
//                this.flowSetBL.setStatusParticipant(participant);
//            }
//        }
//        
//        //��װ����״̬����
//        participant.setStatusname("�������");
//        //ɾ��ԾǨ�ڵ��ԭ�в�����
//        flowSetBL.deleteStatusParticipant(participant);
//        
//        //��Ӹ����˵�������ȷ�Ͻڵ�
//        List<ParticipantInfo> p2InfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "������ȷ��");
//        if ((p2InfoList != null) && (p2InfoList.size() > 0)) {
//            for (ParticipantInfo pInfo : p2InfoList) {
//                participant = new StatusParticipant(bean.getLogInfo());
//                participant.setStatusname("�������");
//                participant.setUserid(pInfo.getUserid());
//                participant.setRoleid(pInfo.getRoleid());
//                this.flowSetBL.setStatusParticipant(participant);
//            }
//        }
//        
        log.debug("========������������Ӳ����߽���========");

    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        
    }
}
