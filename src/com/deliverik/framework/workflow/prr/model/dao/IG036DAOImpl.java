/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;

/**
 * <p>概述:日志信息DAO实现</p>
 * <p>功能描述：1.全件检索</p>
 * <p>         2.主键检索处理</p>
 * <p>          3.条件检索处理</p>
 * <p>          4.检索条件生成</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("deprecation")
public class IG036DAOImpl extends BaseHibernateDAOImpl<IG036Info> implements IG036DAO {
	

	/**
	 * 构造函数
	 */
	public IG036DAOImpl(){
		super(IG036TB.class);
	}

	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG036Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rlid"));
		List<IG036Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 功能：主键检索处理
	 * @param rlid 主键
	 * @return 检索结果
	 */
	public IG036Info findByPK(Serializable rlid) {

		IG036Info rl = super.findByPK(rlid);
		if(rl == null) return null;

		return rl;
	}

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG036Info> findByCond(final IG036SearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		if(WorkFlowConstDefine.RECORDLOG_ORDER_DESC.equals(cond.getRoleorder_type())){
			c.addOrder(Order.desc("rltime"));
		}else if(cond.isRoleorder()){
			c.addOrder(Order.asc("psname"));
			c.addOrder(Order.asc("roleid"));
			c.addOrder(Order.asc("rltime"));
		}else{
			
			c.addOrder(Order.asc("rlid"));
		}
		List<IG036Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG036SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//
		if( cond.getPrid() != null && cond.getPrid()!=0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		if( !StringUtils.isEmpty(cond.getRluserid())){
			c.add(Expression.eq("rluserid", cond.getRluserid()));
		}
		if( !StringUtils.isEmpty(cond.getRlusername())){
			c.add(Expression.eq("rlusername", cond.getRlusername()));
		}
		if( cond.getRoleid()!=null && cond.getRoleid().size()>0){
			c.add(Expression.in("roleid", cond.getRoleid()));
		}
		
		if( !StringUtils.isEmpty(cond.getNotEqualrlType())){
			c.add(Expression.ne("rltype", cond.getNotEqualrlType()));
		}
		
		if( !StringUtils.isEmpty(cond.getRlType())){
			c.add(Expression.eq("rltype", cond.getRlType()));
		}
		
		if( !StringUtils.isEmpty(cond.getPsdcode())){
			c.add(Expression.eq("psdcode", cond.getPsdcode()));
		}
		
		if( !StringUtils.isEmpty(cond.getRolemanger())){
			c.add(Expression.eq("rolemanger", cond.getRolemanger()));
		}
		
		if( !StringUtils.isEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		
		if( cond.getPsdnum()!=null && cond.getPsdnum()>0){
			c.add(Expression.eq("psdnum", cond.getPsdnum()));
		}
		
		return c;
	}
}
