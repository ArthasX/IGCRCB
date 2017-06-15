/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model.condition;

/**
 * 报表授权查询条件接口
 * 
 */
public interface RoleReportSearchCond {
	
	/**
	 * 报表编号获取
	 * @return 
	 */
	public abstract Integer getRfdid();
	
	/**
	 * 角色编号获取
	 * @return 
	 */
	public abstract Integer getRoleid();
	
}
