/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.fxk.model.RiskmanagerwaringInfo;
import com.deliverik.infogovernor.fxk.model.condition.RiskmanagerwaringSearchCond;
import com.deliverik.infogovernor.fxk.model.dao.RiskmanagerwaringDAO;
import com.deliverik.infogovernor.fxk.model.entity.RiskmanagerwaringTB;

/**
  * 概述: 风险管理提示数据表业务逻辑实现
  * 功能描述: 风险管理提示数据表业务逻辑实现
  * 创建记录: 2014/06/17
  * 修改记录: 
  */
public class RiskmanagerwaringBLImpl extends BaseBLImpl implements
		RiskmanagerwaringBL {

	/** 风险管理提示数据表DAO接口 */
	protected RiskmanagerwaringDAO riskmanagerwaringDAO;
	
	/**
	 * 风险管理提示数据表DAO接口设定
	 *
	 * @param riskmanagerwaringDAO 风险管理提示数据表DAO接口
	 */
	public void setRiskmanagerwaringDAO(RiskmanagerwaringDAO riskmanagerwaringDAO) {
		this.riskmanagerwaringDAO = riskmanagerwaringDAO;
	}

	/**
	 * 风险管理提示数据表实例取得
	 *
	 * @return 风险管理提示数据表实例
	 */
	public RiskmanagerwaringTB getRiskmanagerwaringTBInstance() {
		return new RiskmanagerwaringTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskmanagerwaringInfo> searchRiskmanagerwaring() {
		return riskmanagerwaringDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskmanagerwaringInfo searchRiskmanagerwaringByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskmanagerwaringSearchCond cond) {
		return riskmanagerwaringDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskmanagerwaringInfo> searchRiskmanagerwaring(
			RiskmanagerwaringSearchCond cond) {
		return riskmanagerwaringDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskmanagerwaringInfo> searchRiskmanagerwaring(
			RiskmanagerwaringSearchCond cond, int start,
			int count) {
		return riskmanagerwaringDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RiskmanagerwaringInfo registRiskmanagerwaring(RiskmanagerwaringInfo instance)
		throws BLException {
		return riskmanagerwaringDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RiskmanagerwaringInfo updateRiskmanagerwaring(RiskmanagerwaringInfo instance)
		throws BLException {
		checkExistInstance(instance.getRwid());
		return riskmanagerwaringDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRiskmanagerwaringByPK(Integer pk)
		throws BLException {
		riskmanagerwaringDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRiskmanagerwaring(RiskmanagerwaringInfo instance)
		throws BLException {
		riskmanagerwaringDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RiskmanagerwaringInfo checkExistInstance(Integer pk)
		throws BLException {
		RiskmanagerwaringInfo instance = riskmanagerwaringDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}