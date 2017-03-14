/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 授权查询接口
 */
public interface IG711SearchCond {
	
	/**
	 * 授权标识位取得
	 * @return 授权标识位
	 */
	public String getPaflag();
	
	/**
	 * 授权开始日期_从取得
	 * @return 授权开始日期_从
	 */
	public String getPabegintime_f();
	
	/**
	 * 授权开始日期_到取得
	 * @return 授权开始日期_到
	 */
	public String getPabegintime_t();
	
	/**
	 * 授权人取得
	 * @return 授权人
	 */
	public String getPaiid();
	/**
	 * 授权类型取得
	 * @return 授权类型
	 */
	public String getPatype();
	
	/**
	 * 登录用户的id取得
	 * @return 登录用户的id
	 */
	public String getLoginUser();
	
	/**
	 * 授权标识位取得
	 * @return 授权标识位
	 */
	public String getNopaflag();
	
}
