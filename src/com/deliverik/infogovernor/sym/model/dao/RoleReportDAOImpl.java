/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.RoleReport;
import com.deliverik.infogovernor.sym.model.condition.RoleReportSearchCond;
import com.deliverik.infogovernor.sym.model.entity.RoleReportTB;


/**
 * ����汾DAOʵ��
 */
@SuppressWarnings("deprecation")
public class RoleReportDAOImpl extends BaseHibernateDAOImpl<RoleReport> implements RoleReportDAO {
	/**
	 * ���캯��
	 */
	public RoleReportDAOImpl(){
		super(RoleReportTB.class);
	}

	 
	/**
	 * ������������
	 * @param rfdid ��������
	 * @return ��������б�
	 */
	public List<RoleReport> findRoleid(final RoleReportSearchCond cond) {
		
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rfdid"));
		List<RoleReport> ret = findByCriteria(c,0,0);
		return ret;
	}
	
	/**
	 * ������������
	 * @param roleid ��������
	 * @return ��������б�
	 */
	public List<RoleReport> findRfdid(final RoleReportSearchCond cond) {
		
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("roleid"));
		List<RoleReport> ret = findByCriteria(c,0,0);
		return ret;
	}
	
	protected DetachedCriteria getCriteria(RoleReportSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();

		if( null!=cond.getRfdid()){
			c.add(Expression.eq("rfdid", cond.getRfdid()));
		}
		if( null!=cond.getRoleid()){
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		
		return c;
	}


}
