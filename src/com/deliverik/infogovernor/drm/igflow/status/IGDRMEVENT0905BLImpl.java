/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.SigninBL;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;

/**
 * Ӧ��ָ������-��ԴЭ���ڵ����
 * 
 * ��ʼ��ǩ����Ϣ
 * 
 * @author zyl
 *
 *         2015��3��19��11:22:49
 */
public class IGDRMEVENT0905BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0905BLImpl.class);
    
	private FlowSearchBL flowSearchBL;

	private SigninBL signinBL;

	private WorkFlowOperationBL workFlowOperationBL;

	public void setSigninBL(SigninBL signinBL) {
		this.signinBL = signinBL;
	}

	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}


	/**
	 * ��ʼ��ǩ����Ϣ
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {


    }
	

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("============Ӧ��ָ��������ԴЭ���ڵ�ǰ����ʼ===============");
		// ��ȡӦ����������id
		String drillPrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), IGDRMCONSTANTS.PRACTISE_PRID_LABEL);
		// ����������������ָ��������Ҫ��ʼ��ǩ����Ϣ
		if (StringUtils.isEmpty(drillPrid)) {
			// ------------------ ��ʼ��ǩ����Ϣ-----------------
			signinBL.registerSigninInfo(null, bean.getLogInfo().getPrid(), null, "WDP", workFlowOperationBL.getSceneParticipant(bean.getLogInfo().getPrid()));
				//�����ַͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
			IGDRMEmergencyTools.changeSystemState(bean.getLogInfo().getPrid(), "ҵ��ϵͳ", "7",null);
		}
		log.debug("============Ӧ��ָ��������ԴЭ���ڵ�ǰ�������===============");
	}
}
