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
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;

/**
  * 概述: 工作实例表实体
  * 功能描述: 工作实例表实体
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="workInstance")
public class WorkInstanceTB extends BaseEntity implements Serializable,
		Cloneable, WorkInstanceInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="WORKINSTANCE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="WORKINSTANCE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="WORKINSTANCE_TABLE_GENERATOR")
	protected Integer wiid;

	/** 工作定义表主键 */
	protected Integer wdid;

	/** 工作实例名称 */
	protected String winame;

	/** 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；） */
	protected Integer wistatus;

	/** 部门（id） */
	protected String wiDepartmentid;

	/** 人员（userid） */
	protected String wiuserid;

	/** 发起类型（1，自动发起；2，手动发起） */
	protected String wiLunchType;

	/** 执行需所时间（小时） */
	protected String excuteTime;

	/** 实际处理日期 */
	protected String actualDealwithDate;

	/** 工作确认日期 */
	protected String confirmDate;

	/** 执行情况描述 */
	protected String wiDescription;

	/** 按钮动作 */
	protected String btnAction;

	/** 日期栏日期 */
	protected String titleDate;

	/** 表记录创建日期 */
	protected String crtDate;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getWiid() {
		return wiid;
	}

	/**
	 * 主键设定
	 *
	 * @param 主键
	 */
	public void setWiid(Integer wiid) {
		this.wiid = wiid;
	}

	/**
	 * 工作定义表主键取得
	 *
	 * @return 工作定义表主键
	 */
	public Integer getWdid() {
		return wdid;
	}

	/**
	 * 工作定义表主键
	 *
	 * @param wdid 工作定义表主键
	 */
	public void setWdid(Integer wdid) {
		this.wdid = wdid;
	}

	/**
	 * 工作实例名称取得
	 *
	 * @return 工作实例名称
	 */
	public String getWiname() {
		return winame;
	}

	/**
	 * 工作实例名称设定
	 *
	 * @param 工作实例名称
	 */
	public void setWiname(String winame) {
		this.winame = winame;
	}

	/**
	 * 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）取得
	 *
	 * @return 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）
	 */
	public Integer getWistatus() {
		return wistatus;
	}

	/**
	 * 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）设定
	 *
	 * @param 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）
	 */
	public void setWistatus(Integer wistatus) {
		this.wistatus = wistatus;
	}

	/**
	 * 部门（id）取得
	 *
	 * @return 部门（id）
	 */
	public String getWiDepartmentid() {
		return wiDepartmentid;
	}

	/**
	 * 部门（id）设定
	 *
	 * @param 部门（id）
	 */
	public void setWiDepartmentid(String wiDepartmentid) {
		this.wiDepartmentid = wiDepartmentid;
	}

	/**
	 * wiuserid取得
	 *
	 * @return wiuserid
	 */
	public String getWiuserid() {
		return wiuserid;
	}

	/**
	 * wiuserid设定
	 *
	 * @param wiuserid wiuserid
	 */
	public void setWiuserid(String wiuserid) {
		this.wiuserid = wiuserid;
	}

	/**
	 * 发起类型（1，自动发起；2，手动发起）取得
	 *
	 * @return 发起类型（1，自动发起；2，手动发起）
	 */
	public String getWiLunchType() {
		return wiLunchType;
	}

	/**
	 * 发起类型（1，自动发起；2，手动发起）设定
	 *
	 * @param 发起类型（1，自动发起；2，手动发起）
	 */
	public void setWiLunchType(String wiLunchType) {
		this.wiLunchType = wiLunchType;
	}

	/**
	 * 执行需所时间（小时）取得
	 *
	 * @return 执行需所时间（小时）
	 */
	public String getExcuteTime() {
		return excuteTime;
	}

	/**
	 * 执行需所时间（小时）设定
	 *
	 * @param 执行需所时间（小时）
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
	 * 工作确认日期取得
	 *
	 * @return 工作确认日期
	 */
	public String getConfirmDate() {
		return confirmDate;
	}

	/**
	 * 工作确认日期设定
	 *
	 * @param 工作确认日期
	 */
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}

	/**
	 * 执行情况描述取得
	 *
	 * @return 执行情况描述
	 */
	public String getWiDescription() {
		return wiDescription;
	}

	/**
	 * 执行情况描述设定
	 *
	 * @param 执行情况描述
	 */
	public void setWiDescription(String wiDescription) {
		this.wiDescription = wiDescription;
	}

	/**
	 * 按钮动作取得
	 *
	 * @return 按钮动作
	 */
	public String getBtnAction() {
		return btnAction;
	}

	/**
	 * 按钮动作设定
	 *
	 * @param 按钮动作
	 */
	public void setBtnAction(String btnAction) {
		this.btnAction = btnAction;
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
		return wiid;
	}

}