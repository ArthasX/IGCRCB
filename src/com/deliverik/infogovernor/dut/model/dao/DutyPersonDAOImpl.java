/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dut.model.DutyPerson;
import com.deliverik.infogovernor.dut.model.condition.DutyPersonSearchCond;
import com.deliverik.infogovernor.dut.model.entity.DutyPersonTB;

/**
 * 值班检查管理DAO接口实现
 */
@SuppressWarnings("deprecation")
public class DutyPersonDAOImpl extends BaseHibernateDAOImpl<DutyPerson> implements DutyPersonDAO {

	/**
	 * 构造函数
	 */
	public DutyPersonDAOImpl(){
		super(DutyPersonTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<DutyPerson> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("dperid"));
		List<DutyPerson> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 主键检索处理
	 * @param dadid 主键
	 * @return 检索结果
	 */
	public DutyPerson findByPK(Serializable dpid) {
		DutyPerson result = super.findByPK(dpid);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DutyPersonSearchCond cond){
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
	public List<DutyPerson> findByCond(final DutyPersonSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("dperid"));
		List<DutyPerson> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(DutyPersonSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//值班计划ID
		if(cond.getDpid() != null && cond.getDpid() > 0) {
			c.add(Expression.eq("dpid", cond.getDpid()));
		}
		if(StringUtils.isNotEmpty(cond.getDpertime())){
			c.add(Expression.eq("dpertime", cond.getDpertime()));
		}
		if(StringUtils.isNotEmpty(cond.getDperuserid())){
			c.add(Expression.eq("dperuserid", cond.getDperuserid()));
		}
		if(StringUtils.isNotEmpty(cond.getDptype())){
			c.add(Expression.eq("dptype", cond.getDptype()));
		}
		
		if(null != cond.getDpidList() && cond.getDpidList().size() > 0){
			c.add(Expression.in("dpid", cond.getDpidList()));
		}	
		return c;
	}

}
