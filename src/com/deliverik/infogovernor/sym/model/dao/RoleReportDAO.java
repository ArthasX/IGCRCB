/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.RoleReport;
import com.deliverik.infogovernor.sym.model.condition.RoleReportSearchCond;

/**
 * ������DAO�ӿ�
 */
public interface RoleReportDAO extends BaseHibernateDAO<RoleReport> {

	/**
	 * ��ѯ����Ȩ��ɫ
	 * @return ���������
	 */
	public List<RoleReport> findRoleid(final RoleReportSearchCond cond);
	
	/**
	 * ��ѯ����Ȩ����
	 * @return ���������
	 */
	public List<RoleReport> findRfdid(final RoleReportSearchCond cond);
	
}
