/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 报表版本DAO实现
 */
@SuppressWarnings("deprecation")
public class RoleReportDAOImpl extends BaseHibernateDAOImpl<RoleReport> implements RoleReportDAO {
	/**
	 * 构造函数
	 */
	public RoleReportDAOImpl(){
		super(RoleReportTB.class);
	}

	 
	/**
	 * 条件检索处理
	 * @param rfdid 检索条件
	 * @return 检索结果列表
	 */
	public List<RoleReport> findRoleid(final RoleReportSearchCond cond) {
		
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rfdid"));
		List<RoleReport> ret = findByCriteria(c,0,0);
		return ret;
	}
	
	/**
	 * 条件检索处理
	 * @param roleid 检索条件
	 * @return 检索结果列表
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
