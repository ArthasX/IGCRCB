/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 自定义流程配置表接口
  * 功能描述: 自定义流程配置表接口
  * 创建记录: 2012/11/05
  * 修改记录: 
  */
public interface CustomConfigurationInfo extends BaseModel {

	/**
	 * 报表ID取得
	 *
	 * @return 报表ID
	 */
	public Integer getRfdid();

	/**
	 * 报表定义ID取得
	 *
	 * @return 报表定义ID
	 */
	public String getPdid();

	/**
	 * 统计的状态取得
	 *
	 * @return 统计的状态
	 */
	public String getPrstatusInfo();

	/**
	 * 表单ID取得
	 *
	 * @return 表单ID
	 */
	public String getPidid();

	/**
	 * 表单值取得
	 *
	 * @return 表单值
	 */
	public String getPidvalue();

	/**
	 * 登记人ID取得
	 *
	 * @return 登记人ID
	 */
	public String getUserid();
	
	
	public String getCreateTime();
	
	public String getUpdateTime();

}