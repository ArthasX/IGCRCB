/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ������Ȩҵ���߼��ӿ�
 *
 */
public interface RoleReportBL extends BaseBL{
	
	/**
	 * ����Ȩ��ѯ
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public List<RoleReport> searchRoleReportByRfdid(RoleReportSearchCond cond) throws BLException;
	
	/**
	 * δ������Ȩ
	 * 
	 * @param cond ��Ȩ����
	 * @return 
	 */
	public void registRoleReport(RoleReport roleReport) throws BLException;
	
	/**
	 * ɾ��������Ȩ
	 * 
	 * @param cond ɾ������
	 * @return 
	 */
	public void revokeRoleReport(List<RoleReport> list) throws BLException;
	
	/**
	 * ��rfdid��roleid��ѯ
	 * 
	 * @param cond ��ѯ����
	 * @return 
	 */
	public List<RoleReport> searchRoleReport(RoleReportSearchCond cond) throws BLException;
	
	/**
	 * ����Ȩ��ѯ
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public List<RoleReport> searchRoleReportByRoleid(RoleReportSearchCond cond) throws BLException;
}
