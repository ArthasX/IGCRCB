/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 概述: 资产域定义表接口 功能描述: 资产域定义表接口 创建记录: 2011/04/20 修改记录:
 */
public interface SOC0111Info extends BaseModel {

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public Integer getEiddid();

	/**
	 * 名称取得
	 * 
	 * @return 名称
	 */
	public String getName();

	/**
	 * 版本号取得
	 * 
	 * @return 版本号
	 */
	public Integer getVersion();

	/**
	 * 描述取得
	 * 
	 * @return 描述
	 */
	public String getDescription();

	/**
	 * 创建时间取得
	 * 
	 * @return 创建时间
	 */
	public String getCreatetime();

	/**
	 * 更新时间取得
	 * 
	 * @return 更新时间
	 */
	public String getUpdatetime();
//	/**
//	 * 主键取得
//	 *
//	 * @return 主键
//	 */
//	public Serializable getPK();

}