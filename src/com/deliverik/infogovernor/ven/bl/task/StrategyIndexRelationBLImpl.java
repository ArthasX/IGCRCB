/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.ven.model.StrategyIndexRelationInfo;
import com.deliverik.infogovernor.ven.model.condition.StrategyIndexRelationSearchCond;
import com.deliverik.infogovernor.ven.model.dao.StrategyIndexRelationDAO;
import com.deliverik.infogovernor.ven.model.entity.StrategyIndexRelationTB;

/**
  * 概述: 风险策略指标关系表业务逻辑实现
  * 功能描述: 风险策略指标关系表业务逻辑实现
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public class StrategyIndexRelationBLImpl extends BaseBLImpl implements
		StrategyIndexRelationBL {

	/** 风险策略指标关系表DAO接口 */
	protected StrategyIndexRelationDAO strategyIndexRelationDAO;
	
	/**
	 * 风险策略指标关系表DAO接口设定
	 *
	 * @param strategyIndexRelationDAO 风险策略指标关系表DAO接口
	 */
	public void setStrategyIndexRelationDAO(StrategyIndexRelationDAO strategyIndexRelationDAO) {
		this.strategyIndexRelationDAO = strategyIndexRelationDAO;
	}

	/**
	 * 风险策略指标关系表实例取得
	 *
	 * @return 风险策略指标关系表实例
	 */
	public StrategyIndexRelationTB getStrategyIndexRelationTBInstance() {
		return new StrategyIndexRelationTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<StrategyIndexRelationInfo> searchStrategyIndexRelation() {
		return strategyIndexRelationDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public StrategyIndexRelationInfo searchStrategyIndexRelationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(StrategyIndexRelationSearchCond cond) {
		return strategyIndexRelationDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<StrategyIndexRelationInfo> searchStrategyIndexRelation(
			StrategyIndexRelationSearchCond cond) {
		return strategyIndexRelationDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<StrategyIndexRelationInfo> searchStrategyIndexRelation(
			StrategyIndexRelationSearchCond cond, int start,
			int count) {
		return strategyIndexRelationDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public StrategyIndexRelationInfo registStrategyIndexRelation(StrategyIndexRelationInfo instance)
		throws BLException {
		return strategyIndexRelationDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public StrategyIndexRelationInfo updateStrategyIndexRelation(StrategyIndexRelationInfo instance)
		throws BLException {
		checkExistInstance(instance.getSirid());
		return strategyIndexRelationDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteStrategyIndexRelationByPK(Integer pk)
		throws BLException {
		strategyIndexRelationDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteStrategyIndexRelation(StrategyIndexRelationInfo instance)
		throws BLException {
		strategyIndexRelationDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public StrategyIndexRelationInfo checkExistInstance(Integer pk)
		throws BLException {
		StrategyIndexRelationInfo instance = strategyIndexRelationDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}