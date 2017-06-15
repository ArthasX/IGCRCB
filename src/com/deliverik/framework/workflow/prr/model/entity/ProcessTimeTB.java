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
import com.deliverik.framework.workflow.prr.model.ProcessTimeInfo;

/**
  * 概述: 流程计时表实体
  * 功能描述: 流程计时表实体
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="processTime")
public class ProcessTimeTB extends BaseEntity implements Serializable,
		Cloneable, ProcessTimeInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="PROCESSTIME_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="PROCESSTIME_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="PROCESSTIME_TABLE_GENERATOR")
	protected Integer prtid;

	/** 流程ID */
	protected Integer prid;

	/** 计时用户ID */
	protected String userid;

	/** 计时开始时间 */
	protected String prtstartTime;

	/** 开始计时状态 */
	protected String prtstartStatus;

	/** 计时结束时间 */
	protected String prtEndTime;

	/** 计时结束状态 */
	protected String prtEndStatus;

	/** 有效分钟数 */
	protected Integer factTime;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPrtid() {
		return prtid;
	}

	/**
	 * 主键设定
	 *
	 * @param prtid主键
	 */
	public void setPrtid(Integer prtid) {
		this.prtid = prtid;
	}

	/**
	 * 流程ID取得
	 *
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 *
	 * @param prid流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 计时用户ID取得
	 *
	 * @return 计时用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 计时用户ID设定
	 *
	 * @param userid计时用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 计时开始时间取得
	 *
	 * @return 计时开始时间
	 */
	public String getPrtstartTime() {
		return prtstartTime;
	}

	/**
	 * 计时开始时间设定
	 *
	 * @param prtstartTime计时开始时间
	 */
	public void setPrtstartTime(String prtstartTime) {
		this.prtstartTime = prtstartTime;
	}

	/**
	 * 开始计时状态取得
	 *
	 * @return 开始计时状态
	 */
	public String getPrtstartStatus() {
		return prtstartStatus;
	}

	/**
	 * 开始计时状态设定
	 *
	 * @param prtstartStatus开始计时状态
	 */
	public void setPrtstartStatus(String prtstartStatus) {
		this.prtstartStatus = prtstartStatus;
	}

	/**
	 * 计时结束时间取得
	 *
	 * @return 计时结束时间
	 */
	public String getPrtEndTime() {
		return prtEndTime;
	}

	/**
	 * 计时结束时间设定
	 *
	 * @param prtEndTime计时结束时间
	 */
	public void setPrtEndTime(String prtEndTime) {
		this.prtEndTime = prtEndTime;
	}

	/**
	 * 计时结束状态取得
	 *
	 * @return 计时结束状态
	 */
	public String getPrtEndStatus() {
		return prtEndStatus;
	}

	/**
	 * 计时结束状态设定
	 *
	 * @param prtEndStatus计时结束状态
	 */
	public void setPrtEndStatus(String prtEndStatus) {
		this.prtEndStatus = prtEndStatus;
	}

	/**
	 * 有效分钟数取得
	 *
	 * @return 有效分钟数
	 */
	public Integer getFactTime() {
		return factTime;
	}

	/**
	 * 有效分钟数设定
	 *
	 * @param factTime有效分钟数
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
		return prtid;
	}

}