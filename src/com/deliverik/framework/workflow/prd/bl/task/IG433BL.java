/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG433Info;
import com.deliverik.framework.workflow.prd.model.IG567Info;
import com.deliverik.framework.workflow.prd.model.condition.IG433SearchCond;

/**
 * <P>����:�����������ҵ���߼��ӿ�</p>
 * <p>����������1.�رջ���ֹ����ȡ��</p>
 * <p>������¼��songhy 20101129</p>
 */

public interface IG433BL extends BaseBL {

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */	
	public List<IG567Info> searchIG567Info(IG433SearchCond cond, int start, int count);

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */	
	public IG433Info findIG567Info(IG433SearchCond cond, int start, int count);
	
	/**
	 * ���ܣ��־û�����
	 * 
	 * @param IncomeAdjustʵ����
	 * @return IncomeAdjustʵ����
	 */
	public IG433Info saveIG567Info(IG433Info processAssessment)
			throws BLException;
}
