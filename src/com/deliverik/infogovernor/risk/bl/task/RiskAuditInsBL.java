/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.RiskAuditIns;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCond;

/**
 * 
 * ��Ʒ�����Ϣҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public interface RiskAuditInsBL extends BaseBL{
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(RiskAuditInsSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param raiid ��Ʒ�����ϢID
	 * @return ��Ʒ�����Ϣ
	 */
	public RiskAuditIns searchRiskAuditInsByKey(Integer raiid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ����Ʒ�����Ϣ��Ϣ
	 */
	public List<RiskAuditIns> searchRiskAuditInsAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAuditIns> searchRiskAuditIns(RiskAuditInsSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param RiskAuditIns ��¼����
	 * @return ��Ʒ�����Ϣ
	 */
	public RiskAuditIns registRiskAuditIns(RiskAuditIns riskAuditIns) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param raiid ��Ʒ�����ϢID
	 * @return
	 */
	public void deleteRiskAuditIns(Integer raiid) throws BLException;

	/**
	 * �������
	 * 
	 * @param riskAuditIns �������
	 * @return ��Ʒ�����Ϣ
	 */
	public RiskAuditIns updateRiskAuditIns(RiskAuditIns riskAuditIns) throws BLException;
	
	
	/**
	 * �汾�����б��ѯ
	 * 
	 * @return �汾�����б�
	 */
	public List<LabelValueBean> searchRiskAuditInsLabelInUse() ;

}
