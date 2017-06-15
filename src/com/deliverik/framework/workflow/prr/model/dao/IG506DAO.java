/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.condition.IG506SearchCond;

/**
  * ����: ��Ա���ֵ��DAO�ӿ�
  * ��������: ��Ա���ֵ��DAO�ӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG506DAO extends BaseHibernateDAO<IG506Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG506Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG506Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG506SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG506Info> findByCond(
			final IG506SearchCond cond, final int start,
			final int count);

}