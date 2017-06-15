/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.model.IgTest;
import com.deliverik.infogovernor.soc.model.condition.IgTestSearchCond;
import com.deliverik.infogovernor.soc.model.entity.IgTestTB;

/**
 * SOC关系DAO实现
 */
@SuppressWarnings("deprecation")
public class IgTestDAOImpl extends BaseHibernateDAOImpl<IgTest> implements IgTestDAO {

	/**
	 * 构造函数
	 */
	public IgTestDAOImpl(){
		super(IgTestTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IgTest> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("id"));
		List<IgTest> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param rcid 主键
	 * @return 检索结果
	 */
	public IgTest findByPK(Serializable id) {

		IgTest result = super.findByPK(id);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IgTestSearchCond cond){
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
	public List<IgTest> findByCond(final IgTestSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("id"));
		List<IgTest> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IgTestSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		return c;
	}



}
