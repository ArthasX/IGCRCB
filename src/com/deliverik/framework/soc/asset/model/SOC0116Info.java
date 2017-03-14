/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: EiWaitTaskTemp接口
  * 功能描述: EiWaitTaskTemp接口
  * 创建记录: 2012/07/30
  * 修改记录: 
  */
public interface SOC0116Info extends BaseModel {

	/**
	 * ewtId取得
	 *
	 * @return ewtId
	 */
	public Integer getEwtId();

	/**
	 * 文件名字取得
	 *
	 * @return 文件名字
	 */
	public String getFileName();

	/**
	 * batName取得
	 *
	 * @return userId
	 */
	public String getUserId();

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
	public String getEitId();

}