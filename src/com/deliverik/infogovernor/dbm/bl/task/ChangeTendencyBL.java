package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.dbm.model.ChangeTendency;
import com.deliverik.infogovernor.dbm.model.condition.ChangeTendencySearchCond;

public interface ChangeTendencyBL {

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public abstract List<ChangeTendency> findAllChangeTendency()
			throws BLException;

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public abstract int getSearchCount(ChangeTendencySearchCond cond)
			throws BLException;

	/**
	 * 条件检索处理
	 * 
	 * @param cond
	 *            检索条件
	 * @param start
	 *            检索记录起始行号
	 * @param count
	 *            检索记录件数
	 * @return 检索结果列表
	 */
	public abstract List<ChangeTendency> findChangeTendencyByCond(
			ChangeTendencySearchCond cond, int start, int count)
			throws BLException;

}