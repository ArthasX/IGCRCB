/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.dut.model.condition;
/**
 * 
 * 值班计划查询实现类
 *
 */
public class DutyPlanSearchCondImpl  implements DutyPlanSearchCond{
	
	/** 值班计划状态 */
	protected String dpstatus;
	
	/** 值班类型 */
	protected String dadcategory;
	
	/** 值班日期 */
	protected String dptime;
	
	/** 值班日期（大于等于匹配） */
	protected String dptime_ge;

	/** 值班日期（小于等于匹配） */
	protected String dptime_le;
	protected String dptype;
	
	/** 值班计划表主键 */
	protected Integer dpid;
	
	/**
	 * 值班计划状态取得
	 * @return 值班计划状态
	 */
	public String getDpstatus() {
		return dpstatus;
	}

	/**
	 * 值班计划状态设定
	 *
	 * @param dpstatus 值班计划状态
	 */
	public void setDpstatus(String dpstatus) {
		this.dpstatus = dpstatus;
	}

	/**
	 * 值班类型取得
	 * @return 值班类型
	 */
	public String getDadcategory() {
		return dadcategory;
	}

	/**
	 * 值班类型设定
	 *
	 * @param dadcategory 值班类型
	 */
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	/**
	 * 值班日期取得
	 * @return 值班日期
	 */
	public String getDptime() {
		return dptime;
	}

	/**
	 * 值班日期设定
	 *
	 * @param dptime 值班日期
	 */
	public void setDptime(String dptime) {
		this.dptime = dptime;
	}

	public String getDptype() {
		return dptype;
	}

	public void setDptype(String dptype) {
		this.dptype = dptype;
	}
	
	/**
	 * 值班日期（大于等于匹配）取得
	 * @return 值班日期（大于等于匹配）
	 */
	public String getDptime_ge() {
		return dptime_ge;
	}

	/**
	 * 值班日期（大于等于匹配）设定
	 *
	 * @param dptime_ge 值班日期（大于等于匹配）
	 */
	public void setDptime_ge(String dptime_ge) {
		this.dptime_ge = dptime_ge;
	}

	public String getDptime_le() {
		return dptime_le;
	}

	public void setDptime_le(String dptime_le) {
		this.dptime_le = dptime_le;
	}

	/**
	 * 值班计划表主键取得
	 *
	 * @return dpid 值班计划表主键
	 */
	public Integer getDpid() {
		return dpid;
	}

	/**
	 * 值班计划表主键设定
	 *
	 * @param dpid 值班计划表主键
	 */
	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}
	
}
