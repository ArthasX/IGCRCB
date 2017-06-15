package com.deliverik.infogovernor.drm.igflow.button;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.PrivateProcessFormInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * ���ķ���-�ڵ㰴ť�¼�
 * 
 * </p>
 */
public class IGDRMBTN1201BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGDRMBTN1201BLImpl.class);
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;

    /** ��ѯ�๦��API�� */
    private FlowSearchBL flowSearchBL;
    
	/**
	 * ���¹���API���趨
	 * 
	 * @param flowSetBL ���¹���API��
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }


	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	    
		log.debug("========���ļƻ�������ť�¼��趨�Ƿ񲵻ؿ�ʼ========");
    	
    	// ��ѯ�������
    	List<PrivateProcessFormInfo> ppfList = this.flowSearchBL.searchPrivateProcessInfo(bean.getLogInfo().getPrid(), "�������");
    	
    	// �Ƿ񲵻�
    	String backflag = "��";
    	
    	// ������˷���ˣ�����
    	for (PrivateProcessFormInfo ppfInfo : ppfList) {
    		if ("���".equals(ppfInfo.getValue())) {
    			backflag = "��";
    		}
    	}
    	
    	// �����Ƿ񲵻ر���Ϣ
    	PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
        ppivInfo.setFormname("�Ƿ񲵻�");
        ppivInfo.setFormvalue(backflag);
        this.flowSetBL.setPublicProcessInfoValue(ppivInfo);
    	
    	log.debug("========���ļƻ�������ť�¼��趨�Ƿ񲵻ؽ���========");
	}

}
