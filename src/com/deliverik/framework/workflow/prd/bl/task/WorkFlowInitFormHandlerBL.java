/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;

/**
 * <p>
 * ����״̬��ֵ��ʼ��HandlerBL
 * </p>
 */
public interface WorkFlowInitFormHandlerBL extends BaseBL {

	/**
	 * ����״̬��ֵ��ʼ��
	 * 
	 * @param param ���̴�������ӿ�
	 * @return ��ֵ���ϣ�<����-ֵ>��
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param) throws BLException;

}
