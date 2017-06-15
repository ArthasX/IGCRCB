/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.PersonLoanSummary;
import com.csebank.lom.model.condition.PersonLoanSummarySearchCond;
import com.deliverik.framework.base.BaseBL;

/**
 * Ԥ֧��Աͳ�Ʋ�ѯ�ӿ�
 */
public interface PersonLoanSummaryVWBL extends BaseBL {

	/**
	 * <p>
	 * Description: Ԥ֧��Աͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<PersonLoanSummary>
	 */
	public List<PersonLoanSummary> searchPersonLoanSummaryVW(PersonLoanSummarySearchCond cond,int start, int count);
	
	/**
	 * <p>
	 * Description: Ԥ֧��Աͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @return �б��¼����
	 */
	public int getSearchCount(PersonLoanSummarySearchCond cond);
	
}
