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
public class CurrentMonthWorkVWSearchCondImpl implements
		CurrentMonthWorkVWSearchCond {

	/** 当前月*/
	protected String month;
	
	/** 当前登录人角色*/
	protected String[] roleid;
	
	/**排序标识*/
	protected String order;
	
	protected String sing;

	/**
	 * 当前月取得
	 *
	 * @return 当前月
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 当前月设定
	 *
	 * @param month 当前月
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	public String[] getRoleid() {
		return roleid;
	}

	public void setRoleid(String[] roleid) {
		this.roleid = roleid;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSing() {
		return sing;
	}

	public void setSing(String sing) {
		this.sing = sing;
	}





	
	
	
}
