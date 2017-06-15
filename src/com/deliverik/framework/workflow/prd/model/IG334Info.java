/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 通知策略基本信息接口
  * 功能描述: 通知策略基本信息接口
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public interface IG334Info extends BaseModel {

	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid();

	/**
	 * 短信通知取得
	 *
	 * @return 短信通知
	 */
	public String getSms();

	/**
	 * 通知邮件取得
	 *
	 * @return 通知邮件
	 */
	public String getEmail();
	
	/**
	 * 表单定义ID取得
	 * @return pidid 表单定义ID
	 */
	public String getPidid();
	
	/**
	 * 表单定义名称取得
	 * @return pidname 表单定义名称
	 */
	public String getPidname();
	

	/**
	 * 天取得
	 * @return notifyd 天
	 */
	public Integer getNotifyd();

	/**
	 * 小时取得
	 * @return notifyh 小时
	 */
	public Integer getNotifyh();
	/**
	 * 分取得
	 * @return notifym 分
	 */
	public Integer getNotifym();
	/**
	 * 角色ID取得
	 * @return roleid 角色ID
	 */
	public Integer getRoleid() ;

	/**
	 * 处理BL取得
	 * @return processbl 处理BL
	 */
	public String getProcessbl();

}