/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM06VWInfo;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM06SearchCond;

/**
  * 概述: CRM06DAO接口
  * 功能描述: CRM06DAO接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM06DAO extends BaseHibernateDAO<CRM06Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CRM06Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CRM06Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CRM06SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CRM06Info> findByCond(
			final CRM06SearchCond cond, final int start,
			final int count);
	
	/**
	 * 视图条件检索处理
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<CRM06VWInfo> findVWByCond(final CRM06SearchCond cond, final int start, final int count);
	
	/**
	 * 视图条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchVWCount(final CRM06SearchCond cond);
	
	/**
	 * 视图条件检索结果取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<String> getSearchVWByInstance(final CRM06SearchCond cond);

}