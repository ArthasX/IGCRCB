/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCond;

/**
  * ����: �����鶨���DAO�ӿ�
  * ��������: �����鶨���DAO�ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG480DAO extends BaseHibernateDAO<IG480Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG480Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG480Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG480SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG480Info> findByCond(
			final IG480SearchCond cond, final int start,
			final int count);

	/**
	 * PGDID����ֵȡ��
	 * 
	 * @return PGDID����ֵ
	 */
	public String getPgdidSequenceNextValue(String firstsite,String pdsequence);
	/**
	 * �����鶨�����洦��
	 * 
	 * @param pgdid �����鶨��ID
	 */
	public void upgradeGroupProcessDefVersion(String pgdid);
	/**
	 * �����鶨�帴�ƴ���
	 * 
	 * @param pgdid �����鶨��ID
	 * @param pdsequence ���ж���
	 */
	public String copyGroupProcessDefVersion(final String pgdid,final String pdsequence);
}