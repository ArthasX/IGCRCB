/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.Timer01Info;
import com.deliverik.framework.soc.asset.model.condition.Timer01SearchCond;

/**
  * ����: timer01DAO�ӿ�
  * ��������: timer01DAO�ӿ�
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
  */
public interface Timer01DAO extends BaseHibernateDAO<Timer01Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Timer01Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Timer01Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Timer01SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Timer01Info> findByCond(
			final Timer01SearchCond cond, final int start,
			final int count);

}