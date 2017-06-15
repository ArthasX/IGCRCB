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
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * �������̵ȴ����򿪷��ڵ�ǰ����
 * ���ã� ɾ���ýڵ�Ĵ�����  
 * </p>
 */
public class IGEVENT0501BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	
	static Log log = LogFactory.getLog(IGEVENT0501BLImpl.class);
	
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
	 * ����״̬ǰ�������
	 * 
	 * @param bean ������Ϣ
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========�ȴ����򿪷��ڵ�ǰ����ɾ�������ߴ���ʼ========");
		
		 //��־������Ϣ�趨
        StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
        //��װ����״̬����
        spInfo.setStatusname("�ȴ����򿪷�");
        //ɾ��ԾǨ�ڵ��ԭ�в�����
        flowSetBL.deleteStatusParticipant(spInfo);
        
		log.debug("========�ȴ����򿪷��ڵ�ǰ����ɾ�������ߴ������========");
	}

	/**
	 * ����״̬�������
	 * 
	 * @param bean ������Ϣ
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
