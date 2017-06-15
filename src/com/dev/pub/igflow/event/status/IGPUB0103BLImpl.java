/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.pub.igflow.event.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������Ϊ������ǰ����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPUB0103BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGPUB0103BLImpl.class);
	
	/** ������API */
	protected FlowSetBL flowSetBL;

	/**
	 * ������API�趨
	 * @param flowSetBL ������API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("================��������Ϊ��ǰ�ڵ㴦�������ò�����ʼ================");
		//ʵ���������˶���
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatuscode(bean.getAfstatus());
		//ɾ����ǰ�ڵ������
		flowSetBL.deleteStatusParticipant(participant);
		//���ô����ɫΪ�����ɫ
		participant.setRoleid(bean.getCrtroleid());
		//���ô�����Ϊ������
		participant.setUserid(bean.getCrtuserid());
		//���õ�ǰ�ڵ㴦����
		flowSetBL.setStatusParticipant(participant);
		log.debug("================��������Ϊ��ǰ�ڵ㴦�������ò�������================");
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
