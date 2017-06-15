/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.fxk.model.RiskprojectvwInfo;
import com.deliverik.infogovernor.fxk.model.condition.RiskprojectvwSearchCond;

/**
  * ����: ͨѶ¼DAO�ӿ�
  * ��������: ͨѶ¼DAO�ӿ�
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public interface RiskprojectvwDAO extends BaseHibernateDAO<RiskprojectvwInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskprojectvwInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskprojectvwInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskprojectvwSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskprojectvwInfo> findByCond(
			final RiskprojectvwSearchCond cond, final int start,
			final int count);

}