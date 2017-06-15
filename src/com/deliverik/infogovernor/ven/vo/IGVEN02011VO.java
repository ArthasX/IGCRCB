package com.deliverik.infogovernor.ven.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.risk.model.CheckStrategyInfo;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;

/**
 * 风险检查信息检索结果ＶＯ
 *
 */
@SuppressWarnings("serial")
public class IGVEN02011VO extends BaseVO implements Serializable{
	/** 风险检查信息检索结果 */
	protected List<RiskCheck> riskCheckDataList;
	
	/** 风险检查附件 */
	protected List<Attachment> attachmentDataList;
	
	protected List<CheckStrategyInfo> checkStrategyList;

	/** 风险检查对象 */
	protected RiskCheck riskCheck;
	
	/** 风险检查策略表达式的解释信息 */
	protected String cronInfo;
	
	/** 风险检查结果信息检索结果 */
	protected List<RiskCheckResult> riskCheckResultDataList;
	
	/** 风险检查结果对象 */
	protected RiskCheckResult riskCheckResult;
	
	/** 风险审计项信息检索结果集 */
	protected List<RiskAuditDef> riskAuditDefList;
	
	/** 审计项最大级次 */
	protected Integer radMaxLevel;
	
	/** 审计项级次list */
	protected List<Integer> radMaxLevelList;
	
	/** 返回标识 */
	protected String mode;
	
	/**
	 * 返回标识获取
	 * 
	 * @return 返回标识
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 返回标识设定
	 * 
	 * @param mode 返回标识
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	
	/**
	 * @return the checkStrategyList
	 */
	public List<CheckStrategyInfo> getCheckStrategyList() {
		return checkStrategyList;
	}

	/**
	 * @param checkStrategyList the checkStrategyList to set
	 */
	public void setCheckStrategyList(List<CheckStrategyInfo> checkStrategyList) {
		this.checkStrategyList = checkStrategyList;
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


