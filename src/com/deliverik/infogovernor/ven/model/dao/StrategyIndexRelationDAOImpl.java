/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.ven.model.StrategyIndexRelationInfo;
import com.deliverik.infogovernor.ven.model.condition.StrategyIndexRelationSearchCond;
import com.deliverik.infogovernor.ven.model.entity.StrategyIndexRelationTB;

/**
  * 概述: 风险策略指标关系表DAO实现
  * 功能描述: 风险策略指标关系表DAO实现
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class StrategyIndexRelationDAOImpl extends
		BaseHibernateDAOImpl<StrategyIndexRelationInfo> implements StrategyIndexRelationDAO {

	/**
	 * 构造函数
	 */
	public StrategyIndexRelationDAOImpl(){
		super(StrategyIndexRelationTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
    public List<StrategyIndexRelationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	@Override
    public StrategyIndexRelationInfo findByPK(Serializable pk) {
		StrategyIndexRelationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final StrategyIndexRelationSearchCond cond){
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
	public List<StrategyIndexRelationInfo> findByCond(final StrategyIndexRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(StrategyIndexRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//策略表主键
		if(cond.getRsid()!=null&&cond.getRsid()!=0){
		    c.add(Expression.eq("rsid", Integer.valueOf(cond.getRsid())));
		}
		return c;
	}

}