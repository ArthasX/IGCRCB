/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 监控类型表接口
  * 功能描述: 监控类型表接口
  * 创建记录: 2012/02/08
  * 修改记录: 
  */
public interface MonitorTypeInfo extends BaseModel {

	/**
	 * 主键id取得
	 *
	 * @return 主键id
	 */
	public Integer getMtId();

	/**
	 * 监控类型名称取得
	 *
	 * @return 监控类型名称
	 */
	public String getMtName();

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getMtCreateTime();

	/**
	 * 树形层次码取得
	 *
	 * @return 树形层次码
	 */
	public String getMtSyscoding();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getDeleteFlag();

}