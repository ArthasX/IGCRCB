/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG711Info;
import com.deliverik.framework.workflow.prr.model.condition.IG711SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG711TB;

/**
 * <p>概述:授权管理DAO实现</p>
 * <p>功能描述：1.检索条件生成</p>
 * <p>          2.条件检索处理</p>
 * <p>          3.主键检索处理</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("deprecation")
public class IG711DAOImpl extends BaseHibernateDAOImpl<IG711Info> implements IG711DAO {

	/**
	 * 功能：构造函数
	 */
	public IG711DAOImpl(){
		super(IG711TB.class);
	}

	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG711SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//参与人员
		if(StringUtils.isNotEmpty(cond.getPabegintime_f())){
		c.add(Expression.ge("pabegintime", cond.getPabegintime_f()));
		}
		if(StringUtils.isNotEmpty(cond.getPabegintime_t())){
			c.add(Expression.le("pabegintime", cond.getPabegintime_t()));
		}
		
		if(StringUtils.isNotEmpty(cond.getPaflag())){
			c.add(Expression.eq("paflag", cond.getPaflag()));
		}
		if(StringUtils.isNotEmpty(cond.getPaiid())){
			c.add(Expression.eq("paiid", cond.getPaiid()));
		}
		if(StringUtils.isNotEmpty(cond.getPatype())){
			c.add(Expression.eq("patype", cond.getPatype()));
		}
		if(StringUtils.isNotEmpty(cond.getLoginUser())){
			c.add(Expression.eq("pauid", cond.getLoginUser()));
		}
		if(StringUtils.isNotEmpty(cond.getNopaflag())){
			c.add(Expression.ne("paflag", cond.getNopaflag()));
		}
		return c;
	}

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG711Info> findByCond(IG711SearchCond cond, int start,
			int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("paflag"));
		c.addOrder(Order.desc("pabegintime"));
		List<IG711Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 功能：主键检索处理
	 * @param pdaid 主键
	 * @return 检索结果
	 */
	public IG711Info findIG711InfoByPK(Integer paid) {
		IG711Info ret = findByPK(paid);
		return ret;
	}


}
