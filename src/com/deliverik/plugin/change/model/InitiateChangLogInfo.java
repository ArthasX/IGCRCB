/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.change.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 发起变更流程日志接口
  * 功能描述: 发起变更流程日志接口
  * 创建记录: 2015/07/02
  * 修改记录: 
  */
public interface InitiateChangLogInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getIcid();

	/**
	 * 发送时间取得
	 *
	 * @return 发送时间
	 */
	public String getSendTime();

	/**
	 * 发布时间取得
	 *
	 * @return 发布时间
	 */
	public String getPublishTime();

	/**
	 * 流程id取得
	 *
	 * @return 流程id
	 */
	public Integer getPrid();

	/**
	 * 发布状态取得
	 *
	 * @return 发布状态
	 */
	public String getPublishStatus();

	/**
	 * 备注取得
	 *
	 * @return 备注
	 */
	public String getRemark();

	/**
	 * 发起人id取得
	 *
	 * @return 发起人id
	 */
	public String getPruserId();

	/**
	 * 发起人角色id取得
	 *
	 * @return 发起人角色id
	 */
	public String getPrroleId();

	/**
	 * 变更名称取得
	 *
	 * @return 变更名称
	 */
	public String getChangeName();

	/**
	 * 变更描述取得
	 *
	 * @return 变更描述
	 */
	public String getChangeDescription();

	/**
	 * 计划执行开始时间取得
	 *
	 * @return 计划执行开始时间
	 */
	public String getBeginTime();

	/**
	 * 计划执行结束时间取得
	 *
	 * @return 计划执行结束时间
	 */
	public String getEndTime();

	/**
	 * 变更类型取得
	 *
	 * @return 变更类型
	 */
	public String getChangeType();

	/**
	 * 变更类别取得
	 *
	 * @return 变更类别
	 */
	public String getChangeCategory();

	/**
	 * 所选变更类型取得
	 *
	 * @return 所选变更类型
	 */
	public String getSelectedChangeType();

	/**
	 * 变更分类取得
	 *
	 * @return 变更分类
	 */
	public String getChangeClassify();

	/**
	 * 更新平台取得
	 *
	 * @return 更新平台
	 */
	public String getUpdatePlatform();

	/**
	 * 变更原因分类取得
	 *
	 * @return 变更原因分类
	 */
	public String getChangeReasonClassify();

	/**
	 * 变更原因取得
	 *
	 * @return 变更原因
	 */
	public String getChangeReason();

	/**
	 * 变更内容取得
	 *
	 * @return 变更内容
	 */
	public String getChangeContent();

	/**
	 * 相关项目编号取得
	 *
	 * @return 相关项目编号
	 */
	public String getPrjid();

	/**
	 * 相关项目名称取得
	 *
	 * @return 相关项目名称
	 */
	public String getPrjtitle();

	/**
	 * 是否影响业务取得
	 *
	 * @return 是否影响业务
	 */
	public String getIsBusiness();

	/**
	 * 是业务影响范围取得
	 *
	 * @return 是业务影响范围
	 */
	public String getBusinessScope();

	/**
	 * 计划影响业务时长(分钟)取得
	 *
	 * @return 计划影响业务时长(分钟)
	 */
	public String getBusinessTime();

	/**
	 * 执行计划取得
	 *
	 * @return 执行计划
	 */
	public String getDeliveryProgram();

	/**
	 * 回退计划取得
	 *
	 * @return 回退计划
	 */
	public String getRollbackProgram();

	/**
	 * 验证计划取得
	 *
	 * @return 验证计划
	 */
	public String getVerificationProgram();

	/**
	 * 相关程序开发流程取得
	 *
	 * @return 相关程序开发流程
	 */
	public String getRelatedPrid();
	
	/**
	 * 附件key获取
	 * @return the attkey
	 */
	public String getAttkey();
	/**
	 * PMS系统工单ID取得
	 * @return ticketid PMS系统工单ID
	 */
	
	public String getTicketid();
}