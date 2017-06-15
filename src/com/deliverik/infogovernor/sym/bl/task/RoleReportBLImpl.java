/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.RoleReport;
import com.deliverik.infogovernor.sym.model.condition.RoleReportSearchCond;
import com.deliverik.infogovernor.sym.model.dao.RoleReportDAO;

/**
 * 报表信息业务逻辑接口
 *
 */
public class RoleReportBLImpl extends BaseBLImpl implements RoleReportBL{
	
	RoleReportDAO roleReportDAO;
	
	

	public void setRoleReportDAO(RoleReportDAO roleReportDAO) {
		this.roleReportDAO = roleReportDAO;
	}



	public List<RoleReport> searchRoleReportByRfdid(RoleReportSearchCond cond)
			throws BLException {
		return roleReportDAO.findRoleid(cond);
	}



	public void registRoleReport(RoleReport roleReport)
			throws BLException {
		roleReportDAO.save(roleReport);
	}
	
	public void revokeRoleReport(List<RoleReport> list) 
			throws BLException{
		roleReportDAO.delete(list);
	}
	
	public List<RoleReport> searchRoleReport(RoleReportSearchCond cond) 
		throws BLException{
		return roleReportDAO.findRoleid(cond);
	}
	
	public List<RoleReport> searchRoleReportByRoleid(RoleReportSearchCond cond) 
		throws BLException{
		return roleReportDAO.findRfdid(cond);
	}
}
