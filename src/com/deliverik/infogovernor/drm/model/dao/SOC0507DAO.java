/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.SOC0507Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0507SearchCond;

/**
  * ����: Ԥ����Ϣ��DAO�ӿ�
  * ��������: Ԥ����Ϣ��DAO�ӿ�
  * ������¼: 2016/07/15
  * �޸ļ�¼: 
  */
public interface SOC0507DAO extends BaseHibernateDAO<SOC0507Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0507Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0507Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0507SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0507Info> findByCond(
			final SOC0507SearchCond cond, final int start,
			final int count);

}