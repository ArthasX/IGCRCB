/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.Timer02Info;
import com.deliverik.framework.soc.asset.model.condition.Timer01SearchCond;
import com.deliverik.framework.soc.asset.model.condition.Timer02SearchCond;
import com.deliverik.framework.soc.asset.model.entity.Timer02TB;

/**
  * 概述: timer02DAO实现
  * 功能描述: timer02DAO实现
  * 创建记录: 2013/07/04
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class Timer02DAOImpl extends
		BaseHibernateDAOImpl<Timer02Info> implements Timer02DAO {

	/**
	 * 构造函数
	 */
	public Timer02DAOImpl(){
		super(Timer02TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Timer02Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Timer02Info findByPK(Serializable pk) {
		Timer02Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Timer02SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Timer02Info> findByCond(final Timer02SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("collectdate"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(Timer02SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getType())){
			c.add(Expression.eq("typename", cond.getType()));
		}
		if(StringUtils.isNotEmpty(cond.getCollectdate())){
			c.add(Expression.like("collectdate", "%"+cond.getCollectdate()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getExecutstatus())){
			c.add(Expression.eq("executstatus", cond.getExecutstatus()));
		}
		if(StringUtils.isNotEmpty(cond.getUuid())){
			c.add(Expression.eq("uuid", cond.getUuid()));
		}
		return c;
	}
	
}