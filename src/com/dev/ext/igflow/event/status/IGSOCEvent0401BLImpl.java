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
 * SOC���ʵʩ�ڵ�ǰ����
 * </p>
 */
public class IGSOCEvent0401BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0401BLImpl.class);
	
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
		log.debug("========���ʵʩ ǰ�������ò����ߴ���ʼ========");
		//��ӷ�������Ϣ
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatusname("���ʵʩ");
		participant.setUserid(bean.getCrtuserid());
		participant.setRoleid(bean.getCrtroleid());
		flowSetBL.setStatusParticipant(participant);
		log.debug("========���ʵʩ ǰ�������ò����ߴ������========");
	}

	/**
	 * �ƻ���ǰ�������ò����ߴ������
	 * 
	 * @param bean ������Ϣ
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
