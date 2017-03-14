/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.model.CompareobjectHistoryInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectHistorySearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareobjectHistoryTB;

/**
  * 概述: 对比对象历史表业务逻辑接口
  * 功能描述: 对比对象历史表业务逻辑接口
  * 创建记录: 2014/04/24
  * 修改记录: 
  */
public interface CompareobjectHistoryBL extends BaseBL {

	/**
	 * 对比对象历史表实例取得
	 *
	 * @return 对比对象历史表实例
	 */
	public CompareobjectHistoryTB getCompareobjectHistoryTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareobjectHistoryInfo> searchCompareobjectHistory();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareobjectHistoryInfo searchCompareobjectHistoryByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CompareobjectHistorySearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CompareobjectHistoryInfo> searchCompareobjectHistory(
			CompareobjectHistorySearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CompareobjectHistoryInfo> searchCompareobjectHistory(
			CompareobjectHistorySearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CompareobjectHistoryInfo registCompareobjectHistory(CompareobjectHistoryInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CompareobjectHistoryInfo updateCompareobjectHistory(CompareobjectHistoryInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCompareobjectHistoryByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCompareobjectHistory(CompareobjectHistoryInfo instance)
		throws BLException;

}