/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefSearchCond;

/**
 * 
 * �������Ϣҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public interface RiskAuditDefBL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RiskAuditDefSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param radid �������ϢID
	 * @return �������Ϣ
	 */
	public RiskAuditDef searchRiskAuditDefByKey(Integer radid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ���������Ϣ��Ϣ
	 */
	public List<RiskAuditDef> searchRiskAuditDefAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAuditDef> searchRiskAuditDef(RiskAuditDefSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param RiskAuditDef ��¼����
	 * @return �������Ϣ
	 */
	public RiskAuditDef registRiskAuditDef(RiskAuditDef riskAuditDef) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param radid �������ϢID
	 * @return
	 */
	public void deleteRiskAuditDef(Integer radid) throws BLException;

	/**
	 * �������
	 * 
	 * @param riskAuditDef �������
	 * @return �������Ϣ
	 */
	public RiskAuditDef updateRiskAuditDef(RiskAuditDef riskAuditDef) throws BLException;

}
