/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.cic.model.ComparescopeInfo;
import com.deliverik.infogovernor.cic.model.condition.ComparescopeSearchCond;

/**
  * ����: �Ա���DAO�ӿ�
  * ��������: �Ա���DAO�ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface ComparescopeDAO extends BaseHibernateDAO<ComparescopeInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ComparescopeInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ComparescopeInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ComparescopeSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ComparescopeInfo> findByCond(
			final ComparescopeSearchCond cond, final int start,
			final int count);

}