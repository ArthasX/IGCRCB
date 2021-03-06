/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.model.MaintenanceInfo;
import com.deliverik.infogovernor.asset.model.condition.MaintenanceSearchCond;

/**
  * 概述: 风险指标维护DAO接口
  * 功能描述: 风险指标维护DAO接口
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
public interface MaintenanceDAO extends BaseHibernateDAO<MaintenanceInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MaintenanceInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MaintenanceInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final MaintenanceSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<MaintenanceInfo> findByCond(
			final MaintenanceSearchCond cond, final int start,
			final int count);


	public List<Integer> saveOrUpdateMaintenance(final MaintenanceInfo instance);

	/**
	 *  更新
	 * @param instance
	 * @return
	 */
	public MaintenanceInfo update(MaintenanceInfo instance);
	
	/**
	 * 条件检索处理
	 * 根据sql查询
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Object> SearchBySQL(final MaintenanceSearchCond cond);
}