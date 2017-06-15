/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.ven.model.RiskStrategyInfo;
import com.deliverik.infogovernor.ven.model.condition.RiskStrategySearchCond;
import com.deliverik.infogovernor.ven.model.entity.RiskStrategyTB;

/**
  * 概述: 风险策略表DAO实现
  * 功能描述: 风险策略表DAO实现
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class RiskStrategyDAOImpl extends
		BaseHibernateDAOImpl<RiskStrategyInfo> implements RiskStrategyDAO {

	/**
	 * 构造函数
	 */
	public RiskStrategyDAOImpl(){
		super(RiskStrategyTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskStrategyInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskStrategyInfo findByPK(Serializable pk) {
		RiskStrategyInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskStrategySearchCond cond){
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
	public List<RiskStrategyInfo> findByCond(final RiskStrategySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("rsid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskStrategySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getRsname())){
			c.add(Restrictions.like("rsname","%"+cond.getRsname()+"%"));
		}
		return c;
	}

}