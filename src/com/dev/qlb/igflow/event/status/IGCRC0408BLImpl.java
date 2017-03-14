package com.dev.qlb.igflow.event.status;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckResultBL;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckResultTB;

/**
 * 
 * ���ܣ�ָ�ɼ�鹤��������ڵ����ѡ�������Ա���������ɽڵ㣬���ѡ�����ˣ�������ִ�нڵ�
 * @author ʷ����   2014-9-9
 */
public class IGCRC0408BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** ��־����ȡ�� */
	static Log log = LogFactory.getLog(IGCRC0408BLImpl.class);

	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	/** ���ռ����ϢBL */
	protected RiskCheckResultBL riskCheckResultBL;

	/**
	 * @param ��ѯ�๦��API��
	 *            the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * @param riskCheckResultBL the riskCheckResultBL to set
	 */
	public void setRiskCheckResultBL(RiskCheckResultBL riskCheckResultBL) {
		this.riskCheckResultBL = riskCheckResultBL;
	}

	/** ǰ���� */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

	/** ���� */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		 log.debug("========ָ�ɹ������̲�������ǰ�������ò����ߴ���ʼ========");
	        setNextPoint(bean);
	        	        
			log.debug("========ָ�ɹ������̲�������ǰ�������ò����ߴ������========");
	}
	
	/**
	 * ������һ���ڵ�
	 * @param bean
	 */
	private void setNextPoint(WorkFlowStatusEventBeanInfo bean) throws BLException{
		// TODO Auto-generated method stub
		String rcrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��Ա");
//		String people = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "������");
        if(StringUtils.isNotEmpty(rcrid)){
//        	rcrid = rcrid.split("#")[2];
        	RiskCheckResult rcrBean = riskCheckResultBL.searchRiskCheckResultByKey(Integer.parseInt(rcrid));
        	if(rcrBean!=null){
        		RiskCheckResultTB rcrTB = (RiskCheckResultTB)SerializationUtils.clone(rcrBean);
        		rcrTB.setAssignprid(bean.getLogInfo().getPrid());
//        		rcrTB.setRcrusername(people);
        		riskCheckResultBL.updateRiskCheckResult(rcrTB);
        	}			
        }        
	}
}