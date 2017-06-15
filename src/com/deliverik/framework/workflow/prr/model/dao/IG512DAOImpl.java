/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;

/**
 * 流程关系实体DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class IG512DAOImpl extends BaseHibernateDAOImpl<IG512Info> implements IG512DAO {

	/** Ig512 DAO */
	protected IG512DAO ig512DAO;
	/**
	 * 构造函数
	 */
	public IG512DAOImpl(){
		super(IG512TB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG512Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("prrid"));
		List<IG512Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param prrid 主键
	 * @return 检索结果
	 */
	public IG512Info findByPK(Serializable prrid) {

		IG512Info result = super.findByPK(prrid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG512SearchCond cond){
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
	public List<IG512Info> findByCond(final IG512SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("prrid"));
		List<IG512Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG512SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//主动流程ID
		if(cond.getParprid() != null && cond.getParprid() > 0){
			c.add(Expression.eq("parprid", cond.getParprid()));
		}
		//被动流程ID
		if(cond.getCldprid() != null && cond.getCldprid() > 0){
			c.add(Expression.eq("cldprid", cond.getCldprid()));
		}
		return c;
	}

}
