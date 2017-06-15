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
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * SOC����رսڵ�ǰ����
 * </p>
 */
public class IGSOCEvent0405BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0405BLImpl.class);
	
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
		log.debug("========����ر�ǰ�������ò����ߴ���ʼ========");
		//��ӷ�����Ϊ����ر���
//		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
//		//participant.setStatusname("����ر� ");
//		participant.setUserid(bean.getCrtuserid());
//		participant.setRoleid(bean.getCrtroleid());
//		flowSetBL.setStatusParticipant(participant);
		//String userid = this.flowSearchBL.searchPublicProcessInfo(bean
				//.getLogInfo().getPrid(), "һ������");
		//String userid1 = this.flowSearchBL.searchPublicProcessInfo(bean
		//		.getLogInfo().getPrid(), "��������");
		//String userid2 = this.flowSearchBL.searchPublicProcessInfo(bean
				//.getLogInfo().getPrid(), "��������");
		//List<ParticipantInfo> yi = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "һ������");
		List<ParticipantInfo> san = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "��������");
		PublicProcessInfoValue fv = new PublicProcessInfoValue(bean.getLogInfo());
		fv.setFormname("������ʶ");
		fv.setFormvalue("1");
		
		
		if(san != null && san.size() > 0){
			fv.setFormvalue("3");
		}
		
		
		flowSetBL.setPublicProcessInfoValue(fv);
		log.debug("========����ر�ǰ�������ò����ߴ������========");
	}

	/**
	 * �ƻ���ǰ�������ò����ߴ������
	 * 
	 * @param bean ������Ϣ
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
