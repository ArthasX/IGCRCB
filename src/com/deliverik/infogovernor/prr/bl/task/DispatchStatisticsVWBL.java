/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.model.DispatchStatisticsVWInfo;
import com.deliverik.infogovernor.prr.model.condition.DispatchStatisticsVWSearchCond;
import com.deliverik.infogovernor.prr.model.entity.DispatchStatisticsVW;

/**
  * 概述: 发文流程统计业务逻辑接口
  * 功能描述: 发文流程统计业务逻辑接口
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
public interface DispatchStatisticsVWBL extends BaseBL {

	/**
	 * 发文流程统计实例取得
	 *
	 * @return 发文流程统计实例
	 */
	public DispatchStatisticsVW getDispatchStatisticsVWTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<DispatchStatisticsVWInfo> searchDispatchStatisticsVW();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public DispatchStatisticsVWInfo searchDispatchStatisticsVWByPK(String pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(DispatchStatisticsVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<DispatchStatisticsVWInfo> searchDispatchStatisticsVW(
			DispatchStatisticsVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DispatchStatisticsVWInfo> searchDispatchStatisticsVW(
			DispatchStatisticsVWSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public DispatchStatisticsVWInfo registDispatchStatisticsVW(DispatchStatisticsVWInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public DispatchStatisticsVWInfo updateDispatchStatisticsVW(DispatchStatisticsVWInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteDispatchStatisticsVWByPK(String pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteDispatchStatisticsVW(DispatchStatisticsVWInfo instance)
		throws BLException;
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DispatchStatisticsVWInfo> findDispatchStatisticsVW(
			DispatchStatisticsVWSearchCond cond, int start,int count);
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getDispatchStatisticsSearchCount(DispatchStatisticsVWSearchCond cond);

}