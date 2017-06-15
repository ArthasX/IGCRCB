/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG037Info;
import com.deliverik.framework.workflow.prr.model.condition.IG037SearchCond;

/**
  * ����: ���̵�����־��DAO�ӿ�
  * ��������: ���̵�����־��DAO�ӿ�
  * ������¼: 2014/11/14
  * �޸ļ�¼: 
  */
public interface IG037DAO extends BaseHibernateDAO<IG037Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG037Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG037Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG037SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG037Info> findByCond(
			final IG037SearchCond cond, final int start,
			final int count);

}