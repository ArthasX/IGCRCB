/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����ر�ǰ������ԾǨ
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0108BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��ѯ��api */
	protected FlowSearchBL flowSearchBL;
	
	/** ���̴���api */
	protected FlowOptBL flowOptBL;
	
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
	 * ���̴���api�趨
	 * @param flowOptBL ���̴���api
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * ������api�趨
	 * @param flowSetBL ������api
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ǰ����ԾǨ�����̣�
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		//ȡ������������
		Integer parPrid = flowSearchBL.searchProcessRelationForPar(bean.getLogInfo().getPrid());
		if(parPrid != null && parPrid > 0){
			WorkFlowLog logInfo = new WorkFlowLog();
			logInfo.setAuthuserid(bean.getLogInfo().getAuthuserid());
			logInfo.setComment(bean.getLogInfo().getComment());
			logInfo.setExecutorid(bean.getLogInfo().getExecutorid());
			logInfo.setExecutorRoleid(bean.getLogInfo().getExecutorRoleid());
			logInfo.setPrid(parPrid);
			List<ProcessRecordInfo> info = flowSearchBL.searchProcessInfo(parPrid, null);
			StatusParticipant participant = new StatusParticipant(logInfo);
			participant.setStatuscode(info.get(0).getPrstatus());
			participant.setRoleid(bean.getLogInfo().getExecutorRoleid());
			flowSetBL.setStatusParticipant(participant);
			flowOptBL.transitionProcess(parPrid, bean.getLogInfo().getExecutorid(), "�ύ", IGStringUtils.getCurrentDateTime());
		}
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}

