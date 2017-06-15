/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.MonitorObjectDAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectTB;

/**
  * 概述: 监控对象信息业务逻辑实现
  * 功能描述: 监控对象信息业务逻辑实现
  * 创建记录: 2012/02/08
  * 修改记录: 
  */
public class MonitorObjectBLImpl extends BaseBLImpl implements
		MonitorObjectBL {

	/** 监控对象信息DAO接口 */
	protected MonitorObjectDAO monitorObjectDAO;
	
	/**
	 * 监控对象信息DAO接口设定
	 *
	 * @param monitorObjectDAO 监控对象信息DAO接口
	 */
	public void setMonitorObjectDAO(MonitorObjectDAO monitorObjectDAO) {
		this.monitorObjectDAO = monitorObjectDAO;
	}

	/**
	 * 监控对象信息实例取得
	 *
	 * @return 监控对象信息实例
	 */
	public MonitorObjectTB getMonitorObjectTBInstance() {
		return new MonitorObjectTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitorObjectInfo> searchMonitorObject() {
		return monitorObjectDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitorObjectInfo searchMonitorObjectByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(MonitorObjectSearchCond cond) {
		return monitorObjectDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<MonitorObjectInfo> searchMonitorObject(
			MonitorObjectSearchCond cond) {
		return monitorObjectDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return monitorObjectDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public MonitorObjectInfo registMonitorObject(MonitorObjectInfo instance)
		throws BLException {
		return monitorObjectDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public MonitorObjectInfo updateMonitorObject(MonitorObjectInfo instance)
		throws BLException {
		checkExistInstance(instance.getMoId());
		return monitorObjectDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMonitorObjectByPK(Integer pk)
		throws BLException {
		monitorObjectDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMonitorObject(MonitorObjectInfo instance)
		throws BLException {
		monitorObjectDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public MonitorObjectInfo checkExistInstance(Integer pk)
		throws BLException {
		MonitorObjectInfo instance = monitorObjectDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "");
		}
		return instance;
	}

}