package com.deliverik.framework.asset.model.condition;

/**
 * 设备统计分析信息查询条件实现（平台保留）
 * 
 */
public class IG445SearchCondImpl implements IG445SearchCond {
	
	/** 资产登记开始时间*/
	protected String ciupdtime_from;

	/** 资产登记截止时间*/
	protected String ciupdtime_to;
	
	/** 资产模型ID*/
	protected String eid;
	
	/** 资产所属机构层次码*/
	protected String eiorgsyscoding_q;
	
	/**
	 * 取得开始时间取得
	 * @return 取得开始时间
	 */
	public String getCiupdtime_from() {
		return ciupdtime_from;
	}

	/**
	 * 取得开始时间设定
	 *
	 * @param ciupdtime_from 取得开始时间
	 */
	public void setCiupdtime_from(String ciupdtime_from) {
		this.ciupdtime_from = ciupdtime_from;
	}

	/**
	 * 取得截止时间取得
	 * @return 取得截止时间
	 */
	public String getCiupdtime_to() {
		return ciupdtime_to;
	}

	/**
	 * 取得截止时间设定
	 *
	 * @param ciupdtime_to 取得截止时间
	 */
	public void setCiupdtime_to(String ciupdtime_to) {
		this.ciupdtime_to = ciupdtime_to;
	}

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
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
	
	
}
