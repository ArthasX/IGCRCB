/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model.condition;


/**
 * 概述:虚拟资源统计视图检索条件(按机构)
 * 功能描述:虚拟资源统计视图检索条件(按机构) 
 * 创建记录: 2014/02/19
 * 修改记录: 
 */
public class VIM03CountByOrgVWSearchCondImpl implements
		VIM03CountByOrgVWSearchCond {

	/**机构码  */
	protected String orgsyscoding_like;
	/**到期时间*/
	protected String expiryTime;

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
	/**
	 * 获取到期时间
	 */
	public String getExpiryTime() {
		return expiryTime;
	}
	/**
	 * 到期时间设定
	 * @param expiryTime
	 */
	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}
	
}
