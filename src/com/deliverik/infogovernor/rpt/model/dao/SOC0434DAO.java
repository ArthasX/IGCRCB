/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0434Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0434SearchCond;

/**
  * ����: PVVIODAO�ӿ�
  * ��������: PVVIODAO�ӿ�
  * ������¼: 2012/08/20
  * �޸ļ�¼: 
  */
public interface SOC0434DAO extends BaseHibernateDAO<SOC0434Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0434Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0434Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0434SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0434Info> findByCond(
			final SOC0434SearchCond cond, final int start,
			final int count);

}