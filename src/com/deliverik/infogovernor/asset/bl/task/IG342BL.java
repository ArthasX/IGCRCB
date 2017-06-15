/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.IG342Info;
import com.deliverik.infogovernor.asset.model.condition.IG342SearchCond;
import com.deliverik.infogovernor.asset.model.entity.IG342VW;

/**
  * 概述: 业务逻辑接口
  * 功能描述: 业务逻辑接口
  * 创建记录: 2012/08/03
  * 修改记录: 
  */
public interface IG342BL extends BaseBL {

	/**
	 * IG342VW实例取得
	 *
	 * @return IG342VW实例
	 */
	public IG342VW getIG342();

//	/**
//	 * 全件检索
//	 *
//	 * @return 检索结果集
//	 */
//	public List<EntityItemAndConfigItemVWInfo> searchEntityItemAndConfigItemVW();
//
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG342SearchCond cond);

//	/**
//	 * 条件检索处理
//	 *
//	 * @param cond 检索条件
//	 * @return 检索结果列表
//	 */
//	public List<EntityItemAndConfigItemVWInfo> searchEntityItemAndConfigItemVW(
//			EntityItemAndConfigItemVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG342Info> searchIG342(
			IG342SearchCond cond, int start,
			int count);
}