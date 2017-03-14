/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Eatery;
import com.csebank.lom.model.condition.EaterySearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ʳ�óɱ���ϢDAO�ӿ�
 *
 */
public interface EateryDAO extends BaseHibernateDAO<Eatery> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Eatery> findAll();

	/**
	 * ������������
	 * @param rid ����
	 * @return �������
	 */
	public Eatery findByPK(Serializable eid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EaterySearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Eatery> findByCond(final EaterySearchCond cond, final int start, final int count);
	
	


}
