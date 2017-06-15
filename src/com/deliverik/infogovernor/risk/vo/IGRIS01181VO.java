/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.risk.model.RiskAuditIns;

/**
 * ��Ʒ�����Ϣ��������֣�
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRIS01181VO extends BaseVO implements Serializable{
	
	/** ��Ʒ�����Ϣ������� */
	protected List<RiskAuditIns> riskAuditInsList;

	/**
	 * ���캯��
	 * @param riskAuditIns����Ʒ�����Ϣ�������
	 */
	public IGRIS01181VO(List<RiskAuditIns> riskAuditInsList) {
		this.riskAuditInsList = riskAuditInsList;
	}
	
	/**
	 * ��Ʒ�����Ϣ�������ȡ��
	 * @return ��Ʒ�����Ϣ�������
	 */
	public List<RiskAuditIns> getRiskAuditInsList() {
		return riskAuditInsList;
	}

}


