/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

import java.util.Set;

/**
 * 资产关系图文件信息DAO接口查询接口
 *
 */
public interface IG809SearchCond {

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
	 * 资产ID集合取得
	 * @return 资产ID集合
	 */
	public Set<Integer> getEiidList();
	
}
