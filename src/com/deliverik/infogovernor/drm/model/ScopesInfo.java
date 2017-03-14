/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 事件影响范围接口
  * 功能描述: 事件影响范围接口
  * 创建记录: 2015/03/20
  * 修改记录: 
  */
public interface ScopesInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getScopeid();

	/**
	 * 事件ID取得
	 *
	 * @return 事件ID
	 */
	public Integer getEventid();

	/**
	 * 影响范围取得
	 *
	 * @return 影响范围
	 */
	public String getImpscope();

	/**
	 * 业务中断取得
	 *
	 * @return 业务中断
	 */
	public String getImpbus();

	/**
	 * 中断时间取得
	 *
	 * @return 中断时间
	 */
	public String getImptime();

}