/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTaskObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTaskObjectSearchCond;

/**
  * ����: �����������DAO�ӿ�
  * ��������: �����������DAO�ӿ�
  * ������¼: 2012/05/10
  * �޸ļ�¼: 
  */
public interface MonitorTaskObjectDAO extends BaseHibernateDAO<MonitorTaskObjectInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorTaskObjectInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorTaskObjectInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MonitorTaskObjectSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MonitorTaskObjectInfo> findByCond(
			final MonitorTaskObjectSearchCond cond, final int start,
			final int count);

}