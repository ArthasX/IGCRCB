/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.Priority;
import com.deliverik.infogovernor.sym.model.condition.PrioritySearchCond;
import com.deliverik.infogovernor.sym.model.entity.PriorityTB;

/**
 * 概述:优先级DAO实现类
 * 功能描述：1. 全件检索
 * 			2.条件检索结果件数取得
 * 			3.条件检索处理
 * 创建记录：fangyunlong@deliverik.com    2010/12/14
 */
@SuppressWarnings("deprecation")
public class PriorityDAOImpl extends BaseHibernateDAOImpl<Priority> implements PriorityDAO {

	/**
	 * 构造函数
	 */
	public PriorityDAOImpl(){
		super(PriorityTB.class);
	}
	
	/**
     * 全件检索
     * @return 检索结果集
     */
	public List<Priority> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		List<Priority> ret = findByCriteria(c);
		return ret;
	}

	 /**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
	public List<Priority> findByCond(final PrioritySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ivalue"));
		List<Priority> ret = findByCriteria(c, start, count);
		return ret;
	}
	 /**
     * 条件检索结果件数取得
     * @param cond 检索条件
     * @return 检索结果件数
     */
	public int getSearchCount(final PrioritySearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	
	protected DetachedCriteria getCriteria(PrioritySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if( !StringUtils.isEmpty(cond.getPvalue())){
			c.add(Expression.eq("pvalue", cond.getPvalue()));
		}
		if( !StringUtils.isEmpty(cond.getIvalue())){
			c.add(Expression.eq("ivalue", cond.getIvalue()));
		}
		if( !StringUtils.isEmpty(cond.getUvalue())){
			c.add(Expression.eq("uvalue", cond.getUvalue()));
		}
		if( !StringUtils.isEmpty(cond.getPprtype())){
			c.add(Expression.eq("pprtype", cond.getPprtype()));
		}
		
		return c;
	}

}
