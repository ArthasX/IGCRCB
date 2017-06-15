/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.Timer01Info;
import com.deliverik.framework.soc.asset.model.condition.Timer01SearchCond;
import com.deliverik.framework.soc.asset.model.entity.Timer01TB;

/**
  * 概述: timer01DAO实现
  * 功能描述: timer01DAO实现
  * 创建记录: 2013/07/04
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class Timer01DAOImpl extends
		BaseHibernateDAOImpl<Timer01Info> implements Timer01DAO {

	/**
	 * 构造函数
	 */
	public Timer01DAOImpl(){
		super(Timer01TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Timer01Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Timer01Info findByPK(Serializable pk) {
		Timer01Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Timer01SearchCond cond){
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
	public List<Timer01Info> findByCond(final Timer01SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(Timer01SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getTypeNames_Notin() != null && cond.getTypeNames_Notin().size() != 0){
			c.add(Expression.not(Expression.in("typename", cond.getTypeNames_Notin())));
		}
		if(cond.getTypeNames_In() != null && cond.getTypeNames_In().size() != 0){
			c.add(Expression.in("typename", cond.getTypeNames_In()));
		}
		if(cond.getResourceid_Notin() != null && cond.getResourceid_Notin().size() != 0){
			c.add(Expression.not(Expression.in("resourceid", cond.getResourceid_Notin())));
		}
		return c;
	}

}