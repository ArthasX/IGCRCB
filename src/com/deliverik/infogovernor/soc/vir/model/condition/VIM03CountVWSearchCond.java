/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model.condition;
/**
 * 概述:虚拟资源统计视图检索条件接口
 * 功能描述:虚拟资源统计视图检索条件接口
 * 创建记录: 2014/02/19
 * 修改记录: 
 */
public interface VIM03CountVWSearchCond {
	/**
	 * 用户id取得
	 * @return userid 用户id
	 */
	public String getUserid();
	/**
	 * 机构id取得
	 * @return orgsyscoding 机构id
	 */
	public String getOrgsyscoding();
	/**
	 * 到期日期取得
	 * @return expirytime_greater 到期日期
	 */
	public String getExpirytime_greater();
	/**
	 * 用户数量统计取得
	 * @return countUser 用户数量统计
	 */
	public String getCountUser();
	/**
	 * 部门数量统计取得
	 * @return countOrg 部门数量统计
	 */
	public String getCountOrg();
	/**
	 * 项目数量统计取得
	 * @return countProj 项目数量统计
	 */
	public String getCountProj();
}
