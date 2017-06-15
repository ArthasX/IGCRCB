/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.condition.IG221SearchCond;

/**
  * ����: �����߰�ť������Ϣ����ͼDAO�ӿ�
  * ��������: �����߰�ť������Ϣ����ͼDAO�ӿ�
  * ������¼: 2012/04/19
  * �޸ļ�¼: 
  */
public interface IG221DAO extends BaseHibernateDAO<IG221Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG221Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG221Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG221SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG221Info> findByCond(
			final IG221SearchCond cond, final int start,
			final int count);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG221Info> findDefaultByCond(
			final IG221SearchCond cond, final int start,
			final int count);
	
}