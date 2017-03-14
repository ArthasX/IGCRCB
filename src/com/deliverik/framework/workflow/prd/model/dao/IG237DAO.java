/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCond;

/**
  * ����: ���̲���֪ͨ��DAO�ӿ�
  * ��������: ���̲���֪ͨ��DAO�ӿ�
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
public interface IG237DAO extends BaseHibernateDAO<IG237Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG237Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG237Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG237SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG237Info> findByCond(
			final IG237SearchCond cond, final int start,
			final int count);

}