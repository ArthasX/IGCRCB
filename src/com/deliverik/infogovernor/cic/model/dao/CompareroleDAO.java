/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareroleSearchCond;

/**
  * 概述: 对比规则DAO接口
  * 功能描述: 对比规则DAO接口
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public interface CompareroleDAO extends BaseHibernateDAO<CompareroleInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareroleInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareroleInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CompareroleSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CompareroleInfo> findByCond(
			final CompareroleSearchCond cond, final int start,
			final int count);

	/**
     * 根据关系表查询规则及对象
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<CompareroleInfo> searchCompareroleByRelation(final CompareroleSearchCond cond);
}