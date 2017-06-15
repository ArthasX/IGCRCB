/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskPointVMSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RiskPointVMDAO;
import com.deliverik.infogovernor.asset.model.entity.RiskPointVM;

/**
  * 概述: 风险点查询业务逻辑实现
  * 功能描述: 风险点查询业务逻辑实现
  * 创建记录: 2014/06/30
  * 修改记录: 
  */
public class RiskPointVMBLImpl extends BaseBLImpl implements
		RiskPointVMBL {

	/** 风险点查询DAO接口 */
	protected RiskPointVMDAO riskPointVMDAO;
	
	/**
	 * 风险点查询DAO接口设定
	 *
	 * @param riskPointVMDAO 风险点查询DAO接口
	 */
	public void setRiskPointVMDAO(RiskPointVMDAO riskPointVMDAO) {
		this.riskPointVMDAO = riskPointVMDAO;
	}

	/**
	 * 风险点查询实例取得
	 *
	 * @return 风险点查询实例
	 */
	public RiskPointVM getRiskPointVMTBInstance() {
		return new RiskPointVM();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskPointVMInfo> searchRiskPointVM() {
		return riskPointVMDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskPointVMInfo searchRiskPointVMByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskPointVMSearchCond cond) {
		riskPointVMDAO.findByCond(cond, 0, 0);
		return riskPointVMDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskPointVMInfo> searchRiskPointVM(
			RiskPointVMSearchCond cond) {
		return riskPointVMDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskPointVMInfo> searchRiskPointVM(
			RiskPointVMSearchCond cond, int start,
			int count) {
		return riskPointVMDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RiskPointVMInfo registRiskPointVM(RiskPointVMInfo instance)
		throws BLException {
		return riskPointVMDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RiskPointVMInfo updateRiskPointVM(RiskPointVMInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return riskPointVMDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRiskPointVMByPK(Integer pk)
		throws BLException {
		riskPointVMDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRiskPointVM(RiskPointVMInfo instance)
		throws BLException {
		riskPointVMDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RiskPointVMInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskPointVMInfo instance = riskPointVMDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}