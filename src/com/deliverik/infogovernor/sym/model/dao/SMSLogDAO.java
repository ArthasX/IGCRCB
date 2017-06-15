package com.deliverik.infogovernor.sym.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.SMSLog;
import com.deliverik.infogovernor.sym.model.condition.SMSLogSearchCond;

public interface SMSLogDAO extends BaseHibernateDAO<SMSLog>{

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public abstract List<SMSLog> findAll();

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public abstract List<SMSLog> findByCond(final SMSLogSearchCond cond,
			final int start, final int count);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public abstract int getSearchCount(final SMSLogSearchCond cond);

}