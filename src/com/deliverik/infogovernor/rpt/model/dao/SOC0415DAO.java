/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0415Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0415SearchCond;

/**
  * ����: ��ռ�����ʵʱ��DAO�ӿ�
  * ��������: ��ռ�����ʵʱ��DAO�ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/10 ��TSCapacityRealTimeDAO�����޸�ΪSOC0415DAO
  */
public interface SOC0415DAO extends BaseHibernateDAO<SOC0415Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0415Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0415Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0415SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0415Info> findByCond(
			final SOC0415SearchCond cond, final int start,
			final int count);

}