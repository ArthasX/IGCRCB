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

import com.csebank.lom.model.AdvanCescost;
import com.csebank.lom.model.condition.AdvanCescostSearchCond;
import com.csebank.lom.model.entity.AdvanCescostTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 预支费用DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class AdvanCescostDAOImpl extends BaseHibernateDAOImpl<AdvanCescost> implements AdvanCescostDAO {

	/**
	 * 构造函数
	 */
	public AdvanCescostDAOImpl(){
		super(AdvanCescostTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<AdvanCescost> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("acid"));
		List<AdvanCescost> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param acid 主键
	 * @return 检索结果
	 */
	public AdvanCescost findByPK(Serializable acid) {

		AdvanCescost result = super.findByPK(acid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AdvanCescostSearchCond cond){
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
	public List<AdvanCescost> findByCond(final AdvanCescostSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("acid"));
		List<AdvanCescost> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(AdvanCescostSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//开始时间
		if(StringUtils.isNotEmpty(cond.getAcdate_from())){
			c.add(Expression.ge("acinsdate", cond.getAcdate_from()));
		}

		//结束时间
		if(StringUtils.isNotEmpty(cond.getAcdate_to())){
			c.add(Expression.le("acinsdate", cond.getAcdate_to()));
		}
		
		//状态
		if(StringUtils.isNotEmpty(cond.getAcstatus_q())){
			c.add(Expression.eq("acstatus", cond.getAcstatus_q()));
		}
		return c;
	}

}
