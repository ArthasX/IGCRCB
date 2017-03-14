/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.dev.ext.igflow.event.button;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * SOC��������"������"�ڵ��������IG337��ppproctime�ֶ�Ϊnull
 * </p>
 */
public class IGSOCEvent0203BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0203BLImpl.class);
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
	

	/**
	 * ���¹���API���趨
	 * 
	 * @param flowSetBL ���¹���API��
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ��ť�¼��������
	 * 
	 * @param bean ������Ϣ
	 */
	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========��ť�¼��޸����ر�ֵ��ʼ========");
		PublicProcessInfoValue fv = new PublicProcessInfoValue(bean.getLogInfo());
		fv.setFormname("���ر�ʶ");
		fv.setFormvalue("1");
		flowSetBL.setPublicProcessInfoValue(fv);
		log.debug("========��ť�¼��޸����ر�ֵ��ʼ========");
	}
}