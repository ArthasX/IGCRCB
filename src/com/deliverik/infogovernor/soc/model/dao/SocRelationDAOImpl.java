/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.model.SocRelation;
import com.deliverik.infogovernor.soc.model.condition.SocRelationSearchCond;
import com.deliverik.infogovernor.soc.model.entity.SocRelationTB;

/**
 * SOC关系DAO实现
 */
@SuppressWarnings("deprecation")
public class SocRelationDAOImpl extends BaseHibernateDAOImpl<SocRelation> implements SocRelationDAO {

	/**
	 * 构造函数
	 */
	public SocRelationDAOImpl(){
		super(SocRelationTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<SocRelation> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("srid"));
		List<SocRelation> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param rcid 主键
	 * @return 检索结果
	 */
	public SocRelation findByPK(Serializable srid) {

		SocRelation result = super.findByPK(srid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SocRelationSearchCond cond){
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
	public List<SocRelation> findByCond(final SocRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("srid"));
		List<SocRelation> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SocRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//资产编号
		if( !StringUtils.isEmpty(cond.getSreilabel())){
			c.add(Expression.eq("sreilabel",cond.getSreilabel()));
		}
		
		//版本号
		if( !StringUtils.isEmpty(cond.getSrkey1())){
			c.add(Expression.eq("srkey1",cond.getSrkey1()));
		}
		
		//关联资产coding
		if( !StringUtils.isEmpty(cond.getSresycoding())){
			c.add(Expression.eq("sresycoding",cond.getSresycoding()));
		}
		
		return c;
	}



}
