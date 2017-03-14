/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0204Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0204SearchCond;

/**
  * ����: �����Զ�����DAO�ӿ�
  * ��������: �����Զ�����DAO�ӿ�
  * ������¼: 2012/07/20
  * �޸ļ�¼: 2012/08/10 ��ReportCustomLinkDAO�����޸�ΪSOC0204DAO
  */
public interface SOC0204DAO extends BaseHibernateDAO<SOC0204Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0204Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0204Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0204SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0204Info> findByCond(
			final SOC0204SearchCond cond, final int start,
			final int count);

}