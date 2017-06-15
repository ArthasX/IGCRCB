/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.syslog.model.Mss00012Info;
import com.deliverik.infogovernor.syslog.model.condition.Mss00012SearchCond;

/**
  * ����: MSS00012DAO�ӿ�
  * ��������: MSS00012DAO�ӿ�
  * ������¼: 2013/04/25
  * �޸ļ�¼: 
  */
public interface Mss00012DAO extends BaseHibernateDAO<Mss00012Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00012Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00012Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00012SearchCond cond) throws Exception;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00012Info> findByCond(
			final Mss00012SearchCond cond, final int start,
			final int count) throws Exception;

}