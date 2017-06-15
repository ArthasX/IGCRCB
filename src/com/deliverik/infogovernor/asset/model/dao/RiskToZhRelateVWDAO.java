/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskToZhRelateVWSearchCond;

/**
  * ����: ���յ�ָ���ϵDAO�ӿ�
  * ��������: ���յ�ָ���ϵDAO�ӿ�
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public interface RiskToZhRelateVWDAO extends BaseHibernateDAO<RiskToZhRelateVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskToZhRelateVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskToZhRelateVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskToZhRelateVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskToZhRelateVWInfo> findByCond(
			final RiskToZhRelateVWSearchCond cond, final int start,
			final int count);

}