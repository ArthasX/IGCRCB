/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG019SearchCond;

/**
 * <p>概述:事件和服务请求流程汇总视图DAO接口</p>
 * <p>功能描述：1.事件条件检索处理</p>
 * <p>         2.服务请求条件检索处理</p>
 * <p>          3.事件条件检索结果件数取得</p>
 * <p>          4.服务条件检索结果件数取得</p>
 * <p>创建记录：</p>
 */
public interface IG144DAO extends
		BaseHibernateDAO<IG500Info> {

	/**
	 * 功能：事件条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> findIncidentByCond(
			final IG019SearchCond cond, final int start,
			final int count);
	
	/**
	 * 功能：服务请求条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> findServiceRequestByCond(
			final IG019SearchCond cond, final int start,
			final int count);
	
	/**
	 * 功能：事件条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getIncidentSearchCount(final IG019SearchCond cond);
	
	/**
	 * 功能：服务条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getServiceRequestSearchCount(final IG019SearchCond cond);

}
