package com.deliverik.infogovernor.dbm.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dbm.model.ChangeTendency;
import com.deliverik.infogovernor.dbm.model.condition.ChangeTendencySearchCond;

public interface ChangeTendencyDAO extends BaseHibernateDAO<ChangeTendency>{


	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public abstract int getSearchCount(final ChangeTendencySearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public abstract List<ChangeTendency> findByCond(
			final ChangeTendencySearchCond cond, final int start,
			final int count);
}