/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.soc.asset.model.entity.SOC0113TB;

/**
 * 概述: StorageEvent接口 功能描述: StorageEvent接口 创建记录: 2011/06/13 修改记录:
 */
public interface SOC0305Info extends BaseModel {

	/**
	 * 日志记录时间取得
	 * 
	 * @return 日志记录时间
	 */
	public String getDetectiontime();

	/**
	 * dir取得
	 * 
	 * @return dir
	 */
	public String getDir();

	/**
	 * src取得
	 * 
	 * @return src
	 */
	public String getSrc();

	/**
	 * 种类取得
	 * 
	 * @return 种类
	 */
	public String getCategory();

	/**
	 * 级别取得
	 * 
	 * @return 级别
	 */
	public String getSeverity();

	/**
	 * 错误号取得
	 * 
	 * @return 错误号
	 */
	public String getErrornum();

	/**
	 * 信息描述取得
	 * 
	 * @return 信息描述
	 */
	public String getErrordesc();

	/**
	 * Eirootmark 取得
	 * 
	 * @return eirootmark
	 */
	public String getEirootmark();

	/**
	 * 状态取得
	 * 
	 * @return state
	 */
	public String getState();

	/**
	 * 一级种类取得
	 * 
	 * @return sort
	 */
	public String getSort();

	/**
	 *查询类型取得
	 * 
	 * @return sort
	 */
	public Integer getImptypeid();
	
	public String getLparnam();
	/**
	 * 
	 * ip地址
	 * @return IP
	 */
	public String getIp();
	
	/**
	 * 
	 * FailingEnclosureMTMS
	 * @return IP
	 */
	public String getFailingEnclosureMTMS();
	
	public String getFru1Loc();
	
	public String getFru2Loc();
	
	public String getFru3Loc();
	
	public String getReportingMTMS();
	
	/**
	 * 报警类型取得
	 * @return
	 */
	public String getAlarmType();
	
	public Integer getId();
	
	/**
	 * 导入程序管理表实体取得
	 * @return
	 */
	public SOC0113TB getEiImportProgrammeTB();
	
	/**
	 * 处理状态取得
	 * @return
	 */
	public String getStatus();
}