/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������ά�����о���ά
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0205BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��ѯ��api */
	protected FlowSearchBL flowSearchBL;
	
	/** ���̴���api */
	protected FlowOptBL flowOptBL;
	
	/** ������api */
	protected FlowSetBL flowSetBL;
	
	/** ��BL */
	protected IG500BL ig500BL;
	
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
	 * ��BL�趨
	 * @param ig500BL ��BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * ǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		String flag = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�Ƿ����о���ά");
		if("��".equals(flag)){
			List<ProcessRecordInfo> processInfos = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null);
			ProcessRecord record = new ProcessRecord(bean.getLogInfo());
			record.setCrtuserid(bean.getLogInfo().getExecutorid());
			record.setDefid("0128001");
			record.setTitle(processInfos.get(0).getPrtitle() + "�ϱ����о���ά");
			record.setDescription(processInfos.get(0).getPrtitle() + "�ϱ����о���ά");
			record.setRoleid(bean.getLogInfo().getExecutorRoleid());
			Integer prid = flowOptBL.initProcessAction(record);
			flowSetBL.setProcessRelation(bean.getLogInfo().getPrid(), prid);
			IG500Info ig500 = ig500BL.searchIG500InfoByKey(prid);
			IG500TB ig500TB = (IG500TB) SerializationUtils.clone(ig500);
			ig500TB.setProrgid("0002001");
			ig500TB.setProrgname("�оֻ���");
			ig500BL.updateIG500Info(ig500TB);
		}
	}

}
