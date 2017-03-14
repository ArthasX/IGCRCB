/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorObjectDefSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.MonitorObjectDefDAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorObjectDefTB;

/**
  * 概述: 监控对象阀值信息表业务逻辑实现
  * 功能描述: 监控对象阀值信息表业务逻辑实现
  * 创建记录: 2012/02/08
  * 修改记录: 
  */
public class MonitorObjectDefBLImpl extends BaseBLImpl implements
		MonitorObjectDefBL {

	/** 监控对象阀值信息表DAO接口 */
	protected MonitorObjectDefDAO monitorObjectDefDAO;
	
	/**
	 * 监控对象阀值信息表DAO接口设定
	 *
	 * @param monitorObjectDefDAO 监控对象阀值信息表DAO接口
	 */
	public void setMonitorObjectDefDAO(MonitorObjectDefDAO monitorObjectDefDAO) {
		this.monitorObjectDefDAO = monitorObjectDefDAO;
	}

	/**
	 * 监控对象阀值信息表实例取得
	 *
	 * @return 监控对象阀值信息表实例
	 */
	public MonitorObjectDefTB getMonitorObjectDefTBInstance() {
		return new MonitorObjectDefTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitorObjectDefInfo> searchMonitorObjectDef() {
		return monitorObjectDefDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitorObjectDefInfo searchMonitorObjectDefByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(MonitorObjectDefSearchCond cond) {
		return monitorObjectDefDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<MonitorObjectDefInfo> searchMonitorObjectDef(
			MonitorObjectDefSearchCond cond) {
		return monitorObjectDefDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<MonitorObjectDefInfo> searchMonitorObjectDef(
			MonitorObjectDefSearchCond cond, int start,
			int count) {
		return monitorObjectDefDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public MonitorObjectDefInfo registMonitorObjectDef(MonitorObjectDefInfo instance)
		throws BLException {
		return monitorObjectDefDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public MonitorObjectDefInfo updateMonitorObjectDef(MonitorObjectDefInfo instance)
		throws BLException {
		checkExistInstance(instance.getModId());
		return monitorObjectDefDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMonitorObjectDefByPK(Integer pk)
		throws BLException {
		monitorObjectDefDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMonitorObjectDef(MonitorObjectDefInfo instance)
		throws BLException {
		monitorObjectDefDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public MonitorObjectDefInfo checkExistInstance(Integer pk)
		throws BLException {
		MonitorObjectDefInfo instance = monitorObjectDefDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}