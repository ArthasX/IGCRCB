/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import java.util.List;

import com.deliverik.framework.workflow.prd.model.entity.IG237TB;


/**
  * 概述: 流程通知策略接口
  * 功能描述: 流程通知策略接口
  * 创建记录: 2012/04/24
  * 修改记录: 
  */
public interface IG238Info {

	/**
	 * 状态ID取得
	 *
	 * @return 状态ID
	 */
	public String getPsdid();
	
	/**
	 * 是否确认取得
	 *
	 * @return 是否确认
	 */
	public String getPsdconfirm();
	
	/**
	 * 状态名称取得
	 * 
	 * @return 状态名称
	 */
	public String getPsdname();
	
	/**
	 * 是否发送短信取得
	 *
	 * @return 是否发送短信
	 */
	public String getSms();

	/**
	 * 是否发送邮件取得
	 *
	 * @return 是否发送邮件
	 */
	public String getEmail();

	
	/**
	 * 通知人取得
	 * 
	 * @return 通知人
	 */
	public List<IG237TB> getLst_ProcessNoticeStrategyUser();
	
	/**
	 * 通知人ID取得
	 * 
	 * @return 通知人ID
	 */
	public String getNotifierids();

	/**
	 * 通知人名称取得
	 * 
	 * @return 通知人名称
	 */
	public String getNotifiernames();

}