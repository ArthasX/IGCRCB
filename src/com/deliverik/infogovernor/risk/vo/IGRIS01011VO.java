/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.risk.model.RiskAudit;

/**
 * ��ư汾��Ϣ��������֣�
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRIS01011VO extends BaseVO implements Serializable{
	
	/** ��ư汾��Ϣ������� */
	protected List<RiskAudit> riskAuditList;

	/**
	 * ���캯��
	 * @param riskAudit����ư汾��Ϣ�������
	 */
	public IGRIS01011VO(List<RiskAudit> riskAuditList) {
		this.riskAuditList = riskAuditList;
	}
	
	/**
	 * ��ư汾��Ϣ�������ȡ��
	 * @return ��ư汾��Ϣ�������
	 */
	public List<RiskAudit> getRiskAuditList() {
		return riskAuditList;
	}

}


