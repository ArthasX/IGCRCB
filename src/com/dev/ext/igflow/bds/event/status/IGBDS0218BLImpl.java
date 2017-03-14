/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

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
public class IGBDS0218BLImpl implements WorkFlowEventHandlerBL{

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

	/*
	 * 
	 * ���ݵ�ǰ����pridȡ�ô�����ڵ㴦����Ϊ��ǰ�ڵ�Ĵ�����[��ͬ]
	 * �о�����,��������
	 * 
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
		//���ݵ�ǰ����pridȡ�ô�����ڵ㴦����Ϊ��ǰ�ڵ�Ĵ�����[��ͬ]
		
		//������ڵ㴦����
		List<ParticipantInfo> listOfParticipantInfos = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "������");
		
		//������ڵ�ֻ��һ����
		if(CollectionUtils.isNotEmpty(listOfParticipantInfos)){
			StatusParticipant del = new StatusParticipant(bean.getLogInfo());
			del.setStatuscode(bean.getAfstatus());
			flowSetBL.deleteStatusParticipant(del);
			
			StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
			participant.setRoleid(listOfParticipantInfos.get(0).getRoleid());
			participant.setUserid(listOfParticipantInfos.get(0).getUserid());
			participant.setStatuscode(bean.getAfstatus());
			flowSetBL.setStatusParticipant(participant);
			
		}
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

}
