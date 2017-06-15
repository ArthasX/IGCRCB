/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model.condition;

/**
 * 报表版本信息查询条件实现
 * 
 */
public class RoleReportSearchCondImpl implements RoleReportSearchCond {
	
	/** 报表编号 */
	protected Integer rfdid;
	/** 角色编号 */
	protected Integer roleid;
	
	/**
	 * 编号取得
	 * @return 编号
	 */
	public Integer getRfdid() {
		return rfdid;
	}
	
	/**
	 * 编号主键设定
	 * @param rfdid 编号
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	
}
