/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0419Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0419SearchCond;

/**
  * ����: ��������ʵʱ��DAO�ӿ�
  * ��������: ��������ʵʱ��DAO�ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/10 ��VGCapacityRealTimeDAO�����޸�ΪSOC0419DAO
  */
public interface SOC0419DAO extends BaseHibernateDAO<SOC0419Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0419Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0419Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0419SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0419Info> findByCond(
			final SOC0419SearchCond cond, final int start,
			final int count);

}