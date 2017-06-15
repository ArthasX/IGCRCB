/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCond;

/**
  * ����: ����˽�б�����DAO�ӿ�
  * ��������: ����˽�б�����DAO�ӿ�
  * ������¼: 2012/03/27
  * �޸ļ�¼: 
  */
public interface IG899DAO extends BaseHibernateDAO<IG899Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG899Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG899Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG899SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG899Info> findByCond(
			final IG899SearchCond cond, final int start,
			final int count);

}