/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.syslog.model.Mss00005Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00005SearchCond;

/**
  * ����: �澯��Ϣ���DAO�ӿ�
  * ��������: �澯��Ϣ���DAO�ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00005DAO extends BaseHibernateDAO<Mss00005Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00005Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00005Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00005SearchCond cond) throws Exception;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00005Info> findByCond(
			final Mss00005SearchCond cond, final int start,
			final int count) throws Exception;

}