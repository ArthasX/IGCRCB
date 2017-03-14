/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.framework.workflow.prr.model.condition.CurrentMonthWorkVWSearchCond;

/**
 * 概述:查询带有处理人的本月工作 
 * 功能描述：查询带有处理人的本月工作
 * 创建人：赵梓廷
 * 创建记录： 2013-04-22
 * 修改记录：
 */
public interface CurrentMonthWorkVWBL extends BaseBL {

	/**
	 * 本月工作检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCurrentMonthWorkCount(final CurrentMonthWorkVWSearchCond cond);
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CurrentMonthWorkVWInfo> findCurrentMonthWorkByCond(
			final CurrentMonthWorkVWSearchCond cond, final int start,
			final int count);
}
