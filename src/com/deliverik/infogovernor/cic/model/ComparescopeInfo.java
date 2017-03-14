/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 对比域接口
  * 功能描述: 对比域接口
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public interface ComparescopeInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCsid();

	/**
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getCsname();
	
	/**
	 * 创建时间取得
	 * @return 创建时间
	 */
	public String getCreatetime();

	/**
	 * 版本取得
	 * @return
	 */
	public Integer getCsversion();
}