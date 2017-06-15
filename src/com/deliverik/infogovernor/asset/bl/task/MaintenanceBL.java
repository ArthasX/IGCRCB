/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.model.MaintenanceInfo;
import com.deliverik.infogovernor.asset.model.condition.MaintenanceSearchCond;
import com.deliverik.infogovernor.asset.model.entity.MaintenanceTB;

/**
  * 概述: 风险指标维护业务逻辑接口
  * 功能描述: 风险指标维护业务逻辑接口
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
public interface MaintenanceBL extends BaseBL {

	/**
	 * 风险指标维护实例取得
	 *
	 * @return 风险指标维护实例
	 */
	public MaintenanceTB getMaintenanceTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MaintenanceInfo> searchMaintenance();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MaintenanceInfo searchMaintenanceByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(MaintenanceSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<MaintenanceInfo> searchMaintenance(
			MaintenanceSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<MaintenanceInfo> searchMaintenance(
			MaintenanceSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public MaintenanceInfo registMaintenance(MaintenanceInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public MaintenanceInfo updateMaintenance(MaintenanceInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMaintenanceByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMaintenance(MaintenanceInfo instance)
		throws BLException;

	
	public List<Integer> saveOrUpdateMaintenance(MaintenanceInfo instance);
	
	/**
	 * 条件检索处理 
	 * 根据sql查询
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Object> SearchBySQL(MaintenanceSearchCond cond);
	
}