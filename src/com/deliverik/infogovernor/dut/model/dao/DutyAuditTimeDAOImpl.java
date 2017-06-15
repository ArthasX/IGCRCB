/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditTimeSearchCond;
import com.deliverik.infogovernor.dut.model.entity.DutyAuditTimeTB;

/**
 * 值班检查项检查时间逻辑实现类
 *
 */
@SuppressWarnings("deprecation")
public class DutyAuditTimeDAOImpl  extends BaseHibernateDAOImpl<DutyAuditTime> implements DutyAuditTimeDAO{
    
	/**
	 * 构造函数
	 */
	public DutyAuditTimeDAOImpl(){
		super(DutyAuditTimeTB.class);
	}
	
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<DutyAuditTime> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("datid"));
		List<DutyAuditTime> ret = findByCriteria(c);

		return ret;
	}
	
	/**
	 * 主键检索处理
	 * @param acrid 主键
	 * @return 检索结果
	 */
	public DutyAuditTime findByPK(Serializable datid) {

		DutyAuditTime result = super.findByPK(datid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DutyAuditTimeSearchCond cond){
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
	public List<DutyAuditTime> findByCond(final DutyAuditTimeSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("datid"));
		List<DutyAuditTime> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(DutyAuditTimeSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getDadid()!=null && cond.getDadid()!=0){
			c.add(Expression.eq("dadid", cond.getDadid()));
		}
		return c;
	}
	

}
