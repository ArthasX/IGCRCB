/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.AuditResultInfo;
import com.deliverik.framework.asset.model.condition.AuditResultSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: ��ƶԱȽ����Ϣ��DAO�ӿ�
  * ��������: ��ƶԱȽ����Ϣ��DAO�ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface AuditResultDAO extends BaseHibernateDAO<AuditResultInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditResultInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditResultInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AuditResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditResultInfo> findByCond(
			final AuditResultSearchCond cond, final int start,
			final int count);

	/**
	 * ���µ�ǰ����Ϊ������
	 *
	 * @param cond ��������
	 */
	public Integer updateAuditResultWithout(AuditResultSearchCond cond)
		throws BLException;

}