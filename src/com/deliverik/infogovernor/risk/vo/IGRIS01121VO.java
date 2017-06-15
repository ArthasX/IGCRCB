/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;

/**
 * 审计人信息检索结果ＶＯ
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRIS01121VO extends BaseVO implements Serializable{
	
	/** 风险审计人信息检索结果集 */
	protected List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList;
	
	/** 审计项最大级次 */
	protected Integer radMaxLevel;
	
	/** 审计项级次list */
	protected List<Integer> radMaxLevelList;
	
	/**
	 * 风险审计人信息检索结果集取得
	 * 
	 * @return 风险审计人信息检索结果集
	 */
	public List<RiskAuditDefResultVWInfo> getRiskAuditDefResultVWInfoList() {
		return riskAuditDefResultVWInfoList;
	}

	/**
	 * 风险审计人信息检索结果集设定
	 *
	 * @param riskAuditDefResultVWInfoList 风险审计人信息检索结果集
	 */
	public void setRiskAuditDefResultVWInfoList(
			List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList) {
		this.riskAuditDefResultVWInfoList = riskAuditDefResultVWInfoList;
	}

	/**
	 * 审计项最大级次取得
	 * 
	 * @return 审计项最大级次
	 */
	public Integer getRadMaxLevel() {
		return radMaxLevel;
	}
	
	/**
	 * 审计项最大级次设定
	 *
	 * @param radMaxLevel 审计项最大级次
	 */
	public void setRadMaxLevel(Integer radMaxLevel) {
		this.radMaxLevel = radMaxLevel;
	}
	
	/**
	 * 审计项级次list取得
	 * 
	 * @return 审计项级次list
	 */
	public List<Integer> getRadMaxLevelList() {
		return radMaxLevelList;
	}

	/**
	 * 审计项级次list设定
	 *
	 * @param List<Integer> 审计项级次list
	 */
	public void setRadMaxLevelList(List<Integer> radMaxLevelList) {
		this.radMaxLevelList = radMaxLevelList;
	}

}


