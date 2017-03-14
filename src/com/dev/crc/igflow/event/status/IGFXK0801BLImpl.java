package com.dev.crc.igflow.event.status;

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

public class IGFXK0801BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** ��־����ȡ�� */
	static Log log = LogFactory.getLog(IGFXK0801BLImpl.class);

	/** ���¹���API�� */
	private FlowSetBL flowSetBL;

	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;

	/** ִ�й��� */
	private String STATUSNAME_ZXGZ = "ִ�й���";

	/**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * @param ��ѯ�๦��API��
	 *            the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/** ǰ���� */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

	/** ���� */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		 log.debug("========ָ�ɹ������̲�������ǰ�������ò����ߴ���ʼ========");

		    //��־������Ϣ�趨
	        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
	        
	        //��װ����״̬����
	        participant.setStatusname(STATUSNAME_ZXGZ);
	        
	        //ɾ��ԾǨ�ڵ��ԭ�в�����
	        flowSetBL.deleteStatusParticipant(participant);
	        
	        // ���ò���������
	        setParticipant(bean);
	        
			log.debug("========ָ�ɹ������̲�������ǰ�������ò����ߴ������========");
	}
	/**
	 * ���ô�����
	 * @param bean
	 * @param applevel
	 * @param roleid
	 * @throws BLException
	 */
	private void setParticipant(WorkFlowStatusEventBeanInfo bean) throws BLException {
	    
		List<ParticipantInfo> ppList = flowSearchBL.searchPublicParticipantFormValue(bean.getLogInfo().getPrid(), "������");
		
	    if (ppList == null || ppList.size() == 0) {
	        throw new BLException("IGEWA0107.E001");
	    }
	    for (ParticipantInfo participantInfo : ppList) {
			
	        //��־������Ϣ�趨
	        StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
	      
	        //��װ����״̬����
	        participants.setStatusname(STATUSNAME_ZXGZ);
	        
	        //��װ���̴�����id
	        participants.setUserid(participantInfo.getUserid());
	      
	        //��װ���̴����ɫid
	        participants.setRoleid(participantInfo.getRoleid());
	      
	        //�����ɫ�Ͳ��������
	        flowSetBL.setStatusParticipant(participants);
	
	    }
	}
}