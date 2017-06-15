/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.ext.igflow.bds.event.button;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���𷢲�����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0104BLImpl implements WorkFlowStatusButtonHandlerBL{
	
	
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

	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo info)
			throws BLException {
			List<ProcessRecordInfo> processInfos = flowSearchBL.searchProcessInfo(info.getLogInfo().getPrid(), null);
		ProcessRecord record = new ProcessRecord(info.getLogInfo());
		record.setCrtuserid(info.getLogInfo().getExecutorid());
		record.setDefid("0106101");
		record.setTitle(processInfos.get(0).getPrpdname() + "_" + processInfos.get(0).getPrtitle() + "_����ķ���");
		record.setDescription(processInfos.get(0).getPrpdname() + "_" + processInfos.get(0).getPrtitle() + "_����ķ���");
		record.setRoleid(info.getLogInfo().getExecutorRoleid());
		Integer prid = flowOptBL.initProcessAction(record);
		flowSetBL.setProcessRelation(info.getLogInfo().getPrid(), prid);
	}

}
