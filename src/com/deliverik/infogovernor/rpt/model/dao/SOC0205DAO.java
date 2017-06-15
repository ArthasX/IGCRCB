/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0205SearchCond;

/**
  * ����: ��������DAO�ӿ�
  * ��������: ��������DAO�ӿ�
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportManageDAO�����޸�ΪSOC0205DAO
  */
public interface SOC0205DAO extends BaseHibernateDAO<SOC0205Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0205Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0205Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0205SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0205Info> findByCond(
			final SOC0205SearchCond cond, final int start,
			final int count);

}