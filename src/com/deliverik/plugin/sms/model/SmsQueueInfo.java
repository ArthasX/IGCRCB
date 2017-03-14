/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.plugin.sms.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 概述: 短信队列表接口 功能描述: 短信队列表接口 创建记录: 2012/10/31 修改记录:
 */
public interface SmsQueueInfo extends BaseModel {

	public Integer getQid();

	public String getAlertId();

	public String getTel();

	public String getUserId();

	public String getUserName();

	public String getSmsContext();

	public String getAlertTime();

}