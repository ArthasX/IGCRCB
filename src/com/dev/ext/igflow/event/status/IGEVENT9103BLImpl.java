package com.dev.ext.igflow.event.status;

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

public class IGEVENT9103BLImpl extends BaseBLImpl implements
WorkFlowEventHandlerBL{
	
	/** ��־����ȡ�� */
	static Log log = LogFactory.getLog(IGEVENT9103BLImpl.class);
	
	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	/** �û���ɫ����BL */
	private UserRoleBL userRoleBL;
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
	
	/**
	 * ע��flowSearchBL
	 * 
	 * @param flowSearchBL
	 */
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
	
	/**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ǰ������Ӳ�����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	    
	    log.debug("========��������ǰ�������ò����ߴ���ʼ========");
	    
	    //ԾǨ�ڵ�Ĳ�������Ϣȡ��
		List<ParticipantInfo> pInfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "������");
		
        //��־������Ϣ�趨
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //��װ����״̬����
        participant.setStatusname("��˹���");
        
        //ɾ��ԾǨ�ڵ��ԭ�в�����
        flowSetBL.deleteStatusParticipant(participant);
        
        int oldroleid = 0;
        
		for (ParticipantInfo ppInfo : pInfoList) {
		    
		    //ԾǨ�ڵ�Ĳ�����roleidȡ��
		    int roleidF = ppInfo.getRoleid();   
		    
		    if (roleidF == oldroleid) {
		        continue;
		    } else {
		        oldroleid = roleidF;
		    }
		    
		    //��װ��ѯ���������趨
		    UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		    
		    //��װ��ѯ����Ϊ��ɫid
		    cond.setRoleid(roleidF);
		    
		    //��װ��ѯ����Ϊ��ɫ������
		    //cond.setRolemanager(true);
		    
		    //��ý�ɫ������
		    List<UserRoleInfo> roleList = userRoleBL.searchUserRoleVW(cond);

		    //������ɫ���û���Ϣ
		    if (roleList != null && roleList.size() > 0) {

	            //����ԾǨ�ڵ�Ĳ�����
	            for(UserRoleInfo role :roleList){
	                
	                //��־������Ϣ�趨
	                StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
	                
	                //��װ����״̬����
	                participants.setStatusname("��˹���");
	                
	                //��װ���̴�����id
	                participants.setUserid(role.getUserid());
	                
	                //��װ���̴����ɫid
	                participants.setRoleid(roleidF);
	                
	                //�����ɫ�Ͳ��������
	                flowSetBL.setStatusParticipant(participants);
	            }
		    } else {
		        throw new BLException("IGPRR0102.E011", pInfoList.get(0)
	                    .getRolename());
		    }
		}

		log.debug("========��������ǰ�������ò����ߴ������========");

	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		

	}
}
