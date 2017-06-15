/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.ScopesInfo;
import com.deliverik.infogovernor.drm.model.condition.ScopesSearchCond;
import com.deliverik.infogovernor.drm.model.entity.ScopesTB;

/**
  * 概述: 事件影响范围DAO实现
  * 功能描述: 事件影响范围DAO实现
  * 创建记录: 2015/03/20
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class ScopesDAOImpl extends
		BaseHibernateDAOImpl<ScopesInfo> implements ScopesDAO {

	/**
	 * 构造函数
	 */
	public ScopesDAOImpl(){
		super(ScopesTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ScopesInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ScopesInfo findByPK(Serializable pk) {
		ScopesInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ScopesSearchCond cond){
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
	public List<ScopesInfo> findByCond(final ScopesSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ScopesSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if(cond.getEventid()!=null&&cond.getEventid()!=0){
			c.add(Expression.eq("eventid", cond.getEventid()));
		}
		return c;
	}

}