/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkInstanceSearchCond;
import com.deliverik.infogovernor.wim.model.entity.WorkInstanceTB;

/**
  * 概述: workInstance业务逻辑接口
  * 功能描述: workInstance业务逻辑接口
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public interface WorkInstanceBL extends BaseBL {

	/**
	 * workInstance实例取得
	 *
	 * @return workInstance实例
	 */
	public WorkInstanceTB getWorkInstanceTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkInstanceInfo> searchWorkInstance();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkInstanceInfo searchWorkInstanceByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(WorkInstanceSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<WorkInstanceInfo> searchWorkInstance(
			WorkInstanceSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkInstanceInfo> searchWorkInstance(
			WorkInstanceSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public WorkInstanceInfo registWorkInstance(WorkInstanceInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public WorkInstanceInfo updateWorkInstance(WorkInstanceInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteWorkInstanceByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteWorkInstance(WorkInstanceInfo instance)
		throws BLException;

}