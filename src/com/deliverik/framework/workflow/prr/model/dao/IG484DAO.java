/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCond;

/**
  * ����: �������Աʵ��DAO�ӿ�
  * ��������: �������Աʵ��DAO�ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG484DAO extends BaseHibernateDAO<IG484Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG484Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG484Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG484SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG484Info> findByCond(
			final IG484SearchCond cond, final int start,
			final int count);

}