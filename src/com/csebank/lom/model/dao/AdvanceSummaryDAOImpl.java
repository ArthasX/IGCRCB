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

import com.csebank.lom.model.AdvanceSummary;
import com.csebank.lom.model.condition.AdvanceSummarySearchCond;
import com.csebank.lom.model.condition.AdvancesummaryCond;
import com.csebank.lom.model.entity.AdvanceSummaryTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 预支汇总DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class AdvanceSummaryDAOImpl extends BaseHibernateDAOImpl<AdvanceSummary> implements AdvanceSummaryDAO {

	/**
	 * 构造函数
	 */
	public AdvanceSummaryDAOImpl(){
		super(AdvanceSummaryTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<AdvanceSummary> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("asyear"));
		c.addOrder(Order.desc("asmonth"));
		List<AdvanceSummary> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param advanceSummaryTBPK 主键
	 * @return 检索结果
	 */
	public AdvanceSummary findByPK(Serializable advanceSummaryTBPK) {

		AdvanceSummary result = super.findByPK(advanceSummaryTBPK);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AdvanceSummarySearchCond cond){
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
	public List<AdvanceSummary> findByCond(final AdvanceSummarySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("asyear"));
		c.addOrder(Order.desc("asmonth"));
		List<AdvanceSummary> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(AdvanceSummarySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		return c;
	}

	public List<AdvanceSummary> findByCond(AdvancesummaryCond cond, int start,
			int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("asyear"));
		c.addOrder(Order.asc("asmonth"));
		List<AdvanceSummary> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**预支月度统计
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(AdvancesummaryCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//统计日期
	
		if( !StringUtils.isEmpty(cond.getYear()) ){
			c.add(Expression.sql("asyear = '"+ cond.getYear()+"'"));
		}
		
		return c;
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AdvancesummaryCond cond){
		DetachedCriteria c = getCriteria(cond);
		
		return getCount(c);
	}

}
