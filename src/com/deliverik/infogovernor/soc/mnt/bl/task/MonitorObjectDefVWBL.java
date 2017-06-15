/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefVWInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectDefVWSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectDefVW;

/**
  * 概述: 监控对象KPI信息视图业务逻辑接口
  * 功能描述: 监控对象KPI信息视图业务逻辑接口
  * 创建记录: 2012/02/13
  * 修改记录: 
  */
public interface MonitorObjectDefVWBL extends BaseBL {

	/**
	 * 监控对象KPI信息视图实例取得
	 *
	 * @return 监控对象KPI信息视图实例
	 */
	public MonitorObjectDefVW getMonitorObjectDefVWTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitorObjectDefVWInfo> searchMonitorObjectDefVW();


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(MonitorObjectDefVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<MonitorObjectDefVWInfo> searchMonitorObjectDefVW(
			MonitorObjectDefVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<MonitorObjectDefVWInfo> searchMonitorObjectDefVW(
			MonitorObjectDefVWSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public MonitorObjectDefVWInfo registMonitorObjectDefVW(MonitorObjectDefVWInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public MonitorObjectDefVWInfo updateMonitorObjectDefVW(MonitorObjectDefVWInfo instance)
		throws BLException;


	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMonitorObjectDefVW(MonitorObjectDefVWInfo instance)
		throws BLException;

}