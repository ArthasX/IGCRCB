/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0409Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0409SearchCond;

/**
  * ����: ����pvʵʱ��DAO�ӿ�
  * ��������: ����pvʵʱ��DAO�ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��PVHostRealTimeDAO������ΪSOC0409DAO
  */
public interface SOC0409DAO extends BaseHibernateDAO<SOC0409Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0409Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0409Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0409SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0409Info> findByCond(
			final SOC0409SearchCond cond, final int start,
			final int count);

}