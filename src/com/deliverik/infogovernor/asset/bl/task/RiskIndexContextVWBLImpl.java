/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexContextVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RiskIndexContextVWDAO;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexContextVW;

/**
  * 概述: 风险指标展示内容查询业务逻辑实现
  * 功能描述: 风险指标展示内容查询业务逻辑实现
  * 创建记录: 2014/07/26
  * 修改记录: 
  */
public class RiskIndexContextVWBLImpl extends BaseBLImpl implements
		RiskIndexContextVWBL {

	/** 风险指标展示内容查询DAO接口 */
	protected RiskIndexContextVWDAO riskIndexContextVWDAO;
	
	/**
	 * 风险指标展示内容查询DAO接口设定
	 *
	 * @param riskIndexContextVWDAO 风险指标展示内容查询DAO接口
	 */
	public void setRiskIndexContextVWDAO(RiskIndexContextVWDAO riskIndexContextVWDAO) {
		this.riskIndexContextVWDAO = riskIndexContextVWDAO;
	}

	/**
	 * 风险指标展示内容查询实例取得
	 *
	 * @return 风险指标展示内容查询实例
	 */
	public RiskIndexContextVW getRiskIndexContextVWTBInstance() {
		return new RiskIndexContextVW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskIndexContextVWInfo> searchRiskIndexContextVW() {
		return riskIndexContextVWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskIndexContextVWInfo searchRiskIndexContextVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskIndexContextVWSearchCond cond) {
		return riskIndexContextVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskIndexContextVWInfo> searchRiskIndexContextVW(
			RiskIndexContextVWSearchCond cond) {
		return riskIndexContextVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskIndexContextVWInfo> searchRiskIndexContextVW(
			RiskIndexContextVWSearchCond cond, int start,
			int count) {
		return riskIndexContextVWDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RiskIndexContextVWInfo registRiskIndexContextVW(RiskIndexContextVWInfo instance)
		throws BLException {
		return riskIndexContextVWDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RiskIndexContextVWInfo updateRiskIndexContextVW(RiskIndexContextVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getRimid());
		return riskIndexContextVWDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRiskIndexContextVWByPK(Integer pk)
		throws BLException {
		riskIndexContextVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRiskIndexContextVW(RiskIndexContextVWInfo instance)
		throws BLException {
		riskIndexContextVWDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RiskIndexContextVWInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskIndexContextVWInfo instance = riskIndexContextVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}