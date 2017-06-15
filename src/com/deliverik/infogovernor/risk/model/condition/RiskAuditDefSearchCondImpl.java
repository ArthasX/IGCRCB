/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
 *  风险审计项信息查询条件实现
 *  @author lipeng@deliverik.com
 */
public class RiskAuditDefSearchCondImpl implements RiskAuditDefSearchCond {
	
	/** 风险审计版本id */
	protected Integer raid;
	

	/** 风险审计状态 */
	protected String radstatus;
	
	/** 风险审计项层次码 */
	protected String radcode;
	
	/** 风险审计项层次码 */
	protected String radcode_q;
	
	/** 风险审计项上级层次码 */
	protected String radparcode;
	
	/** 风险审计项上级层次码查询 */
	protected String radparcode_q;
	
	/** 风险审计项版本 */
	protected String raversion;
	
	/** 按照层次降序排列 */
	protected String byLevelDesc;
	
	
	
	/**
	 * 按照层次降序排列取得
	 * @return 按照层次降序排列
	 */
	public String getByLevelDesc() {
		return byLevelDesc;
	}

	/**
	 * 按照层次降序排列设定
	 * @param byLevelDesc 按照层次降序排列
	 */
	public void setByLevelDesc(String byLevelDesc) {
		this.byLevelDesc = byLevelDesc;
	}

	/**
	 * 风险审计项版本取得
	 * @return 风险审计项版本
	 */
	public String getRaversion() {
		return raversion;
	}

	/**
	 * 风险审计项版本设定
	 * @param raversion 风险审计项版本
	 */
	public void setRaversion(String raversion) {
		this.raversion = raversion;
	}
	
	public String getRadcode_q() {
		return radcode_q;
	}

	public void setRadcode_q(String radcode_q) {
		this.radcode_q = radcode_q;
	}

	public String getRadparcode_q() {
		return radparcode_q;
	}

	public void setRadparcode_q(String radparcode_q) {
		this.radparcode_q = radparcode_q;
	}

	/**
	 * 风险审计项上级层次码取得
	 * @return 风险审计项上级层次码
	 */
	public String getRadparcode() {
		return radparcode;
	}

	/**
	 * 风险审计项上级层次码设定
	 * @param radparcode 风险审计项上级层次码
	 */
	public void setRadparcode(String radparcode) {
		this.radparcode = radparcode;
	}
	
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
	 * 风险审计项状态取得
	 * @return 风险审计项状态
	 */
	public String getRadstatus() {
		return radstatus;
	}

	/**
	 * 风险审计项状态设定
	 * @param radfrequency 风险审计项状态
	 */
	public void setRadstatus(String radstatus) {
		this.radstatus = radstatus;
	}

	/**
	 * 风险审计项层次码取得
	 * @return 风险审计项层次码
	 */
	public String getRadcode() {
		return radcode;
	}

	/**
	 * 风险审计项层次码设定
	 * @param radcode 风险审计项层次码
	 */
	public void setRadcode(String radcode) {
		this.radcode = radcode;
	}
}
