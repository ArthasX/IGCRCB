/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.AuditWaitTaskSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: ��ƴ���������DAO�ӿ�
  * ��������: ��ƴ���������DAO�ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface AuditWaitTaskDAO extends BaseHibernateDAO<AuditWaitTaskInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditWaitTaskInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditWaitTaskInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AuditWaitTaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditWaitTaskInfo> findByCond(
			final AuditWaitTaskSearchCond cond, final int start,
			final int count);

}