/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.com.model.condition;

/**
 * 
 * 处理中的工作查询接口实现
 *
 */
public class ProcessInHandVWInfoSearchCondImpl implements ProcessInHandVWInfoSearchCond {
	/**
	 * 处理人id		
	 */
	private String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}