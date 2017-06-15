/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.EiWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.EiWaitTaskSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: ����������DAO�ӿ�
  * ��������: ����������DAO�ӿ�
  * ������¼: 2011/04/29
  * �޸ļ�¼: 
  */
public interface EiWaitTaskDAO extends BaseHibernateDAO<EiWaitTaskInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiWaitTaskInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EiWaitTaskInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EiWaitTaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EiWaitTaskInfo> findByCond(
			final EiWaitTaskSearchCond cond, final int start,
			final int count);

}