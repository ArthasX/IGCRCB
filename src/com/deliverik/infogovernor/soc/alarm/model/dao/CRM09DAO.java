/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.alarm.model.CRM09Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM09SearchCond;

/**
  * ����: CRM09DAO�ӿ�
  * ��������: CRM09DAO�ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM09DAO extends BaseHibernateDAO<CRM09Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM09Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM09Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CRM09SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM09Info> findByCond(
			final CRM09SearchCond cond, final int start,
			final int count);

}