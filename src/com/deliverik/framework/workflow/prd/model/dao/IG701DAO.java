/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCond;

/**
  * ����: ���̲鿴��ɫ��Ȩ����DAO�ӿ�
  * ��������: ���̲鿴��ɫ��Ȩ����DAO�ӿ�
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
public interface IG701DAO extends BaseHibernateDAO<IG701Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG701Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG701Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG701SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG701Info> findByCond(
			final IG701SearchCond cond, final int start,
			final int count);

}