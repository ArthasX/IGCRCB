/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTypeSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.MonitorTypeDAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTypeTB;

/**
  * 概述: 监控类型表业务逻辑实现
  * 功能描述: 监控类型表业务逻辑实现
  * 创建记录: 2012/02/08
  * 修改记录: 
  */
public class MonitorTypeBLImpl extends BaseBLImpl implements
		MonitorTypeBL {

	/** 监控类型表DAO接口 */
	protected MonitorTypeDAO monitorTypeDAO;
	
	/**
	 * 监控类型表DAO接口设定
	 *
	 * @param monitorTypeDAO 监控类型表DAO接口
	 */
	public void setMonitorTypeDAO(MonitorTypeDAO monitorTypeDAO) {
		this.monitorTypeDAO = monitorTypeDAO;
	}

	/**
	 * 监控类型表实例取得
	 *
	 * @return 监控类型表实例
	 */
	public MonitorTypeTB getMonitorTypeTBInstance() {
		return new MonitorTypeTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitorTypeInfo> searchMonitorType() {
		return monitorTypeDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitorTypeInfo searchMonitorTypeByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(MonitorTypeSearchCond cond) {
		return monitorTypeDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<MonitorTypeInfo> searchMonitorType(
			MonitorTypeSearchCond cond) {
		return monitorTypeDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<MonitorTypeInfo> searchMonitorType(
			MonitorTypeSearchCond cond, int start,
			int count) {
		return monitorTypeDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public MonitorTypeInfo registMonitorType(MonitorTypeInfo instance)
		throws BLException {
		return monitorTypeDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public MonitorTypeInfo updateMonitorType(MonitorTypeInfo instance)
		throws BLException {
		checkExistInstance(instance.getMtId());
		return monitorTypeDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMonitorTypeByPK(Integer pk)
		throws BLException {
		monitorTypeDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMonitorType(MonitorTypeInfo instance)
		throws BLException {
		monitorTypeDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public MonitorTypeInfo checkExistInstance(Integer pk)
		throws BLException {
		MonitorTypeInfo instance = monitorTypeDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}