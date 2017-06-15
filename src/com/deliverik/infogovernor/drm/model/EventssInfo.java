/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 事件级别表接口
  * 功能描述: 事件级别表接口
  * 创建记录: 2015/03/18
  * 修改记录: 
  */
public interface EventssInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getEventid();

	/**
	 * 事件名称取得
	 *
	 * @return 事件名称
	 */
	public String getEventname();

	/**
	 * 事件等级取得
	 *
	 * @return 事件等级
	 */
	public Integer getLabels();
	
	/**
	 * 事件描述取得
	 *
	 * @return 事件描述
	 */
	public String getEventdes();

}