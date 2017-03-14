/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 流程参与者信息
 */
public interface ParticipantInfo {
	
	/**
	 * 机构层次码取得
	 * @return 机构层次码
	 */
	public String getOrgid();

	/**
	 * 机构名称取得
	 * @return 机构名称
	 */
	public String getOrgname();

	/**
	 * 角色ID取得
	 * @return 角色ID
	 */
	public Integer getRoleid();

	/**
	 * 角色名称取得
	 * @return 角色名称
	 */
	public String getRolename();
	
	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid();

	/**
	 * 用户姓名取得
	 *
	 * @return 用户姓名
	 */
	public String getUsername();
	
	/**
	 * 手机号取得
	 * @return 手机号
	 */
	public String getPhone();
	
	/**
	 * 处理开始时间取得
	 * @return 处理开始时间
	 */
	public String getPpinittime();

	/**
	 * 处理结束时间取得
	 * @param ppopentime 处理结束时间 
	 */
	public String getPpproctime();
}
