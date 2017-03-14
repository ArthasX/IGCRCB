/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.user.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 首页跳转URL定义接口
  * 功能描述: 首页跳转URL定义接口
  * 创建记录: 2012/07/18
  * 修改记录: 
  */
public interface IG622Info extends BaseModel {

	/**
	 * 首页ID取得
	 *
	 * @return 首页ID
	 */
	public String getHpid();

	/**
	 * 首页描述取得
	 *
	 * @return 首页描述
	 */
	public String getHplabel();

	/**
	 * 首页URL取得
	 *
	 * @return 首页URL
	 */
	public String getHpurl();

	/**
	 * 首页显示名称取得
	 *
	 * @return 首页显示名称
	 */
	public String getHptitle();

}