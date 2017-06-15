/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.CicollecttaskInfo;
import com.deliverik.framework.soc.asset.model.condition.CicollecttaskSearchCond;

/**
  * 概述: cicollecttask业务逻辑接口
  * 功能描述: cicollecttask业务逻辑接口
  * 创建记录: 2013/07/05
  * 修改记录: 
  */
public interface CicollecttaskBL extends BaseBL {




	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CicollecttaskSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CicollecttaskInfo> searchCicollecttask(
			CicollecttaskSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CicollecttaskInfo> searchCicollecttask(
			CicollecttaskSearchCond cond, int start,
			int count);

	public List<Integer> findResourceidByType(int type) throws Exception;
	
	public List<Integer> getTypeIdByName(final List<String> names);
	
	public List<Integer> getResourceIdByType(final List<Integer> typeids);
	
	public List<String> getHQPlateformNameList()throws Exception;

}