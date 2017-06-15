/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.PersonLoanSummary;
import com.csebank.lom.model.condition.PersonLoanSummarySearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * Ԥ֧��Աͳ��DAO
 * 
 */
public interface PersonLoanSummaryVWDAO extends BaseHibernateDAO<PersonLoanSummary> {

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PersonLoanSummary> findByCond(final PersonLoanSummarySearchCond cond,
			final int start, final int count);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final PersonLoanSummarySearchCond cond);

}
