/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.ext.igflow.linkpage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowLinkageHandlerBL;

/**
 * <p>
 * �������¼������߼�ʵ��
 * </p>
 */
public class ChangeOptionsLinkageBLImpl extends BaseBLImpl implements
		WorkFlowLinkageHandlerBL {

	/**
	 * �������¼�����
	 * @param value ��������ֵ
	 */
	public String linkageExecute(String value) throws BLException {
		//ͨ����������ֵ������һ����ҵ���߼���ȡ�ñ�������ֵ
		return "1,�ش�%2,��ͨ%3,��΢";
		
	}
	/**
	 * ������У�鴦�����
	 * @param initiativeValue ��������ֵ
	 * @param passivityValue ��������ֵ 
	 */
	public String checkLinkageExecute(String initiativeValue,String passivityValue) throws BLException{
		return null;
	}
}
