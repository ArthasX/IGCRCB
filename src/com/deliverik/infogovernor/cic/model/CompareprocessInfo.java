/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 对比记录接口
  * 功能描述: 对比记录接口
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public interface CompareprocessInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCpid();

	/**
	 * 比对域外键取得
	 *
	 * @return 比对域外键
	 */
	public Integer getFkCsid();

	/**
	 * 开始时间取得
	 *
	 * @return 开始时间
	 */
	public String getCpstarttime();

	/**
	 * 结束时间取得
	 *
	 * @return 结束时间
	 */
	public String getCpendtime();

	/**
	 * 进度取得
	 *
	 * @return 进度
	 */
	public String getCpschedule();

	/**
	 * 执行结果取得
	 *
	 * @return 执行结果
	 */
	public String getCpresulttype();

	/**
	 * 错误提示取得
	 *
	 * @return 错误提示
	 */
	public String getErrorcaption();




}