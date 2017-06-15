/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskToZhRelateVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskToZhRelateVW;

/**
  * 概述: 风险到指标关系业务逻辑接口
  * 功能描述: 风险到指标关系业务逻辑接口
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public interface RiskToZhRelateVWBL extends BaseBL {

	/**
	 * 风险到指标关系实例取得
	 *
	 * @return 风险到指标关系实例
	 */
	public RiskToZhRelateVW getRiskToZhRelateVWTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskToZhRelateVWInfo> searchRiskToZhRelateVW();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskToZhRelateVWInfo searchRiskToZhRelateVWByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskToZhRelateVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskToZhRelateVWInfo> searchRiskToZhRelateVW(
			RiskToZhRelateVWSearchCond cond);

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
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RiskToZhRelateVWInfo registRiskToZhRelateVW(RiskToZhRelateVWInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RiskToZhRelateVWInfo updateRiskToZhRelateVW(RiskToZhRelateVWInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRiskToZhRelateVWByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRiskToZhRelateVW(RiskToZhRelateVWInfo instance)
		throws BLException;

}