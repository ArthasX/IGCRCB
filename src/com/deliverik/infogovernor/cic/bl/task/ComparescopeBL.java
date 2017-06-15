/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.model.ComparescopeInfo;
import com.deliverik.infogovernor.cic.model.condition.ComparescopeSearchCond;
import com.deliverik.infogovernor.cic.model.entity.ComparescopeTB;

/**
  * 概述: 对比域业务逻辑接口
  * 功能描述: 对比域业务逻辑接口
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public interface ComparescopeBL extends BaseBL {

	/**
	 * 对比域实例取得
	 *
	 * @return 对比域实例
	 */
	public ComparescopeTB getComparescopeTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ComparescopeInfo> searchComparescope();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ComparescopeInfo searchComparescopeByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ComparescopeSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<ComparescopeInfo> searchComparescope(
			ComparescopeSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ComparescopeInfo> searchComparescope(
			ComparescopeSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public ComparescopeInfo registComparescope(ComparescopeInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public ComparescopeInfo updateComparescope(ComparescopeInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteComparescopeByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteComparescope(ComparescopeInfo instance)
		throws BLException;

}