/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model.condition;


/**
 * 概述:虚拟资源统计视图检索条件
 * 功能描述:虚拟资源统计视图检索条件
 * 创建记录: 2014/02/19
 * 修改记录: 
 */
public class VIM03CountVWSearchCondImpl implements
		VIM03CountVWSearchCond {
	
	/**用户id */
	protected String userid;
	/**机构id */
	protected String orgsyscoding;
	/**到期日期 */
	protected String expirytime_greater;
	
	/**用户数量统计*/
	protected String countUser;
	/**部门数量统计*/
	protected String countOrg;
	/**项目数量统计*/
	protected String countProj;
	
	/**
	 * 用户id取得
	 * @return userid 用户id
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 机构id取得
	 * @return orgsyscoding 机构id
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}
	/**
	 * 到期日期取得
	 * @return expirytime_greater 到期日期
	 */
	public String getExpirytime_greater() {
		return expirytime_greater;
	}
	/**
	 * 用户id设定
	 * @param userid 用户id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 机构id设定
	 * @param orgsyscoding 机构id
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}
	/**
	 * 到期日期设定
	 * @param expirytime_greater 到期日期
	 */
	public void setExpirytime_greater(String expirytime_greater) {
		this.expirytime_greater = expirytime_greater;
	}
	/**
	 * 用户数量统计取得
	 * @return countUser 用户数量统计
	 */
	public String getCountUser() {
		return countUser;
	}
	/**
	 * 部门数量统计取得
	 * @return countOrg 部门数量统计
	 */
	public String getCountOrg() {
		return countOrg;
	}
	/**
	 * 项目数量统计取得
	 * @return countProj 项目数量统计
	 */
	public String getCountProj() {
		return countProj;
	}
	/**
	 * 用户数量统计设定
	 * @param countUser 用户数量统计
	 */
	public void setCountUser(String countUser) {
		this.countUser = countUser;
	}
	/**
	 * 部门数量统计设定
	 * @param countOrg 部门数量统计
	 */
	public void setCountOrg(String countOrg) {
		this.countOrg = countOrg;
	}
	/**
	 * 项目数量统计设定
	 * @param countProj 项目数量统计
	 */
	public void setCountProj(String countProj) {
		this.countProj = countProj;
	}
	
}
