/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM08SearchCond;

/**
  * ����: CRM08DAO�ӿ�
  * ��������: CRM08DAO�ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM08DAO extends BaseHibernateDAO<CRM08Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM08Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM08Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CRM08SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM08Info> findByCond(
			final CRM08SearchCond cond, final int start,
			final int count);

}