/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.EiBelongRelationInfo;
import com.deliverik.framework.asset.model.EiBelongRelationVWInfo;
import com.deliverik.framework.asset.model.condition.EiBelongRelationSearchCond;
import com.deliverik.framework.asset.model.condition.EiBelongRelationVWSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * 概述: 配置所属关系表DAO接口
  * 功能描述: 配置所属关系表DAO接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface EiBelongRelationDAO extends BaseHibernateDAO<EiBelongRelationInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiBelongRelationInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EiBelongRelationInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EiBelongRelationSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiBelongRelationInfo> findByCond(
			final EiBelongRelationSearchCond cond, final int start,
			final int count);
	
	/**
	 * 配置包含关系检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EiBelongRelationVWInfo> searchEiBelongRelationVW(final EiBelongRelationVWSearchCond cond);
	
	/**
	 * 配置包含关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EiBelongRelationInfo> searchMaxEiBelongRelation(final EiBelongRelationSearchCond cond);

}