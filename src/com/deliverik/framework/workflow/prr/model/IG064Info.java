/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model;

/**
  * 概述: 流程记录节点提醒视图接口
  * 功能描述: 流程记录节点提醒视图接口
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
public interface IG064Info {

	/**
	 * 流程ID取得
	 *
	 * @return 流程ID
	 */
	public Integer getPrid();

	/**
	 * 流程状态ID取得
	 *
	 * @return 流程状态ID
	 */
	public String getPsdid();

	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid();
	
	public String getPsdname();

	/**
	 * 流程状态标示取得
	 *
	 * @return 流程状态标示
	 */
	public String getPsdcode();

	/**
	 * 是否提交（0：否；1：是）取得
	 *
	 * @return 是否提交（0：否；1：是）
	 */
	public String getPsdconfirm();

	/**
	 * 当前参与角色ID取得
	 *
	 * @return 当前参与角色ID
	 */
	public Integer getPproleid();

	/**
	 * 参与角色名称取得
	 *
	 * @return 参与角色名称
	 */
	public String getPprolename();

	/**
	 * 当前参与人员ID取得
	 *
	 * @return 当前参与人员ID
	 */
	public String getPpuserid();

	/**
	 * 人员姓名取得
	 *
	 * @return 人员姓名
	 */
	public String getPpusername();

	/**
	 * 接单动作取得
	 *
	 * @return 接单动作
	 */
	public String getPpsubstatus();
	
	public String getPpinittime();

	/**
	 * 接单时间取得
	 *
	 * @return 接单时间
	 */
	public String getPpbacktime();

	/**
	 * 策略定义状态ID取得
	 *
	 * @return 策略定义状态ID
	 */
	public String getPnsdpsdid();

	/**
	 * 策略表提交标示取得
	 *
	 * @return 策略表提交标示
	 */
	public String getPnsdconfirm();

	/**
	 * 是否发送短信取得
	 *
	 * @return 是否发送短信
	 */
	public String getSms();

	/**
	 * 是否发送EMAIL取得
	 *
	 * @return 是否发送EMAIL
	 */
	public String getEmail();

	/**
	 * 通知时间天取得
	 *
	 * @return 通知时间天
	 */
	public Integer getNotifyd();

	/**
	 * 通知小时取得
	 *
	 * @return 通知小时
	 */
	public Integer getNotifyh();

	/**
	 * 通知时间分取得
	 *
	 * @return 通知时间分
	 */
	public Integer getNotifym();

	/**
	 * 上报天取得
	 *
	 * @return 上报天
	 */
	public Integer getReportd();

	/**
	 * 上报时取得
	 *
	 * @return 上报时
	 */
	public Integer getReporth();

	/**
	 * 上报分取得
	 *
	 * @return 上报分
	 */
	public Integer getReportm();

	/**
	 * 角色负责人取得
	 *
	 * @return 角色负责人
	 */
	public String getRolemanager();
	
	public Integer getPpid();
	public String getPrtitle();


	public String getPrserialnum();
	
	//====>130225Begin
	/**
	 * 状态模式取得
	 *
	 * @return psdassign 状态模式
	 */
	public String getPsdassign();
	
	/**
	 * 机构层次码取得
	 *
	 * @return pporgid 机构层次码
	 */
	public String getPporgid();
	
	/**
	 * 机构名称取得
	 *
	 * @return pporgname 机构名称
	 */
	public String getPporgname();
	//====>130225End
}