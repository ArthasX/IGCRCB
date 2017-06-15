/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: vCenter ServiceInstance接口
  * 功能描述: vCenter ServiceInstance接口
  * 创建记录: 2014/02/12
  * 修改记录: 
  */
public interface VIM01Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getVcid();

	/**
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getVcname();

	/**
	 * URL取得
	 *
	 * @return URL
	 */
	public String getVcurl();

	/**
	 * 用户名取得
	 *
	 * @return 用户名
	 */
	public String getVcusername();

	/**
	 * 密码取得
	 *
	 * @return 密码
	 */
	public String getVcpassword();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getVcstatus();

}