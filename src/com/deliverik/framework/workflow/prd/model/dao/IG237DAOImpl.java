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
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG237TB;

/**
  * 概述: 流程策略通知人DAO实现
  * 功能描述: 流程策略通知人DAO实现
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG237DAOImpl extends
		BaseHibernateDAOImpl<IG237Info> implements IG237DAO {

	/**
	 * 构造函数
	 */
	public IG237DAOImpl(){
		super(IG237TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG237Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG237Info findByPK(Serializable pk) {
		IG237Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG237SearchCond cond){
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
	public List<IG237Info> findByCond(final IG237SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG237SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPsdid())) {
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPsdconfirm())) {
			c.add(Expression.eq("psdconfirm", cond.getPsdconfirm()));
		}
		if(StringUtils.isNotEmpty(cond.getPsdid_like())) {
			c.add(Expression.like("psdid", cond.getPsdid_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getPivalue())) {
			c.add(Expression.eq("pivalue", cond.getPivalue()));
		}
		return c;
	}

}