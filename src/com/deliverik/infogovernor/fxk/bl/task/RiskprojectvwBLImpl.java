/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.fxk.model.RiskprojectvwInfo;
import com.deliverik.infogovernor.fxk.model.condition.RiskprojectvwSearchCond;
import com.deliverik.infogovernor.fxk.model.dao.RiskprojectvwDAO;
import com.deliverik.infogovernor.fxk.model.entity.RiskprojectvwTB;

/**
  * 概述: 通讯录业务逻辑实现
  * 功能描述: 通讯录业务逻辑实现
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public class RiskprojectvwBLImpl extends BaseBLImpl implements
		RiskprojectvwBL {

	/** 通讯录DAO接口 */
	protected RiskprojectvwDAO riskprojectvwDAO;
	
	/**
	 * 通讯录DAO接口设定
	 *
	 * @param riskprojectvwDAO 通讯录DAO接口
	 */
	public void setRiskprojectvwDAO(RiskprojectvwDAO riskprojectvwDAO) {
		this.riskprojectvwDAO = riskprojectvwDAO;
	}

	/**
	 * 通讯录实例取得
	 *
	 * @return 通讯录实例
	 */
	public RiskprojectvwTB getRiskprojectvwTBInstance() {
		return new RiskprojectvwTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskprojectvwInfo> searchRiskprojectvw() {
		return riskprojectvwDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskprojectvwInfo searchRiskprojectvwByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskprojectvwSearchCond cond) {
		return riskprojectvwDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskprojectvwInfo> searchRiskprojectvw(
			RiskprojectvwSearchCond cond) {
		return riskprojectvwDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskprojectvwInfo> searchRiskprojectvw(
			RiskprojectvwSearchCond cond, int start,
			int count) {
		return riskprojectvwDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RiskprojectvwInfo registRiskprojectvw(RiskprojectvwInfo instance)
		throws BLException {
		return riskprojectvwDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RiskprojectvwInfo updateRiskprojectvw(RiskprojectvwInfo instance)
		throws BLException {
		checkExistInstance(instance.getPrid ());
		return riskprojectvwDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRiskprojectvwByPK(Integer pk)
		throws BLException {
		riskprojectvwDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRiskprojectvw(RiskprojectvwInfo instance)
		throws BLException {
		riskprojectvwDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RiskprojectvwInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskprojectvwInfo instance = riskprojectvwDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}