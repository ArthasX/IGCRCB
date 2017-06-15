/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;


/**
 * 风险审计评估结果信息查询条件实现
 * @author lipeng@deliverik.com
 */
public class RiskAuditResultSearchCondImpl implements RiskAuditResultSearchCond {
	
	/** 风险审计评估结果ID */
	protected Integer rarid;

	/** 风险审计发起ID */
	protected Integer raiid;
	
	/** 风险审计项ID */
	protected Integer radid;
	
	/** 风险审计评估人ID */
	protected String raruserid;
	
	/** 风险审计项层次码 */
	protected String radcode;
	
	
	/**
	 * 风险审计评估结果ID取得
	 * @return 风险审计评估结果ID
	 */
	public Integer getRarid() {
		return rarid;
	}

	/**
	 * 风险审计评估结果ID设定
	 * @param rarid 风险审计评估结果ID
	 */
	public void setRarid(Integer rarid) {
		this.rarid = rarid;
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
	/**
	 * 风险审计项ID取得
	 * @return 风险审计项ID
	 */
	public Integer getRadid() {
		return radid;
	}

	/**
	 * 风险审计项ID设定
	 * @param radid 风险审计项ID
	 */
	public void setRadid(Integer radid) {
		this.radid = radid;
	}

	/**
	 * 风险审计评估人ID取得
	 * @return 风险审计评估人ID
	 */
	public String getRaruserid() {
		return raruserid;
	}

	/**
	 * 风险审计评估人ID设定
	 * @param raruserid 风险审计评估人ID
	 */
	public void setRaruserid(String raruserid) {
		this.raruserid = raruserid;
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
