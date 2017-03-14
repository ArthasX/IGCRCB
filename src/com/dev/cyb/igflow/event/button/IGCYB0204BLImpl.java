package com.dev.cyb.igflow.event.button;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * �������ж��Ƿ����һ������
 * 
 * </p>
 */
public class IGCYB0204BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGCYB0204BLImpl.class);
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
	
	private FlowSearchBL flowSearchBL;

	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
	    this.flowSearchBL = flowSearchBL;
    }

	/**
	 * ���¹���API���趨
	 * 
	 * @param flowSetBL ���¹���API��
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}


	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	    
	    log.debug("========�������Ƿ����һ��������ť�¼�����ʼ========");

	    List<ParticipantInfo> p3InfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "һ������");
        PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());

        ppivInfo.setFormname("�Ƿ����һ������");

        if ((p3InfoList != null) && (p3InfoList.size() > 0))
            ppivInfo.setFormvalue("1");
        else {
            ppivInfo.setFormvalue("0");
        }
        this.flowSetBL.setPublicProcessInfoValue(ppivInfo);
	    
		log.debug("========������ڵ��ж��Ƿ����һ��������ť�¼��������========");
	}

}
