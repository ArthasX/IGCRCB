/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sta.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;
import com.deliverik.infogovernor.sta.model.condition.RiskCheckProblemSuperviseVWSearchCond;

/**
  * ����: �������ļලDAO�ӿ�
  * ��������: �������ļලDAO�ӿ�
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
public interface RiskCheckProblemSuperviseVWDAO extends BaseHibernateDAO<RiskCheckProblemSuperviseVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskCheckProblemSuperviseVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskCheckProblemSuperviseVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskCheckProblemSuperviseVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckProblemSuperviseVWInfo> findByCond(
			final RiskCheckProblemSuperviseVWSearchCond cond, final int start,
			final int count);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	public List<RiskCheckProblemSuperviseVWInfo> findRiskCheckProblemSupervise(
			final RiskCheckProblemSuperviseVWSearchCond cond, final int start,final int count);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	public int findRiskCheckProblemSuperviseSearchCount(
			final RiskCheckProblemSuperviseVWSearchCond cond);

}