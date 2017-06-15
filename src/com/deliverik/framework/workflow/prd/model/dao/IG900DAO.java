/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG900Info;
import com.deliverik.framework.workflow.prd.model.condition.IG900SearchCond;

/**
  * ����: ���̰�ť�����DAO�ӿ�
  * ��������: ���̰�ť�����DAO�ӿ�
  * ������¼: 2012/04/18
  * �޸ļ�¼: 
  */
public interface IG900DAO extends BaseHibernateDAO<IG900Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG900Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG900Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG900SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG900Info> findByCond(
			final IG900SearchCond cond, final int start,
			final int count);

}