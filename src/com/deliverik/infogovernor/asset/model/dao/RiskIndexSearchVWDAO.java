/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexSearchVWSearchCond;

/**
  * ����: ����ָ���ѯDAO�ӿ�
  * ��������: ����ָ���ѯDAO�ӿ�
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public interface RiskIndexSearchVWDAO extends BaseHibernateDAO<RiskIndexSearchVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskIndexSearchVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskIndexSearchVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskIndexSearchVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskIndexSearchVWInfo> findByCond(
			final RiskIndexSearchVWSearchCond cond, final int start,
			final int count);

}