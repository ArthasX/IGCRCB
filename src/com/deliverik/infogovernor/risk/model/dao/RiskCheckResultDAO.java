/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCond;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCondImpl;

/**
 * ���ռ����DAO�ӿ�
 */
public interface RiskCheckResultDAO extends BaseHibernateDAO<RiskCheckResult> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RiskCheckResult> findAll();

	/**
	 * ������������
	 * @param rcrid ����
	 * @return �������
	 */
	public RiskCheckResult findByPK(Serializable rcrid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskCheckResultSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckResult> findByCond(final RiskCheckResultSearchCond cond, final int start, final int count);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckResult> findResultByCond(final RiskCheckResultSearchCond cond, final int start, final int count);
	
	/**
	 * ��ҳ��鹤����ѯ
	 * @param userid ��ѯ�û�ID
	 * @param desc �Ƿ�ʱ�䵹������
	 * @param group �Ƿ��ѯ��ؼ�鹤����Ϣ(true:��;flase:��) 
	 * @return ��������б�
	 */
	public List<RiskCheckResult> riskCheckResultGoup(final String userid, final boolean desc, final boolean group);
	
	/**
	 * ������ѯ
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckResult> sel(final RiskCheckResultSearchCondImpl cond, final int start, final int count);
	public List<RiskCheckResult>  dbmrcrsel(String year);
	public List<RiskCheckResult>  getRiskCheckResult(final RiskCheckResultSearchCond cond);
	
	/**
	 * �����������(�ٷֱ�)����ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCountForRate(final RiskCheckResultSearchCond cond);
}
