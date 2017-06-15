/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG482Info;
import com.deliverik.framework.workflow.prd.model.condition.IG482SearchCond;

/**
  * ����: �����������ϵ�����DAO�ӿ�
  * ��������: �����������ϵ�����DAO�ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG482DAO extends BaseHibernateDAO<IG482Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG482Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG482Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG482SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG482Info> findByCond(
			final IG482SearchCond cond, final int start,
			final int count);

}