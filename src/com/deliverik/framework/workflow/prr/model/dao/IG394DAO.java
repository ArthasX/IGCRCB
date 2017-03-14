/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG394Info;
import com.deliverik.framework.workflow.prr.model.condition.IG394SearchCond;

/**
  * ����: ���Ѽ�¼��DAO�ӿ�
  * ��������: ���Ѽ�¼��DAO�ӿ�
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
public interface IG394DAO extends BaseHibernateDAO<IG394Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG394Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG394Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG394SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG394Info> findByCond(
			final IG394SearchCond cond, final int start,
			final int count);

}