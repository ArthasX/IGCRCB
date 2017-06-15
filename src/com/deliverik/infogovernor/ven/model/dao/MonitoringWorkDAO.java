/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.model.condition.MonitoringWorkSearchCond;

/**
  * ����: ��⹤�����DAO�ӿ�
  * ��������: ��⹤�����DAO�ӿ�
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public interface MonitoringWorkDAO extends BaseHibernateDAO<MonitoringWorkInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitoringWorkInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitoringWorkInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MonitoringWorkSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MonitoringWorkInfo> findByCond(
			final MonitoringWorkSearchCond cond, final int start,
			final int count);

}