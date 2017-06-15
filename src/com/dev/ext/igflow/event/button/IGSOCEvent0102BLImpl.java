/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.dev.ext.igflow.event.button;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;

/**
 * <p>
 * SOC��������"������"�ڵ��������IG337��ppproctime�ֶ�Ϊnull
 * </p>
 */
public class IGSOCEvent0102BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0102BLImpl.class);
	
	/** ������ת��Ϣ��¼�� */
	private IG337BL ig337BL;
	
	/**
	 * ������ת��Ϣ��¼���趨
	 * 
	 * @param ig337BL ������ת��Ϣ��¼��
	 */
	public void setIg337BL(IG337BL ig337BL) {
		this.ig337BL = ig337BL;
	}
	
	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	/**
	 * ��ѯ�๦��API���趨
	 * 
	 * @param flowSearchBL ���¹���API���ѯ�๦��API��
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ��ť�¼��������
	 * 
	 * @param bean ������Ϣ
	 */
	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========�����к�������ʱ�䴦��ʼ========");
		String formValue = this.flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "����״̬");
		if(formValue.equals("������")){//״̬δ����ԾǨʱ����IG337���е�����
			//��ȡ��ǰIG337���ʵ��
			IG337SearchCondImpl cond = new IG337SearchCondImpl();
			cond.setPrid(bean.getLogInfo().getPrid());
			cond.setPpstatus("Y");
			List<IG337Info> infoList = ig337BL.searchIG337InfoRun(cond);
			
			if(infoList != null && infoList.size()>0){
				IG337TB ig337 = (IG337TB) infoList.get(0);
				ig337.setPpproctime(null);
				ig337BL.updateIG337Info(ig337);
			}
		}
		log.debug("========�����к�������ʱ�䴦�����========");
	}
}