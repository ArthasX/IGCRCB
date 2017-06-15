/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0405Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0405SearchCond;

/**
  * ����: �߼�������ʵʱ��DAO�ӿ�
  * ��������: �߼�������ʵʱ��DAO�ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��LVCapacityRealTimeDAO������ΪSOC0405DAO
  */
public interface SOC0405DAO extends BaseHibernateDAO<SOC0405Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0405Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0405Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0405SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0405Info> findByCond(
			final SOC0405SearchCond cond, final int start,
			final int count);

}