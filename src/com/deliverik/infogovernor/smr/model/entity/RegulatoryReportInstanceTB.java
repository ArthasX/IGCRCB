/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;

/**
  * 概述: 报表填报实例表实体
  * 功能描述: 报表填报实例表实体
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="RegulatoryReportInstance")
public class RegulatoryReportInstanceTB extends BaseEntity implements Serializable,
		Cloneable, RegulatoryReportInstanceInfo {

	/** 自增ID */
	@Id
	@TableGenerator(
		name="REGULATORYREPORTINSTANCE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REGULATORYREPORTINSTANCE_SEQUENCE", initialValue=1000, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REGULATORYREPORTINSTANCE_TABLE_GENERATOR")
	protected Integer instanceID;

	/** 组类型 */
	protected String prtype;

	/** 组标识 */
	protected String key;

	/** 填报发起时间 */
	protected String inittime;

	/** 填报结束时间 */
	protected String endtime;

	/** 填报限制时间 */
	protected String limittime;

	/** 备注 */
	protected String remark;

	/** 状态：0开启，1二级审批，2中止,3关闭*/
	protected String status;
	
	/** 发起人ID */
	protected String userid;
	
	/** 发起人姓名 */
	protected String username;
	
	/** 年报说明 */
	protected String reportdesc;
	
	/** 年 */
	protected String year;
	
	/** 季度 */
	protected String quarter;
	
	/** 月份 */
	protected String month;
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * 自增ID取得
	 *
	 * @return 自增ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * 自增ID设定
	 *
	 * @param instanceID 自增ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}

	/**
	 * 组类型取得
	 *
	 * @return 组类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 组类型设定
	 *
	 * @param prtype 组类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 组标识取得
	 *
	 * @return 组标识
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 组标识设定
	 *
	 * @param key 组标识
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 填报发起时间取得
	 *
	 * @return 填报发起时间
	 */
	public String getInittime() {
		return inittime;
	}

	/**
	 * 填报发起时间设定
	 *
	 * @param inittime 填报发起时间
	 */
	public void setInittime(String inittime) {
		this.inittime = inittime;
	}

	/**
	 * 填报结束时间取得
	 *
	 * @return 填报结束时间
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * 填报结束时间设定
	 *
	 * @param endtime 填报结束时间
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * 填报限制时间取得
	 *
	 * @return 填报限制时间
	 */
	public String getLimittime() {
		return limittime;
	}

	/**
	 * 填报限制时间设定
	 *
	 * @param limittime 填报限制时间
	 */
	public void setLimittime(String limittime) {
		this.limittime = limittime;
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
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 状态设定
	 *
	 * @param status 状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 发起人ID
	 * 
	 * @return 发起人ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 发起人ID
	 * @param userid 发起人ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 发起人姓名
	 * @return 发起人姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 发起人姓名
	 * @param username 发起人姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 年报说明
	 * @return 年报说明
	 */
	public String getReportdesc() {
		return reportdesc;
	}
	/**
	 * 年报说明
	 * @param reportdesc 年报说明
	 */
	public void setReportdesc(String reportdesc) {
		this.reportdesc = reportdesc;
	}
	
	/**
	 * 年取得
	 * @return 年
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 年设定
	 * @param year 年
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 季度取得
	 * @return 季度
	 */
	public String getQuarter() {
		return quarter;
	}

	/**
	 * 季度设定
	 * @param quarter 季度
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return instanceID;
	}

}