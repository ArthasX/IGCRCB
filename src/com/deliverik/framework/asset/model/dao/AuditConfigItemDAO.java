/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.AuditConfigItemInfo;
import com.deliverik.framework.asset.model.condition.AuditConfigItemSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * 概述: 审计资产属性表DAO接口
  * 功能描述: 审计资产属性表DAO接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface AuditConfigItemDAO extends BaseHibernateDAO<AuditConfigItemInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AuditConfigItemInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AuditConfigItemInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AuditConfigItemSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AuditConfigItemInfo> findByCond(
			final AuditConfigItemSearchCond cond, final int start,
			final int count);

	/**
	 * 检索资产属性及属性对比分类
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AuditConfigItemInfo> searchAuditConfigItemForAucmptype(Integer eiid);

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteAuditConfigItem();

}