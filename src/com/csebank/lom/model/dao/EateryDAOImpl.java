/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.model.Eatery;
import com.csebank.lom.model.condition.EaterySearchCond;
import com.csebank.lom.model.entity.EateryTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 食堂成本管理DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class EateryDAOImpl extends BaseHibernateDAOImpl<Eatery> implements EateryDAO {

	/**
	 * 构造函数
	 */
	public EateryDAOImpl(){
		super(EateryTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Eatery> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("edate"));
		List<Eatery> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param eid 主键
	 * @return 检索结果
	 */
	public Eatery findByPK(Serializable eid) {

		Eatery result = super.findByPK(eid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EaterySearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Eatery> findByCond(final EaterySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("edate"));
		List<Eatery> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EaterySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
	
		//食堂成本信息开始时间
		if(StringUtils.isNotEmpty(cond.getEtime_from())){
			c.add(Expression.ge("edate", cond.getEtime_from()));
		}

		//食堂成本信息结束时间
		if(StringUtils.isNotEmpty(cond.getEtime_to())){
			c.add(Expression.le("edate", cond.getEtime_to()));
		}

		return c;
	}

}
