/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.RiskAudit;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditSearchCond;

/**
 * 
 * �����Ϣҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public interface RiskAuditBL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RiskAuditSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param raid �����ϢID
	 * @return �����Ϣ
	 */
	public RiskAudit searchRiskAuditByKey(Integer raid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�������Ϣ��Ϣ
	 */
	public List<RiskAudit> searchRiskAuditAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAudit> searchRiskAudit(RiskAuditSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param RiskAudit ��¼����
	 * @return �����Ϣ
	 */
	public RiskAudit registRiskAudit(RiskAudit riskAudit) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param raid �����ϢID
	 * @return
	 */
	public void deleteRiskAudit(Integer raid) throws BLException;

	/**
	 * �������
	 * 
	 * @param riskAudit �������
	 * @return �����Ϣ
	 */
	public RiskAudit updateRiskAudit(RiskAudit riskAudit) throws BLException;
	
	/**
	 * �汾�����б��ѯ
	 * 
	 * @return �汾�����б�
	 */
	public List<LabelValueBean> searchRiskAuditLabelInUse();
	
	/**
	 * ��ȡ��ǰ���汾����ʶ
	 * @return ���汾����ʶ
	 */
	
	public String getMaxRacode();

}
