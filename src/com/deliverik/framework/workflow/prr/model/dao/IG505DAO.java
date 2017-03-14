/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.condition.IG505SearchCond;

/**
  * ����: ���̱�ֵ��DAO�ӿ�
  * ��������: ���̱�ֵ��DAO�ӿ�
  * ������¼: 2013/08/28
  * �޸ļ�¼: 
  */
public interface IG505DAO extends BaseHibernateDAO<IG505Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG505Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG505Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG505SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG505Info> findByCond(
			final IG505SearchCond cond, final int start,
			final int count);

}