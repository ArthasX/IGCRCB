/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.dut.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * 值班启动查询Form
 */
public class IGDUT0206Form extends BaseForm {


	private static final long serialVersionUID = 1L;
	
	/** 值班计划状态 执行中*/
	protected String dpstatus;
	
	/** 值班类型 */
	protected String dadcategory;
	
	/** 值班日期 当前日期*/
	protected String dptime;
	
	/** 遗留问题 */
	protected String dpquestion;
	
	/** 总结 */
	protected String dpinfo;
	
	/**
	 * 值班计划ID
	 */
	protected Integer dpid;
	
	/**
	 * 白班/夜班
	 */
	protected String dptype;
	
	/**
	 * 交接人ID
	 */
	protected String dperuserid;
	
	/**
	 * 交接人姓名
	 */
	protected String dperusername;
	
	protected String currentdate = IGStringUtils.getCurrentDate();
	
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

	/**
	 * 遗留问题取得
	 * @return 遗留问题
	 */
	public String getDpquestion() {
		return dpquestion;
	}

	/**
	 * 遗留问题设定
	 *
	 * @param dpquestion 遗留问题
	 */
	public void setDpquestion(String dpquestion) {
		this.dpquestion = dpquestion;
	}

	/**
	 * 总结取得
	 * @return 总结
	 */
	public String getDpinfo() {
		return dpinfo;
	}

	/**
	 * 总结设定
	 *
	 * @param dpinfo 总结
	 */
	public void setDpinfo(String dpinfo) {
		this.dpinfo = dpinfo;
	}

	/**
	 * 值班计划ID取得
	 * @return 值班计划
	 */
	public Integer getDpid() {
		return dpid;
	}

	/**
	 * 值班计划ID设定
	 * @param dpid 值班计划ID
	 */
	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}

	/**
	 * 白班/夜班取得
	 * @return 白班/夜班
	 */
	public String getDptype() {
		return dptype;
	}

	/**
	 * 白班/夜班设定
	 * @param dptype 白班/夜班
	 */
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}

	/**
	 * 交接人ID取得
	 * @return 交接人
	 */
	public String getDperuserid() {
		return dperuserid;
	}

	/**
	 * 交接人ID设定
	 * @param dperuserid 交接人
	 */
	public void setDperuserid(String dperuserid) {
		this.dperuserid = dperuserid;
	}

	/**
	 * 交接人姓名取得
	 * @return 交接人姓名
	 */
	public String getDperusername() {
		return dperusername;
	}

	/**
	 * 交接人姓名设定
	 * @param dperusername 交接人姓名
	 */
	public void setDperusername(String dperusername) {
		this.dperusername = dperusername;
	}

	public String getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}

	
}
