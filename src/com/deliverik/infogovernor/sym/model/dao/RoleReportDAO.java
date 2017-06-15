/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.RoleReport;
import com.deliverik.infogovernor.sym.model.condition.RoleReportSearchCond;

/**
 * 报表定义DAO接口
 */
public interface RoleReportDAO extends BaseHibernateDAO<RoleReport> {

	/**
	 * 查询已授权角色
	 * @return 检索结果集
	 */
	public List<RoleReport> findRoleid(final RoleReportSearchCond cond);
	
	/**
	 * 查询已授权报表
	 * @return 检索结果集
	 */
	public List<RoleReport> findRfdid(final RoleReportSearchCond cond);
	
}
