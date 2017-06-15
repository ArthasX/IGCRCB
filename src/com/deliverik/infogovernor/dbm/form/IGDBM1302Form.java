/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.form;
import com.deliverik.framework.base.BaseForm;


/**
 * 工作管理-新增Form
 *
 */
@SuppressWarnings("serial")
public class IGDBM1302Form extends BaseForm {

	protected Integer wmid;
	
	/** 工作名称 */
	protected String wmname;

	/** 描述 */
	protected String wmdesc;

	/** 完成状态(0-未完成1-已完成) */
	protected String wmstatus;

	/** 发起日期 */
	protected String wmstartdate;

	/** 限期完成日期 */
	protected String wmlimitdate;

	/** 实际完成日期 */
	protected String wmfactdate;

	/** 频率 */
	protected String wmfrequency;

	/** 工作执行表达式  */
	protected String wmcron;

	/** 发起人id */
	protected String wmuserid;

	/** 发起人姓名 */
	protected String wmusername;

	/** 发起人角色id */
	protected String wmroleid;

	/** 发起人角色名称 */
	protected String wmrolename;

	/** 选项 */
	protected String wmoption;

	/** 提醒时间（小时） */
	protected String wmremindh;

	/** 提醒时间（分钟） */
	protected String wmremindm;

	/** 数据来源 0-登记1-复制  */
	protected String wmtype;

	/** 是否提醒0-提醒1-不再提醒  */
	protected String wmremind;

	/** 备注 */
	protected String wmremark;
	
	/** 风险检查频率内容 */
	protected String wmfrequencydesc;
	
	/** 风险检查频率(周) */
	protected String[] wmfrequencyweek;
	
	/** 风险检查频率(月) */
	protected String[] wmfrequencymonth;
	
	/** 风险检查频率(每月最后一天) */
	protected String wmfrequencymonthlastday;
	/** 数据源 wmid  */
	protected String rewmid;
	
	/** 风险检查频率(周) */
	protected String wmfrequencyweeks;
	
	/** 风险检查频率(月) */
	protected String wmfrequencymonths;
	
	/**
	 * @return the 数据源wmid
	 */
	public String getRewmid() {
		return rewmid;
	}

	/**
	 * @param 数据源wmid the rewmid to set
	 */
	public void setRewmid(String rewmid) {
		this.rewmid = rewmid;
	}

	/**
	 * @return the wmid
	 */
	public Integer getWmid() {
		return wmid;
	}

	/**
	 * @param wmid the wmid to set
	 */
	public void setWmid(Integer wmid) {
		this.wmid = wmid;
	}

	/**
	 * @return the 工作名称
	 */
	public String getWmname() {
		return wmname;
	}

	/**
	 * @param 工作名称 the wmname to set
	 */
	public void setWmname(String wmname) {
		this.wmname = wmname;
	}

	/**
	 * @return the 描述
	 */
	public String getWmdesc() {
		return wmdesc;
	}

	/**
	 * @param 描述 the wmdesc to set
	 */
	public void setWmdesc(String wmdesc) {
		this.wmdesc = wmdesc;
	}

	/**
	 * @return the 完成状态(0-未完成1-已完成)
	 */
	public String getWmstatus() {
		return wmstatus;
	}

	/**
	 * @param 完成状态(0-未完成1-已完成) the wmstatus to set
	 */
	public void setWmstatus(String wmstatus) {
		this.wmstatus = wmstatus;
	}

	/**
	 * @return the 发起日期
	 */
	public String getWmstartdate() {
		return wmstartdate;
	}

	/**
	 * @param 发起日期 the wmstartdate to set
	 */
	public void setWmstartdate(String wmstartdate) {
		this.wmstartdate = wmstartdate;
	}

	/**
	 * @return the 限期完成日期
	 */
	public String getWmlimitdate() {
		return wmlimitdate;
	}

	/**
	 * @param 限期完成日期 the wmlimitdate to set
	 */
	public void setWmlimitdate(String wmlimitdate) {
		this.wmlimitdate = wmlimitdate;
	}

	/**
	 * @return the 实际完成日期
	 */
	public String getWmfactdate() {
		return wmfactdate;
	}

	/**
	 * @param 实际完成日期 the wmfactdate to set
	 */
	public void setWmfactdate(String wmfactdate) {
		this.wmfactdate = wmfactdate;
	}

	/**
	 * @return the 频率
	 */
	public String getWmfrequency() {
		return wmfrequency;
	}

	/**
	 * @param 频率 the wmfrequency to set
	 */
	public void setWmfrequency(String wmfrequency) {
		this.wmfrequency = wmfrequency;
	}

	/**
	 * @return the 工作执行表达式
	 */
	public String getWmcron() {
		return wmcron;
	}

	/**
	 * @param 工作执行表达式 the wmcron to set
	 */
	public void setWmcron(String wmcron) {
		this.wmcron = wmcron;
	}

	/**
	 * @return the 发起人id
	 */
	public String getWmuserid() {
		return wmuserid;
	}

