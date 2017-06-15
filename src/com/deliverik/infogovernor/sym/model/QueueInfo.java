/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 短信队列表接口
  * 功能描述: 短信队列表接口
  * 创建记录: 2012/11/13
  * 修改记录: 
  */
public interface QueueInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getQid();

	/**
	 * 告警ID取得
	 *
	 * @return 告警ID
	 */
	public String getAlertid();

	/**
	 * 告警内容取得
	 *
	 * @return 告警内容
	 */
	public String getSmscontext();

	/**
	 * 告警时间取得
	 *
	 * @return 告警时间
	 */
	public String getAlerttime();

	/**
	 * 手机号取得
	 *
	 * @return 手机号
	 */
	public String getTel();

	/**
	 * 用户姓名取得
	 *
	 * @return 用户姓名
	 */
	public String getUserName();

	/**
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getUserid();

}