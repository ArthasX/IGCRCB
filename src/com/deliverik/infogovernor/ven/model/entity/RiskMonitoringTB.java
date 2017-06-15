/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;

/**
  * 概述: 风险监测工作表实体
  * 功能描述: 风险监测工作表实体
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RiskMonitoring")
public class RiskMonitoringTB extends BaseEntity implements Serializable,
		Cloneable, RiskMonitoringInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="RISKMONITORING_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="RISKMONITORING_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKMONITORING_TABLE_GENERATOR")
	protected Integer rmid;

	/** 风险策略主键id */
	protected Integer rsid;

	/** 监测任务名称 */
	protected String rmname;

	/** 计划开始时间 */
	protected String rmstartdate;

	/** 实际完成时间 */
	protected String rmenddate;

	/** 进度 */
	protected String rmrate;
	
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRmid() {
		return rmid;
	}

	/**
	 * 主键设定
	 *
	 * @param rmid 主键
	 */
	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}

	/**
	 * 风险策略主键id取得
	 *
	 * @return 风险策略主键id
	 */
	public Integer getRsid() {
		return rsid;
	}

	/**
	 * 风险策略主键id设定
	 *
	 * @param rsid 风险策略主键id
	 */
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}

	/**
	 * 监测任务名称取得
	 *
	 * @return 监测任务名称
	 */
	public String getRmname() {
		return rmname;
	}

	/**
	 * 监测任务名称设定
	 *
	 * @param rmname 监测任务名称
	 */
	public void setRmname(String rmname) {
		this.rmname = rmname;
	}

	/**
	 * 计划开始时间取得
	 *
	 * @return 计划开始时间
	 */
	public String getRmstartdate() {
		return rmstartdate;
	}

	/**
	 * 计划开始时间设定
	 *
	 * @param rmstartdate 计划开始时间
	 */
	public void setRmstartdate(String rmstartdate) {
		this.rmstartdate = rmstartdate;
	}

	/**
	 * 实际完成时间取得
	 *
	 * @return 实际完成时间
	 */
	public String getRmenddate() {
		return rmenddate;
	}

	/**
	 * 实际完成时间设定
	 *
	 * @param rmenddate 实际完成时间
	 */
	public void setRmenddate(String rmenddate) {
		this.rmenddate = rmenddate;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return rmid;
	}

	/**
	 * 进度取得
	 * @return rmrate  进度
	 */
	public String getRmrate() {
		return rmrate;
	}

	/**
	 * 进度设定
	 * @param rmrate  进度
	 */
	public void setRmrate(String rmrate) {
		this.rmrate = rmrate;
	}

}