/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexSearchVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RiskIndexSearchVWDAO;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexSearchVW;

/**
  * 概述: 风险指标查询业务逻辑实现
  * 功能描述: 风险指标查询业务逻辑实现
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
public class RiskIndexSearchVWBLImpl extends BaseBLImpl implements
		RiskIndexSearchVWBL {

	/** 风险指标查询DAO接口 */
	protected RiskIndexSearchVWDAO riskIndexSearchVWDAO;
	
	/**
	 * 风险指标查询DAO接口设定
	 *
	 * @param riskIndexSearchVWDAO 风险指标查询DAO接口
	 */
	public void setRiskIndexSearchVWDAO(RiskIndexSearchVWDAO riskIndexSearchVWDAO) {
		this.riskIndexSearchVWDAO = riskIndexSearchVWDAO;
	}

	/**
	 * 风险指标查询实例取得
	 *
	 * @return 风险指标查询实例
	 */
	public RiskIndexSearchVW getRiskIndexSearchVWTBInstance() {
		return new RiskIndexSearchVW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskIndexSearchVWInfo> searchRiskIndexSearchVW() {
		return riskIndexSearchVWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskIndexSearchVWInfo searchRiskIndexSearchVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskIndexSearchVWSearchCond cond) {
		return riskIndexSearchVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskIndexSearchVWInfo> searchRiskIndexSearchVW(
			RiskIndexSearchVWSearchCond cond) {
		return riskIndexSearchVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskIndexSearchVWInfo> searchRiskIndexSearchVW(
			RiskIndexSearchVWSearchCond cond, int start,
			int count) {
		return riskIndexSearchVWDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RiskIndexSearchVWInfo registRiskIndexSearchVW(RiskIndexSearchVWInfo instance)
		throws BLException {
		return riskIndexSearchVWDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RiskIndexSearchVWInfo updateRiskIndexSearchVW(RiskIndexSearchVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return riskIndexSearchVWDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRiskIndexSearchVWByPK(Integer pk)
		throws BLException {
		riskIndexSearchVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRiskIndexSearchVW(RiskIndexSearchVWInfo instance)
		throws BLException {
		riskIndexSearchVWDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RiskIndexSearchVWInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskIndexSearchVWInfo instance = riskIndexSearchVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}