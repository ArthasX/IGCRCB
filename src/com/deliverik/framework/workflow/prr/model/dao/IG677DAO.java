/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;

/**
 * <p>概述:流程记录视图DAO接口</p>
 * <p>功能描述：1.全件检索</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.条件检索处理</p>
 * <p>          4.条件检索结果件数取得</p>
 * <p>创建记录：</p>
 */
public interface IG677DAO extends BaseHibernateDAO<IG677Info> {

	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG677Info> findAll();

	/**
	 * 功能：主键检索处理
	 * @param pdaid 主键
	 * @return 检索结果
	 */
	public IG677Info findByPK(Serializable processRecordVWPK);

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG677Info> findByCond(final IG677SearchCond cond, final int start, final int count);
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG677SearchCond cond);
}
