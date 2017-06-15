/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.ProcessTimeInfo;
import com.deliverik.framework.workflow.prr.model.condition.ProcessTimeSearchCond;
import com.deliverik.framework.workflow.prr.model.entity.ProcessTimeTB;



/**
  * 概述: 流程计时表业务逻辑接口
  * 功能描述: 流程计时表业务逻辑接口
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
public interface ProcessTimeBL extends BaseBL {

	/**
	 * 流程计时表实例取得
	 *
	 * @return 流程计时表实例
	 */
	public ProcessTimeTB getProcessTimeTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ProcessTimeInfo> searchProcessTime();

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public ProcessTimeInfo searchProcessTimeByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ProcessTimeSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<ProcessTimeInfo> searchProcessTime(
			ProcessTimeSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProcessTimeInfo> searchProcessTime(
			ProcessTimeSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public ProcessTimeInfo registProcessTime(ProcessTimeInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public ProcessTimeInfo updateProcessTime(ProcessTimeInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteProcessTimeByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteProcessTime(ProcessTimeInfo instance)
		throws BLException;

}