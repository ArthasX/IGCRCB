/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.ven.model.StrategyIndexRelationInfo;
import com.deliverik.infogovernor.ven.model.condition.StrategyIndexRelationSearchCond;

/**
  * ����: ���ղ���ָ���ϵ��DAO�ӿ�
  * ��������: ���ղ���ָ���ϵ��DAO�ӿ�
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public interface StrategyIndexRelationDAO extends BaseHibernateDAO<StrategyIndexRelationInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<StrategyIndexRelationInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public StrategyIndexRelationInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final StrategyIndexRelationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<StrategyIndexRelationInfo> findByCond(
			final StrategyIndexRelationSearchCond cond, final int start,
			final int count);

}