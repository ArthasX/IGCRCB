/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.model.condition.MonitoringWorkSearchCond;
import com.deliverik.infogovernor.ven.model.entity.MonitoringWorkTB;

/**
  * 概述: 监测工作填报表业务逻辑接口
  * 功能描述: 监测工作填报表业务逻辑接口
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public interface MonitoringWorkBL extends BaseBL {

	/**
	 * 监测工作填报表实例取得
	 *
	 * @return 监测工作填报表实例
	 */
	public MonitoringWorkTB getMonitoringWorkTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitoringWorkInfo> searchMonitoringWork();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitoringWorkInfo searchMonitoringWorkByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(MonitoringWorkSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<MonitoringWorkInfo> searchMonitoringWork(
			MonitoringWorkSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<MonitoringWorkInfo> searchMonitoringWork(
			MonitoringWorkSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public MonitoringWorkInfo registMonitoringWork(MonitoringWorkInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public MonitoringWorkInfo updateMonitoringWork(MonitoringWorkInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMonitoringWorkByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMonitoringWork(MonitoringWorkInfo instance)
		throws BLException;

}