/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckWorkConutVWSearchCond;

/**
  * 概述: 检查工作统计报表DAO接口
  * 功能描述: 检查工作统计报表DAO接口
  * 创建记录: 2014/07/09
  * 修改记录: 
  */
public interface CheckWorkConutVWDAO extends BaseHibernateDAO<CheckWorkConutVWInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CheckWorkConutVWInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CheckWorkConutVWInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CheckWorkConutVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CheckWorkConutVWInfo> findByCond(
			final CheckWorkConutVWSearchCond cond, final int start,
			final int count);

}