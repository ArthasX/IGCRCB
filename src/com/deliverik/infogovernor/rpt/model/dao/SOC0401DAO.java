/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0401Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0401SearchCond;

/**
  * ����: ���ݿ�����ʵʱ��DAO�ӿ�
  * ��������: ���ݿ�����ʵʱ��DAO�ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��DBCapacityRealTimeDAO������ΪSOC0401DAO
  */
public interface SOC0401DAO extends BaseHibernateDAO<SOC0401Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0401Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0401Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0401SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0401Info> findByCond(
			final SOC0401SearchCond cond, final int start,
			final int count);

}