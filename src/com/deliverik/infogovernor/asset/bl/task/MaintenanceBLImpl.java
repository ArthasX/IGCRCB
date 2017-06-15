/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.model.MaintenanceInfo;
import com.deliverik.infogovernor.asset.model.condition.MaintenanceSearchCond;
import com.deliverik.infogovernor.asset.model.condition.MaintenanceSearchCondImpl;
import com.deliverik.infogovernor.asset.model.dao.MaintenanceDAO;
import com.deliverik.infogovernor.asset.model.entity.MaintenanceTB;

/**
  * 概述: 风险指标维护业务逻辑实现
  * 功能描述: 风险指标维护业务逻辑实现
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
public class MaintenanceBLImpl extends BaseBLImpl implements
		MaintenanceBL {

	/** 风险指标维护DAO接口 */
	protected MaintenanceDAO maintenanceDAO;
	
	/**
	 * 风险指标维护DAO接口设定
	 *
	 * @param maintenanceDAO 风险指标维护DAO接口
	 */
	public void setMaintenanceDAO(MaintenanceDAO maintenanceDAO) {
		this.maintenanceDAO = maintenanceDAO;
	}

	/**
	 * 风险指标维护实例取得
	 *
	 * @return 风险指标维护实例
	 */
	public MaintenanceTB getMaintenanceTBInstance() {
		return new MaintenanceTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MaintenanceInfo> searchMaintenance() {
		return maintenanceDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MaintenanceInfo searchMaintenanceByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(MaintenanceSearchCond cond) {
		return maintenanceDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<MaintenanceInfo> searchMaintenance(
			MaintenanceSearchCond cond) {
		return maintenanceDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return maintenanceDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public MaintenanceInfo registMaintenance(MaintenanceInfo instance)
		throws BLException {
		return maintenanceDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public MaintenanceInfo updateMaintenance(MaintenanceInfo instance)
		throws BLException {
		
		return maintenanceDAO.update(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteMaintenanceByPK(Integer pk)
		throws BLException {
		maintenanceDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteMaintenance(MaintenanceInfo instance)
		throws BLException {
		maintenanceDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public MaintenanceInfo checkExistInstance(Integer pk)
		throws BLException {
		MaintenanceInfo instance = maintenanceDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	public List<Integer> saveOrUpdateMaintenance(MaintenanceInfo instance) {
		// TODO Auto-generated method stub

		return this.maintenanceDAO.saveOrUpdateMaintenance(instance);
	}
	
	/**
	 * 条件检索处理 
	 * 根据sql查询
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Object> SearchBySQL(MaintenanceSearchCond cond) {
		return maintenanceDAO.SearchBySQL(cond);
	}
}