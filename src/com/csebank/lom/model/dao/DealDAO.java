/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Deal;
import com.csebank.lom.model.condition.DealSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ����Ǽ���ϢDAO
 *
 */
public interface DealDAO extends BaseHibernateDAO<Deal> {
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Deal> findAll();

	/**
	 * ������������
	 * @param rid ����
	 * @return �������
	 */
	public Deal findByPK(Serializable rid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DealSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Deal> findByCond(final DealSearchCond cond, final int start, final int count);
	
	
	


	
}
