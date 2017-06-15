/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
 * 审计项和相关审计人外联视图查询条件实现
 * @author lipeng@deliverik.com
 */
public class RiskAuditDefResultVWSearchCondImpl implements RiskAuditDefResultVWSearchCond {
	
	/** 风险审计发起ID */
	protected Integer raiid;
	
	/** 风险审计项状态 */
	protected String radstatus;


	/**
	 * 风险审计项状态取得
	 * @return 风险审计项状态
	 */
	public String getRadstatus() {
		return radstatus;
	}

	/**
	 * 风险审计项状态设定
	 * @param radstatus 风险审计项状态
	 */
	public void setRadstatus(String radstatus) {
		this.radstatus = radstatus;
	}
	
	/**
	 * 风险审计发起ID取得
	 * @return 风险审计发起ID
	 */
	public Integer getRaiid() {
		return raiid;
	}

	/**
	 * 风险审计发起ID设定
	 * @param raiid 风险审计发起ID
	 */
	public void setRaiid(Integer raiid) {
		this.raiid = raiid;
	}
}
