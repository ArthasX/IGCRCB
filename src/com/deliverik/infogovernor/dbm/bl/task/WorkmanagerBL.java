/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;
import com.deliverik.infogovernor.dbm.model.condition.WorkmanagerSearchCond;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerTB;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerVW;

/**
  * 概述: 工作管理业务逻辑接口
  * 功能描述: 工作管理业务逻辑接口
  * 创建记录: 2016/04/19
  * 修改记录: 
  */
public interface WorkmanagerBL extends BaseBL {

	/**
	 * 工作管理实例取得
	 *
	 * @return 工作管理实例
	 */
	public WorkmanagerTB getWorkmanagerTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkmanagerInfo> searchWorkmanager();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkmanagerInfo searchWorkmanagerByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(WorkmanagerSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<WorkmanagerInfo> searchWorkmanager(
			WorkmanagerSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkmanagerInfo> searchWorkmanager(
			WorkmanagerSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public WorkmanagerInfo registWorkmanager(WorkmanagerInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public WorkmanagerInfo updateWorkmanager(WorkmanagerInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteWorkmanagerByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteWorkmanager(WorkmanagerInfo instance)
		throws BLException;

	/**
	 * 查询当前工作复制版本中最新的一条
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<WorkmanagerInfo> searchNewWorkmanager(WorkmanagerSearchCond cond);
	
	/**
	 * 统计待处理工作
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkmanagerVW> searchSumByCond(WorkmanagerSearchCond cond);
	
}