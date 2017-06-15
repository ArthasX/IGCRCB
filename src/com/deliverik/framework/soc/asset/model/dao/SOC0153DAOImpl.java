/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0153Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0153SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0153TB;


public class SOC0153DAOImpl extends BaseHibernateDAOImpl<SOC0153Info>
		implements SOC0153DAO {

	/**
	 * 构造函数
	 */
	public SOC0153DAOImpl() {
		super(SOC0153TB.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<SOC0153Info> findByCond(final SOC0153SearchCond cond,
			final int start,final int count) {
		
		DetachedCriteria c = this.getCriteria(cond);
		c.addOrder(Order.desc("logDate"));
		return super.findByCriteria(c, start, count);
		
	}


	public int getSearchCount(final SOC0153SearchCond cond) {
		DetachedCriteria c = this.getCriteria(cond);
		
		return super.getCount(c);
	}


	
	
	protected DetachedCriteria getCriteria(SOC0153SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getLogName())){
			c.add(Expression.like("logName", "%"+cond.getLogName()+"%"));
		}
		if(null!=cond.getCiType()&&cond.getCiType()>0){
			c.add(Expression.eq("ciType", cond.getCiType()));
		}
		if(StringUtils.isNotEmpty(cond.getLogStatus())){
			c.add(Expression.eq("logStatus", cond.getLogStatus()));
		}
		if(StringUtils.isNotEmpty(cond.getServerIP())){
			c.add(Expression.eq("serverIP", cond.getServerIP()));
		}
		if(StringUtils.isNotEmpty(cond.getWarnType())){
			c.add(Expression.eq("warnType", cond.getWarnType()));
		}
		if(StringUtils.isNotEmpty(cond.getsDate())){
			c.add(Expression.ge("logDate", cond.getsDate()));
		}
		if(StringUtils.isNotEmpty(cond.geteDate())){
			c.add(Expression.le("logDate", cond.geteDate() + " 23:59"));
		}
		
		
		return c;
	}
}