/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * 概述: StorageEvent检索条件实现
  * 功能描述: StorageEvent检索条件实现
  * 创建记录: 2011/06/13
  * 修改记录: 
  */
public class SOC0305SearchCondImpl implements
		SOC0305SearchCond {
	
	/** id*/
	protected String id;
	
	/** 查询类型*/
	public String impcitype;
	
	/**错误日志的顶级实体名 */
	public String eirootmark_eq;
	
	/**错误日志的DIR	 */
	public String dir_eq; 
	
	/**错误日志的错误号	 */
	public String errornum_eq; 
	
	/** 日志创建时间 */
	protected String detectiontime_eq;

	/**开始的错误日志记录时间  */
	public String detectiontime_from;
	
	/**结束的错误日志记录时间  */
	public String detectiontime_to;
	
	/**告警级别  */
	public String severity_eq;
	
	/** 告警种类 */
	private String alarmType;
	
	/** 错误描述 */
	private String errorDesc;
	
	/**处理状态*/
	private String status;
	
	/**
	 * 错误描述取得
	 * @return
	 */
	public String getErrorDesc() {
		return errorDesc;
	}

	/**
	 * 错误描述设定
	 * @param errorDesc
	 */
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	/**
	 * 告警种类取得
	 * @return
	 */
	public String getAlarmType() {
		return alarmType;
	}

	/**
	 * 告警种类设定
	 * @param alarmType
	 */
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}
	
	/**
	 * 告警级别取得
	 * @return severity_eq
	 */
	public String getSeverity_eq()
	{
		return severity_eq;
	}
	
	/**
	 * 告警级别设置
	 * @param severity_eq
	 */
	public void setSeverity_eq(String severity_eq)
	{
		this.severity_eq = severity_eq;
	}

	/**
	 * 错误日志的顶级实体名取得
	 * @return eirootmark_eq
	 */
	public String getEirootmark_eq() {
		return eirootmark_eq;
	}

	/**
	 * 错误日志的顶级实体名设置
	 * @param eirootmark_eq
	 */
	public void setEirootmark_eq(String eirootmark_eq) {
		this.eirootmark_eq = eirootmark_eq;
	}

	/**
	 * 错误日志的DIR取得
	 * @return dir_eq
	 */
	public String getDir_eq() {
		return dir_eq;
	}

	/**
	 * 错误日志的DIR设置
	 * @param dir_eq
	 */
	public void setDir_eq(String dir_eq) {
		this.dir_eq = dir_eq;
	}

	/**
	 * 错误日志的错误号取得
	 * @return errornum_eq
	 */
	public String getErrornum_eq() {
		return errornum_eq;
	}

	/**
	 * 错误日志的错误号设置
	 * @param errornum_eq
	 */
	public void setErrornum_eq(String errornum_eq) {
		this.errornum_eq = errornum_eq;
	}

	/**
	 * 开始的错误日志记录时间取得
	 * @return detectiontime_from
	 */
	public String getDetectiontime_from() {
		return detectiontime_from;
	}

	/**
	 * 开始的错误日志记录时间设置
	 * @param detectiontime_from
	 */
	public void setDetectiontime_from(String detectiontime_from) {
		this.detectiontime_from = detectiontime_from;
	}

	/**
	 * 结束的错误日志记录时间取得
	 * @return detectiontime_to
	 */
	public String getDetectiontime_to() {
		return detectiontime_to;
	}

	/**
	 * 结束的错误日志记录时间设置
	 * @param detectiontime_to
	 */
	public void setDetectiontime_to(String detectiontime_to) {
		this.detectiontime_to = detectiontime_to;
	}
	public String getImpcitype() {
		return impcitype;
	}

	public void setImpcitype(String impcitype) {
		this.impcitype = impcitype;
	}

	/**
	 * 日志创建时间取得
	 */
	public String getDetectiontime_eq() {
		return detectiontime_eq;
	}

	/**
	 * 日志创建时间设定
	 * @param detectiontime_eq
	 */
	public void setDetectiontime_eq(String detectiontime_eq) {
		this.detectiontime_eq = detectiontime_eq;
	}

	/**
	 * id取得
	 */
	public String getId() {
		return id;
	}

	/**
	 * id设定
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}