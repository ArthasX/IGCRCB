/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.EventssInfo;
import com.deliverik.infogovernor.drm.model.condition.EventssSearchCond;

/**
  * ����: �¼������DAO�ӿ�
  * ��������: �¼������DAO�ӿ�
  * ������¼: 2015/03/18
  * �޸ļ�¼: 
  */
public interface EventssDAO extends BaseHibernateDAO<EventssInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EventssInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EventssInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EventssSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EventssInfo> findByCond(
			final EventssSearchCond cond, final int start,
			final int count);

}