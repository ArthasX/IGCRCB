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
 * һ�������ж��Ƿ���ڶ�������
 * 
 * </p>
 */
public class IGCYB0201BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGCYB0201BLImpl.class);
	
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
	    
	    log.debug("========һ�������ж��Ƿ���ڶ���������ť�¼�����ʼ========");

	    List<ParticipantInfo> p3InfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "��������");
        PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());

        ppivInfo.setFormname("�Ƿ���ڶ�������");

        if ((p3InfoList != null) && (p3InfoList.size() > 0))
            ppivInfo.setFormvalue("1");
        else {
            ppivInfo.setFormvalue("0");
        }
        this.flowSetBL.setPublicProcessInfoValue(ppivInfo);
	    
		log.debug("========һ�������ж��Ƿ���ڶ���������ť�¼��������========");
	}

}
