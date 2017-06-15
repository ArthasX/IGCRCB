/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexContextVWSearchCond;

/**
  * ����: ����ָ��չʾ���ݲ�ѯDAO�ӿ�
  * ��������: ����ָ��չʾ���ݲ�ѯDAO�ӿ�
  * ������¼: 2014/07/26
  * �޸ļ�¼: 
  */
public interface RiskIndexContextVWDAO extends BaseHibernateDAO<RiskIndexContextVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskIndexContextVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskIndexContextVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskIndexContextVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskIndexContextVWInfo> findByCond(
			final RiskIndexContextVWSearchCond cond, final int start,
			final int count);

}