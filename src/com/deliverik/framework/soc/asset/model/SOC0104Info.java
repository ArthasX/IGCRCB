/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 审计任务表接口
  * 功能描述: 审计任务表接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface SOC0104Info extends BaseModel {

	/**
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getAutid();

	/**
	 * 审计任务描述取得
	 *
	 * @return 审计任务描述
	 */
	public String getAutdesc();

	/**
	 * 审计时间戳取得
	 *
	 * @return 审计时间戳
	 */
	public String getAuttime();
	
	/**
	 * 状态取得
	 * 
	 * @return 状态
	 */
	public String getAutstatus();

	/**
	 * 最后更新时间取得
	 * @return 最后更新时间
	 */
	public String getAutupdtime();

	/**
	 * 最后对比时间取得
	 * @return 最后对比时间
	 */
	public String getAutcomptime();

}