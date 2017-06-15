/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.risk.model.RiskAuditResult;

/**
 * ���������Ϣ��������֣�
 * 
 * @author maozhipeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRIS01131VO extends BaseVO implements Serializable{
	
	/** ���������Ϣ������� */
	protected List<RiskAuditResult> riskAuditResultList;
	
	/** ���������ϸ��Ϣ */
	protected RiskAuditResult riskAuditResult;
	
	/** ��Ʒ������������б� */
	protected List<LabelValueBean> riskAuditResultLabelList;
	
	/**
	 * ��Ʒ������������б�ȡ��
	 * 
	 * @return ��Ʒ������������б�
	 */
	public List<LabelValueBean> getRiskAuditResultLabelList() {
		return riskAuditResultLabelList;
	}

	/**
	 * ��Ʒ������������б��趨
	 *
	 * @param riskAuditResultLabelList ��Ʒ������������б�
	 */
	public void setRiskAuditResultLabelList(List<LabelValueBean> riskAuditResultLabelList) {
		this.riskAuditResultLabelList = riskAuditResultLabelList;
	}
	

	public IGRIS01131VO() {
		
	}
	/**
	 * ���캯��
	 * @param riskAuditResultList�����������Ϣ�������
	 */
	public IGRIS01131VO(List<RiskAuditResult> riskAuditResultList) {
		this.riskAuditResultList = riskAuditResultList;
	}
	
	
	/**
	 * ���������Ϣ�������ȡ��
	 * @return ���������Ϣ�������
	 */

	public List<RiskAuditResult> getRiskAuditResultList() {
		return riskAuditResultList;
	}
	/**
	 * ���������ϸ��Ϣȡ��
	 * @return ���������ϸ��Ϣ���
	 */
	public RiskAuditResult getRiskAuditResult() {
		return riskAuditResult;
	}
	/**
	 * ���������ϸ��Ϣ�趨
	 * @param ���������ϸ��Ϣ���
	 */
	public void setRiskAuditResult(RiskAuditResult riskAuditResult) {
		this.riskAuditResult = riskAuditResult;
	}

}


