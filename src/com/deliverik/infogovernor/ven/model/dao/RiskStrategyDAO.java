/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.ven.model.RiskStrategyInfo;
import com.deliverik.infogovernor.ven.model.condition.RiskStrategySearchCond;

/**
  * ����: ���ղ��Ա�DAO�ӿ�
  * ��������: ���ղ��Ա�DAO�ӿ�
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public interface RiskStrategyDAO extends BaseHibernateDAO<RiskStrategyInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskStrategyInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskStrategyInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskStrategySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskStrategyInfo> findByCond(
			final RiskStrategySearchCond cond, final int start,
			final int count);

}