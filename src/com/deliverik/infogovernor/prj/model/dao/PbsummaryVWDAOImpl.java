/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;

import org.hibernate.criterion.Expression;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.prj.model.Pbsummary;
import com.deliverik.infogovernor.prj.model.condition.PbsummaryVWSearchCond;
import com.deliverik.infogovernor.prj.model.entity.PbsummaryVW;


/**
 * <p>概述:预算及工程分类信息视图DAO实现</p>
 * <p>功能描述：1.条件检索处理</p>
 * <p>创建记录：</p>
 */

@SuppressWarnings("deprecation")
public class PbsummaryVWDAOImpl extends BaseHibernateDAOImpl<Pbsummary> implements PbsummaryVWDAO{
	/**
	 * 预算及工程分类信息视图构造函数
	 * 
	 */
	public PbsummaryVWDAOImpl(){
		super(PbsummaryVW.class);
	}
	
	public List<Pbsummary> findByCond(final PbsummaryVWSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		List<Pbsummary> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	protected DetachedCriteria getCriteria(PbsummaryVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPid()!=null){
			c.add(Expression.eq("pid", cond.getPid()));
		}
		if(cond.getPbid()!=null){
			c.add(Expression.eq("pbid", cond.getPbid()));
		}
		if(cond.getBid()!=null){
			c.add(Expression.eq("bid", cond.getBid()));
		}
		if( !StringUtils.isEmpty(cond.getByear_begin())){
			c.add(Expression.ge("byear", cond.getByear_begin()));
		}
		if( !StringUtils.isEmpty(cond.getByear_end())){
			c.add(Expression.le("byear", cond.getByear_end()));
		}
		return c;
	}
}
