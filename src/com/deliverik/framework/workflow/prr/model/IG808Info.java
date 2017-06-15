/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model;

/**
 * <p>概述:首页上按部门统计工作数量视图接口</p>
 * <p>功能描述：</p>
 * <p>创建记录：宋海洋 2010/11/13</p>
 */
public interface IG808Info {
	
	/**
	 * 功能：机构名取得
	 * @return orgname 用户ID
	 */
	public abstract String getOrgname();

	/**
	 * 功能：工作数量取得
	 * @return workCount 工作数量
	 */
	public abstract String getWorkCount();
}