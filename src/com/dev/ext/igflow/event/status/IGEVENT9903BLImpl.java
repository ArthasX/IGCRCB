/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.ext.igflow.event.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * ������� - ����������̹رսڵ�ǰ��������ʵ�����ʱ��
 * @author Administrator
 *
 */
public class IGEVENT9903BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGEVENT9903BLImpl.class);
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;

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
	 * ǰ������Ӳ�����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
	    log.debug("========����������̹رսڵ�ǰ��������ʵ�����ʱ�䴦��ʼ========");

        PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());

        ppivInfo.setFormname("ʵ�����ʱ��");
        ppivInfo.setFormvalue(IGStringUtils.getCurrentDateTime());
        
        this.flowSetBL.setPublicProcessInfoValue(ppivInfo);
	    
		log.debug("========����������̹رսڵ�ǰ��������ʵ�����ʱ�䴦�����========");
	}

}

