/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.CheckToRiskRelateVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckToRiskRelateVWSearchCond;

/**
  * ����: �������յ��ϵģ��DAO�ӿ�
  * ��������: �������յ��ϵģ��DAO�ӿ�
  * ������¼: 2014/07/23
  * �޸ļ�¼: 
  */
public interface CheckToRiskRelateVWDAO extends BaseHibernateDAO<CheckToRiskRelateVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckToRiskRelateVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckToRiskRelateVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckToRiskRelateVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckToRiskRelateVWInfo> findByCond(
			final CheckToRiskRelateVWSearchCond cond, final int start,
			final int count);

}