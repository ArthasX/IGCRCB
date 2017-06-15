package com.deliverik.infogovernor.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;

public class ProcessDefineTypeValueBean {
	/** ��¼��־ */
	private static Log log = LogFactory.getLog(ProcessDefineTypeValueBean.class);
	
	private static WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");

	/**
	 * ��ȡ���̵�ǰ״̬��ʾ����
	 * 
	 * @param prid ����ID
	 * @return ��ǰ״̬��ʾ����
	 */
	public static String getConfigInfo(Integer prid) {
		try {
			//��ѯ��ǰ����
			IG500Info process = workFlowOperationBL.searchProcessRecordByKey(prid);
			if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(process.getPrstatus())){
				return "��ֹ";
			}else{
				return workFlowOperationBL.searchCurrentStatusName(prid);
			}
		} catch (Exception e) {
			log.error("״̬��ʾ�쳣", e);
			return "";
		}
	}

}
