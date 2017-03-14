/*
 * 北京递蓝科软件股份有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wki.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.wki.model.WorkinfoInfo;

/**
  * 概述: 工作信息实体
  * 功能描述: 工作信息实体
  * 创建记录: 2017/03/02
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="workinfo")
public class WorkinfoTB extends BaseEntity implements Serializable,
		Cloneable, WorkinfoInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="WORKINFO_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="WORKINFO_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="WORKINFO_TABLE_GENERATOR")
	protected Integer workinfoid;

	/** 工作名称 */
	protected String workname;

	protected String startdate;
	/** 周期 */
	protected Integer workperiod;

	/** 预计完成时间 */
	protected String estFinDate;

	/** 实际完成时间 */
	protected String actFinDate;

	/** 超时提醒期限 */
	protected Integer timeOutPeriod;

	/** 发起人id */
	protected Integer initid;

	/** 发起人姓名 */
	protected String initname;

	/** 执行人id */
	protected Integer execid;

	/** 执行人姓名 */
	protected String execname;

	/** 工作状态 */
	protected Integer workstatus;

	/** 备注 */
	protected String remark;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getWorkinfoid() {
		return workinfoid;
	}

	/**
	 * 主键设定
	 *
	 * @param workinfoid 主键
	 */
	public void setWorkinfoid(Integer workinfoid) {
		this.workinfoid = workinfoid;
	}

	/**
	 * 工作名称取得
	 *
	 * @return 工作名称
	 */
	public String getWorkname() {
		return workname;
	}

	/**
	 * 工作名称设定
	 *
	 * @param workname 工作名称
	 */
	public void setWorkname(String workname) {
		this.workname = workname;
	}

	/**
	 * 周期取得
	 *
	 * @return 周期
	 */
	public Integer getWorkperiod() {
		return workperiod;
	}

	/**
	 * 周期设定
	 *
	 * @param workperiod 周期
	 */
	public void setWorkperiod(Integer workperiod) {
		this.workperiod = workperiod;
	}

	/**
	 * 预计完成时间取得
	 *
	 * @return 预计完成时间
	 */
	public String getEstFinDate() {
		return estFinDate;
	}

	/**
	 * 预计完成时间设定
	 *
	 * @param estFinDate 预计完成时间
	 */
	public void setEstFinDate(String estFinDate) {
		this.estFinDate = estFinDate;
	}

	/**
	 * 实际完成时间取得
	 *
	 * @return 实际完成时间
	 */
	public String getActFinDate() {
		return actFinDate;
	}

	/**
	 * 实际完成时间设定
	 *
	 * @param actFinDate 实际完成时间
	 */
	public void setActFinDate(String actFinDate) {
		this.actFinDate = actFinDate;
	}

	/**
	 * 超时提醒期限取得
	 *
	 * @return 超时提醒期限
	 */
	public Integer getTimeOutPeriod() {
		return timeOutPeriod;
	}

	/**
	 * 超时提醒期限设定
	 *
	 * @param timeOutPeriod 超时提醒期限
	 */
	public void setTimeOutPeriod(Integer timeOutPeriod) {
		this.timeOutPeriod = timeOutPeriod;
	}

	/**
	 * 发起人id取得
	 *
	 * @return 发起人id
	 */
	public Integer getInitid() {
		return initid;
	}

	/**
	 * 发起人id设定
	 *
	 * @param initid 发起人id
	 */
	public void setInitid(Integer initid) {
		this.initid = initid;
	}

	/**
	 * 发起人姓名取得
	 *
	 * @return 发起人姓名
	 */
	public String getInitname() {
		return initname;
	}

	/**
	 * 发起人姓名设定
	 *
	 * @param initname 发起人姓名
	 */
	public void setInitname(String initname) {
		this.initname = initname;
	}

	/**
	 * 执行人id取得
	 *
	 * @return 执行人id
	 */
	public Integer getExecid() {
		return execid;
	}

	/**
	 * 执行人id设定
	 *
	 * @param execid 执行人id
	 */
	public void setExecid(Integer execid) {
		this.execid = execid;
	}

	/**
	 * 执行人姓名取得
	 *
	 * @return 执行人姓名
	 */
	public String getExecname() {
		return execname;
	}

	/**
	 * 执行人姓名设定
	 *
	 * @param execname 执行人姓名
	 */
	public void setExecname(String execname) {
		this.execname = execname;
	}

	/**
	 * 工作状态取得
	 *
	 * @return 工作状态
	 */
	public Integer getWorkstatus() {
		return workstatus;
	}

	/**
	 * 工作状态设定
	 *
	 * @param workstatus 工作状态
	 */
	public void setWorkstatus(Integer workstatus) {
		this.workstatus = workstatus;
	}

	/**
	 * 备注取得
	 *
	 * @return 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注设定
	 *
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return workinfoid;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

}