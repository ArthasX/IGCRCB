/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 抄阅人表接口
  * 功能描述: 抄阅人表接口
  * 创建记录: 2013/02/25
  * 修改记录: 
  */
public interface CopyReadUserInfo extends BaseModel{

	/**
	 * 无意义自增主键取得
	 *
	 * @return 无意义自增主键
	 */
	public Integer getCruid();

	/**
	 * 流程id取得
	 *
	 * @return 流程id
	 */
	public Integer getPrid();

	/**
	 * 流程编号取得
	 *
	 * @return 流程编号
	 */
	public String getPrserialnum();

	/**
	 * 流程名称取得
	 *
	 * @return 流程名称
	 */
	public String getPrtitle();

	/**
	 * 流程类型取得
	 *
	 * @return 流程类型
	 */
	public String getPrpdname ();

	/**
	 * 处理人角色取得
	 *
	 * @return 处理人角色
	 */
	public String getPrrolename();

	/**
	 * 处理人姓名取得
	 *
	 * @return 处理人姓名
	 */
	public String getPrusername ();

	/**
	 * 处理状态取得
	 *
	 * @return 处理状态
	 */
	public String getCrustatus ();

	/**
	 * 分派时间取得
	 *
	 * @return 分派时间
	 */
	public String getPrassigntime();

	/**
	 * 查看时间取得
	 *
	 * @return 查看时间
	 */
	public String getPrlooktime();

	/**
	 * 是否查看标识取得
	 *
	 * @return 是否查看标识
	 */
	public String getIslook();

	/**
	 * 处理人id取得
	 *
	 * @return 处理人id
	 */
	public String getPruserid ();

	/**
	 * 流程开始时间取得
	 *
	 * @return 流程开始时间
	 */
	public String getPrstarttime();
	
	/**
	 * 流程定义id取得
	 *
	 * @return 流程定义id
	 */
	public String getPrpdid();
	
	/**
	 * 流程子状态取得
	 *
	 * @return 流程子状态
	 */
	public String getPrsubstatus();
}