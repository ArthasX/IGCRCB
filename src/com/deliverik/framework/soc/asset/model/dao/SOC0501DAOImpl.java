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
import com.deliverik.framework.soc.asset.model.SOC0501Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0501SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0501TB;


public class SOC0501DAOImpl extends BaseHibernateDAOImpl<SOC0501Info>
		implements SOC0501DAO {

	/**
	 * 构造函数
	 */
	public SOC0501DAOImpl() {
		super(SOC0501TB.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<SOC0501Info> findByCond(final SOC0501SearchCond cond,
			final int start,final int count) {
		
		DetachedCriteria c = this.getCriteria(cond);
		c.addOrder(Order.desc("regDate"));
		return super.findByCriteria(c, start, count);
		
	}


	public int getSearchCount(final SOC0501SearchCond cond) {
		DetachedCriteria c = this.getCriteria(cond);
		
		return super.getCount(c);
	}


	
	
	protected DetachedCriteria getCriteria(SOC0501SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
//		if(cond.getPid()!=null&&cond.getPid()>0){
//			c.add(Expression.eq("pid", cond.getPid()));
//		}
		
		if(StringUtils.isNotEmpty(cond.getPwdType())){
			c.add(Expression.eq("pwdType", cond.getPwdType()));
		}
	
		if(StringUtils.isNotEmpty(cond.getServerIP())){
			c.add(Expression.eq("serverIP", cond.getServerIP()));
		}
		if(StringUtils.isNotEmpty(cond.getUserName())){
			c.add(Expression.eq("userName", cond.getUserName()));
			
		}
		
		
		return c;
	}
}