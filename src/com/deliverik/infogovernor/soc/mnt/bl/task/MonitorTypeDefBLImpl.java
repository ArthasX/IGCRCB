/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTypeDefSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.MonitorTypeDefDAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTypeDefTB;

/**
  * 概述: 监控类型阀值信息业务逻辑实现
  * 功能描述: 监控类型阀值信息业务逻辑实现
  * 创建记录: 2012/02/08
  * 修改记录: 
  */
public class MonitorTypeDefBLImpl extends BaseBLImpl implements
		MonitorTypeDefBL {

	/** 监控类型阀值信息DAO接口 */
	protected MonitorTypeDefDAO monitorTypeDefDAO;
	
	/**
	 * 监控类型阀值信息DAO接口设定
	 *
	 * @param monitorTypeDefDAO 监控类型阀值信息DAO接口
	 */
	public void setMonitorTypeDefDAO(MonitorTypeDefDAO monitorTypeDefDAO) {
		this.monitorTypeDefDAO = monitorTypeDefDAO;
	}

	/**
	 * 监控类型阀值信息实例取得
	 *
	 * @return 监控类型阀值信息实例
	 */
	public MonitorTypeDefTB getMonitorTypeDefTBInstance() {
		return new MonitorTypeDefTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitorTypeDefInfo> searchMonitorTypeDef() {
		return monitorTypeDefDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitorTypeDefInfo searchMonitorTypeDefByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(MonitorTypeDefSearchCond cond) {
		return monitorTypeDefDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<MonitorTypeDefInfo> searchMonitorTypeDef(
			MonitorTypeDefSearchCond cond) {
		return monitorTypeDefDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<MonitorTypeDefInfo> searchMonitorTypeDef(
			MonitorTypeDefSearchCond cond, int start,
			int count) {
		return monitorTypeDefDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public MonitorTypeDefInfo registMonitorTypeDef(MonitorTypeDefInfo instance)
		throws BLException {
		return monitorTypeDefDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public MonitorTypeDefInfo updateMonitorTypeDef(MonitorTypeDefInfo instance)
		throws BLException {
		checkExistInstance(instance.getMtdId());
		return monitorTypeDefDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMonitorTypeDefByPK(Integer pk)
		throws BLException {
		monitorTypeDefDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMonitorTypeDef(MonitorTypeDefInfo instance)
		throws BLException {
		monitorTypeDefDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public MonitorTypeDefInfo checkExistInstance(Integer pk)
		throws BLException {
		MonitorTypeDefInfo instance = monitorTypeDefDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}