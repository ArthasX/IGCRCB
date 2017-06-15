package com.deliverik.infogovernor.risk.model.condition;



/**
 * 风险检查与风险审计项关系信息查询条件实现
 * 
 */
public class AuditCheckRelationSearchCondImpl implements AuditCheckRelationSearchCond {

	/** 风险检查与风险审计关系ID */
	protected Integer acrid;
	
	/** 风险检查ID */
	protected Integer rcid;
	
	/** 风险审计项ID */
	protected Integer radid;

	/** 风险审计项编码 */
	protected String radcode;
	

	/**
	 * @return the acrid
	 */
	public Integer getAcrid() {
		return acrid;
	}

	/**
	 * @return the rcid
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * @return the radid
	 */
	public Integer getRadid() {
		return radid;
	}

	/**
	 * @return the radcode
	 */
	public String getRadcode() {
		return radcode;
	}

	/**
	 * @param acrid the acrid to set
	 */
	public void setAcrid(Integer acrid) {
		this.acrid = acrid;
	}

	/**
	 * @param rcid the rcid to set
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * @param radid the radid to set
	 */
	public void setRadid(Integer radid) {
		this.radid = radid;
	}

	/**
	 * @param radcode the radcode to set
	 */
	public void setRadcode(String radcode) {
		this.radcode = radcode;
	}
	
	
	
}
