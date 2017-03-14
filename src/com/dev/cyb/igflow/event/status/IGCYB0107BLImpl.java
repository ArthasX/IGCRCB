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
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

public class IGCYB0107BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGCYB0107BLImpl.class);
    /** ���¹���API�� */
    private FlowSetBL flowSetBL;
    
    /** ��ѯ�๦��API�� */
    private FlowSearchBL flowSearchBL;
    
    /**�û���ɫ����BL*/
    private UserRoleBL userRoleBL;
    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

    /**
     * ע���û���ɫ����BL
     * 
     * @param userRoleBL
     */
    public void setUserRoleBL(UserRoleBL userRoleBL) {
        this.userRoleBL = userRoleBL;
    }
    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
       
    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        log.debug("========����������ɽڵ�����������̷�����ԱΪ �����߿�ʼ========");

        List<ParticipantInfo> pInfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "��������");
        
        Integer roleid = pInfoList.get(0).getRoleid(); 
        
        //��װ��ѯ���������趨
        UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
        
        //��װ��ѯ����Ϊ��ɫid
        cond.setRoleid(roleid);
        
        //����roleid��ý�ɫ�µ�������
        List<UserRoleInfo> roleList = userRoleBL.searchUserRoleVW(cond);
        
        //��־������Ϣ�趨
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //��װ����״̬����
        participant.setStatusname("��������");
        
        //ɾ��ԾǨ�ڵ��ԭ�в�����
        flowSetBL.deleteStatusParticipant(participant);
        
        for(UserRoleInfo info :roleList){
            //��־������Ϣ�趨
            StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
            
            //��װ���̴�����id
            participants.setUserid(info.getUserid());
            
            //��װ���̴����ɫid
            participants.setRoleid(info.getRoleid());
            
            //��װ����״̬����
            participants.setStatusname("��������");
            
            //�����ɫ�Ͳ��������
            flowSetBL.setStatusParticipant(participants);
        }
        
        log.debug("========����������ɽڵ�����������̷�����ԱΪ �����߽���========");
    }
}
