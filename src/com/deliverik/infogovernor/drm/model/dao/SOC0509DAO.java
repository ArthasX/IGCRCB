/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.SOC0509Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0509SearchCond;

/**
  * ����: Ԥ���½���ϢDAO�ӿ�
  * ��������: Ԥ���½���ϢDAO�ӿ�
  * ������¼: 2016/07/07
  * �޸ļ�¼: 
  */
public interface SOC0509DAO extends BaseHibernateDAO<SOC0509Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0509Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0509Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0509SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0509Info> findByCond(
			final SOC0509SearchCond cond, final int start,
			final int count);

	public Integer getNextCorder();

}