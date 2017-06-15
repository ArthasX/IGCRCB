/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskIndexShowVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexShowVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RiskIndexShowVWDAO;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexShowVW;

/**
  * 概述: 风险指标展示查询业务逻辑实现
  * 功能描述: 风险指标展示查询业务逻辑实现
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
public class RiskIndexShowVWBLImpl extends BaseBLImpl implements
		RiskIndexShowVWBL {

	/** 风险指标展示查询DAO接口 */
	protected RiskIndexShowVWDAO riskIndexShowVWDAO;
	
	/**
	 * 风险指标展示查询DAO接口设定
	 *
	 * @param riskIndexShowVWDAO 风险指标展示查询DAO接口
	 */
	public void setRiskIndexShowVWDAO(RiskIndexShowVWDAO riskIndexShowVWDAO) {
		this.riskIndexShowVWDAO = riskIndexShowVWDAO;
	}

	/**
	 * 风险指标展示查询实例取得
	 *
	 * @return 风险指标展示查询实例
	 */
	public RiskIndexShowVW getRiskIndexShowVWTBInstance() {
		return new RiskIndexShowVW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskIndexShowVWInfo> searchRiskIndexShowVW() {
		return riskIndexShowVWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskIndexShowVWInfo searchRiskIndexShowVWByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskIndexShowVWSearchCond cond) {
		return riskIndexShowVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskIndexShowVWInfo> searchRiskIndexShowVW(
			RiskIndexShowVWSearchCond cond) {
		return riskIndexShowVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskIndexShowVWInfo> searchRiskIndexShowVW(
			RiskIndexShowVWSearchCond cond, int start,
			int count) {
		return riskIndexShowVWDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RiskIndexShowVWInfo registRiskIndexShowVW(RiskIndexShowVWInfo instance)
		throws BLException {
		return riskIndexShowVWDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RiskIndexShowVWInfo updateRiskIndexShowVW(RiskIndexShowVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getEsyscoding());
		return riskIndexShowVWDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRiskIndexShowVWByPK(String pk)
		throws BLException {
		riskIndexShowVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRiskIndexShowVW(RiskIndexShowVWInfo instance)
		throws BLException {
		riskIndexShowVWDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RiskIndexShowVWInfo checkExistInstance(String pk)
		throws BLException {
		RiskIndexShowVWInfo instance = riskIndexShowVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}