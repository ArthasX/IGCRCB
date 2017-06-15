/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.model.SocRelation;
import com.deliverik.infogovernor.soc.model.condition.SocRelationSearchCond;

/**
 * SOC关系DAO接口
 */
public interface SocRelationDAO extends BaseHibernateDAO<SocRelation> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<SocRelation> findAll();

	/**
	 * 主键检索处理
	 * @param eid 主键
	 * @return 检索结果
	 */
	public SocRelation findByPK(Serializable rcid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SocRelationSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SocRelation> findByCond(final SocRelationSearchCond cond, final int start, final int count);
	
	
}
