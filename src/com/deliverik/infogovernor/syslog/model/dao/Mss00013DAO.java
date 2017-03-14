/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.syslog.model.Mss00013Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00013SearchCond;

/**
  * ����: mss00013DAO�ӿ�
  * ��������: mss00013DAO�ӿ�
  * ������¼: 2013/08/15
  * �޸ļ�¼: 
  */
public interface Mss00013DAO extends BaseHibernateDAO<Mss00013Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00013Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00013Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00013SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00013Info> findByCond(
			final Mss00013SearchCond cond, final int start,
			final int count);

}