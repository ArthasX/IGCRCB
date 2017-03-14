/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG256Info;
import com.deliverik.framework.workflow.prd.model.condition.IG256SearchCond;

/**
  * ����: ���̲�������DAO�ӿ�
  * ��������: ���̲�������DAO�ӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG256DAO extends BaseHibernateDAO<IG256Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG256Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG256Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG256SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG256Info> findByCond(
			final IG256SearchCond cond, final int start,
			final int count);

}