/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * �������¼�����HandlerBL
 * </p>
 */
public interface WorkFlowLinkageHandlerBL extends BaseBL {

	/**
	 * �������������
	 *  @param value ����ֵ
	 */
	public String linkageExecute(String value) throws BLException;
	

	/**
	 * ������У�鴦�����
	 * 
	 */
	public String checkLinkageExecute(String initiativeValue,String passivityValue) throws BLException;



}
