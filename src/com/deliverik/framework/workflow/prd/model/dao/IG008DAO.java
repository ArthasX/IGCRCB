/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG008Info;
import com.deliverik.framework.workflow.prd.model.condition.IG008SearchCond;

/**
  * ����: ��Ա����ɫ�޶�DAO�ӿ�
  * ��������: ��Ա����ɫ�޶�DAO�ӿ�
  * ������¼: 2013/11/27
  * �޸ļ�¼: 
  */
public interface IG008DAO extends BaseHibernateDAO<IG008Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG008Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG008Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG008SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG008Info> findByCond(
			final IG008SearchCond cond, final int start,
			final int count);

}