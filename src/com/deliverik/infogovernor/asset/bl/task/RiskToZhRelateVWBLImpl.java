/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskToZhRelateVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RiskToZhRelateVWDAO;
import com.deliverik.infogovernor.asset.model.entity.RiskToZhRelateVW;

/**
  * 概述: 风险到指标关系业务逻辑实现
  * 功能描述: 风险到指标关系业务逻辑实现
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public class RiskToZhRelateVWBLImpl extends BaseBLImpl implements
		RiskToZhRelateVWBL {

	/** 风险到指标关系DAO接口 */
	protected RiskToZhRelateVWDAO riskToZhRelateVWDAO;
	
	/**
	 * 风险到指标关系DAO接口设定
	 *
	 * @param riskToZhRelateVWDAO 风险到指标关系DAO接口
	 */
	public void setRiskToZhRelateVWDAO(RiskToZhRelateVWDAO riskToZhRelateVWDAO) {
		this.riskToZhRelateVWDAO = riskToZhRelateVWDAO;
	}

	/**
	 * 风险到指标关系实例取得
	 *
	 * @return 风险到指标关系实例
	 */
	public RiskToZhRelateVW getRiskToZhRelateVWTBInstance() {
		return new RiskToZhRelateVW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskToZhRelateVWInfo> searchRiskToZhRelateVW() {
		return riskToZhRelateVWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskToZhRelateVWInfo searchRiskToZhRelateVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskToZhRelateVWSearchCond cond) {
		return riskToZhRelateVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskToZhRelateVWInfo> searchRiskToZhRelateVW(
			RiskToZhRelateVWSearchCond cond) {
		return riskToZhRelateVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskToZhRelateVWInfo> searchRiskToZhRelateVW(
			RiskToZhRelateVWSearchCond cond, int start,
			int count) {
		return riskToZhRelateVWDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RiskToZhRelateVWInfo registRiskToZhRelateVW(RiskToZhRelateVWInfo instance)
		throws BLException {
		return riskToZhRelateVWDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RiskToZhRelateVWInfo updateRiskToZhRelateVW(RiskToZhRelateVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return riskToZhRelateVWDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRiskToZhRelateVWByPK(Integer pk)
		throws BLException {
		riskToZhRelateVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRiskToZhRelateVW(RiskToZhRelateVWInfo instance)
		throws BLException {
		riskToZhRelateVWDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RiskToZhRelateVWInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskToZhRelateVWInfo instance = riskToZhRelateVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}