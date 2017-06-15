/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.condition.IG108SearchCond;

/**
  * ����: �Զ������̱���ѯ���������DAO�ӿ�
  * ��������: �Զ������̱���ѯ���������DAO�ӿ�
  * ������¼: 2013/03/13
  * �޸ļ�¼: 
  */
public interface IG108DAO extends BaseHibernateDAO<IG108Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG108Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG108Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG108SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG108Info> findByCond(
			final IG108SearchCond cond, final int start,
			final int count);

}