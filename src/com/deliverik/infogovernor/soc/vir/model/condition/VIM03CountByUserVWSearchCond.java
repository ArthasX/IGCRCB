/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model.condition;
/**
 * 概述:虚拟资源统计视图检索条件接口(按用户)
 * 功能描述:虚拟资源统计视图检索条件接口(按用户) 
 * 创建记录: 2014/02/19
 * 修改记录: 
 */
public interface VIM03CountByUserVWSearchCond {

	/**
	 * 用户id取得
	 * @return userid_like 用户id
	 */
	public String getUserid_like();
	/**
	 * 用户名取得
	 * @return username 用户名
	 */
	public String getUsername_like();
	/**
	 * 机构码取得
	 * @return orgsyscoding 机构码
	 */
	public String getOrgsyscoding_like();
}
