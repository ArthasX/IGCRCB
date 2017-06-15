/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.CustomConfigurationInfo;
import com.deliverik.infogovernor.sym.model.condition.CustomConfigurationSearchCond;

/**
  * ����: �Զ����������ñ�DAO�ӿ�
  * ��������: �Զ����������ñ�DAO�ӿ�
  * ������¼: 2012/11/05
  * �޸ļ�¼: 
  */
public interface CustomConfigurationDAO extends BaseHibernateDAO<CustomConfigurationInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CustomConfigurationInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CustomConfigurationInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CustomConfigurationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CustomConfigurationInfo> findByCond(
			final CustomConfigurationSearchCond cond, final int start,
			final int count);

}