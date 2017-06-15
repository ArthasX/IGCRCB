/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG481Info;
import com.deliverik.framework.workflow.prd.model.condition.IG481SearchCond;

/**
  * ����: �������Ա��DAO�ӿ�
  * ��������: �������Ա��DAO�ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG481DAO extends BaseHibernateDAO<IG481Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG481Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG481Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG481SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG481Info> findByCond(
			final IG481SearchCond cond, final int start,
			final int count);
	/**
	 * ��������ɾ��
	 * @param cond
	 */
	public void deleteByCond(final IG481SearchCond cond);
	
	/**
	 * �������̶���ID��ѯ�鶨���б�
	 * @param pdid ���̶���ID
	 * @return �鶨���б�
	 */
	public List<IG480Info> searchIG480(final String pdid);
}