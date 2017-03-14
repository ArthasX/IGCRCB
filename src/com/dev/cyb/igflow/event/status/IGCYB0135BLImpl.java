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
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

public class IGCYB0135BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGCYB0135BLImpl.class);
    /** ���¹���API�� */
    private FlowSetBL flowSetBL;
    
    /**�û���ɫ����BL*/
    private UserRoleBL userRoleBL;

    /**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    /**
     * @param �û���ɫ����BL the userRoleBL to set
     */
    public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	 log.debug("========���������������̸�λ�����������ڵ���ӷ����˽�ɫ������Ϊ�����߿�ʼ========");

         //��־������Ϣ�趨
         StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
         
         //��װ����״̬����
         participant.setStatusname("��λ����������");
         //ɾ��ԾǨ�ڵ��ԭ�в�����
         flowSetBL.deleteStatusParticipant(participant);
         
         UserRoleVWSearchCondImpl urVWCond =  new UserRoleVWSearchCondImpl();
         if(bean.getCrtroleid().equals(1024)){
        	 urVWCond.setRoleid(1021);
         }
         if(bean.getCrtroleid().equals(1023)){
        	 urVWCond.setRoleid(1020);
         }
         if(bean.getCrtroleid().equals(1022)){
        	 urVWCond.setRoleid(1019);
         }
         List<UserRoleInfo> urList = userRoleBL.searchUserRoleVW(urVWCond);
         for (UserRoleInfo userRoleInfo : urList) {
        	 StatusParticipant participant1 = new StatusParticipant(bean.getLogInfo());
        	 participant1.setStatusname("��λ����������");
        	 participant1.setUserid(userRoleInfo.getUserid());		// ��ɫ������id
        	 participant1.setRoleid(userRoleInfo.getRoleid());
        	 this.flowSetBL.setStatusParticipant(participant1);
		}
        log.debug("========���������������̸�λ�����������ڵ���ӷ����˽�ɫ������Ϊ�����߽���========");
    }
}
