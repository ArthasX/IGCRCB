/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
 * 风险审计信息查询条件实现
 * @author lipeng@deliverik.com
 */
public class RiskAuditSearchCondImpl implements RiskAuditSearchCond {
	
	/** 风险审计版本id */
	protected Integer raid;
	
	/** 风险审计版本 */
	protected String raversion;
	
	/** 风险审计状态 */
	protected String rastatus;
	
	/**
	 * 风险审计版本id取得
	 * @return 风险审计版本id
	 */
	public Integer getRaid() {
		return raid;
	}

	/**
	 * 风险审计版本id设定
	 * @param raversion 风险审计id版本
	 */
	public void setRaid(Integer raid) {
		this.raid = raid;
	}

	/**
	 * 风险审计版本取得
	 * @return 风险审计版本
	 */
	public String getRaversion() {
		return raversion;
	}

	/**
	 * 风险审计版本设定
	 * @param raversion 风险审计版本
	 */
	public void setRaversion(String raversion) {
		this.raversion = raversion;
	}
	
	/**
	 * 风险审计状态取得
	 * @return 风险审计状态
	 */
	public String getRastatus() {
		return rastatus;
	}

	/**
	 * 风险审计状态设定
	 * @param rastatus 风险审计状态
	 */
	public void setRastatus(String rastatus) {
		this.rastatus = rastatus;
	}
}
