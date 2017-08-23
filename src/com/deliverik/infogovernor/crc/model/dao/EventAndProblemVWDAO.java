/*
 * 北京递蓝科股份有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.infogovernor.crc.model.EventAndProblemVWInfo;
import com.deliverik.infogovernor.crc.model.condition.EventAndProblemVWSearchCond;

public interface EventAndProblemVWDAO {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EventAndProblemVWInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EventAndProblemVWInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EventAndProblemVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EventAndProblemVWInfo> findByCond(
			final EventAndProblemVWSearchCond cond, final int start,
			final int count);
}
