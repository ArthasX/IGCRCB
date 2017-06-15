/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 场景响应策略检索条件接口
  * 功能描述: 场景响应策略检索条件接口
  * 创建记录: 2016/09/20
  * 修改记录: 
  */
public interface ResponseStrategySearchCond {
	/**
	 * 场景id
	 */
	public Integer getSenceid();

	/**
	 * 关键字匹配 in
	 * 
	 * @return
	 */
	public String[] getKeyword_in();

	/**
	 * 场景id集合
	 * 
	 * @return
	 */
	public Integer[] getSenceids();
}