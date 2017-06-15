/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;
import com.deliverik.infogovernor.dbm.model.condition.Ip_FilterSearchCond;

/**
  * ����: ȫ��IP����DAO�ӿ�
  * ��������: ȫ��IP����DAO�ӿ�
  * ������¼: 2012/11/07
  * �޸ļ�¼: 
  */
public interface Ip_FilterDAO extends BaseHibernateDAO<Ip_FilterInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Ip_FilterInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Ip_FilterInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Ip_FilterSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Ip_FilterInfo> findByCond(
			final Ip_FilterSearchCond cond, final int start,
			final int count);

}