/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.vim.igflow.event.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;

/**
 * ��Դ����������ǰ�������ò�����
 * 
 * @author DLK)Administrator
 * @version 1.0.0
 */
public class IGVIM0206BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGVIM0206BLImpl.class);
    private FlowSearchBL flowSearchBL;
    
    /** ���¹���API�� */
    private FlowSetBL flowSetBL;

    /** �û���ɫ����BL */
    private UserRoleBL userRoleBL;

    /** ��Դ���������Ϣ��ҵ���߼� */
    protected VIM03BL vim03BL;
    
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

    /**
     * ���ø��¹���API��
     * @param flowSetBL ���¹���API��
     */
    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    /**
     * �����û���ɫ����BL
     * @param userRoleBL �û���ɫ����BL
     */
    public void setUserRoleBL(UserRoleBL userRoleBL) {
        this.userRoleBL = userRoleBL;
    }

    /**
     * ������Դ���������Ϣ��ҵ���߼�
     * @param vim03BL ��Դ���������Ϣ��ҵ���߼�
     */
    public void setVim03BL(VIM03BL vim03bl) {
        vim03BL = vim03bl;
    }

    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        
    }

    /**
     * ǰ�������ò����� 
     */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {

        log.debug("======== ��Դ����������״̬�ڵ�ǰ�������ò����ߴ���ʼ========");
        
      //��־������Ϣ�趨
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //��װ����״̬����
        participant.setStatusname("������");
        
        //ɾ��ԾǨ�ڵ��ԭ�в�����
        flowSetBL.deleteStatusParticipant(participant);
        
        List<ParticipantInfo> pInfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "������");
        
        for(ParticipantInfo info :pInfoList){
            //��־������Ϣ�趨
            StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
            
            //��װ���̴�����id
            participants.setUserid(info.getUserid());
            
            //��װ���̴����ɫid
            participants.setRoleid(info.getRoleid());
            
            //��װ����״̬����
            participants.setStatusname("������");
            
            //�����ɫ�Ͳ��������
            flowSetBL.setStatusParticipant(participants);
        }
        
        log.debug("========��Դ����������״̬�ڵ�ǰ�������ò����ߴ������========");
    }
}
