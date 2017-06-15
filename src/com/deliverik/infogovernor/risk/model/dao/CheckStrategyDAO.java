/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.CheckStrategyInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckStrategySearchCond;

/**
  * ����: ������DAO�ӿ�
  * ��������: ������DAO�ӿ�
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public interface CheckStrategyDAO extends BaseHibernateDAO<CheckStrategyInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckStrategyInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckStrategyInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckStrategySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckStrategyInfo> findByCond(
			final CheckStrategySearchCond cond, final int start,
			final int count);
}