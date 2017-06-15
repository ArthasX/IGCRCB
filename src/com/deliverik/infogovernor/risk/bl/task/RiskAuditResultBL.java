/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.RiskAuditResult;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditResultSearchCond;

/**
 * 
 * ��ƽ��ʵ��ҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public interface RiskAuditResultBL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RiskAuditResultSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param rarid ��ƽ��ʵ��ID
	 * @return ��ƽ��ʵ��
	 */
	public RiskAuditResult searchRiskAuditResultByKey(Integer rarid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ����ƽ��ʵ����Ϣ
	 */
	public List<RiskAuditResult> searchRiskAuditResultAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAuditResult> searchRiskAuditResult(RiskAuditResultSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param RiskAuditResult ��¼����
	 * @return ��ƽ��ʵ��
	 */
	public RiskAuditResult registRiskAuditResult(RiskAuditResult riskAuditResult) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param rarid ��ƽ��ʵ��ID
	 * @return
	 */
	public void deleteRiskAuditResult(Integer rarid) throws BLException;

	/**
	 * �������
	 * 
	 * @param riskAuditResult �������
	 * @return ��ƽ��ʵ��
	 */
	public RiskAuditResult updateRiskAuditResult(RiskAuditResult riskAuditResult) throws BLException;

}
