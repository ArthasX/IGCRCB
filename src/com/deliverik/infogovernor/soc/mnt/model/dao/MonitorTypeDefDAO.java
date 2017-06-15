/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTypeDefSearchCond;

/**
  * ����: ������ͷ�ֵ��ϢDAO�ӿ�
  * ��������: ������ͷ�ֵ��ϢDAO�ӿ�
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public interface MonitorTypeDefDAO extends BaseHibernateDAO<MonitorTypeDefInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorTypeDefInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorTypeDefInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MonitorTypeDefSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MonitorTypeDefInfo> findByCond(
			final MonitorTypeDefSearchCond cond, final int start,
			final int count);

}