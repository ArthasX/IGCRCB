/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.SigninBL;

/**
 * Ӧ����������-����׼���ڵ�ǰ����
 * 
 * ǩ�����������
 * 
 * @author zyl
 *
 *         2015��3��12��21:03:48
 */
public class IGDRMEVENT0702BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0702BLImpl.class);
    /**����API*/
    private FlowSearchBL flowSearchBL;
    /**ǩ����BL*/
    private SigninBL signinBL;
	private WorkFlowOperationBL workFlowOperationBL;



	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {

	}

	/**
	 * Ӧ����������-����ʵʩǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========Ӧ������������׼���ڵ�ǰ�������ǩ����Ա��ʼ========");
    	
		// ------------------------�������˷����ʼ�-----------------------
		// ר��Ԥ��
		String emcproeiname = this.flowSearchBL.searchProcessEntityItem(bean.getLogInfo().getPrid(), IGDRMCONSTANTS.SPECIAL_PLAN_NAME).get(0).getEiname();
		// ��������
		String sceneeiname = this.flowSearchBL.searchProcessEntityItem(bean.getLogInfo().getPrid(), IGDRMCONSTANTS.EMERGENCY_SCENE_NAME).get(0).getEiname();
		// �����ʼ�
		workFlowOperationBL.send(bean.getLogInfo().getPrid(), emcproeiname, sceneeiname, bean.getPdid(), IGStringUtils.getCurrentDateTime());

		// ------------------ ��ʼ��ǩ����Ϣ-----------------
		signinBL.registerSigninInfo(bean.getLogInfo().getPrid(), null, null, "WDP", workFlowOperationBL.getSceneParticipant(bean.getLogInfo().getPrid()));

		log.debug("========Ӧ������������׼���ڵ�ǰ�������ǩ����Ա����========");
	}

	/**
	 * @param ����API the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}


	/**
	 * @param ǩ����BL the signinBL to set
	 */
	public void setSigninBL(SigninBL signinBL) {
		this.signinBL = signinBL;
	}


}
