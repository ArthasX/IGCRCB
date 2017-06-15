/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0424Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0424SearchCond;

/**
  * ����: �������ͱ�DAO�ӿ�
  * ��������: �������ͱ�DAO�ӿ�
  * ������¼: 2012/07/18
  * �޸ļ�¼: 2012/08/10 ��ReportTypeDAO�����޸�ΪSOC0424DAO
  */
public interface SOC0424DAO extends BaseHibernateDAO<SOC0424Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0424Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0424Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0424SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0424Info> findByCond(
			final SOC0424SearchCond cond, final int start,
			final int count);

}