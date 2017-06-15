/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.alarm.model.CRM07Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM07SearchCond;

/**
  * ����: CRM07DAO�ӿ�
  * ��������: CRM07DAO�ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM07DAO extends BaseHibernateDAO<CRM07Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM07Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM07Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CRM07SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM07Info> findByCond(
			final CRM07SearchCond cond, final int start,
			final int count);

}