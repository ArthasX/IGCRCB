/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 短信日志信息表接口
  * 功能描述: 短信日志信息表接口
  * 创建记录: 2012/02/20
  * 修改记录: 
  */
public interface SmsMessageLogInfo extends BaseModel {

	/**
	 * 无意义主键取得
	 *
	 * @return 无意义主键
	 */
	public Integer getMid();

	/**
	 * 手机号码取得
	 *
	 * @return 手机号码
	 */
	public String getTelephone();

	/**
	 * 短信内容取得
	 *
	 * @return 短信内容
	 */
	public String getMessage();

	/**
	 * 业务系统名称取得
	 *
	 * @return 业务系统名称
	 */
	public String getPlatformInfo();

	/**
	 * 发送时间取得
	 *
	 * @return 发送时间
	 */
	public String getSendtime();

	/**
	 * 发送短信IP地址取得
	 *
	 * @return 发送短信IP地址
	 */
	public String getSendIP();

}