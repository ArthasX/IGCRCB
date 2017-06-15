/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0208Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0208SearchCond;

/**
  * ����: �¼��������Ч��DAO�ӿ�
  * ��������: �¼��������Ч��DAO�ӿ�
  * ������¼: 2011/11/23
  * �޸ļ�¼: 2012/08/10 ��ServeEfficiencyDAO�����޸�ΪSOC0208DAO
  */
public interface SOC0208DAO extends BaseHibernateDAO<SOC0208Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0208Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0208Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0208SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0208Info> findByCond(
			final SOC0208SearchCond cond, final int start,
			final int count);

}