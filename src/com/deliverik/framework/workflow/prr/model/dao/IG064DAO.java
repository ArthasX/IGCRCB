/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG064Info;
import com.deliverik.framework.workflow.prr.model.condition.IG064SearchCond;

/**
  * ����: ���̼�¼�ڵ�������ͼDAO�ӿ�
  * ��������: ���̼�¼�ڵ�������ͼDAO�ӿ�
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
public interface IG064DAO extends BaseHibernateDAO<IG064Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG064Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG064Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG064SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG064Info> findByCond(
			final IG064SearchCond cond, final int start,
			final int count);

}