	/**
	 * @param 发起人id the wmuserid to set
	 */
	public void setWmuserid(String wmuserid) {
		this.wmuserid = wmuserid;
	}

	/**
	 * @return the 发起人姓名
	 */
	public String getWmusername() {
		return wmusername;
	}

	/**
	 * @param 发起人姓名 the wmusername to set
	 */
	public void setWmusername(String wmusername) {
		this.wmusername = wmusername;
	}

	/**
	 * @return the 发起人角色id
	 */
	public String getWmroleid() {
		return wmroleid;
	}

	/**
	 * @param 发起人角色id the wmroleid to set
	 */
	public void setWmroleid(String wmroleid) {
		this.wmroleid = wmroleid;
	}

	/**
	 * @return the 发起人角色名称
	 */
	public String getWmrolename() {
		return wmrolename;
	}

	/**
	 * @param 发起人角色名称 the wmrolename to set
	 */
	public void setWmrolename(String wmrolename) {
		this.wmrolename = wmrolename;
	}

	/**
	 * @return the 选项
	 */
	public String getWmoption() {
		return wmoption;
	}

	/**
	 * @param 选项 the wmoption to set
	 */
	public void setWmoption(String wmoption) {
		this.wmoption = wmoption;
	}

	/**
	 * @return the 提醒时间（小时）
	 */
	public String getWmremindh() {
		return wmremindh;
	}

	/**
	 * @param 提醒时间（小时） the wmremindh to set
	 */
	public void setWmremindh(String wmremindh) {
		this.wmremindh = wmremindh;
	}

	/**
	 * @return the 提醒时间（分钟）
	 */
	public String getWmremindm() {
		return wmremindm;
	}

	/**
	 * @param 提醒时间（分钟） the wmremindm to set
	 */
	public void setWmremindm(String wmremindm) {
		this.wmremindm = wmremindm;
	}

	/**
	 * @return the 数据来源0-登记1-复制
	 */
	public String getWmtype() {
		return wmtype;
	}

	/**
	 * @param 数据来源0-登记1-复制 the wmtype to set
	 */
	public void setWmtype(String wmtype) {
		this.wmtype = wmtype;
	}

	/**
	 * @return the 是否提醒0-提醒1-不再提醒
	 */
	public String getWmremind() {
		return wmremind;
	}

	/**
	 * @param 是否提醒0-提醒1-不再提醒 the wmremind to set
	 */
	public void setWmremind(String wmremind) {
		this.wmremind = wmremind;
	}

	/**
	 * @return the 备注
	 */
	public String getWmremark() {
		return wmremark;
	}

	/**
	 * @param 备注 the wmremark to set
	 */
	public void setWmremark(String wmremark) {
		this.wmremark = wmremark;
	}

	/**
	 * @return the 风险检查频率内容
	 */
	public String getWmfrequencydesc() {
		return wmfrequencydesc;
	}

	/**
	 * @param 风险检查频率内容 the wmfrequencydesc to set
	 */
	public void setWmfrequencydesc(String wmfrequencydesc) {
		this.wmfrequencydesc = wmfrequencydesc;
	}

	/**
	 * @return the 风险检查频率(周)
	 */
	public String[] getWmfrequencyweek() {
		return wmfrequencyweek;
	}

	/**
	 * @param 风险检查频率(周) the wmfrequencyweek to set
	 */
	public void setWmfrequencyweek(String[] wmfrequencyweek) {
		this.wmfrequencyweek = wmfrequencyweek;
	}

	/**
	 * @return the 风险检查频率(月)
	 */
	public String[] getWmfrequencymonth() {
		return wmfrequencymonth;
	}

	/**
	 * @param 风险检查频率(月) the wmfrequencymonth to set
	 */
	public void setWmfrequencymonth(String[] wmfrequencymonth) {
		this.wmfrequencymonth = wmfrequencymonth;
	}

	/**
	 * @return the 风险检查频率(每月最后一天)
	 */
	public String getWmfrequencymonthlastday() {
		return wmfrequencymonthlastday;
	}

	/**
	 * @param 风险检查频率(每月最后一天) the wmfrequencymonthlastday to set
	 */
	public void setWmfrequencymonthlastday(String wmfrequencymonthlastday) {
		this.wmfrequencymonthlastday = wmfrequencymonthlastday;
	}

	/**
	 * @return the 风险检查频率(周)
	 */
	public String getWmfrequencyweeks() {
		return wmfrequencyweeks;
	}

	/**
	 * @param 风险检查频率(周) the wmfrequencyweeks to set
	 */
	public void setWmfrequencyweeks(String wmfrequencyweeks) {
		this.wmfrequencyweeks = wmfrequencyweeks;
	}

	/**
	 * @return the 风险检查频率(月)
	 */
	public String getWmfrequencymonths() {
		return wmfrequencymonths;
	}

	/**
	 * @param 风险检查频率(月) the wmfrequencymonths to set
	 */
	public void setWmfrequencymonths(String wmfrequencymonths) {
		this.wmfrequencymonths = wmfrequencymonths;
	}
	
}
