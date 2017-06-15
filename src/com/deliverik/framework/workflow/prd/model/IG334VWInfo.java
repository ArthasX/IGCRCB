/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

/**
 * 概述: 流程策略设定信息
 * 功能描述: 流程策略设定信息
 * 创建记录: 2013/09/04
 * 修改记录: 
 */
public interface IG334VWInfo{

	/**
	 * 表单定义ID取得
	 *
	 * @return pidid 表单定义ID
	 */
	public String getPidid();
	
	/**
	 * 流程类型ID取得
	 *
	 * @return pdid 流程类型ID
	 */
	public String getPdid();
	
	/**
	 * 流程策略发送短信标识取得
	 *
	 * @return sms 流程策略发送短信标识
	 */
	public String getSms();
	
	/**
	 * 流程策略发送邮件标识取得
	 *
	 * @return email 流程策略发送邮件标识
	 */
	public String getEmail();
	
	/**
	 * 流程策略对应状态主键取得
	 *
	 * @return psdid 流程策略对应状态主键
	 */
	public String getPsdid();
	
	/**
	 * 流程策略对应状态标识取得
	 *
	 * @return psdcode 流程策略对应状态标识
	 */
	public String getPsdcode();
	
	/**
	 * 流程策略对应状态名称取得
	 *
	 * @return psdname 流程策略对应状态名称
	 */
	public String getPsdname();
	
	/**
	 * 流程策略相关表单名称取得
	 *
	 * @return pidname 流程策略相关表单名称
	 */
	public String getPidname();
	
	/**
	 * 流程策略相关表单值取得
	 *
	 * @return pivalue 流程策略相关表单值
	 */
	public String getPivalue();
	
	/**
	 * 流程策略超时提醒天数取得
	 *
	 * @return notifyd 流程策略超时提醒天数
	 */
	public Integer getNotifyd();
	
	/**
	 * 流程策略超时提醒小时取得
	 *
	 * @return notifyh 流程策略超时提醒小时
	 */
	public Integer getNotifyh();
	
	/**
	 * 流程策略超时提醒分钟取得
	 *
	 * @return notifym 流程策略超时提醒分钟
	 */
	public Integer getNotifym();
	
	/**
	 * 流程策略报告上级天数取得
	 *
	 * @return reportd 流程策略报告上级天数
	 */
	public Integer getReportd();
	
	/**
	 * 流程策略报告上级小时取得
	 *
	 * @return reporth 流程策略报告上级小时
	 */
	public Integer getReporth();
	
	/**
	 * 流程策略报告上级分钟取得
	 *
	 * @return reportm 流程策略报告上级分钟
	 */
	public Integer getReportm();
	
	/**
	 * 流程策略提醒角色ID取得
	 *
	 * @return roleid 流程策略提醒角色ID
	 */
	public Integer getRoleid();
	
	/**
	 * 流程策略提醒调用BL取得
	 *
	 * @return processbl 流程策略提醒调用BL
	 */
	public String getProcessbl();
	
	/**
	 * 流程策略提醒是否上报角色负责人取得
	 *
	 * @return rolemanager 流程策略提醒是否上报角色负责人
	 */
	public String getRolemanager();
	
	/**
	 * 是否确认取得
	 *
	 * @return psdconfirm 是否确认
	 */
	public String getPsdconfirm();
}
