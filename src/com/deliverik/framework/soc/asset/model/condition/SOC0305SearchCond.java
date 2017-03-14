/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * 概述: StorageEvent检索条件接口
  * 功能描述: StorageEvent检索条件接口
  * 创建记录: 2011/06/13
  * 修改记录: 
  */
public interface SOC0305SearchCond {

	/**
	 * 查询类型取得
	 * @return impcitype
	 */
	public abstract String getImpcitype();
	/**
	 * 错误日志的种类取得
	 * @return sort_eq
	 */
	public abstract String getEirootmark_eq();
	
	/**
	 * 错误日志的DIR取得
	 * @return dir_eq
	 */
	public abstract String getDir_eq(); 
	
	/**
	 * 错误日志的错误号取得
	 * @return errornum_eq
	 */
	public abstract String getErrornum_eq(); 
	
	/**
	 * 日志创建时间取得
	 * @return
	 */
	public String getDetectiontime_eq();
	
	/**
	 * 开始的存储事件创建时间取得
	 * @return detectiontime_from 存储事件创建时间
	 */
	public abstract String getDetectiontime_from();
	
	/**
	 * 结束的存储事件创建时间取得
	 * @return detectiontime_to 存储事件创建时间
	 */
	public abstract String getDetectiontime_to();
	
	/**
	 * 告警级别取得
	 * @return severity_eq
	 */
	public String getSeverity_eq();
	
	/**
	 * 错误描述取得
	 * @return
	 */
	public String getErrorDesc();
	
	/**
	 * 告警种类取得
	 * @return
	 */
	public String getAlarmType();
	
	/**
	 * id取得
	 * @return
	 */
	public String getId();
	
	/**
	 * 处理状态取得
	 * @return
	 */
	public String getStatus();
}