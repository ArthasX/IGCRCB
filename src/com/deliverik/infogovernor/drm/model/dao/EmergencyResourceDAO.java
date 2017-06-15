/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.EmergencyResourceInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyResourceSearchCond;

/**
  * ����: EmergencyResourceDAO�ӿ�
  * ��������: EmergencyResourceDAO�ӿ�
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
public interface EmergencyResourceDAO extends BaseHibernateDAO<EmergencyResourceInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EmergencyResourceInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EmergencyResourceInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EmergencyResourceSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EmergencyResourceInfo> findByCond(
			final EmergencyResourceSearchCond cond, final int start,
			final int count);

}