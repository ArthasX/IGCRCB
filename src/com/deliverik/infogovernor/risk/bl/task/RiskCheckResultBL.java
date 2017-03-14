/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCond;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCondImpl;

/**
 * 
 * ���ռ������Ϣҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public interface RiskCheckResultBL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RiskCheckResultSearchCond cond);
	
	/**
	 * �����������(�ٷֱ�)����ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCountForRate(RiskCheckResultSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param rcrid ���ռ������ϢID
	 * @return ���ռ������Ϣ
	 */
	public RiskCheckResult searchRiskCheckResultByKey(Integer rcrid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����ռ������Ϣ��Ϣ
	 */
	public List<RiskCheckResult> searchRiskCheckResultAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckResult> searchRiskCheckResult(RiskCheckResultSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param RiskCheckResult ��¼����
	 * @return ���ռ������Ϣ
	 */
	public RiskCheckResult registRiskCheckResult(RiskCheckResult riskCheckResult) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param rcrid ���ռ������ϢID
	 * @return
	 */
	public void deleteRiskCheckResult(Integer rcrid) throws BLException;

	/**
	 * �������
	 * 
	 * @param riskCheckResult �������
	 * @return ���ռ������Ϣ
	 */
	public RiskCheckResult updateRiskCheckResult(RiskCheckResult riskCheckResult) throws BLException;
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckResult> findResultByCond(RiskCheckResultSearchCond cond, int start, int count);

	/**
	 * ��ҳ��鹤����ѯ
	 * @param userid ��ѯ�û�ID
	 * @param desc �Ƿ�ʱ�䵹������
	 * @param group �Ƿ��ѯ��ؼ�鹤����Ϣ(true:��;flase:��) 
	 * @return ��������б�
	 */
	public List<RiskCheckResult> riskCheckResultGoup(String userid, boolean desc, boolean group);
	
	public List<RiskCheckResult> sel(RiskCheckResultSearchCondImpl cond, int i,int j);
	public List<RiskCheckResult> dbmrcrsel(String year);
	public List<RiskCheckResult> getRiskCheckResult(RiskCheckResultSearchCond cond);

}
