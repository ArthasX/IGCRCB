/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.condition.IG156SearchCond;

/**
  * ����: ����״̬��ť�����DAO�ӿ�
  * ��������: ����״̬��ť�����DAO�ӿ�
  * ������¼: 2012/04/13
  * �޸ļ�¼: 
  */
public interface IG156DAO extends BaseHibernateDAO<IG156Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG156Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG156Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG156SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG156Info> findByCond(
			final IG156SearchCond cond, final int start,
			final int count);

	/**
	 * PEDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PEDID����ֵ
	 */
	public String getPedidSequenceNextValue(String psdid);
}