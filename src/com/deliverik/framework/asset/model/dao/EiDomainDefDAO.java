/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDefSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: �ʲ������DAO�ӿ�
  * ��������: �ʲ������DAO�ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface EiDomainDefDAO extends BaseHibernateDAO<EiDomainDefInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiDomainDefInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EiDomainDefInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EiDomainDefSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EiDomainDefInfo> findByCond(
			final EiDomainDefSearchCond cond, final int start,
			final int count);
	/**
	 * ��ѯ���EiddId
	 * @return 
	 */
	public Integer findMaxEiddId();

	/**
	 * ��ȡ�ʲ�����汾
	 * @param eiddid
	 * @param version
	 * @return
	 */
	public List<EiDomainDefInfo> searchEiDomainDefByPK(Integer eiddid,
			Integer version);

}