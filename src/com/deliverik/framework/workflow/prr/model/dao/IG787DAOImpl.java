/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG787Info;
import com.deliverik.framework.workflow.prr.model.condition.IG787SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG787VW;

/**
 * <p>概述:流程共通变量视图DAO实现</p>
 * <p>功能描述：1.条件检索处理</p>
 * <p>			 2.检索条件生成</p>
 * <p>			 3.条件检索结果件数取得</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("deprecation")
public class IG787DAOImpl extends BaseHibernateDAOImpl<IG787Info> implements IG787DAO {

	/**
	 * 功能：构造函数
	 */
	public IG787DAOImpl(){
		super(IG787VW.class);
	}
	
	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG787Info> findByCond(final IG787SearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("prid"));
		List<IG787Info> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG787SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();

		if(cond.getPrid()!=null && cond.getPrid()>0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		
		if(cond.getPidgid()!=null && cond.getPidgid()>0){
			c.add(Expression.eq("pidgid", cond.getPidgid()));
		}
		
		return c;
	}
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG787SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
}
