/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 场景响应策略接口
  * 功能描述: 场景响应策略接口
  * 创建记录: 2016/09/20
  * 修改记录: 
  */
public interface ResponseStrategyInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRsid();

	/**
	 * 场景id取得
	 *
	 * @return 场景id
	 */
	public Integer getSenceid();

	/**
	 * 策略描述取得
	 *
	 * @return 策略描述
	 */
	public String getStrategyDesc();

	/**
	 * 关键字取得
	 *
	 * @return 关键字
	 */
	public String getKeyword();

	/**
	 * 特殊处理类取得
	 *
	 * @return 特殊处理类
	 */
	public String getHandleBL();
	
	/**
	 * 特殊处理BL的参数
	 * @return
	 */
	public String getRsargs();

}