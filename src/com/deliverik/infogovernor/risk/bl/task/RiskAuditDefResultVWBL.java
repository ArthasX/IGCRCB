/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefResultVWSearchCond;

/**
 * 
 * ��������������������ͼҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public interface RiskAuditDefResultVWBL extends BaseBL{

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAuditDefResultVWInfo> searchRiskAuditDefResultVW(RiskAuditDefResultVWSearchCond cond, int start, int count);
	
	/**
	 * ��ȡ�������󼶴�
	 * @return �������󼶴�
	 */
	public String getMaxRadlevel(RiskAuditDefResultVWSearchCond cond);

}
