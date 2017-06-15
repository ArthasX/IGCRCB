/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0411Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0411SearchCond;

/**
  * ����: �洢����ʵʱ��DAO�ӿ�
  * ��������: �洢����ʵʱ��DAO�ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��StorageCapacityRealTimeDAO������ΪSOC0411DAO
  */
public interface SOC0411DAO extends BaseHibernateDAO<SOC0411Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0411Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0411Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0411SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0411Info> findByCond(
			final SOC0411SearchCond cond, final int start,
			final int count);

}