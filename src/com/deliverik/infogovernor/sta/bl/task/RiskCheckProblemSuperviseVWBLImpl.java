/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sta.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prr.model.entity.DispatchStatisticsVW;
import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;
import com.deliverik.infogovernor.sta.model.condition.RiskCheckProblemSuperviseVWSearchCond;
import com.deliverik.infogovernor.sta.model.dao.RiskCheckProblemSuperviseVWDAO;

/**
  * 概述: 问题整改监督业务逻辑实现
  * 功能描述: 问题整改监督业务逻辑实现
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
public class RiskCheckProblemSuperviseVWBLImpl extends BaseBLImpl implements
	RiskCheckProblemSuperviseVWBL {

	/** 发文流程统计DAO接口 */
	protected RiskCheckProblemSuperviseVWDAO riskcheckproblemsuperviseVWDAO;
	
	/**
	 * 发文流程统计DAO接口设定
	 *
	 * @param riskcheckproblemsuperviseVWDAO 发文流程统计DAO接口
	 */
	public void setriskcheckproblemsuperviseVWDAO(RiskCheckProblemSuperviseVWDAO riskcheckproblemsuperviseVWDAO) {
		this.riskcheckproblemsuperviseVWDAO = riskcheckproblemsuperviseVWDAO;
	}

	/**
	 * 发文流程统计实例取得
	 *
	 * @return 发文流程统计实例
	 */
	public DispatchStatisticsVW getDispatchStatisticsVWTBInstance() {
		return new DispatchStatisticsVW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskCheckProblemSuperviseVWInfo> searchDispatchStatisticsVW() {
		return riskcheckproblemsuperviseVWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskCheckProblemSuperviseVWInfo searchDispatchStatisticsVWByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskCheckProblemSuperviseVWSearchCond cond) {
		return riskcheckproblemsuperviseVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskCheckProblemSuperviseVWInfo> searchDispatchStatisticsVW(
			RiskCheckProblemSuperviseVWSearchCond cond) {
		return riskcheckproblemsuperviseVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheckProblemSuperviseVWInfo> searchDispatchStatisticsVW(
			RiskCheckProblemSuperviseVWSearchCond cond, int start,
			int count) {
		return riskcheckproblemsuperviseVWDAO.findByCond(cond, start, count);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheckProblemSuperviseVWInfo> findDispatchStatisticsVW(
			RiskCheckProblemSuperviseVWSearchCond cond, int start,
			int count) {
		return riskcheckproblemsuperviseVWDAO.findRiskCheckProblemSupervise(cond, start, count);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getRiskCheckProblemSuperviseSearchCount(RiskCheckProblemSuperviseVWSearchCond cond) {
		return riskcheckproblemsuperviseVWDAO.findRiskCheckProblemSuperviseSearchCount(cond);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public RiskCheckProblemSuperviseVWInfo checkExistInstance(String pk)
		throws BLException {
		RiskCheckProblemSuperviseVWInfo instance = riskcheckproblemsuperviseVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}