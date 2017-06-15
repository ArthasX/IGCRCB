/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.Timer02Info;
import com.deliverik.framework.soc.asset.model.condition.Timer02SearchCond;

/**
  * ����: timer02DAO�ӿ�
  * ��������: timer02DAO�ӿ�
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
  */
public interface Timer02DAO extends BaseHibernateDAO<Timer02Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Timer02Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Timer02Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Timer02SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Timer02Info> findByCond(
			final Timer02SearchCond cond, final int start,
			final int count);

}