/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG941Info;
import com.deliverik.framework.workflow.prr.model.condition.IG941SearchCond;

/**
 * 服务工单日志DAO接口
 */
public interface IG941DAO extends BaseHibernateDAO<IG941Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG941Info> findAll();

	/**
	 * 主键检索处理
	 * @param sflid 主键
	 * @return 检索结果
	 */
	public IG941Info findByPK(Serializable sflid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG941SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG941Info> findByCond(final IG941SearchCond cond, final int start, final int count);
	
}
