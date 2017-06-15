/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.ext.igflow.event.status;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckResultBL;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckResultTB;

/**
 * ����������� - �����ɣ��ڵ�ǰ�������������ͬ�������֮��Ĺ�ϵ
 * @author Administrator
 *
 */
public class IGEVENT9904BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGEVENT9904BLImpl.class);
	
    /** ���̴���BL */
    private WorkFlowOperationBL workFlowOperationBL;
	
	/** ���ռ����ϢBL */
	protected RiskCheckResultBL riskCheckResultBL;
	
	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	/**
     * ���̴���BL�趨
     *
     * @param workFlowOperationBL ���̴���BL
     */
    public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
        this.workFlowOperationBL = workFlowOperationBL;
    }
    
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}
	public void setRiskCheckResultBL(RiskCheckResultBL riskCheckResultBL) {
		this.riskCheckResultBL = riskCheckResultBL;
	}
	/**
	 *��ѯ�๦��API���趨
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	
	/**
	 * ǰ������Ӳ�����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
	    log.debug("========����������̴����������ͬ�������֮��Ĺ�ϵ����ʼ========");

        IG500Info prInfo = workFlowOperationBL.searchProcessRecordByKey(bean.getLogInfo().getPrid());
        
        String rcrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��鹤��");
        if(StringUtils.isNotEmpty(rcrid)){
        	rcrid = rcrid.split("#")[2];
        	RiskCheckResult rcrBean = riskCheckResultBL.searchRiskCheckResultByKey(Integer.parseInt(rcrid));
        	if(rcrBean!=null){
        		RiskCheckResultTB rcrTB = (RiskCheckResultTB)SerializationUtils.clone(rcrBean);
        		rcrTB.setPrid(prInfo.getPrid());
        		riskCheckResultBL.updateRiskCheckResult(rcrTB);
        	}
        }
		log.debug("========����������̴����������ͬ�������֮��Ĺ�ϵ�������========");
	}

}

