/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 每月盘点查询接口实现
 *
 */
public class InventoryInfoSearchCondImpl implements InventoryInfoSearchCond {
	
	/** 本月开始 */
	protected String date_from;
	
	/** 本月结束 */
	protected String date_to;
	
	/** 上月开始 */
	protected String predate_from;
	
	/** 上月结束 */
	protected String predate_to;
	
	/** 所属机构 */
	protected String org;
	

	
	/**
	 * @return the org
	 */
	public String getOrg() {
		return org;
	}

	/**
	 * @param org the org to set
	 */
	public void setOrg(String org) {
		this.org = org;
	}

	public String getDate_from() {
		return date_from;
	}

	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}

	public String getDate_to() {
		return date_to;
	}

	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}

	public String getPredate_from() {
		return predate_from;
	}

	public void setPredate_from(String predate_from) {
		this.predate_from = predate_from;
	}

	public String getPredate_to() {
		return predate_to;
	}

	public void setPredate_to(String predate_to) {
		this.predate_to = predate_to;
	}


}
