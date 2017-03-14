/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.ext.igflow.bds.event.status;

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

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������-���ٷ����ڵ���Ӳ�����
 * </p>
 * 
 * @author yangyining@deliverik.com
 * @version 1.0
 */
public class IGBDS0214BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {

    /** ��־����ȡ�� */
    static Log log = LogFactory.getLog(IGBDS0214BLImpl.class);

    /** ���¹���API�� */
    private FlowSetBL flowSetBL;

    /** ��ѯ�๦��API�� */
    private FlowSearchBL flowSearchBL;

    /**
     * ע����¹���API��
     * 
     * @param flowSetBL
     */
    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    /**
     * ��ѯ�๦��API���趨
     */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        
    }

    /**
     * ǰ������Ӳ�����
     */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        log.debug("========��������-���ٷ����ڵ���Ӳ����ߴ���ʼ========");
        
        
        List<ParticipantInfo> pInfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "��¼����������");
        if(pInfoList == null || pInfoList.size() <= 0){
            throw new BLException("IGPRR0102.E006", "��¼����������");
        }
        
        if(pInfoList != null && pInfoList.size() > 0){
            //��־������Ϣ�趨
            StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
            //��װ����״̬����
            participant.setStatusname("���ٷ���");
            //ɾ��ԾǨ�ڵ��ԭ�в�����
            flowSetBL.deleteStatusParticipant(participant);
            
            // ��Ӳ�����
            for(ParticipantInfo info :pInfoList){
                //��־������Ϣ�趨
                StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
                //��װ���̴�����id
                participants.setUserid(info.getUserid());
                //��װ���̴����ɫid
                participants.setRoleid(info.getRoleid());
                //��װ����״̬����
                participants.setStatusname("���ٷ���");
                //�����ɫ�Ͳ��������
                flowSetBL.setStatusParticipant(participants);
            }
        }else{
            throw new BLException("IGEWA0113.E001");
        }
        
        log.debug("========��������-���ٷ����ڵ���Ӳ����ߴ������========");
    
    }

}
