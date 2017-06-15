/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 资产关系图文件信息
 *
 */
public interface IG809Info extends BaseModel{

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Integer getEirfid();
	
	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public Integer getEiid();
	
	/**
	 * 关系图类型取得
	 * @return 关系图类型
	 */
	public String getEirftype();
	
	/**
	 * 关系图文件名取得
	 * @return 关系图文件名
	 */
	public String getEirfname();
	
	/**
	 * 更新时间取得
	 * @return 更新时间
	 */
	public String getEirfupdtime();
	
}
