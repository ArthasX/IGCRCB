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
public class CheckLinkageBLImpl extends BaseBLImpl implements
		WorkFlowLinkageHandlerBL {

	/**
	 * �������¼�����
	 * @param ��������ֵ
	 */
	public String linkageExecute(String value) throws BLException {
		//ͨ����������ֵ������һ����ҵ���߼���ȡ�ñ�������ֵ
		return "ok";
		
	}
	/**
	 * ������У�鴦�����
	 * @param initiativeValue ��������ֵ
	 * @param passivityValue �ӱ���ֵ 
	 */
	public String checkLinkageExecute(String initiativeValue,String passivityValue) throws BLException{
		//���հ���һ����ҵ���߼������ύ�ı�����У��
		//������ֵ����Ϊ�գ��ӱ���ֵ����Ϊ��
		//������Ϣ��keyֵ������ApplicationResources.properties��
		String errorKey = "";
		
		//�����ҵ���߼�
		if(initiativeValue.endsWith(passivityValue)){
			errorKey = "IGPRD0102.E003";
		}else{
			errorKey = "IGPRD0102.E003";
		}
		 
		return errorKey;
	}
}
