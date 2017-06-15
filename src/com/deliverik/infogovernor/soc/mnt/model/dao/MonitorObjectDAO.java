/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectSearchCond;

/**
  * ����: ��ض�����ϢDAO�ӿ�
  * ��������: ��ض�����ϢDAO�ӿ�
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public interface MonitorObjectDAO extends BaseHibernateDAO<MonitorObjectInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorObjectInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorObjectInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MonitorObjectSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MonitorObjectInfo> findByCond(
			final MonitorObjectSearchCond cond, final int start,
			final int count);

}