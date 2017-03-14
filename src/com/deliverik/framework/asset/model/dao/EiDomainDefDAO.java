/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDefSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * 概述: 资产域定义表DAO接口
  * 功能描述: 资产域定义表DAO接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface EiDomainDefDAO extends BaseHibernateDAO<EiDomainDefInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiDomainDefInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EiDomainDefInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EiDomainDefSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiDomainDefInfo> findByCond(
			final EiDomainDefSearchCond cond, final int start,
			final int count);
	/**
	 * 查询最大EiddId
	 * @return 
	 */
	public Integer findMaxEiddId();

	/**
	 * 获取资产域定义版本
	 * @param eiddid
	 * @param version
	 * @return
	 */
	public List<EiDomainDefInfo> searchEiDomainDefByPK(Integer eiddid,
			Integer version);

}