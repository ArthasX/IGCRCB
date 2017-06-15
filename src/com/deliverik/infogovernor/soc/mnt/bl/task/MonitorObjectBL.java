/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectTB;

/**
  * 概述: 监控对象信息业务逻辑接口
  * 功能描述: 监控对象信息业务逻辑接口
  * 创建记录: 2012/02/08
  * 修改记录: 
  */
public interface MonitorObjectBL extends BaseBL {

	/**
	 * 监控对象信息实例取得
	 *
	 * @return 监控对象信息实例
	 */
	public MonitorObjectTB getMonitorObjectTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitorObjectInfo> searchMonitorObject();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitorObjectInfo searchMonitorObjectByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(MonitorObjectSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<MonitorObjectInfo> searchMonitorObject(
			MonitorObjectSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<MonitorObjectInfo> searchMonitorObject(
			MonitorObjectSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public MonitorObjectInfo registMonitorObject(MonitorObjectInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public MonitorObjectInfo updateMonitorObject(MonitorObjectInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMonitorObjectByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMonitorObject(MonitorObjectInfo instance)
		throws BLException;

}