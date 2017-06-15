/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCond;

/**
  * ����: �����¼�DAO�ӿ�
  * ��������: �����¼�DAO�ӿ�
  * ������¼: 2014/07/18
  * �޸ļ�¼: 
  */
public interface RiskcaseVWDAO extends BaseHibernateDAO<RiskcaseVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskcaseVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskcaseVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskcaseVWSearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskcaseVWInfo> findByCond(
			final RiskcaseVWSearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskcaseVWInfo> findByCondByVersion(
			final RiskcaseVWSearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskcaseVWInfo> findByCond(
			final RiskcaseVWSearchCond cond, final int start,
			final int count);

}