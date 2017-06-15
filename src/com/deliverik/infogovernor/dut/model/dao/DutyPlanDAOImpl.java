/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCond;
import com.deliverik.infogovernor.dut.model.entity.DutyPersonTB;
import com.deliverik.infogovernor.dut.model.entity.DutyPlanTB;

/**
 * 值班检查管理DAO接口实现
 */
@SuppressWarnings("deprecation")
public class DutyPlanDAOImpl extends BaseHibernateDAOImpl<DutyPlan> implements DutyPlanDAO {

	/**
	 * 构造函数
	 */
	public DutyPlanDAOImpl(){
		super(DutyPlanTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<DutyPlan> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("dpid"));
		List<DutyPlan> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 主键检索处理
	 * @param dadid 主键
	 * @return 检索结果
	 */
	public DutyPlan findByPK(Serializable dpid) {
		DutyPlan result = super.findByPK(dpid);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DutyPlanSearchCond cond){
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
	public List<DutyPlan> findByCond(final DutyPlanSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(StringUtils.isNotEmpty(cond.getDptime_ge())) {
			c.addOrder(Order.asc("dptime"));
		} else {
			c.addOrder(Order.asc("dpid"));
		}
		List<DutyPlan> ret = findByCriteria(c, start, count);
		
		for(DutyPlan i : ret){
			lazyLoad(i);
		}

		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(DutyPlanSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//计划状态
		if(StringUtils.isNotEmpty(cond.getDpstatus())){
			c.add(Expression.eq("dpstatus", cond.getDpstatus()));
		}
		//值班类型
		if(StringUtils.isNotEmpty(cond.getDadcategory())){
			c.add(Expression.eq("dadcategory", cond.getDadcategory()));
		}
		//值班日期（大于等于匹配）
		if(StringUtils.isNotEmpty(cond.getDptime_ge())){
			c.add(Expression.ge("dptime", cond.getDptime_ge()));
		}
		//值班日期（小于等于匹配）
		if(StringUtils.isNotEmpty(cond.getDptime_le())){
			c.add(Expression.le("dptime", cond.getDptime_le()));
		}
		// 值班计划表主键
		if(null != cond.getDpid()){
			c.add(Expression.eq("dpid", cond.getDpid()));
		}
		if(StringUtils.isNotEmpty(cond.getDptime())){
			c.add(Expression.eq("dptime", cond.getDptime()));
		}
		if(StringUtils.isNotEmpty(cond.getDptype())){
			c.add(Expression.eq("dptype", cond.getDptype()));
		}
		return c;
	}

	protected void lazyLoad(DutyPlan info){

		if(info == null) 
			return;

		Hibernate.initialize(info.getDutyPersonList());
		
		for(DutyPersonTB i : info.getDutyPersonList())
			Hibernate.initialize(i);
		
	}

}
