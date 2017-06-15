package com.deliverik.infogovernor.ven.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.risk.model.CheckStrategyInfo;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.ven.model.RiskStrategyInfo;

/**
 * ���ռ����Ϣ��������֣�
 *
 */
@SuppressWarnings("serial")
public class IGVEN01011VO extends BaseVO implements Serializable{
	/** ���ռ����Ϣ������� */
	protected List<RiskCheck> riskCheckDataList;
	
	/** ���ռ�鸽�� */
	protected List<Attachment> attachmentDataList;
	
	protected List<RiskStrategyInfo> riskStrategyList;

	/** ���ռ����� */
	protected RiskCheck riskCheck;
	
	/** ���ռ����Ա��ʽ�Ľ�����Ϣ */
	protected String cronInfo;
	
	/** ���ռ������Ϣ������� */
	protected List<RiskCheckResult> riskCheckResultDataList;
	
	/** ���ռ�������� */
	protected RiskCheckResult riskCheckResult;
	
	/** �����������Ϣ��������� */
	protected List<RiskAuditDef> riskAuditDefList;
	
	/** �������󼶴� */
	protected Integer radMaxLevel;
	
	/** ������list */
	protected List<Integer> radMaxLevelList;
	
	/** ���ر�ʶ */
	protected String mode;
	
	/**
	 * ���ر�ʶ��ȡ
	 * 
	 * @return ���ر�ʶ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ���ر�ʶ�趨
	 * 
	 * @param mode ���ر�ʶ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}



	public List<RiskStrategyInfo> getRiskStrategyList() {
		return riskStrategyList;
	}

	public void setRiskStrategyList(List<RiskStrategyInfo> riskStrategyList) {
		this.riskStrategyList = riskStrategyList;
	}

	/**
	 * @return the riskAuditDefList
	 */
	public List<RiskAuditDef> getRiskAuditDefList() {
		return riskAuditDefList;
	}

	/**
	 * @return the radMaxLevel
	 */
	public Integer getRadMaxLevel() {
		return radMaxLevel;
	}

	/**
	 * @return the radMaxLevelList
	 */
	public List<Integer> getRadMaxLevelList() {
		return radMaxLevelList;
	}

	/**
	 * @param riskAuditDefList the riskAuditDefList to set
	 */
	public void setRiskAuditDefList(List<RiskAuditDef> riskAuditDefList) {
		this.riskAuditDefList = riskAuditDefList;
	}

	/**
	 * @param radMaxLevel the radMaxLevel to set
	 */
	public void setRadMaxLevel(Integer radMaxLevel) {
		this.radMaxLevel = radMaxLevel;
	}

	/**
	 * @param radMaxLevelList the radMaxLevelList to set
	 */
	public void setRadMaxLevelList(List<Integer> radMaxLevelList) {
		this.radMaxLevelList = radMaxLevelList;
	}

	/**
	 * @return the riskCheckResult
	 */
	public RiskCheckResult getRiskCheckResult() {
		return riskCheckResult;
	}

	/**
	 * @param riskCheckResult the riskCheckResult to set
	 */
	public void setRiskCheckResult(RiskCheckResult riskCheckResult) {
		this.riskCheckResult = riskCheckResult;
	}

	/**
	 * @return the riskCheckResultDataList
	 */
	public List<RiskCheckResult> getRiskCheckResultDataList() {
		return riskCheckResultDataList;
	}

	/**
	 * @param riskCheckResultDataList the riskCheckResultDataList to set
	 */
	public void setRiskCheckResultDataList(
			List<RiskCheckResult> riskCheckResultDataList) {
		this.riskCheckResultDataList = riskCheckResultDataList;
	}

	/**
	 * @return the cronInfo
	 */
	public String getCronInfo() {
		return cronInfo;
	}

	/**
	 * @param cronInfo the cronInfo to set
	 */
	public void setCronInfo(String cronInfo) {
		this.cronInfo = cronInfo;
	}

	/**
	 * @return the riskCheck
	 */
	public RiskCheck getRiskCheck() {
		return riskCheck;
	}

	/**
	 * @param riskCheck the riskCheck to set
	 */
	public void setRiskCheck(RiskCheck riskCheck) {
		this.riskCheck = riskCheck;
	}

	/**
	 * @return the attachmentDataList
	 */
	public List<Attachment> getAttachmentDataList() {
		return attachmentDataList;
	}

	/**
	 * @param attachmentDataList the attachmentDataList to set
	 */
	public void setAttachmentDataList(List<Attachment> attachmentDataList) {
		this.attachmentDataList = attachmentDataList;
	}

	/**
	 * @return the riskCheckDataList
	 */
	public List<RiskCheck> getRiskCheckDataList() {
		return riskCheckDataList;
	}

	/**
	 * @param riskCheckDataList the riskCheckDataList to set
	 */
	public void setRiskCheckDataList(List<RiskCheck> riskCheckDataList) {
		this.riskCheckDataList = riskCheckDataList;
	}
	
	

}


