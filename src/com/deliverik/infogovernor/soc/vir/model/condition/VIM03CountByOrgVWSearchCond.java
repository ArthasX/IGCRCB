/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model.condition;
/**
 * 概述:虚拟资源统计视图检索条件接口(按机构)
 * 功能描述:虚拟资源统计视图检索条件接口(按机构) 
 * 创建记录: 2014/02/19
 * 修改记录: 
 */
public interface VIM03CountByOrgVWSearchCond {

	/**
	 * 机构码取得
	 * @return orgsyscoding 机构码
	 */
	public String getOrgsyscoding_like();
	/**
	 * 获取到期时间
	 */
	public String getExpiryTime();
}
