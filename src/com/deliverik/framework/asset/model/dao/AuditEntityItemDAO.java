/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.AuditEntityItemInfo;
import com.deliverik.framework.asset.model.condition.AuditEntityItemSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: ����ʲ���DAO�ӿ�
  * ��������: ����ʲ���DAO�ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface AuditEntityItemDAO extends BaseHibernateDAO<AuditEntityItemInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditEntityItemInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditEntityItemInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AuditEntityItemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditEntityItemInfo> findByCond(
			final AuditEntityItemSearchCond cond, final int start,
			final int count);

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteAuditEntityItem();

}