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
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeTemplateInfo;


/**
  * 概述: 作息时间模板定义表实体
  * 功能描述: 作息时间模板定义表实体
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ProcessWorkTimeTemplate")
public class ProcessWorkTimeTemplateTB extends BaseEntity implements Serializable,
		Cloneable, ProcessWorkTimeTemplateInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="PROCESSWORKTIMETEMPLATE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="PROCESSWORKTIMETEMPLATE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PROCESSWORKTIMETEMPLATE_TABLE_GENERATOR")
	protected Integer pwtId;

	/** 工作日期 */
	protected String pwtDate;

	/** 工作开始时间 */
	protected String pwtStartTime;

	/** 工作结束时间 */
	protected String pwtEndTime;

	/** 休息时间 */
	protected Integer pwtSleepTime;

	/** 有效时间 */
	protected Integer factTime;


	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPwtId() {
		return pwtId;
	}

	/**
	 * 主键设定
	 *
	 * @param pwtId主键
	 */
	public void setPwtId(Integer pwtId) {
		this.pwtId = pwtId;
	}

	/**
	 * 工作日期取得
	 *
	 * @return 工作日期
	 */
	public String getPwtDate() {
		return pwtDate;
	}

	/**
	 * 工作日期设定
	 *
	 * @param pwtDate工作日期
	 */
	public void setPwtDate(String pwtDate) {
		this.pwtDate = pwtDate;
	}

	/**
	 * 工作开始时间取得
	 *
	 * @return 工作开始时间
	 */
	public String getPwtStartTime() {
		return pwtStartTime;
	}

	/**
	 * 工作开始时间设定
	 *
	 * @param pwtStartTime工作开始时间
	 */
	public void setPwtStartTime(String pwtStartTime) {
		this.pwtStartTime = pwtStartTime;
	}

	/**
	 * 工作结束时间取得
	 *
	 * @return 工作结束时间
	 */
	public String getPwtEndTime() {
		return pwtEndTime;
	}

	/**
	 * 工作结束时间设定
	 *
	 * @param pwtEndTime工作结束时间
	 */
	public void setPwtEndTime(String pwtEndTime) {
		this.pwtEndTime = pwtEndTime;
	}

	/**
	 * 休息时间取得
	 *
	 * @return 休息时间
	 */
	public Integer getPwtSleepTime() {
		return pwtSleepTime;
	}

	/**
	 * 休息时间设定
	 *
	 * @param pwtSleepTime休息时间
	 */
	public void setPwtSleepTime(Integer pwtSleepTime) {
		this.pwtSleepTime = pwtSleepTime;
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
		return pwtId;
	}

}