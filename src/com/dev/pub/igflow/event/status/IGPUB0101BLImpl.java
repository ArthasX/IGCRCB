/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.pub.igflow.event.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * ���ȫ�������ߴ������ʱ��	
 *
 */
public class IGPUB0101BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGPUB0101BLImpl.class);
	
	/** ���¹���API�� */
	protected FlowSetBL flowSetBL;

	/**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}
	
	/**
	 * ���ȫ�������ߴ������ʱ��
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
	    log.debug("========���ȫ�������ߴ������ʱ�䴦��ʼ========");

        //���ȫ�������ߴ������ʱ��
//        flowSetBL.setStatusParticipantAllRehandle(bean.getLogInfo().getPrid(), bean.getAfstatus());
        
		log.debug("========���ȫ�������ߴ������ʱ�䴦�����========");
	}

}

