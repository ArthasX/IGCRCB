/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.SOC0137Info;
import com.deliverik.framework.soc.asset.model.SOC0103Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0103SearchCond;

/**
  * 概述: 审计对比结果信息表DAO接口
  * 功能描述: 审计对比结果信息表DAO接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface SOC0103DAO extends BaseHibernateDAO<SOC0103Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0103Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0103Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0103SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0103Info> findByCond(
			final SOC0103SearchCond cond, final int start,
			final int count);

	/**
	 * 更新当前数据为不合理
	 *
	 * @param cond 检索条件
	 */
	public Integer updateSOC0103Without(SOC0103SearchCond cond)
		throws BLException;

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0137Info> findByCondOne(SOC0103SearchCond cond);
}