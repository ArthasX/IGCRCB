/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.ext.igflow.event.status;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.smr.bl.IGSMRCONSTANT;
import com.deliverik.infogovernor.smr.bl.task.ApproveSuggestionBL;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCondImpl;
import com.deliverik.infogovernor.smr.model.entity.ApproveSuggestionTB;

/**
 * �״̬����
 * �����Ч���������
 *
 */
public class IGEVENT1404BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGEVENT1404BLImpl.class);
	
	/** �������ҵ��BL */
	private ApproveSuggestionBL approveSuggestionBL;

	/**
	 * �������ҵ��BL�趨
	 * 
	 * @param approveSuggestionBL �������ҵ��BL
	 */
	public void setApproveSuggestionBL(ApproveSuggestionBL approveSuggestionBL) {
		this.approveSuggestionBL = approveSuggestionBL;
	}



	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("========���ָ����˴������ʱ�俪ʼ========");
	    //��ѯ��Ч�ı��������
	    ApproveSuggestionSearchCondImpl cond = new ApproveSuggestionSearchCondImpl();
	    cond.setPrid_eq(bean.getLogInfo().getPrid());
	    cond.setStatus_eq(IGSMRCONSTANT.APPROVE_STATUS_YES);//��Ч
	    List<ApproveSuggestionInfo> lst_ApproveSuggestionInfo = this.approveSuggestionBL.searchApproveSuggestionInfo(cond);
    	for(ApproveSuggestionInfo info : lst_ApproveSuggestionInfo) {
    		ApproveSuggestionTB tb = (ApproveSuggestionTB)SerializationUtils.clone(info);
    		tb.setStatus(IGSMRCONSTANT.APPROVE_STATUS_NO);//��Ч
    		this.approveSuggestionBL.updateApproveSuggestionInfo(tb);
    	}
		log.debug("========���ָ����˴������ʱ�����========");
	}
	
	/**
	 * ���ȫ�������ߴ������ʱ��
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	    
	}

}

