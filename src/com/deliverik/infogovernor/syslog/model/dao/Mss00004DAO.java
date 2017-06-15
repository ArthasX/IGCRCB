/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.syslog.model.Mss00004Info;
import com.deliverik.infogovernor.syslog.model.Mss00004VWInfo;
import com.deliverik.infogovernor.syslog.model.condition.Mss00004SearchCond;

/**
  * ����: �澯����ģ���DAO�ӿ�
  * ��������: �澯����ģ���DAO�ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00004DAO extends BaseHibernateDAO<Mss00004Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00004Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00004Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00004SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00004Info> findByCond(
			final Mss00004SearchCond cond, final int start,
			final int count);
	/**
	 * 
	 * ��ѯģ����ͼ
	 * @param end 
	 * @param start 
	 *
	 * @���� zhaoyong
	 */
	public List<Mss00004VWInfo> findByCondVW(final Mss00004SearchCond cond, int start, int end);

}