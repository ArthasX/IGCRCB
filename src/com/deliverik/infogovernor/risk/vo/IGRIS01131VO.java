/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.risk.model.RiskAuditResult;

/**
 * 审计评估信息检索结果ＶＯ
 * 
 * @author maozhipeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRIS01131VO extends BaseVO implements Serializable{
	
	/** 审计评估信息检索结果 */
	protected List<RiskAuditResult> riskAuditResultList;
	
	/** 审计评估详细信息 */
	protected RiskAuditResult riskAuditResult;
	
	/** 审计发起批次下拉列表 */
	protected List<LabelValueBean> riskAuditResultLabelList;
	
	/**
	 * 审计发起批次下拉列表取得
	 * 
	 * @return 审计发起批次下拉列表
	 */
	public List<LabelValueBean> getRiskAuditResultLabelList() {
		return riskAuditResultLabelList;
	}

	/**
	 * 审计发起批次下拉列表设定
	 *
	 * @param riskAuditResultLabelList 审计发起批次下拉列表
	 */
	public void setRiskAuditResultLabelList(List<LabelValueBean> riskAuditResultLabelList) {
		this.riskAuditResultLabelList = riskAuditResultLabelList;
	}
	

	public IGRIS01131VO() {
		
	}
	/**
	 * 构造函数
	 * @param riskAuditResultList　审计评估信息检索结果
	 */
	public IGRIS01131VO(List<RiskAuditResult> riskAuditResultList) {
		this.riskAuditResultList = riskAuditResultList;
	}
	
	
	/**
	 * 审计评估信息检索结果取得
	 * @return 审计评估信息检索结果
	 */

	public List<RiskAuditResult> getRiskAuditResultList() {
		return riskAuditResultList;
	}
	/**
	 * 审计评估详细信息取得
	 * @return 审计评估详细信息结果
	 */
	public RiskAuditResult getRiskAuditResult() {
		return riskAuditResult;
	}
	/**
	 * 审计评估详细信息设定
	 * @param 审计评估详细信息结果
	 */
	public void setRiskAuditResult(RiskAuditResult riskAuditResult) {
		this.riskAuditResult = riskAuditResult;
	}

}


