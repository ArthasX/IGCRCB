/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTaskObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTaskObjectSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTaskObjectTB;

/**
  * 概述: 监控任务对象表业务逻辑接口
  * 功能描述: 监控任务对象表业务逻辑接口
  * 创建记录: 2012/05/10
  * 修改记录: 
  */
public interface MonitorTaskObjectBL extends BaseBL {

	/**
	 * 监控任务对象表实例取得
	 *
	 * @return 监控任务对象表实例
	 */
	public MonitorTaskObjectTB getMonitorTaskObjectTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitorTaskObjectInfo> searchMonitorTaskObject();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitorTaskObjectInfo searchMonitorTaskObjectByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(MonitorTaskObjectSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<MonitorTaskObjectInfo> searchMonitorTaskObject(
			MonitorTaskObjectSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<MonitorTaskObjectInfo> searchMonitorTaskObject(
			MonitorTaskObjectSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public MonitorTaskObjectInfo registMonitorTaskObject(MonitorTaskObjectInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public MonitorTaskObjectInfo updateMonitorTaskObject(MonitorTaskObjectInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMonitorTaskObjectByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMonitorTaskObject(MonitorTaskObjectInfo instance)
		throws BLException;

}