/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;

/**
  * 概述: 工作管理实体
  * 功能描述: 工作管理实体
  * 创建记录: 2016/04/19
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="workmanager")
public class WorkmanagerTB extends BaseEntity implements Serializable,
		Cloneable, WorkmanagerInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="WORKMANAGER_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="WORKMANAGER_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="WORKMANAGER_TABLE_GENERATOR")
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
	
	/** 数据源 wmid  */
	protected String rewmid;
	
	/** 风险检查频率(周) */
	protected String wmfrequencyweeks;
	
	/** 风险检查频率(月) */
	protected String wmfrequencymonths;
	
	/** 频率(每月最后一天) */
	protected String wmfrequencymonthlastday;
	
	/**
	 * @return the 频率(每月最后一天)
	 */
	public String getWmfrequencymonthlastday() {
		return wmfrequencymonthlastday;
	}

	/**
	 * @param 频率(每月最后一天) the wmfrequencymonthlastday to set
	 */
	public void setWmfrequencymonthlastday(String wmfrequencymonthlastday) {
		this.wmfrequencymonthlastday = wmfrequencymonthlastday;
	}

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
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getWmid() {
		return wmid;
	}

	/**
	 * 主键设定
	 *
	 * @param wmid 主键
	 */
	public void setWmid(Integer wmid) {
		this.wmid = wmid;
	}

	/**
	 * 工作名称取得
	 *
	 * @return 工作名称
	 */
	public String getWmname() {
		return wmname;
	}

	/**
	 * 工作名称设定
	 *
	 * @param wmname 工作名称
	 */
	public void setWmname(String wmname) {
		this.wmname = wmname;
	}

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getWmdesc() {
		return wmdesc;
	}

	/**
	 * 描述设定
	 *
	 * @param wmdesc 描述
	 */
	public void setWmdesc(String wmdesc) {
		this.wmdesc = wmdesc;
	}

	/**
	 * 完成状态(0-未完成1-已完成)取得
	 *
	 * @return 完成状态(0-未完成1-已完成)
	 */
	public String getWmstatus() {
		return wmstatus;
	}

	/**
	 * 完成状态(0-未完成1-已完成)设定
	 *
	 * @param wmstatus 完成状态(0-未完成1-已完成)
	 */
	public void setWmstatus(String wmstatus) {
		this.wmstatus = wmstatus;
	}

	/**
	 * 发起日期取得
	 *
	 * @return 发起日期
	 */
	public String getWmstartdate() {
		return wmstartdate;
	}

	/**
	 * 发起日期设定
	 *
	 * @param wmstartdate 发起日期
	 */
	public void setWmstartdate(String wmstartdate) {
		this.wmstartdate = wmstartdate;
	}

	/**
	 * 限期完成日期取得
	 *
	 * @return 限期完成日期
	 */
	public String getWmlimitdate() {
		return wmlimitdate;
	}

	/**
	 * 限期完成日期设定
	 *
	 * @param wmlimitdate 限期完成日期
	 */
	public void setWmlimitdate(String wmlimitdate) {
		this.wmlimitdate = wmlimitdate;
	}

	/**
	 * 实际完成日期取得
	 *
	 * @return 实际完成日期
	 */
	public String getWmfactdate() {
		return wmfactdate;
	}

	/**
	 * 实际完成日期设定
	 *
	 * @param wmfactdate 实际完成日期
	 */
	public void setWmfactdate(String wmfactdate) {
		this.wmfactdate = wmfactdate;
	}

	/**
	 * 频率取得
	 *
	 * @return 频率
	 */
	public String getWmfrequency() {
		return wmfrequency;
	}

	/**
	 * 频率设定
	 *
	 * @param wmfrequency 频率
	 */
	public void setWmfrequency(String wmfrequency) {
		this.wmfrequency = wmfrequency;
	}

	/**
	 * 工作执行表达式 取得
	 *
	 * @return 工作执行表达式 
	 */
	public String getWmcron() {
		return wmcron;
	}

	/**
	 * 工作执行表达式 设定
	 *
	 * @param wmcron 工作执行表达式 
	 */
	public void setWmcron(String wmcron) {
		this.wmcron = wmcron;
	}

	/**
	 * 发起人id取得
	 *
	 * @return 发起人id
	 */
	public String getWmuserid() {
		return wmuserid;
	}

	/**
	 * 发起人id设定
	 *
	 * @param wmuserid 发起人id
	 */
	public void setWmuserid(String wmuserid) {
		this.wmuserid = wmuserid;
	}

	/**
	 * 发起人姓名取得
	 *
	 * @return 发起人姓名
	 */
	public String getWmusername() {
		return wmusername;
	}

	/**
	 * 发起人姓名设定
	 *
	 * @param wmusername 发起人姓名
	 */
	public void setWmusername(String wmusername) {
		this.wmusername = wmusername;
	}

	/**
	 * 发起人角色id取得
	 *
	 * @return 发起人角色id
	 */
	public String getWmroleid() {
		return wmroleid;
	}

	/**
	 * 发起人角色id设定
	 *
	 * @param wmroleid 发起人角色id
	 */
	public void setWmroleid(String wmroleid) {
		this.wmroleid = wmroleid;
	}

	/**
	 * 发起人角色名称取得
	 *
	 * @return 发起人角色名称
	 */
	public String getWmrolename() {
		return wmrolename;
	}

	/**
	 * 发起人角色名称设定
	 *
	 * @param wmrolename 发起人角色名称
	 */
	public void setWmrolename(String wmrolename) {
		this.wmrolename = wmrolename;
	}

	/**
	 * 选项取得
	 *
	 * @return 选项
	 */
	public String getWmoption() {
		return wmoption;
	}

	/**
	 * 选项设定
	 *
	 * @param wmoption 选项
	 */
	public void setWmoption(String wmoption) {
		this.wmoption = wmoption;
	}

	/**
	 * 提醒时间（小时）取得
	 *
	 * @return 提醒时间（小时）
	 */
	public String getWmremindh() {
		return wmremindh;
	}

	/**
	 * 提醒时间（小时）设定
	 *
	 * @param wmremindh 提醒时间（小时）
	 */
	public void setWmremindh(String wmremindh) {
		this.wmremindh = wmremindh;
	}

	/**
	 * 提醒时间（分钟）取得
	 *
	 * @return 提醒时间（分钟）
	 */
	public String getWmremindm() {
		return wmremindm;
	}

	/**
	 * 提醒时间（分钟）设定
	 *
	 * @param wmremindm 提醒时间（分钟）
	 */
	public void setWmremindm(String wmremindm) {
		this.wmremindm = wmremindm;
	}

	/**
	 * 数据来源 0-登记1-复制 取得
	 *
	 * @return 数据来源 0-登记1-复制 
	 */
	public String getWmtype() {
		return wmtype;
	}

	/**
	 * 数据来源 0-登记1-复制 设定
	 *
	 * @param wmtype 数据来源 0-登记1-复制 
	 */
	public void setWmtype(String wmtype) {
		this.wmtype = wmtype;
	}

	/**
	 * 是否提醒0-提醒1-不再提醒 取得
	 *
	 * @return 是否提醒0-提醒1-不再提醒 
	 */
	public String getWmremind() {
		return wmremind;
	}

	/**
	 * 是否提醒0-提醒1-不再提醒 设定
	 *
	 * @param wmremind 是否提醒0-提醒1-不再提醒 
	 */
	public void setWmremind(String wmremind) {
		this.wmremind = wmremind;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return wmid;
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