/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: StorageEvent接口
  * 功能描述: StorageEvent接口
  * 创建记录: 2011/06/13
  * 修改记录: 
  */
public interface StorageEventInfo extends BaseModel {

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
	 * @return eirootmark
	 */
	public String getEirootmark();
	
	/**
	 * 状态取得
	 * @return state
	 */
	public String getState();
	
	/**
	 * 一级种类取得
	 * @return sort
	 */
	public String getSort();

	/**
	 * 记录时间戳取得
	 *
	 * @return 记录时间戳
	 */
	public String getFingerprint();

}