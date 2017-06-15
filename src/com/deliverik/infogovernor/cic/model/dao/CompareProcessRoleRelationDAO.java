/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.cic.model.CompareProcessRoleRelationInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareProcessRoleRelationSearchCond;

/**
  * ����: ��ϵ��DAO�ӿ�
  * ��������: ��ϵ��DAO�ӿ�
  * ������¼: 2014/04/24
  * �޸ļ�¼: 
  */
public interface CompareProcessRoleRelationDAO extends BaseHibernateDAO<CompareProcessRoleRelationInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareProcessRoleRelationInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareProcessRoleRelationInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CompareProcessRoleRelationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareProcessRoleRelationInfo> findByCond(
			final CompareProcessRoleRelationSearchCond cond, final int start,
			final int count);

}