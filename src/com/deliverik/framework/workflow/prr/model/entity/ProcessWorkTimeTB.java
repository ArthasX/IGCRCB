/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeInfo;

/**
  * 概述: 用户作息时间定义表实体
  * 功能描述: 用户作息时间定义表实体
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ProcessWorkTime")
public class ProcessWorkTimeTB extends BaseEntity implements Serializable,
		Cloneable, ProcessWorkTimeInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="PROCESSWORKTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="PROCESSWORKTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PROCESSWORKTIME_TABLE_GENERATOR")
	protected Integer pwId;

	/** 用户ID */
	protected String userId;

	/** 工作日期 */
	protected String pwDate;

	/** 工作开始时间 */
	protected String pwStartTime;

	/** 工作结束时间 */
	protected String pwEndTime;

	/** 休息时间 */
	protected Integer pwSleep;

	/** 用户修改标志位 */
	protected String pwFlg;

	/** 有效时间 */
	protected Integer factTime;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPwId() {
		return pwId;
	}

	/**
	 * 主键设定
	 *
	 * @param pwId主键
	 */
	public void setPwId(Integer pwId) {
		this.pwId = pwId;
	}

	/**
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 用户ID设定
	 *
	 * @param userId用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 工作日期取得
	 *
	 * @return 工作日期
	 */
	public String getPwDate() {
		return pwDate;
	}

	/**
	 * 工作日期设定
	 *
	 * @param pwDate工作日期
	 */
	public void setPwDate(String pwDate) {
		this.pwDate = pwDate;
	}

	/**
	 * 工作开始时间取得
	 *
	 * @return 工作开始时间
	 */
	public String getPwStartTime() {
		return pwStartTime;
	}

	/**
	 * 工作开始时间设定
	 *
	 * @param pwStartTime工作开始时间
	 */
	public void setPwStartTime(String pwStartTime) {
		this.pwStartTime = pwStartTime;
	}

	/**
	 * 工作结束时间取得
	 *
	 * @return 工作结束时间
	 */
	public String getPwEndTime() {
		return pwEndTime;
	}

	/**
	 * 工作结束时间设定
	 *
	 * @param pwEndTime工作结束时间
	 */
	public void setPwEndTime(String pwEndTime) {
		this.pwEndTime = pwEndTime;
	}

	/**
	 * 休息时间取得
	 *
	 * @return 休息时间
	 */
	public Integer getPwSleep() {
		return pwSleep;
	}

	/**
	 * 休息时间设定
	 *
	 * @param pwSleep休息时间
	 */
	public void setPwSleep(Integer pwSleep) {
		this.pwSleep = pwSleep;
	}

	/**
	 * 用户修改标志位取得
	 *
	 * @return 用户修改标志位
	 */
	public String getPwFlg() {
		return pwFlg;
	}

	/**
	 * 用户修改标志位设定
	 *
	 * @param pwFlg用户修改标志位
	 */
	public void setPwFlg(String pwFlg) {
		this.pwFlg = pwFlg;
	}

	/**
	 * 有效时间取得
	 *
	 * @return 有效时间
	 */
	public Integer getFactTime() {
		return factTime;
	}

	/**
	 * 有效时间设定
	 *
	 * @param factTime有效时间
	 */
	public void setFactTime(Integer factTime) {
		this.factTime = factTime;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return pwId;
	}

}