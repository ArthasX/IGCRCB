/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.dev.ext.igflow.event.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * SOC��������"������"�ڵ�ǰ�������ô�����ָ������Ա
 * </p>
 */
public class IGSOCEvent0101BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0101BLImpl.class);
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
	
	/**
	 * ���¹���API���趨
	 * 
	 * @param flowSetBL ���¹���API��
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
	 * ����״̬ǰ�������
	 * 
	 * @param bean ������Ϣ
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========������ǰ�������ò����ߴ���ʼ========");
		//ɾ����״̬Ŀǰ�Ĳ����ߣ����½����趨
		StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
		spInfo.setStatusname("������");
		this.flowSetBL.deleteStatusParticipant(spInfo);
		
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatusname("������");
		participant.setUserid(bean.getCrtuserid());
		participant.setRoleid(bean.getCrtroleid());
		flowSetBL.setStatusParticipant(participant);
		log.debug("========������ǰ�������ò����ߴ������========");
	}

	/**
	 * ����״̬�������
	 * 
	 * @param bean ������Ϣ
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}