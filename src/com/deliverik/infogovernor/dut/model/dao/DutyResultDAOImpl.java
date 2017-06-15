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
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCond;
import com.deliverik.infogovernor.dut.model.entity.DutyResultTB;

/**
 * 值班检查内容DAO实现
 */
@SuppressWarnings("deprecation")
public class DutyResultDAOImpl extends BaseHibernateDAOImpl<DutyResult> implements DutyResultDAO {

	/**
	 * 构造函数
	 */
	public DutyResultDAOImpl(){
		super(DutyResultTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<DutyResult> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("dadtype"));
		c.addOrder(Order.asc("dattime"));
		c.addOrder(Order.asc("dadname"));
		List<DutyResult> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param rcid 主键
	 * @return 检索结果
	 */
	public DutyResult findByPK(Serializable rcid) {

		DutyResult result = super.findByPK(rcid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DutyResultSearchCond cond){
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
	public List<DutyResult> findByCond(final DutyResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("dadtype"));
		c.addOrder(Order.asc("dattime"));
		c.addOrder(Order.asc("dadname"));
		List<DutyResult> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(DutyResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//值班计划ID
		if(cond.getDpid() != null && cond.getDpid() > 0) {
			c.add(Expression.eq("dpid", cond.getDpid()));
		}
		//值班检查项ID
		if(cond.getDadid() != null && cond.getDadid() > 0) {
			c.add(Expression.eq("dadid", cond.getDadid()));
		}
		
		//值班日期
		if(StringUtils.isNotEmpty(cond.getDptime())) {
			c.add(Expression.eq("dptime", cond.getDptime()));
		}
		
		//检查名称
		if(StringUtils.isNotEmpty(cond.getDadname())){
			c.add(Expression.like("dadname", "%"+cond.getDadname()+"%"));
		}
		
		//时间段
		if( !StringUtils.isEmpty(cond.getDclosetime())){
			c.add(Expression.le("dptime", cond.getDclosetime()));
		}
		if( !StringUtils.isEmpty(cond.getDopentime())){
			c.add(Expression.ge("dptime", cond.getDopentime()));
		}
		//值班日期（大于等于匹配）
		if(StringUtils.isNotEmpty(cond.getDptime_ge())){
			c.add(Expression.ge("dptime", cond.getDptime_ge()));
		}
		//值班日期（小于等于匹配）
		if(StringUtils.isNotEmpty(cond.getDptime_le())){
			c.add(Expression.le("dptime", cond.getDptime_le()));
		}
		//值班类型
		if(StringUtils.isNotEmpty(cond.getDadcategory())){
			c.add(Expression.eq("dadcategory", cond.getDadcategory()));
		}
		//检查结果（空匹配）
		if(StringUtils.isNotEmpty(cond.getIsNullDrcontent())){
			c.add(Expression.or(Expression.eq("drcontent",""), Expression.isNull("drcontent")));
		}
		if(StringUtils.isNotEmpty(cond.getDattime())){
			c.add(Expression.eq("dattime", cond.getDattime()));
		}
		return c;
	}



}
