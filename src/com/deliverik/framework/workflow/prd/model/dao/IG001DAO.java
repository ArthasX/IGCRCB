/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCond;

/**
  * ����: OA��ɫ���ñ�DAO�ӿ�
  * ��������: OA��ɫ���ñ�DAO�ӿ�
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
public interface IG001DAO extends BaseHibernateDAO<IG001Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG001Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG001Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG001SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG001Info> findByCond(
			final IG001SearchCond cond, final int start,
			final int count);

}