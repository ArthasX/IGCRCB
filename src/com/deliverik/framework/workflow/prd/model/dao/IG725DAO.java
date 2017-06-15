/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCond;

/**
  * ����: ȱʡ�����߰�ť�����DAO�ӿ�
  * ��������: ȱʡ�����߰�ť�����DAO�ӿ�
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public interface IG725DAO extends BaseHibernateDAO<IG725Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG725Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG725Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG725SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG725Info> findByCond(
			final IG725SearchCond cond, final int start,
			final int count);
	
	public String getPdbdidSequenceNextValue(final String psdid);
}