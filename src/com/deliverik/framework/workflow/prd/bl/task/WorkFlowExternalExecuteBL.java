/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.parameter.ExternalParameterInfo;

/**
 * <p>
 * �����ⲿ�¼�����HandlerBL
 * </p>
 */
public interface WorkFlowExternalExecuteBL{

	/**
	 * 
	 * @param eventID ����ID
	 * @param param ����
	 * @throws BLException
	 */
	public void eventExecute(String eventID, ExternalParameterInfo param) throws BLException;

}
