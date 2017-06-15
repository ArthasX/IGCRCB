/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.ven.model.RiskMonitoringInfo;
import com.deliverik.infogovernor.ven.model.condition.RiskMonitoringSearchCond;
import com.deliverik.infogovernor.ven.model.dao.RiskMonitoringDAO;
import com.deliverik.infogovernor.ven.model.entity.RiskMonitoringTB;

/**
  * 概述: 风险监测表业务逻辑实现
  * 功能描述: 风险监测表业务逻辑实现
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public class RiskMonitoringBLImpl extends BaseBLImpl implements
		RiskMonitoringBL {

	/** 风险监测表DAO接口 */
	protected RiskMonitoringDAO riskMonitoringDAO;
	
	/**
	 * 风险监测表DAO接口设定
	 *
	 * @param riskMonitoringDAO 风险监测表DAO接口
	 */
	public void setRiskMonitoringDAO(RiskMonitoringDAO riskMonitoringDAO) {
		this.riskMonitoringDAO = riskMonitoringDAO;
	}

	/**
	 * 风险监测表实例取得
	 *
	 * @return 风险监测表实例
	 */
	public RiskMonitoringTB getRiskMonitoringTBInstance() {
		return new RiskMonitoringTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskMonitoringInfo> searchRiskMonitoring() {
		return riskMonitoringDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskMonitoringInfo searchRiskMonitoringByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskMonitoringSearchCond cond) {
		return riskMonitoringDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskMonitoringInfo> searchRiskMonitoring(
			RiskMonitoringSearchCond cond) {
		return riskMonitoringDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskMonitoringInfo> searchRiskMonitoring(
			RiskMonitoringSearchCond cond, int start,
			int count) {
		return riskMonitoringDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RiskMonitoringInfo registRiskMonitoring(RiskMonitoringInfo instance)
		throws BLException {
		return riskMonitoringDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RiskMonitoringInfo updateRiskMonitoring(RiskMonitoringInfo instance)
		throws BLException {
		checkExistInstance(instance.getRmid());
		return riskMonitoringDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRiskMonitoringByPK(Integer pk)
		throws BLException {
		riskMonitoringDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRiskMonitoring(RiskMonitoringInfo instance)
		throws BLException {
		riskMonitoringDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RiskMonitoringInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskMonitoringInfo instance = riskMonitoringDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}