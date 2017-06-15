/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.condition.HWorkVWSearchCond;
import com.deliverik.framework.workflow.prd.model.entity.HWorkVW;

/**
 * 模块：历史工作统计-
 * 说明：历史工作统计DAO接口
 * 作者：zhaoyunli
 */
@SuppressWarnings("deprecation")
public class HWorkVWDAOImpl extends BaseHibernateDAOImpl<HWorkVW> implements HWorkVWDAO {

	/**
	 * 构造函数
	 */
	public HWorkVWDAOImpl(){
		super(HWorkVW.class);
	}
	
	public List<HWorkVW> findByCond(final HWorkVWSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		List<HWorkVW> ret = null;
		ret = findByCriteria(c);
		return ret;
	}
	
	protected DetachedCriteria getCriteria(HWorkVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if(cond.getPropentime()!=null) {
			c.add(Expression.like("propentime", cond.getPropentime()));
		}
		if(cond.getPruserid()!=null) {
			c.add(Expression.eq("pruserid", cond.getPruserid()));
		}
		return c;
	}

}
