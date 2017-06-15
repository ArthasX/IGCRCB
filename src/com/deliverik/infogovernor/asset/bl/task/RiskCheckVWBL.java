/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.RiskCheckVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskCheckVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskCheckVW;

/**
  * 概述: 检查工作统计报表业务逻辑接口
  * 功能描述: 检查工作统计报表业务逻辑接口
  * 创建记录: 2014/07/22
  * 修改记录: 
  */
public interface RiskCheckVWBL extends BaseBL {

	/**
	 * 检查工作统计报表实例取得
	 *
	 * @return 检查工作统计报表实例
	 */
	public RiskCheckVW getRiskCheckVWTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskCheckVWInfo> searchRiskCheckVW();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskCheckVWInfo searchRiskCheckVWByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(RiskCheckVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskCheckVWInfo> searchRiskCheckVW(
			RiskCheckVWSearchCond cond);

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
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public RiskCheckVWInfo registRiskCheckVW(RiskCheckVWInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public RiskCheckVWInfo updateRiskCheckVW(RiskCheckVWInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteRiskCheckVWByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteRiskCheckVW(RiskCheckVWInfo instance)
		throws BLException;

}