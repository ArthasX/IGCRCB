/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCond;
import com.deliverik.infogovernor.smr.model.entity.ApproveSuggestionTB;

/**
  * 概述: 审批意见表业务逻辑接口
  * 功能描述: 审批意见表业务逻辑接口
  * 创建记录: 2013/07/22
  * 修改记录: 
  */
public interface ApproveSuggestionBL extends BaseBL {

	/**
	 * 审批意见表实例取得
	 *
	 * @return 审批意见表实例
	 */
	public ApproveSuggestionTB getApproveSuggestionTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ApproveSuggestionInfo> searchApproveSuggestionInfo();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ApproveSuggestionInfo searchApproveSuggestionInfoByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ApproveSuggestionSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<ApproveSuggestionInfo> searchApproveSuggestionInfo(
			ApproveSuggestionSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ApproveSuggestionInfo> searchApproveSuggestionInfo(
			ApproveSuggestionSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public ApproveSuggestionInfo registApproveSuggestionInfo(ApproveSuggestionInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public ApproveSuggestionInfo updateApproveSuggestionInfo(ApproveSuggestionInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteApproveSuggestionInfoByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteApproveSuggestionInfo(ApproveSuggestionInfo instance)
		throws BLException;

}