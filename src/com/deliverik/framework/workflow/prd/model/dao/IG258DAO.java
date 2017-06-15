/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG258Info;
import com.deliverik.framework.workflow.prd.model.condition.IG258SearchCond;

/**
  * ����: ����״̬�����ߵ���DAO�ӿ�
  * ��������: ����״̬�����ߵ���DAO�ӿ�
  * ������¼: 2012/05/09
  * �޸ļ�¼: 
  */
public interface IG258DAO extends BaseHibernateDAO<IG258Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG258Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG258Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG258SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG258Info> findByCond(
			final IG258SearchCond cond, final int start,
			final int count);

	public String getPspcdSequenceNextValue(final String psdid);
}