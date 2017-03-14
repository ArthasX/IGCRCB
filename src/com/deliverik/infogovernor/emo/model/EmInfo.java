/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.emo.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: oracle性能采集接口
  * 功能描述: oracle性能采集接口
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
public interface EmInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getEm_id();

	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getEm_type();

	/**
	 * 顶级sql的ID取得
	 *
	 * @return 顶级sql的ID
	 */
	public String getEm_sqlid();

	/**
	 * 顶级会话的ID取得
	 *
	 * @return 顶级会话的ID
	 */
	public String getEm_sessionid();

	/**
	 * SQL类型取得
	 *
	 * @return SQL类型
	 */
	public String getEm_sqltype();

	/**
	 * SQL内容取得
	 *
	 * @return SQL内容
	 */
	public String getEm_sqlcontent();

	/**
	 * 用户名取得
	 *
	 * @return 用户名
	 */
	public String getEm_username();

	/**
	 * 程序取得
	 *
	 * @return 程序
	 */
	public String getEm_program();

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_other();

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_network();

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_Queueing();

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_Idle();

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_Cluster();

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_administrative();

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_configuraction();

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_commit();

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_application();

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_concurrency();

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_systemIO();

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_userIO();

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_scheduler();

	/**
	 * 指标名称取得
	 *
	 * @return 指标名称
	 */
	public String getEm_cpu();

	/**
	 * 指标总和取得
	 *
	 * @return 指标总和
	 */
	public String getEm_Totail();

	/**
	 * 采集时间取得
	 *
	 * @return 采集时间
	 */
	public String getEm_Collecttime();

}