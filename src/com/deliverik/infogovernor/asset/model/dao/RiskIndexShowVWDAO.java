/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.RiskIndexShowVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexShowVWSearchCond;

/**
  * ����: ����ָ��չʾ��ѯDAO�ӿ�
  * ��������: ����ָ��չʾ��ѯDAO�ӿ�
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public interface RiskIndexShowVWDAO extends BaseHibernateDAO<RiskIndexShowVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskIndexShowVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskIndexShowVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskIndexShowVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskIndexShowVWInfo> findByCond(
			final RiskIndexShowVWSearchCond cond, final int start,
			final int count);

}