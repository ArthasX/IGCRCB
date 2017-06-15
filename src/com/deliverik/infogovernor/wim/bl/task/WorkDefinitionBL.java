/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkDefinitionSearchCond;
import com.deliverik.infogovernor.wim.model.entity.WorkDefinitionTB;

/**
  * 概述: WorkDefinition业务逻辑接口
  * 功能描述: WorkDefinition业务逻辑接口
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public interface WorkDefinitionBL extends BaseBL {

	/**
	 * WorkDefinition实例取得
	 *
	 * @return WorkDefinition实例
	 */
	public WorkDefinitionTB getWorkDefinitionTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkDefinitionInfo> searchWorkDefinition();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkDefinitionInfo searchWorkDefinitionByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(WorkDefinitionSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<WorkDefinitionInfo> searchWorkDefinition(
			WorkDefinitionSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkDefinitionInfo> searchWorkDefinition(
			WorkDefinitionSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public WorkDefinitionInfo registWorkDefinition(WorkDefinitionInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public WorkDefinitionInfo updateWorkDefinition(WorkDefinitionInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteWorkDefinitionByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteWorkDefinition(WorkDefinitionInfo instance)
		throws BLException;

}