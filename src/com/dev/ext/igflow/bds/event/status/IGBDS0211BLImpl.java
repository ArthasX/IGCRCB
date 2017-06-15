/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ù���Ԥ�ô�����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0211BLImpl implements WorkFlowEventHandlerBL{


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
		//��ѯ������
		List<ParticipantInfo> participants = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "�����������ݿ�");
		StatusParticipant delParticipant = new StatusParticipant(bean.getLogInfo());
		delParticipant.setStatuscode(bean.getAfstatus());
		flowSetBL.deleteStatusParticipant(delParticipant);
		if(participants != null){
			for(ParticipantInfo participant:participants){
				StatusParticipant statusParticipant = new StatusParticipant(bean.getLogInfo());
				statusParticipant.setStatuscode(bean.getAfstatus());
				statusParticipant.setRoleid(participant.getRoleid());
				statusParticipant.setUserid(participant.getUserid());
				flowSetBL.setStatusParticipant(statusParticipant);
			}
		}
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}
}
