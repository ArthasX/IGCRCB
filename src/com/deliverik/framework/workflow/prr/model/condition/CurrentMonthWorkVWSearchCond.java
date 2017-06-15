/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 概述:查询带有处理人的本月工作 
 * 功能描述：查询带有处理人的本月工作
 * 创建人：赵梓廷
 * 创建记录： 2013-04-22
 * 修改记录：
 */
public interface CurrentMonthWorkVWSearchCond {

	/**
	 * 当前月取得
	 *
	 * @return 当前月
	 */
	public String getMonth();
	
	/**
	 * 当前登录人角色取得
	 *
	 * @return 当前登录人角色
	 */
	public String[] getRoleid();
	
	public String getOrder();
	
	public String getSing();
}
