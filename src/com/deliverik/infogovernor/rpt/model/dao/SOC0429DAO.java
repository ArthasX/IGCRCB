/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0429Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0429SearchCond;

/**
  * ����: ����������ͼDAO�ӿ�
  * ��������: ����������ͼDAO�ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��HostCapacityRealTimeVWDAO������ΪSOC0429DAO
  */
public interface SOC0429DAO extends BaseHibernateDAO<SOC0429Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0429Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0429Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0429SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0429Info> findByCond(
			final SOC0429SearchCond cond, final int start,
			final int count);

}