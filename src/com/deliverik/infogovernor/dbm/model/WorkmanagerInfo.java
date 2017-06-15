/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 工作管理接口
  * 功能描述: 工作管理接口
  * 创建记录: 2016/04/19
  * 修改记录: 
  */
public interface WorkmanagerInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getWmid();

	/**
	 * 工作名称取得
	 *
	 * @return 工作名称
	 */
	public String getWmname();

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getWmdesc();

	/**
	 * 完成状态(0-未完成1-已完成)取得
	 *
	 * @return 完成状态(0-未完成1-已完成)
	 */
	public String getWmstatus();

	/**
	 * 发起日期取得
	 *
	 * @return 发起日期
	 */
	public String getWmstartdate();

	/**
	 * 限期完成日期取得
	 *
	 * @return 限期完成日期
	 */
	public String getWmlimitdate();

	/**
	 * 实际完成日期取得
	 *
	 * @return 实际完成日期
	 */
	public String getWmfactdate();

	/**
	 * 频率取得
	 *
	 * @return 频率
	 */
	public String getWmfrequency();

	/**
	 * 工作执行表达式 取得
	 *
	 * @return 工作执行表达式 
	 */
	public String getWmcron();

	/**
	 * 发起人id取得
	 *
	 * @return 发起人id
	 */
	public String getWmuserid();

	/**
	 * 发起人姓名取得
	 *
	 * @return 发起人姓名
	 */
	public String getWmusername();

	/**
	 * 发起人角色id取得
	 *
	 * @return 发起人角色id
	 */
	public String getWmroleid();

	/**
	 * 发起人角色名称取得
	 *
	 * @return 发起人角色名称
	 */
	public String getWmrolename();

	/**
	 * 选项取得
	 *
	 * @return 选项
	 */
	public String getWmoption();

	/**
	 * 提醒时间（小时）取得
	 *
	 * @return 提醒时间（小时）
	 */
	public String getWmremindh();

	/**
	 * 提醒时间（分钟）取得
	 *
	 * @return 提醒时间（分钟）
	 */
	public String getWmremindm();

	/**
	 * 数据来源 0-登记1-复制 取得
	 *
	 * @return 数据来源 0-登记1-复制 
	 */
	public String getWmtype();

	/**
	 * 是否提醒0-提醒1-不再提醒 取得
	 *
	 * @return 是否提醒0-提醒1-不再提醒 
	 */
	public String getWmremind();

	/**
	 * @return the 备注
	 */
	public String getWmremark();
	
	/**
	 * @return the 数据源wmid
	 */
	public String getRewmid();
	
	/**
	 * @return the 频率(每月最后一天)
	 */
	public String getWmfrequencymonthlastday();
	
	/**
	 * @return the 风险检查频率(周)
	 */
	public String getWmfrequencyweeks();
	
	/**
	 * @return the 风险检查频率(月)
	 */
	public String getWmfrequencymonths();
}