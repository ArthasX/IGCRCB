/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0111SearchCond;

/**
  * 概述: 资产域定义表DAO接口
  * 功能描述: 资产域定义表DAO接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SOC0111DAO extends BaseHibernateDAO<SOC0111Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0111Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0111Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0111SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0111Info> findByCond(
			final SOC0111SearchCond cond, final int start,
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
	public List<SOC0111Info> searchEiDomainDefByPK(Integer eiddid,
			Integer version);

}