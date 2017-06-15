/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.syslog.model.Mss00001Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00001SearchCond;

/**
  * ����: �豸��Ϣ��DAO�ӿ�
  * ��������: �豸��Ϣ��DAO�ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00001DAO extends BaseHibernateDAO<Mss00001Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00001Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00001Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00001SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00001Info> findByCond(
			final Mss00001SearchCond cond, final int start,
			final int count);

}