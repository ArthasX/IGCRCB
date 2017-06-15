/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.syslog.model.Mss00009Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00009SearchCond;

/**
  * ����: mss00009DAO�ӿ�
  * ��������: mss00009DAO�ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00009DAO extends BaseHibernateDAO<Mss00009Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00009Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00009Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00009SearchCond cond) throws Exception;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00009Info> findByCond(
			final Mss00009SearchCond cond, final int start,
			final int count) throws Exception;

	
	/**
	 * ��ȡ��ǰ���ID
	 * @return
	 */
	public int getMaxID();
}