package com.deliverik.framework.asset.model.condition;

/**
 * 资产统计信息检索条件实现
 * 
 */
public class IG011SearchCondImpl implements IG011SearchCond {

	/** 资产登记开始时间*/
	protected String ciupdtime_from;

	/** 资产登记截止时间*/
	protected String ciupdtime_to;
	
	/** 资产所属机构层次码*/
	protected String eiorgsyscoding_q;
	
	/** 资产模型上级层次码*/
	protected String eparcoding;
	
	/** 机构查询类型（平台保留。0所属机构 1使用机构）*/
	protected String orgType;
	
	

	/**
	 * 资产模型上级层次码取得
	 * @return 资产模型上级层次码
	 */
	public String getEparcoding() {
		return eparcoding;
	}

	/**
	 * 资产模型上级层次码设定
	 *
	 * @param eparcoding 资产模型上级层次码
	 */
	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}

	/**
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding_q() {
		return eiorgsyscoding_q;
	}

	/**
	 * 资产所属机构层次码设定
	 *
	 * @param eiorgsyscoding_q 资产所属机构层次码
	 */
	public void setEiorgsyscoding_q(String eiorgsyscoding_q) {
		this.eiorgsyscoding_q = eiorgsyscoding_q;
	}

	/**
	 * 资产登记开始时间取得
	 * @return 资产登记开始时间
	 */
	public String getCiupdtime_from() {
		return ciupdtime_from;
	}

	/**
	 * 资产登记开始时间设定
	 *
	 * @param ciupdtime_from 资产登记开始时间
	 */
	public void setCiupdtime_from(String ciupdtime_from) {
		this.ciupdtime_from = ciupdtime_from;
	}

	/**
	 * 资产登记截止时间取得
	 * @return 资产登记截止时间
	 */
	public String getCiupdtime_to() {
		return ciupdtime_to;
	}

	/**
	 * 资产登记截止时间设定
	 *
	 * @param ciupdtime_to 资产登记截止时间
	 */
	public void setCiupdtime_to(String ciupdtime_to) {
		this.ciupdtime_to = ciupdtime_to;
	}

	/**
	 * 机构查询类型（平台保留）取得
	 * @return 机构查询类型（平台保留）
	 */
	public String getOrgType() {
		return orgType;
	}

	/**
	 * 机构查询类型（平台保留）设定
	 *
	 * @param orgType 机构查询类型（平台保留）
	 */
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

}
