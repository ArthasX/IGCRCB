/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.AuditConfigItemInfo;
import com.deliverik.framework.asset.model.condition.AuditConfigItemSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: ����ʲ����Ա�DAO�ӿ�
  * ��������: ����ʲ����Ա�DAO�ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface AuditConfigItemDAO extends BaseHibernateDAO<AuditConfigItemInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditConfigItemInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditConfigItemInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AuditConfigItemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditConfigItemInfo> findByCond(
			final AuditConfigItemSearchCond cond, final int start,
			final int count);

	/**
	 * �����ʲ����Լ����ԶԱȷ���
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AuditConfigItemInfo> searchAuditConfigItemForAucmptype(Integer eiid);

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteAuditConfigItem();

}