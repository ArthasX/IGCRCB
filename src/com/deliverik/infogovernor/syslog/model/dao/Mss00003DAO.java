/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.syslog.model.Mss00003Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00003SearchCond;

/**
  * ����: �澯����������DAO�ӿ�
  * ��������: �澯����������DAO�ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00003DAO extends BaseHibernateDAO<Mss00003Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00003Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00003Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00003SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00003Info> findByCond(
			final Mss00003SearchCond cond, final int start,
			final int count);

}