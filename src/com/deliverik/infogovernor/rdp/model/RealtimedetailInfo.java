/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 日志信息接口
  * 功能描述: 日志信息接口
  * 创建记录: 2014/05/06
  * 修改记录: 
  */
public interface RealtimedetailInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();

	/**
	 * 任务主键取得
	 *
	 * @return 任务主键
	 */
	public Integer getTaskid();

	/**
	 * 主机ip取得
	 *
	 * @return 主机ip
	 */
	public String getHostip();

	/**
	 * 内容取得
	 *
	 * @return 内容
	 */
	public String getContent();

}