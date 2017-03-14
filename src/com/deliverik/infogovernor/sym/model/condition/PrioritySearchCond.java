/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.model.condition;
/**
 * 概述:优先级查询接口
 * 功能描述：1.影响度值取得
 * 			2.优先级值取得
 * 			3.紧急度值取得
 * 			4.流程类型取得
 * 创建记录：fangyunlong@deliverik.com    2010/12/14
 */
public interface PrioritySearchCond {
	
	/**
	 *影响度值取得
	 * 
	 * @return 影响度值
	 */
	public String getIvalue();

	/**
	 *优先级值取得
	 * 
	 * @return 优先级值
	 */
	public String getPvalue();

	/**
	 *紧急度值取得
	 * 
	 * @return 紧急度值
	 */
	public String getUvalue();
	
	/**
	 *流程类型取得
	 * 
	 * @return 流程类型
	 */
	public String getPprtype();

}
