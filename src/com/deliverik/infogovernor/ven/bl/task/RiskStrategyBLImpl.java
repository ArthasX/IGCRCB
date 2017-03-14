/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.ven.model.RiskStrategyInfo;
import com.deliverik.infogovernor.ven.model.condition.RiskStrategySearchCond;
import com.deliverik.infogovernor.ven.model.dao.RiskStrategyDAO;
import com.deliverik.infogovernor.ven.model.entity.RiskStrategyTB;

/**
  * 概述: 风险策略表业务逻辑实现
  * 功能描述: 风险策略表业务逻辑实现
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public class RiskStrategyBLImpl extends BaseBLImpl implements
		RiskStrategyBL {

	/** 风险策略表DAO接口 */
	protected RiskStrategyDAO riskStrategyDAO;
	
	/**
	 * 风险策略表DAO接口设定
	 *
	 * @param riskStrategyDAO 风险策略表DAO接口
	 */
	public void setRiskStrategyDAO(RiskStrategyDAO riskStrategyDAO) {
		this.riskStrategyDAO = riskStrategyDAO;
	}

	/**
	 * 风险策略表实例取得
	 *
	 * @return 风险策略表实例
	 */
	public RiskStrategyTB getRiskStrategyTBInstance() {
		return new RiskStrategyTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskStrategyInfo> searchRiskStrategy() {
		return riskStrategyDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskStrategyInfo searchRiskStrategyByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskStrategySearchCond cond) {
		return riskStrategyDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskStrategyInfo> searchRiskStrategy(
			RiskStrategySearchCond cond) {
		return riskStrategyDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskStrategyInfo> searchRiskStrategy(
			RiskStrategySearchCond cond, int start,
			int count) {
		return riskStrategyDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RiskStrategyInfo registRiskStrategy(RiskStrategyInfo instance)
		throws BLException {
		return riskStrategyDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RiskStrategyInfo updateRiskStrategy(RiskStrategyInfo instance)
		throws BLException {
		checkExistInstance(instance.getRsid());
		return riskStrategyDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRiskStrategyByPK(Integer pk)
		throws BLException {
		riskStrategyDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRiskStrategy(RiskStrategyInfo instance)
		throws BLException {
		riskStrategyDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RiskStrategyInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskStrategyInfo instance = riskStrategyDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}