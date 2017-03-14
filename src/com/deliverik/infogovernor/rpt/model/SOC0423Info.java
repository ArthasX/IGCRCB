/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 容量对象表接口
  * 功能描述: 容量对象表接口
  * 创建记录: 2012/07/17
  * 修改记录: 2012/08/09 将CapacityObjectListInfo表名改为SOC0423Info
  */
public interface SOC0423Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();

	/**
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getName();

	/**
	 * 对象类型取得
	 *
	 * @return 对象类型
	 */
	public String getObjectType();

	/**
	 * 对象名称取得
	 *
	 * @return 对象名称
	 */
	public String getObjectName();
	/**
	 * 错误代码取得
	 *
	 * @return errorNum 错误代码
	 */
	public Integer getErrorNum();
	/**
	 * 告警代码取得
	 *
	 * @return warningNum 告警代码
	 */
	public Integer getWarningNum();
	/**
	 * 状态取得
	 *
	 * @return status 状态
	 */
	public Integer getStatus();

}