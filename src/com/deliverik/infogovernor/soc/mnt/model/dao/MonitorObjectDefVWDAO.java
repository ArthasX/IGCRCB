/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefVWInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectDefVWSearchCond;

/**
  * ����: ��ض���KPI��Ϣ��ͼDAO�ӿ�
  * ��������: ��ض���KPI��Ϣ��ͼDAO�ӿ�
  * ������¼: 2012/02/13
  * �޸ļ�¼: 
  */
public interface MonitorObjectDefVWDAO extends BaseHibernateDAO<MonitorObjectDefVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorObjectDefVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorObjectDefVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MonitorObjectDefVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MonitorObjectDefVWInfo> findByCond(
			final MonitorObjectDefVWSearchCond cond, final int start,
			final int count);

}