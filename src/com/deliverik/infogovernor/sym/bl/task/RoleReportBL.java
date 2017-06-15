/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.model.RoleReport;
import com.deliverik.infogovernor.sym.model.condition.RoleReportSearchCond;

/**
 * 
 * 报表授权业务逻辑接口
 *
 */
public interface RoleReportBL extends BaseBL{
	
	/**
	 * 已授权查询
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public List<RoleReport> searchRoleReportByRfdid(RoleReportSearchCond cond) throws BLException;
	
	/**
	 * 未报表授权
	 * 
	 * @param cond 授权条件
	 * @return 
	 */
	public void registRoleReport(RoleReport roleReport) throws BLException;
	
	/**
	 * 删除报表授权
	 * 
	 * @param cond 删除条件
	 * @return 
	 */
	public void revokeRoleReport(List<RoleReport> list) throws BLException;
	
	/**
	 * 按rfdid、roleid查询
	 * 
	 * @param cond 查询条件
	 * @return 
	 */
	public List<RoleReport> searchRoleReport(RoleReportSearchCond cond) throws BLException;
	
	/**
	 * 已授权查询
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public List<RoleReport> searchRoleReportByRoleid(RoleReportSearchCond cond) throws BLException;
}
