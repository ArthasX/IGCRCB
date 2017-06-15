/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
  * 概述: 审计资产表检索条件接口
  * 功能描述: 审计资产表检索条件接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface SOC0102SearchCond {
	
	/**
	 * 审计资产类型(1:新增, 2:修改) 取得
	 * 
	 * @return 审计资产类型
	 */
	public String getAucmptype();
	
	/**
	 * 顶级CI标识取得
	 * 
	 * @return 顶级CI标识
	 */
	public List<String> getTopCIList();
}