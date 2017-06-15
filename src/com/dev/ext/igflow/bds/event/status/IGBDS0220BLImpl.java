/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

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
 * Description: Ԥ�ô�����
 * </p>
 * 
 * @author zhangze@deliverik.com
 * @version 1.0
 */
public class IGBDS0220BLImpl implements WorkFlowEventHandlerBL{

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
		
		//��д�������������������ͬһ��
//		List<ParticipantInfo> listOfParticipantInfos = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "�������");
		
		List<ParticipantInfo> participants = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		
		if(CollectionUtils.isNotEmpty(participants)){
			
			for (ParticipantInfo participantInfo : participants) {
				//ָ������ɫ��ɾ��
				if(StringUtils.isEmpty(participantInfo.getUserid())){
					StatusParticipant del = new StatusParticipant(bean.getLogInfo());
					del.setStatuscode(bean.getAfstatus());
					del.setRoleid(participantInfo.getRoleid());
					flowSetBL.deleteStatusParticipant(del);
				}
				
			}
		}
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

}
