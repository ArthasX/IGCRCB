package com.deliverik.framework.workflow.prr.model;

/**
 * 概述: 流程执行人信息接口
 * 功能描述: 流程执行人信息接口
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
public interface IG602Info {
	
	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid();
	
	/**
	 * 用户姓名取得
	 * @return 用户姓名
	 */
	public String getUsername();

	/**
	 * 用户角色ID取得
	 * @return 用户角色ID
	 */
	public Integer getRoleid();

	/**
	 * 用户角色名称取得
	 * @return 用户角色名称
	 */
	public String getRolename();
	
	/**
	 * 用户机构层次码取得
	 * @return 用户机构层次码
	 */
	public String getOrgsyscoding();

	/**
	 * 用户机构名称取得
	 * @return 用户机构名称
	 */
	public String getOrgname();

	/**
	 * 处理完成标识取得
	 * 
	 * @return 处理完成标识
	 */
	public String getDoneFlag();

	/**
	 * 用户手机号取得
	 * 
	 * @return 用户手机号
	 */
	public String getUsermobile();

	/**
	 * 用户工号取得
	 * 
	 * @return 用户工号
	 */
	public String getUserinfo();
	
}
