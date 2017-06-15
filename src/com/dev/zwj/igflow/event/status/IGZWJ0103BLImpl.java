/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.zwj.igflow.event.status;

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
 * Description: ���ò�����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGZWJ0103BLImpl implements WorkFlowEventHandlerBL{
	
	/** ������API */
	protected FlowSetBL flowSetBL;

	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatusname("�������ȷ��");
		flowSetBL.deleteStatusParticipant(participant);
		participant.setUserid(bean.getCrtuserid());
		participant.setRoleid(bean.getCrtroleid());
		flowSetBL.setStatusParticipant(participant);
		participant.setStatusname("�����뿪ȷ��");
		participant.setUserid(null);
		participant.setRoleid(null);
		flowSetBL.deleteStatusParticipant(participant);
		participant.setUserid(bean.getCrtuserid());
		participant.setRoleid(bean.getCrtroleid());
		flowSetBL.setStatusParticipant(participant);
	}

}
