/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.asset.model.condition.CITaskSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: CI��������DAO�ӿ�
  * ��������: CI��������DAO�ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CITaskDAO extends BaseHibernateDAO<CITaskInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CITaskInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CITaskInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CITaskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CITaskInfo> findByCond(
			final CITaskSearchCond cond, final int start,
			final int count);

}