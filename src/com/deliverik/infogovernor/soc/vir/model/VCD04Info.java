/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: vCloud部署日志接口
  * 功能描述: vCloud部署日志接口
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public interface VCD04Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();

	/**
	 * 项目主键取得
	 *
	 * @return 项目主键
	 */
	public Integer getPid();

	/**
	 * 虚机名称取得
	 *
	 * @return 虚机名称
	 */
	public String getVmName();

	/**
	 * 日志内容取得
	 *
	 * @return 日志内容
	 */
	public String getContent();

	/**
	 * 发生时间取得
	 *
	 * @return 发生时间
	 */
	public String getUpdateTime();

	/**
	 * 标志取得
	 *
	 * @return 标志
	 */
	public String getFlag();

}