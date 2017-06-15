/*
 * 北京递蓝科软件股份有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wki.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wki.model.WorkinfoInfo;
import com.deliverik.infogovernor.wki.model.condition.WorkinfoSearchCond;
import com.deliverik.infogovernor.wki.model.entity.WorkinfoTB;

/**
  * 概述: 工作信息业务逻辑接口
  * 功能描述: 工作信息业务逻辑接口
  * 创建记录: 2017/03/02
  * 修改记录: 
  */
public interface WorkinfoBL extends BaseBL {

	/**
	 * 工作信息实例取得
	 *
	 * @return 工作信息实例
	 */
	public WorkinfoTB getWorkinfoTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkinfoInfo> searchWorkinfo();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkinfoInfo searchWorkinfoByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(WorkinfoSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<WorkinfoInfo> searchWorkinfo(
			WorkinfoSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkinfoInfo> searchWorkinfo(
			WorkinfoSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public WorkinfoInfo registWorkinfo(WorkinfoInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public WorkinfoInfo updateWorkinfo(WorkinfoInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteWorkinfoByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteWorkinfo(WorkinfoInfo instance)
		throws BLException;

}