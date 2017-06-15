/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.model.CR03Info;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;
import com.deliverik.infogovernor.soc.model.condition.CR03SearchCond;

/**
  * 概述: 配置原数据与主机关系表DAO接口
  * 功能描述: 配置原数据与主机关系表DAO接口
  * 创建记录: 2013/04/08
  * 修改记录: 
  */
public interface CR03DAO extends BaseHibernateDAO<CR03Info> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CR03Info> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CR03Info findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CR03SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CR03Info> findByCond(
			final CR03SearchCond cond, final int start,
			final int count);
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CR03Info> findByCondMax(
			final CR03SearchCond cond, final int start, 
			final int count);
	
	/**
	 * 条件检索处理[最大日期的导入和type]
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CR03VWInfo> findByCondMaxAndEsyscoding(final CR03SearchCond cond, final int start, final int count);
	
	/**
	 * 条件检索结果件数取得[最大日期的导入和type]
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCountByCondMaxAndEsyscoding(final CR03SearchCond cond);
	
	/**
	 * 获取配置采集的版本信息
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CR03VWInfo> getRciVersions(final CR03SearchCond cond, final int start, final int count);

}