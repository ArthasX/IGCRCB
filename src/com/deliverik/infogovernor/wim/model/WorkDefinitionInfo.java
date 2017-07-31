/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 工作定义接口
  * 功能描述: 工作定义接口
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public interface WorkDefinitionInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return wdid
	 */
	public Integer getWdid();

	/**
	 * 工作项名称取得
	 *
	 * @return 工作项名称
	 */
	public String getWdname();

	/**
	 * 发起人（userid）取得
	 *
	 * @return 发起人（userid）
	 */
	public String getInitiatorId();

	/**
	 * 周期/频率取得
	 *
	 * @return 周期/频率
	 */
	public String getCycle();

	/**
	 * 发起时间取得
	 *
	 * @return 发起时间
	 */
	public String getWdcreateTime();

	/**
	 * 工作项描述取得
	 *
	 * @return 工作项描述
	 */
	public String getDescription();

	/**
	 * 开始日期取得
	 *
	 * @return 开始日期
	 */
	public String getBeginDate();

	/**
	 * 结束日期取得
	 *
	 * @return 结束日期
	 */
	public String getEndDate();

	/**
	 * 预计完成日期取得
	 *
	 * @return 预计完成日期
	 */
	public String getEstimateFinishDate();

	/**
	 * 实际完成日期取得
	 *
	 * @return 实际完成日期
	 */
	public String getActualFinishDate();

	/**
	 * 超时提醒时间（天）取得
	 *
	 * @return 超时提醒时间（天）
	 */
	public String getOvertimeTipsTime();
	
	/**
	 * 超时停止处理时间（天）取得
	 * @return 超时停止处理时间（天）
	 */
	public String getOvertimeStopDealTime();

	/**
	 * 负责人（userid）取得
	 *
	 * @return 负责人（userid）
	 */
	public String getLeaderId();
	
	/**
	 * 负责人名称取得
	 * @return 负责人名称
	 */
	public String getLeaderName();

	/**
	 * 执行人（userid,userid,userid,...）取得
	 *
	 * @return 执行人（userid,userid,userid,...）
	 */
	public String getExcutorId();
	
	/**
	 * 执行人名称取得
	 * @return 执行人名称
	 */
	public String getExcutorName();

	/**
	 * 启用状态（0，未启用；1，已启用）取得
	 *
	 * @return 启用状态（0，未启用；1，已启用）
	 */
	public String getWdstatus();

	/**
	 * 月取得
	 *
	 * @return 月
	 */
	public String getWdmonth();

	/**
	 * 每月最后一天发起（Y，是；N；否）取得
	 *
	 * @return 每月最后一天发起（Y，是；N；否）
	 */
	public String getMonthLastDay();

	/**
	 * 周取得
	 *
	 * @return 周
	 */
	public String getWdweek();

	/**
	 * 时取得
	 *
	 * @return 时
	 */
	public String getWdhour();

	/**
	 * 分取得
	 *
	 * @return 分
	 */
	public String getWdminute();

	/**
	 * 是否短信通知（Y,是；N，否）取得
	 *
	 * @return 是否短信通知（Y,是；N，否）
	 */
	public String getIsMsgNotice();

	/**
	 * 备注取得
	 *
	 * @return 备注
	 */
	public String getRemarks();

	/**
	 * 表记录创建日期取得
	 *
	 * @return 表记录创建日期
	 */
	public String getCrtDate();
	
	/**
	 * 预留字段取得
	 * @return 预留字段
	 */
	public String getReservedFiled();

}