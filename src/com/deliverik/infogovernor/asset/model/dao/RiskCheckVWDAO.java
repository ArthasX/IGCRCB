/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.RiskCheckVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskCheckVWSearchCond;

/**
  * ����: ��鹤��ͳ�Ʊ���DAO�ӿ�
  * ��������: ��鹤��ͳ�Ʊ���DAO�ӿ�
  * ������¼: 2014/07/22
  * �޸ļ�¼: 
  */
public interface RiskCheckVWDAO extends BaseHibernateDAO<RiskCheckVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskCheckVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskCheckVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskCheckVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckVWInfo> findByCond(
			final RiskCheckVWSearchCond cond, final int start,
			final int count);

}