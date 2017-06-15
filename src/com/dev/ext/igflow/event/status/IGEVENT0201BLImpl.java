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
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * ����ƻ���˽ڵ�ǰ�������ò�����
 * ������״̬�Ĳ����߼��������״̬�Ĳ��������õ��ƻ���˽ڵ���
 * </p>
 */
public class IGEVENT0201BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	
	static Log log = LogFactory.getLog(IGEVENT0201BLImpl.class);
	
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
	 * ����״̬ǰ�������
	 * 
	 * @param bean ������Ϣ
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========�ƻ����ǰ�������ò����ߴ���ʼ========");
		//ɾ����״̬Ŀǰ�Ĳ����ߣ����½����趨
		StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
		spInfo.setStatusname("�ƻ����");
		this.flowSetBL.deleteStatusParticipant(spInfo);
		
		//��ѯ����״̬�Ĳ����ߣ������ˣ�
		List<ParticipantInfo> p1InfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "����");
		for(ParticipantInfo pInfo : p1InfoList){
			StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
			participant.setStatusname("�ƻ����");
			participant.setUserid(pInfo.getUserid());
			participant.setRoleid(pInfo.getRoleid());
			flowSetBL.setStatusParticipant(participant);
		}
		
		//��ѯ�������״̬�Ĳ�����
		List<ParticipantInfo> p2InfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "�������");
		for(ParticipantInfo pInfo : p2InfoList){
			StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
			participant.setStatusname("�ƻ����");
			participant.setUserid(pInfo.getUserid());
			participant.setRoleid(pInfo.getRoleid());
			flowSetBL.setStatusParticipant(participant);
		}
		
		
		log.debug("========�ƻ����ǰ�������ò����ߴ������========");
	}

	/**
	 * ����״̬�������
	 * 
	 * @param bean ������Ϣ
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
