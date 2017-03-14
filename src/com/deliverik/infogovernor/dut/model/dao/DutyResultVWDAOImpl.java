/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;
import com.deliverik.infogovernor.dut.model.condition.DutyResultVWSearchCond;
import com.deliverik.infogovernor.dut.model.entity.DutyResultVW;

/**
 * 值班日报DAO实现
 */
@SuppressWarnings("deprecation")
public class DutyResultVWDAOImpl extends BaseHibernateDAOImpl<DutyResultVWInfo> implements DutyResultVWDAO {

	/**
	 * 构造函数
	 */
	public DutyResultVWDAOImpl(){
		super(DutyResultVW.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<DutyResultVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("dadtype"));
		c.addOrder(Order.asc("dattime"));
		c.addOrder(Order.asc("dadname"));
		List<DutyResultVWInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param rcid 主键
	 * @return 检索结果
	 */
	public DutyResultVWInfo findByPK(Serializable rcid) {

		DutyResultVWInfo result = super.findByPK(rcid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DutyResultVWSearchCond cond){
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
	public List<DutyResultVWInfo> findByCond(final DutyResultVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("dadtype"));
		c.addOrder(Order.asc("dattime"));
		c.addOrder(Order.asc("dadorderby"));
		//c.addOrder(Order.asc("dattime"));
		//c.addOrder(Order.asc("dadname"));
		List<DutyResultVWInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(DutyResultVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//值班检查项ID
		if(cond.getDadid() != null && cond.getDadid() > 0) {
			c.add(Expression.eq("dadid", cond.getDadid()));
		}
		
		//值班计划ID
		if(cond.getDpid() != null && cond.getDpid() > 0) {
			c.add(Expression.eq("dpid", cond.getDpid()));
		}
		
		//值班类型
		if(StringUtils.isNotEmpty(cond.getDadcategory())) {
			c.add(Expression.eq("dadcategory", cond.getDadcategory()));
		}
		
		//
		if(StringUtils.isNotEmpty(cond.getDattime_form()) && StringUtils.isEmpty(cond.getDattime_q())) {
			c.add(Expression.ge("dattime", cond.getDattime_form()));
		}
		
		if(StringUtils.isNotEmpty(cond.getDattime_to()) && StringUtils.isEmpty(cond.getDattime_q())) {
			c.add(Expression.lt("dattime", cond.getDattime_to()));
		}
		
		if(StringUtils.isNotEmpty(cond.getDattime_q())){
			if(StringUtils.isNotEmpty(cond.getDattime_form()) && StringUtils.isNotEmpty(cond.getDattime_to())) {
				StringBuffer buff = new StringBuffer();
				buff.append("(dattime>='");
				buff.append(cond.getDattime_form());
				buff.append("' and dattime<'23:59'");
				buff.append(" or ");
				buff.append("dattime>='00:00' and dattime< '");
				buff.append(cond.getDattime_to());
				buff.append("')");
				c.add(Expression.sql(buff.toString()));
			}
			
			
		}
		
		return c;
	}



}
