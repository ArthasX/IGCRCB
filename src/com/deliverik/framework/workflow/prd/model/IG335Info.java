/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 表单策略表接口
  * 功能描述: 表单策略表接口
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public interface IG335Info extends BaseModel {

	/**
	 * 状态定义ID取得
	 *
	 * @return 状态定义ID
	 */
	public String getPsdid();

	/**
	 * 表单定义ID取得
	 *
	 * @return 表单定义ID
	 */
	public String getPidid();

	/**
	 * 表单值取得
	 * @return pivalue 表单值
	 */
	public String getPivalue();
	
	/**
	 * 确认节点是否发送取得
	 * @return psdconfirm 确认节点是否发送
	 */
	public String getPsdconfirm();

	/**
	 * 天取得
	 *
	 * @return 天
	 */
	public Integer getNotifyd();

	/**
	 * 小时取得
	 *
	 * @return 小时
	 */
	public Integer getNotifyh();

	/**
	 * 分取得
	 *
	 * @return 分
	 */
	public Integer getNotifym();
	
	/**
	 * 上报_天取得
	 * @return reportd 上报_天
	 */
	public Integer getReportd();

	/**
	 * 上报_小时取得
	 * @return reporth 上报_小时
	 */
	public Integer getReporth();

	/**
	 * 上报_分取得
	 * @return reportm 上报_分
	 */
	public Integer getReportm();

	/**
	 * 角色ID取得
	 *
	 * @return 角色ID
	 */
	public Integer getRoleid();
	
	/**
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getRolename();

	/**
	 * 处理BL取得
	 *
	 * @return 处理BL
	 */
	public String getProcessbl();
	
	/**
	 * 上报角色负责人取得
	 * @return rolemanager 上报角色负责人
	 */
	public String getRolemanager();
	
	/**
	 * 通知人ID取得
	 * @return notifierids 通知人ID
	 */
	public String getNotifierids();
	
	/**
	 * 通知人名称取得
	 * @return notifiernames 通知人名称
	 */
	public String getNotifiernames();

	/**
	 * 流程定义ID取得
	 * @return pdid
	 */
	public String getPdid();

}