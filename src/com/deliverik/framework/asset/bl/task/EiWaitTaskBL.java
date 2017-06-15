/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.EiWaitTaskInfo;
import com.deliverik.framework.asset.model.condition.EiWaitTaskSearchCond;
import com.deliverik.framework.asset.model.entity.EiWaitTaskTB;

/**
  * 概述: 待处理任务业务逻辑接口
  * 功能描述: 待处理任务业务逻辑接口
  * 创建记录: 2011/04/29
  * 修改记录: 
  */
public interface EiWaitTaskBL extends BaseBL {

	/**
	 * 待处理任务实例取得
	 *
	 * @return 待处理任务实例
	 */
	public EiWaitTaskTB getEiWaitTaskTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiWaitTaskInfo> searchEiWaitTask();

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public EiWaitTaskInfo searchEiWaitTaskByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(EiWaitTaskSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<EiWaitTaskInfo> searchEiWaitTask(
			EiWaitTaskSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiWaitTaskInfo> searchEiWaitTask(
			EiWaitTaskSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public EiWaitTaskInfo registEiWaitTask(EiWaitTaskInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public EiWaitTaskInfo updateEiWaitTask(EiWaitTaskInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteEiWaitTaskByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteEiWaitTask(EiWaitTaskInfo instance)
		throws BLException;

}