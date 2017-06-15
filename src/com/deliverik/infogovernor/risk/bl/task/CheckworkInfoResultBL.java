/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.CheckworkInfoResultInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckworkInfoResultSearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckworkInfoResultTB;

/**
  * 概述: 检查工作检查任务关联表业务逻辑接口
  * 功能描述: 检查工作检查任务关联表业务逻辑接口
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
public interface CheckworkInfoResultBL extends BaseBL {

	/**
	 * 检查工作检查任务关联表实例取得
	 *
	 * @return 检查工作检查任务关联表实例
	 */
	public CheckworkInfoResultTB getCheckworkInfoResultTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CheckworkInfoResultInfo> searchCheckworkInfoResult();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CheckworkInfoResultInfo searchCheckworkInfoResultByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CheckworkInfoResultSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CheckworkInfoResultInfo> searchCheckworkInfoResult(
			CheckworkInfoResultSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CheckworkInfoResultInfo> searchCheckworkInfoResult(
			CheckworkInfoResultSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CheckworkInfoResultInfo registCheckworkInfoResult(CheckworkInfoResultInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CheckworkInfoResultInfo updateCheckworkInfoResult(CheckworkInfoResultInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCheckworkInfoResultByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCheckworkInfoResult(CheckworkInfoResultInfo instance)
		throws BLException;

}