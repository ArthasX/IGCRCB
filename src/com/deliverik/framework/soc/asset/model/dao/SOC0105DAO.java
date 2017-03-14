/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0105Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0105SearchCond;

/**
  * 概述: 审计待处理任务DAO接口
  * 功能描述: 审计待处理任务DAO接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface SOC0105DAO extends BaseHibernateDAO<SOC0105Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0105Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0105Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0105SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0105Info> findByCond(
			final SOC0105SearchCond cond, final int start,
			final int count);

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteAll();

}