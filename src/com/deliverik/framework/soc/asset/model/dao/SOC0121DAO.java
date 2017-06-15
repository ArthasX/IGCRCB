/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0121Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;

/**
  * 概述: 快照关系表DAO接口
  * 功能描述: 快照关系表DAO接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SOC0121DAO extends BaseHibernateDAO<SOC0121Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0121Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0121Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0121SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0121Info> findByCond(
			final SOC0121SearchCond cond, final int start,
			final int count);

	/**
	 * 出图用拓扑关系
	 * @return
	 */
	public List<SOC0121Info> searchShowStorageIOSnapshotRelation();

}