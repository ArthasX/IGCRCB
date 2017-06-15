/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.dev.ext.igflow.event.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * SOC����ƻ��нڵ�ǰ����
 * </p>
 */
public class IGSOCEvent0301BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0301BLImpl.class);
	
	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	/** �����๦��API�� */
	private FlowSetBL flowSetBL;
	
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
	 * �ƻ���ǰ�������ò����ߴ������
	 * 
	 * @param bean ������Ϣ
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========�ƻ���ǰ�������ò����ߴ���ʼ========");
		//ɾ����ǰ״̬Ŀǰ�Ĳ����ߣ����½����趨
		StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
		spInfo.setStatusname("�ƻ���");
		this.flowSetBL.deleteStatusParticipant(spInfo);
		
		String userid = this.flowSearchBL.searchPublicProcessInfo(bean
				.getLogInfo().getPrid(), "���̲�����");
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatusname("�ƻ���");
		participant.setUserid(userid);
		participant.setRoleid(1001);
		flowSetBL.setStatusParticipant(participant);
		log.debug("========�ƻ���ǰ�������ò����ߴ������========");
	}

	/**
	 * �ƻ���ǰ�������ò����ߴ������
	 * 
	 * @param bean ������Ϣ
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
