/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.condition.IG715SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG715TB;

/**
 * 服务工单关联流程DAO实现
 */
@SuppressWarnings("deprecation")
public class IG715DAOImpl extends BaseHibernateDAOImpl<IG715Info> implements IG715DAO {

	/**
	 * 构造函数
	 */
	public IG715DAOImpl(){
		super(IG715TB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG715Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("sfid"));
		List<IG715Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param raid 主键
	 * @return 检索结果
	 */
	public IG715Info findByPK(Serializable sfid) {

		IG715Info result = super.findByPK(sfid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG715SearchCond cond){
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
	public List<IG715Info> findByCond(final IG715SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("sprrid"));
		List<IG715Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG715SearchCond cond){
		
		DetachedCriteria c = getDetachedCriteria();

		if(null != cond.getSprrid()){
			c.add(Expression.eq("sprrid", cond.getSprrid()));
		}
		if(null != cond.getSprrsfid()){
			c.add(Expression.eq("sprrsfid", cond.getSprrsfid()));
		}
		if(null != cond.getSprrprid()){
			c.add(Expression.eq("sprrprid", cond.getSprrprid()));
		}

		return c;
	}

	/**
	 * 获取服务工单关联流程实体
	 * @return 服务工单关联流程实体
	 */
	public IG715TB getIG715TBInstance() {

		return  new IG715TB();
		
	}

}
