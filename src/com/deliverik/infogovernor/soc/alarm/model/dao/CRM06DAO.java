/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM06VWInfo;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM06SearchCond;

/**
  * ����: CRM06DAO�ӿ�
  * ��������: CRM06DAO�ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM06DAO extends BaseHibernateDAO<CRM06Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM06Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM06Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CRM06SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM06Info> findByCond(
			final CRM06SearchCond cond, final int start,
			final int count);
	
	/**
	 * ��ͼ������������
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<CRM06VWInfo> findVWByCond(final CRM06SearchCond cond, final int start, final int count);
	
	/**
	 * ��ͼ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchVWCount(final CRM06SearchCond cond);
	
	/**
	 * ��ͼ�����������ȡ��
	 *
	 * @param cond ��������
	 * @return �������
	 */
	public List<String> getSearchVWByInstance(final CRM06SearchCond cond);

}