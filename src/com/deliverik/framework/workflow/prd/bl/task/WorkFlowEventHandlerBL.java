/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * �����¼�����HandlerBL
 * </p>
 */
public interface WorkFlowEventHandlerBL extends BaseBL {

	/**
	 * ����״̬ǰ�������
	 * 
	 * @param bean ǰ�����������
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException;

	/**
	 * ����״̬�������
	 * 
	 * @param bean ǰ�����������
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException;

}
