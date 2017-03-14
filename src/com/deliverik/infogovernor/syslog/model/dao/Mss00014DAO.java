/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.syslog.model.Mss00014Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00014SearchCond;

/**
  * ����: mss00014DAO�ӿ�
  * ��������: mss00014DAO�ӿ�
  * ������¼: 2014/01/21
  * �޸ļ�¼: 
  */
public interface Mss00014DAO extends BaseHibernateDAO<Mss00014Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00014Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00014Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00014SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00014Info> findByCond(
			final Mss00014SearchCond cond, final int start,
			final int count);

}