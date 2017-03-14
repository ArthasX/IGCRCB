/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.ext.igflow.bds.event.status;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������Ϊ������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0109BLImpl implements WorkFlowEventHandlerBL{


	/** ��ѯ��api */
	protected FlowSearchBL flowSearchBL;
	
	/** ������api */
	protected FlowSetBL flowSetBL;
	
	/**
	 * ��ѯ��api�趨
	 * @param flowSearchBL ��ѯ��api
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ������api�趨
	 * @param flowSetBL ������api
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatuscode(bean.getAfstatus());
		flowSetBL.deleteStatusParticipant(participant);
		participant.setUserid(bean.getCrtuserid());
		participant.setRoleid(bean.getCrtroleid());
		flowSetBL.setStatusParticipant(participant);
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
