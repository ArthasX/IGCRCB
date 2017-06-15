/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model.condition;


/**
 * 概述:虚拟资源统计视图检索条件(按用户)
 * 功能描述:虚拟资源统计视图检索条件(按用户) 
 * 创建记录: 2014/02/19
 * 修改记录: 
 */
public class VIM03CountByUserVWSearchCondImpl implements
		VIM03CountByUserVWSearchCond {


	/**用户id */
	protected String userid_like;
	/**用户名  */
	protected String username_like;
	/**机构码  */
	protected String orgsyscoding_like;
	
	/**
	 * 用户id取得
	 * @return userid_like 用户id
	 */
	public String getUserid_like() {
		return userid_like;
	}
	/**
	 * 用户id设定
	 * @param userid_like 用户id
	 */
	public void setUserid_like(String userid_like) {
		this.userid_like = userid_like;
	}
	/**
	 * 用户名取得
	 * @return username_like 用户名
	 */
	public String getUsername_like() {
		return username_like;
	}
	/**
	 * 用户名设定
	 * @param username_like 用户名
	 */
	public void setUsername_like(String username_like) {
		this.username_like = username_like;
	}
	/**
	 * 机构码取得
	 * @return orgsyscoding_like 机构码
	 */
	public String getOrgsyscoding_like() {
		return orgsyscoding_like;
	}
	/**
	 * 机构码设定
	 * @param orgsyscoding_like 机构码
	 */
	public void setOrgsyscoding_like(String orgsyscoding_like) {
		this.orgsyscoding_like = orgsyscoding_like;
	}
	
}
