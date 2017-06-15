/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.csebank.lom.model.LoanPayDetail;
import com.csebank.lom.model.condition.LoanPayDetailSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * �軹����ϸDAO�ӿ�
 *
 */
public interface LoanPayDetailDAO extends BaseHibernateDAO<LoanPayDetail> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<LoanPayDetail> findAll();

	/**
	 * ������������
	 * @param dadid ����
	 * @return �������
	 */
	public LoanPayDetail findByPK(Serializable lpdid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final LoanPayDetailSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<LoanPayDetail> findByCond(final LoanPayDetailSearchCond cond, final int start, final int count);
	
	/**
	 * ��ȡ�ѻ����ֽ������ѻ��Ʊ��
	 * 
	 * @param lpdid ����¼ID
	 * @return �ѻ����ֽ������ѻ��Ʊ��
	 */
	
	public BigDecimal[] searchAmountdAndInvoice(final Integer lpdid);
}
