/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTaskObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTaskObjectSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.MonitorTaskObjectDAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTaskObjectTB;

/**
  * 概述: 监控任务对象表业务逻辑实现
  * 功能描述: 监控任务对象表业务逻辑实现
  * 创建记录: 2012/05/10
  * 修改记录: 
  */
public class MonitorTaskObjectBLImpl extends BaseBLImpl implements
		MonitorTaskObjectBL {

	/** 监控任务对象表DAO接口 */
	protected MonitorTaskObjectDAO monitorTaskObjectDAO;
	
	/**
	 * 监控任务对象表DAO接口设定
	 *
	 * @param monitorTaskObjectDAO 监控任务对象表DAO接口
	 */
	public void setMonitorTaskObjectDAO(MonitorTaskObjectDAO monitorTaskObjectDAO) {
		this.monitorTaskObjectDAO = monitorTaskObjectDAO;
	}

	/**
	 * 监控任务对象表实例取得
	 *
	 * @return 监控任务对象表实例
	 */
	public MonitorTaskObjectTB getMonitorTaskObjectTBInstance() {
		return new MonitorTaskObjectTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitorTaskObjectInfo> searchMonitorTaskObject() {
		return monitorTaskObjectDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitorTaskObjectInfo searchMonitorTaskObjectByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(MonitorTaskObjectSearchCond cond) {
		return monitorTaskObjectDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<MonitorTaskObjectInfo> searchMonitorTaskObject(
			MonitorTaskObjectSearchCond cond) {
		return monitorTaskObjectDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return monitorTaskObjectDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public MonitorTaskObjectInfo registMonitorTaskObject(MonitorTaskObjectInfo instance)
		throws BLException {
		return monitorTaskObjectDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public MonitorTaskObjectInfo updateMonitorTaskObject(MonitorTaskObjectInfo instance)
		throws BLException {
		checkExistInstance(instance.getMtoId());
		return monitorTaskObjectDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMonitorTaskObjectByPK(Integer pk)
		throws BLException {
		monitorTaskObjectDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMonitorTaskObject(MonitorTaskObjectInfo instance)
		throws BLException {
		monitorTaskObjectDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public MonitorTaskObjectInfo checkExistInstance(Integer pk)
		throws BLException {
		MonitorTaskObjectInfo instance = monitorTaskObjectDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}