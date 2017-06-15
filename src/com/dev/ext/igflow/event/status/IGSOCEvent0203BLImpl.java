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
 * SOC��������RFC�ڵ�ǰ�������ô�����ָ������Ա
 * </p>
 */
public class IGSOCEvent0203BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0203BLImpl.class);
	
	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
	
	/**
	 * ��ѯ�๦��API���趨
	 * 
	 * @param flowSearchBL ���¹���API���ѯ�๦��API��
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ���¹���API���趨
	 * 
	 * @param flowSetBL ���¹���API��
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ����״̬RFC�ڵ�ǰ���������ɫָ������Ա
	 * 
	 * @param bean ������Ϣ
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========RFCǰ�������ò����ߴ���ʼ========");
		//ɾ����ǰ״̬Ŀǰ�Ĳ����ߣ����½����趨
		StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
		spInfo.setStatusname("RFC");
		this.flowSetBL.deleteStatusParticipant(spInfo);
		
		String userid = this.flowSearchBL.searchPublicProcessInfo(bean
				.getLogInfo().getPrid(), "���̲�����");
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatusname("RFC");
		participant.setUserid(userid);
		participant.setRoleid(1001);
		flowSetBL.setStatusParticipant(participant);
		log.debug("========RFCǰ�������ò����ߴ������========");
	}

	/**
	 * ����״̬�������
	 * 
	 * @param bean ������Ϣ
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
