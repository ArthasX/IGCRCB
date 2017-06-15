/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
  * 概述: 检查工作统计报表检索条件实现
  * 功能描述: 检查工作统计报表检索条件实现
  * 创建记录: 2014/07/09
  * 修改记录: 
  */
public class CheckWorkConutVWSearchCondImpl implements
		CheckWorkConutVWSearchCond {
	/** 检查方式 */
	protected String rcrtestmode;
	
	
	/**检查时间*/
	public String datetime;
	/**检查条件半年*/
	public String halfyear;
	/**检查条件年*/
	public String year;
	/**常规条件*/
	public String cg;
	
	/**
	 * cg取得
	 * @return cg cg
	 */
	public String getCg() {
		return cg;
	}

	/**
	 * cg设定
	 * @param cg cg
	 */
	public void setCg(String cg) {
		this.cg = cg;
	}

	/**
	 * year取得
	 * @return year year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * year设定
	 * @param year year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**季度查询*/
	public String quart;

	/**
	 * 季度查询取得
	 * @return quart 季度查询
	 */
	public String getQuart() {
		return quart;
	}

	/**
	 * 季度查询设定
	 * @param quart 季度查询
	 */
	public void setQuart(String quart) {
		this.quart = quart;
	}

	/**
	 * halfyear取得
	 * @return halfyear halfyear
	 */
	public String getHalfyear() {
		return halfyear;
	}

	/**
	 * halfyear设定
	 * @param halfyear halfyear
	 */
	public void setHalfyear(String halfyear) {
		this.halfyear = halfyear;
	}

	/**
	 * 检查时间取得
	 * @return datetime 检查时间
	 */
	public String getDatetime() {
		return datetime;
	}

	/**
	 * 检查时间设定
	 * @param datetime 检查时间
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	/**
	 * 检查方式取得
	 * @return rcrtestmode 检查方式
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 * 检查方式设定
	 * @param rcrtestmode 检查方式
	 */
	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
	}
}