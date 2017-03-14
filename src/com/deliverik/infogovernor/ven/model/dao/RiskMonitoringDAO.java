/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;
import com.deliverik.infogovernor.ven.model.condition.RiskMonitoringSearchCond;

/**
  * ����: ���ռ���DAO�ӿ�
  * ��������: ���ռ���DAO�ӿ�
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public interface RiskMonitoringDAO extends BaseHibernateDAO<RiskMonitoringInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskMonitoringInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskMonitoringInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskMonitoringSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskMonitoringInfo> findByCond(
			final RiskMonitoringSearchCond cond, final int start,
			final int count);

}