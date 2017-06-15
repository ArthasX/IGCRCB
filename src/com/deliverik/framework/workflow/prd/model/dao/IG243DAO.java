/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCond;

/**
  * ����: ���̱��ⶨ���DAO�ӿ�
  * ��������: ���̱��ⶨ���DAO�ӿ�
  * ������¼: 2012/03/30
  * �޸ļ�¼: 
  */
public interface IG243DAO extends BaseHibernateDAO<IG243Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG243Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG243Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG243SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG243Info> findByCond(
			final IG243SearchCond cond, final int start,
			final int count);
	
	/**
	 * PTDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PTDID����ֵ
	 */
	public String getPtdidSequenceNextValue(String pdid);

}