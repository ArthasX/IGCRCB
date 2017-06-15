/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskCheckVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskCheckVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RiskCheckVWDAO;
import com.deliverik.infogovernor.asset.model.entity.RiskCheckVW;

/**
  * 概述: 检查工作统计报表业务逻辑实现
  * 功能描述: 检查工作统计报表业务逻辑实现
  * 创建记录: 2014/07/22
  * 修改记录: 
  */
public class RiskCheckVWBLImpl extends BaseBLImpl implements
		RiskCheckVWBL {

	/** 检查工作统计报表DAO接口 */
	protected RiskCheckVWDAO riskCheckVWDAO;
	
	/**
	 * 检查工作统计报表DAO接口设定
	 *
	 * @param riskCheckVWDAO 检查工作统计报表DAO接口
	 */
	public void setRiskCheckVWDAO(RiskCheckVWDAO riskCheckVWDAO) {
		this.riskCheckVWDAO = riskCheckVWDAO;
	}

	/**
	 * 检查工作统计报表实例取得
	 *
	 * @return 检查工作统计报表实例
	 */
	public RiskCheckVW getRiskCheckVWTBInstance() {
		return new RiskCheckVW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskCheckVWInfo> searchRiskCheckVW() {
		return riskCheckVWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskCheckVWInfo searchRiskCheckVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskCheckVWSearchCond cond) {
		return riskCheckVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskCheckVWInfo> searchRiskCheckVW(
			RiskCheckVWSearchCond cond) {
		return riskCheckVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheckVWInfo> searchRiskCheckVW(
			RiskCheckVWSearchCond cond, int start,
			int count) {
		return riskCheckVWDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RiskCheckVWInfo registRiskCheckVW(RiskCheckVWInfo instance)
		throws BLException {
		return riskCheckVWDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RiskCheckVWInfo updateRiskCheckVW(RiskCheckVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return riskCheckVWDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRiskCheckVWByPK(Integer pk)
		throws BLException {
		riskCheckVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRiskCheckVW(RiskCheckVWInfo instance)
		throws BLException {
		riskCheckVWDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RiskCheckVWInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskCheckVWInfo instance = riskCheckVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}