/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.PersonLoanDetail;
import com.csebank.lom.model.condition.PersonLoanDetailSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ��Ա���ͳ��DAO
 * 
 */
public interface PersonLoanDetailVWDAO extends BaseHibernateDAO<PersonLoanDetail> {

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PersonLoanDetail> findByCond(final PersonLoanDetailSearchCond cond,
			final int start, final int count);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final PersonLoanDetailSearchCond cond);
	
}
