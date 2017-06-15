/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTypeSearchCond;

/**
  * ����: ������ͱ�DAO�ӿ�
  * ��������: ������ͱ�DAO�ӿ�
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public interface MonitorTypeDAO extends BaseHibernateDAO<MonitorTypeInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorTypeInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorTypeInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MonitorTypeSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MonitorTypeInfo> findByCond(
			final MonitorTypeSearchCond cond, final int start,
			final int count);

}