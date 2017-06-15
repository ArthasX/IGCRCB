/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.alarm.model.CRM05Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM05SearchCond;

/**
  * ����: CRM05DAO�ӿ�
  * ��������: CRM05DAO�ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM05DAO extends BaseHibernateDAO<CRM05Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM05Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM05Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CRM05SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM05Info> findByCond(
			final CRM05SearchCond cond, final int start,
			final int count);

}