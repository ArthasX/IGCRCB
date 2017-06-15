/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.condition.IG233SearchCond;

/**
  * ����: �Զ������̷��ɶ����DAO�ӿ�
  * ��������: �Զ������̷��ɶ����DAO�ӿ�
  * ������¼: 2013/03/12
  * �޸ļ�¼: 
  */
public interface IG233DAO extends BaseHibernateDAO<IG233Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG233Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG233Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG233SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG233Info> findByCond(
			final IG233SearchCond cond, final int start,
			final int count);

}