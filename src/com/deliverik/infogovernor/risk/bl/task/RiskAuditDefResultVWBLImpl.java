/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefResultVWSearchCond;
import com.deliverik.infogovernor.risk.model.dao.RiskAuditDefResultVWDAO;

/**
 * 
 * ��������������������ͼҵ���߼��ӿ�
 * @author liupeng@deliverik.com
 *
 */
public class RiskAuditDefResultVWBLImpl extends BaseBLImpl implements RiskAuditDefResultVWBL{
	
	/** RiskAuditDefResultVW DAO */
	protected RiskAuditDefResultVWDAO RiskAuditDefResultVWDAO;
	
	public void setRiskAuditDefResultVWDAO(
			RiskAuditDefResultVWDAO RiskAuditDefResultVWDAO) {
		this.RiskAuditDefResultVWDAO = RiskAuditDefResultVWDAO;
	}


	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskAuditDefResultVWInfo> searchRiskAuditDefResultVW(RiskAuditDefResultVWSearchCond cond, int start, int count){
		
		return RiskAuditDefResultVWDAO.findByCond(cond,start,count);
	}
	
	/**
	 * ��ȡ�������󼶴�
	 * @return �������󼶴�
	 */
	public String getMaxRadlevel(RiskAuditDefResultVWSearchCond cond){
		return RiskAuditDefResultVWDAO.getMaxRadlevel(cond);
	}
	
}
