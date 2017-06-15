/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.IG622Info;
import com.deliverik.framework.user.model.condition.IG622SearchCond;
import com.deliverik.framework.user.model.entity.IG622TB;

/**
  * 概述: 首页跳转URL定义DAO实现
  * 功能描述: 首页跳转URL定义DAO实现
  * 创建记录: 2012/07/18
  * 修改记录: 
  */
public class IG622DAOImpl extends
		BaseHibernateDAOImpl<IG622Info> implements IG622DAO {

	/**
	 * 构造函数
	 */
	public IG622DAOImpl(){
		super(IG622TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG622Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("hpid"));
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG622Info findByPK(Serializable pk) {
		IG622Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG622SearchCond cond){
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
	public List<IG622Info> findByCond(final IG622SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("hpid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG622SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}