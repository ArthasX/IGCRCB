/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;

/**
 * 审计评估检查项检索结果ＶＯ
 * 
 * @author maozhipeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRIS01151VO extends BaseVO implements Serializable{
	
	/** 审计评估检查项检索结果 */
	protected List<RiskCheck> riskCheckList;
	
	/** 审计评估检查结果检索结果 */
	protected List<RiskCheckResult> riskCheckResultList;
	
	/**风险检查详细信息*/
	
	protected RiskCheck riskCheck;
	
	/** 风险检查策略表达式的解释信息 */
	protected String cronInfo;
	
	/** 风险检查信息附件集合 */
	protected List<Attachment> attachmentList;
	
	/**风险检查结果*/
	protected Map<RiskCheckResult, List<Attachment>> attachmentMap;
	
	public IGRIS01151VO() {
		
	}
	/**
	 * 构造函数
	 * @param riskAuditResultList　审计评估信息检索结果
	 */
	public IGRIS01151VO(List<RiskCheck> riskCheckList) {
		this.riskCheckList = riskCheckList;
	}
	
	public Map<RiskCheckResult, List<Attachment>> getAttachmentMap() {
		return attachmentMap;
	}
	public void setAttachmentMap(
			Map<RiskCheckResult, List<Attachment>> attachmentMap) {
		this.attachmentMap = attachmentMap;
	}
	public List<RiskCheckResult> getRiskCheckResultList() {
		return riskCheckResultList;
	}
	public void setRiskCheckResultList(List<RiskCheckResult> riskCheckResultList) {
		this.riskCheckResultList = riskCheckResultList;
	}
	public List<RiskCheck> getRiskCheckList() {
		return riskCheckList;
	}
	public RiskCheck getRiskCheck() {
		return riskCheck;
	}
	public void setRiskCheck(RiskCheck riskCheck) {
		this.riskCheck = riskCheck;
	}
	public String getCronInfo() {
		return cronInfo;
	}
	public void setCronInfo(String cronInfo) {
		this.cronInfo = cronInfo;
	}
	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}
	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

}


