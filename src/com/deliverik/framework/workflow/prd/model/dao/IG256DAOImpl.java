/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG256Info;
import com.deliverik.framework.workflow.prd.model.condition.IG256SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG256TB;

/**
  * 概述: 流程策略提醒DAO实现
  * 功能描述: 流程策略提醒DAO实现
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG256DAOImpl extends
		BaseHibernateDAOImpl<IG256Info> implements IG256DAO {

	/**
	 * 构造函数
	 */
	public IG256DAOImpl(){
		super(IG256TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG256Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG256Info findByPK(Serializable pk) {
		IG256Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG256SearchCond cond){
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
	public List<IG256Info> findByCond(final IG256SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG256SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid() != null && cond.getPrid() != 0) {
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		if(StringUtils.isNotEmpty(cond.getPrstatus())) {
			c.add(Expression.eq("prstatus", cond.getPrstatus()));
		}
		if(StringUtils.isNotEmpty(cond.getFlag())){
			c.add(Expression.eq("flag", cond.getFlag()));
		}
		if(cond.getFlag_in() != null && cond.getFlag_in().length != 0){
			c.add(Expression.in("flag", cond.getFlag_in()));
		}
		return c;
	}

}