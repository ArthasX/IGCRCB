/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;

/**
  * 概述: 工作日志表实体
  * 功能描述: 工作日志表实体
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="workLog")
public class WorkLogTB extends BaseEntity implements Serializable,
		Cloneable, WorkLogInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="WORKLOG_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="WORKLOG_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="WORKLOG_TABLE_GENERATOR")
	protected Integer wlid;

	/** 工作实例表主键 */
	protected Integer wiid;

	/** 工作日志名称 */
	protected String wlname;

	/** 执行人（userid） */
	protected String excutorId;

	/** 操作 */
	protected String operation;

	/** 日期栏日期 */
	protected String titleDate;

	/** 执行时间 */
	protected String excuteTime;

	/** 实际处理日期 */
	protected String actualDealwithDate;

	/** 执行情况描述 */
	protected String wlDescription;

	/** 表记录创建日期 */
	protected String crtDate;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getWlid() {
		return wlid;
	}

	/**
	 * 主键设定
	 *
	 * @param 主键
	 */
	public void setWlid(Integer wlid) {
		this.wlid = wlid;
	}

	/**
	 * 工作实例表主键取得
	 *
	 * @return 工作实例表主键
	 */
	public Integer getWiid() {
		return wiid;
	}

	/**
	 * 工作实例表主键设定
	 *
	 * @param 工作实例表主键
	 */
	public void setWiid(Integer wiid) {
		this.wiid = wiid;
	}

	/**
	 * 工作日志名称取得
	 *
	 * @return 工作日志名称
	 */
	public String getWlname() {
		return wlname;
	}

	/**
	 * 工作日志名称设定
	 *
	 * @param 工作日志名称
	 */
	public void setWlname(String wlname) {
		this.wlname = wlname;
	}

	/**
	 * 执行人（userid）取得
	 *
	 * @return 执行人（userid）
	 */
	public String getExcutorId() {
		return excutorId;
	}

	/**
	 * 执行人（userid）设定
	 *
	 * @param 执行人（userid）
	 */
	public void setExcutorId(String excutorId) {
		this.excutorId = excutorId;
	}

	/**
	 * 操作取得
	 *
	 * @return 操作
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * 操作设定
	 *
	 * @param 操作
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * 日期栏日期取得
	 *
	 * @return 日期栏日期
	 */
	public String getTitleDate() {
		return titleDate;
	}

	/**
	 * 日期栏日期设定
	 *
	 * @param 日期栏日期
	 */
	public void setTitleDate(String titleDate) {
		this.titleDate = titleDate;
	}

	/**
	 * 执行时间取得
	 *
	 * @return excuteTime
	 */
	public String getExcuteTime() {
		return excuteTime;
	}

	/**
	 * 执行时间设定
	 *
	 * @param 执行时间
	 */
	public void setExcuteTime(String excuteTime) {
		this.excuteTime = excuteTime;
	}

	/**
	 * 实际处理日期取得
	 *
	 * @return 实际处理日期
	 */
	public String getActualDealwithDate() {
		return actualDealwithDate;
	}

	/**
	 * 实际处理日期设定
	 *
	 * @param 实际处理日期
	 */
	public void setActualDealwithDate(String actualDealwithDate) {
		this.actualDealwithDate = actualDealwithDate;
	}

	/**
	 * 执行情况描述取得
	 *
	 * @return 执行情况描述
	 */
	public String getWlDescription() {
		return wlDescription;
	}

	/**
	 * 执行情况描述设定
	 *
	 * @param 执行情况描述
	 */
	public void setWlDescription(String wlDescription) {
		this.wlDescription = wlDescription;
	}

	/**
	 * 表记录创建日期取得
	 *
	 * @return 表记录创建日期
	 */
	public String getCrtDate() {
		return crtDate;
	}

	/**
	 * 表记录创建日期设定
	 *
	 * @param 表记录创建日期
	 */
	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return wlid;
	}

}