/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * ����״̬��ť����HandlerBL
 * </p>
 */
public interface WorkFlowStatusButtonHandlerBL extends BaseBL {
	
	/**
	 * ����״̬��ť�������
	 * 
	 * @param info ����
	 */
	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo info) throws BLException;
}
