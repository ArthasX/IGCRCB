package com.deliverik.infogovernor.sym.model.condition;

public class CustomReportSearchCondImpl implements CustomReportSearchCond {

	

	/**
	 *用户名ID
	 */
	protected String userid;

	/**
	 *用户名ID取得
	 * 
	 * @return 用户名ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 *用户名ID设定
	 * 
	 * @param userid用户名ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 *报表ID
	 */
	protected Integer rfdid;

	/**
	 *报表ID取得
	 * 
	 * @return 报表ID
	 */
	public Integer getRfdid() {
		return rfdid;
	}

	/**
	 *报表ID设定
	 * 
	 * @param rfdid报表ID
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 *排序编号
	 */
	protected Integer ordernum;

	/**
	 *排序编号取得
	 * 
	 * @return 排序编号
	 */
	public Integer getOrdernum() {
		return ordernum;
	}

	/**
	 *排序编号设定
	 * 
	 * @param ordernum排序编号
	 */
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

}
