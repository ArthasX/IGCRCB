/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
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

/**
 * <p>
 * SOC�������봦��ڵ�ǰ����
 * </p>
 */
public class IGSOCEvent0501BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0501BLImpl.class);
	
	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	/** �����๦��API�� */
	private FlowSetBL flowSetBL;
	
	protected UserRoleBL userRoleBL;
	
	/**
	 * @param userRoleBL the userRoleBL to set
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 * �����๦��API���趨
	 * 
	 * @param flowSetBL ���¹���API���ѯ�๦��API��
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
	 * ��ѯ�๦��API���趨
	 * 
	 * @param flowSearchBL ���¹���API���ѯ�๦��API��
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ��������ǰ�������ò����ߴ������
	 * 
	 * @param bean ������Ϣ
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========��������ǰ�������ò����ߴ���ʼ========");
		//ɾ����ǰ״̬Ŀǰ�Ĳ����ߣ����½����趨
		StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
		spInfo.setStatusname("���ݴ���");
		this.flowSetBL.deleteStatusParticipant(spInfo);
				
		//����roleid��ý�ɫ�µ�������
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoleid(161);//���ݴ����ɫid
		List<UserRoleInfo> roleList=userRoleBL.searchUserRoleVW(cond);
		
		for(UserRoleInfo pInfo : roleList){
			StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
			participant.setStatusname("���ݴ���");
			participant.setUserid(pInfo.getUserid());
			participant.setRoleid(pInfo.getRoleid());
			flowSetBL.setStatusParticipant(participant);
		}
		log.debug("========��������ǰ�������ò����ߴ������========");
	}

	/**
	 * �ƻ���ǰ�������ò����ߴ������
	 * 
	 * @param bean ������Ϣ
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
