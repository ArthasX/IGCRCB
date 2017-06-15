/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0208Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0208SearchCond;

/**
  * 概述: 事件变更服务效率DAO接口
  * 功能描述: 事件变更服务效率DAO接口
  * 创建记录: 2011/11/23
  * 修改记录: 2012/08/10 将ServeEfficiencyDAO表名修改为SOC0208DAO
  */
public interface SOC0208DAO extends BaseHibernateDAO<SOC0208Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0208Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0208Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0208SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0208Info> findByCond(
			final SOC0208SearchCond cond, final int start,
			final int count);

}