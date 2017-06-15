/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0502Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0502SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0502TB;


public class SOC0502DAOImpl extends BaseHibernateDAOImpl<SOC0502Info>
		implements SOC0502DAO {

	/**
	 * 构造函数
	 */
	public SOC0502DAOImpl() {
		super(SOC0502TB.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<SOC0502Info> findByCond(final SOC0502SearchCond cond,
			final int start,final int count) {
		
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("regDate"));
		return super.findByCriteria(c, start, count);
		
	}


	public int getSearchCount(final SOC0502SearchCond cond) {

		DetachedCriteria c = this.getCriteria(cond);
		
		return super.getCount(c);
	}

	public void deleteByRids(Integer[] rids){
		String sql = "delete from soc0502 where rid in (:rids)";
		SQLQuery q = this.getSession().createSQLQuery(sql);
		//q.setParameter("rids", rids);
		q.setParameterList("rids", rids);
		q.executeUpdate();
	}

	protected DetachedCriteria getCriteria(SOC0502SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPid()!=null&&cond.getPid()>0){
			c.add(Expression.eq("pid", cond.getPid()));
		}
	
		
		return c;
	}
}