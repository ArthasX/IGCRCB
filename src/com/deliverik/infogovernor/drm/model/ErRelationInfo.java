/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: ErRelation接口
  * 功能描述: ErRelation接口
  * 创建记录: 2016/06/14
  * 修改记录: 
  */
public interface ErRelationInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getErrid();

	/**
	 * 应急资源主键取得
	 *
	 * @return 应急资源主键
	 */
	public Integer getErid();

	/**
	 * 资源编码取得
	 *
	 * @return 资源编码
	 */
	public String getErcode();

	/**
	 * 资产id取得
	 *
	 * @return 资产id
	 */
	public String getEiid();

	/**
	 * 删除标志取得
	 *
	 * @return 删除标志
	 */
	public String getDeleteflag();

}