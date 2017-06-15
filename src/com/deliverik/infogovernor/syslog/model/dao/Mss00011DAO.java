/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.syslog.model.Mss00011Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00011SearchCond;

/**
  * ����: mss00011DAO�ӿ�
  * ��������: mss00011DAO�ӿ�
  * ������¼: 2013/04/16
  * �޸ļ�¼: 
  */
public interface Mss00011DAO extends BaseHibernateDAO<Mss00011Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00011Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00011Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00011SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00011Info> findByCond(
			final Mss00011SearchCond cond, final int start,
			final int count);

}