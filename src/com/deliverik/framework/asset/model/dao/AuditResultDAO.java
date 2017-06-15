/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.AuditResultInfo;
import com.deliverik.framework.asset.model.condition.AuditResultSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * 概述: 审计对比结果信息表DAO接口
  * 功能描述: 审计对比结果信息表DAO接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface AuditResultDAO extends BaseHibernateDAO<AuditResultInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AuditResultInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AuditResultInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AuditResultSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AuditResultInfo> findByCond(
			final AuditResultSearchCond cond, final int start,
			final int count);

	/**
	 * 更新当前数据为不合理
	 *
	 * @param cond 检索条件
	 */
	public Integer updateAuditResultWithout(AuditResultSearchCond cond)
		throws BLException;

}