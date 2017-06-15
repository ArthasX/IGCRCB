/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: SOC0106接口
  * 功能描述: SOC0106接口
  * 创建记录: 2012/07/31
  * 修改记录: 
  */
public interface SOC0106Info extends BaseModel {

	/**
	 * awtId取得
	 *
	 * @return awtId
	 */
	public Integer getAwtId();

	/**
	 * 文件名字取得
	 *
	 * @return 文件名字
	 */
	public String getFileName();

	/**
	 * batName取得
	 *
	 * @return batName
	 */
	public String getBatName();

	/**
	 * 实体名字取得
	 *
	 * @return 实体名字
	 */
	public String getEiName();

	/**
	 * 实体Id取得
	 *
	 * @return 实体Id
	 */
	public String getAuwtId();

}