package com.deliverik.infogovernor.sta.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sta.model.ProcessRecordSummary;
import com.deliverik.infogovernor.sta.model.condition.ProcessRecordSummarySearchCond;

public interface ProcessRecordSummaryVWDAO extends BaseHibernateDAO<ProcessRecordSummary> {
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProcessRecordSummary> findByCond(final ProcessRecordSummarySearchCond cond, final int start,
			final int count);
}
