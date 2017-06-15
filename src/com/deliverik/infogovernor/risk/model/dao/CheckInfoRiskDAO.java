/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.CheckInfoRiskInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckInfoRiskSearchCond;

/**
  * ����: �����Թ���������DAO�ӿ�
  * ��������: �����Թ���������DAO�ӿ�
  * ������¼: 2014/09/03
  * �޸ļ�¼: 
  */
public interface CheckInfoRiskDAO extends BaseHibernateDAO<CheckInfoRiskInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckInfoRiskInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckInfoRiskInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckInfoRiskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckInfoRiskInfo> findByCond(
			final CheckInfoRiskSearchCond cond, final int start,
			final int count);

}