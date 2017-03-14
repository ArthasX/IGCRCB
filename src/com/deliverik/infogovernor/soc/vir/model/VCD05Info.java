/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: vCloud部署模板接口
  * 功能描述: vCloud部署模板接口
  * 创建记录: 2014/02/25
  * 修改记录: 
  */
public interface VCD05Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();

	/**
	 * 模板名称取得
	 *
	 * @return 模板名称
	 */
	public String getTemplateName();

	/**
	 * vCloudId取得
	 *
	 * @return vCloudId
	 */
	public Integer getVcloudid();

	/**
	 * vapp名称取得
	 *
	 * @return vapp名称
	 */
	public String getVappname();

}