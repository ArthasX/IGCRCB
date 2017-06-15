/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskPointVMSearchCond;

/**
  * ����: ���յ��ѯDAO�ӿ�
  * ��������: ���յ��ѯDAO�ӿ�
  * ������¼: 2014/06/30
  * �޸ļ�¼: 
  */
public interface RiskPointVMDAO extends BaseHibernateDAO<RiskPointVMInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskPointVMInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskPointVMInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskPointVMSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskPointVMInfo> findByCond(
			final RiskPointVMSearchCond cond, final int start,
			final int count);

}