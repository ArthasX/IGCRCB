/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.ext.igflow.bds.event.status;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ⷢ��������̹ر�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0206BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��ѯ��api */
	protected FlowSearchBL flowSearchBL;
	
	/** ���̴���api */
	protected FlowOptBL flowOptBL;

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
		//��ѯ��������Ϣ
		Integer parPrid = flowSearchBL.searchProcessRelationForPar(bean.getLogInfo().getPrid());
		if(parPrid != null && parPrid > 0){
			//ԾǨ��������Ϣ
			flowOptBL.transitionProcess(parPrid, bean.getLogInfo().getExecutorid(), "�ύ", IGStringUtils.getCurrentDateTime());
		}
	}

}
