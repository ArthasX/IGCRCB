/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0401Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0401SearchCond;

/**
  * 概述: 数据库容量实时表DAO接口
  * 功能描述: 数据库容量实时表DAO接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将DBCapacityRealTimeDAO表名改为SOC0401DAO
  */
public interface SOC0401DAO extends BaseHibernateDAO<SOC0401Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0401Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0401Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0401SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0401Info> findByCond(
			final SOC0401SearchCond cond, final int start,
			final int count);

}