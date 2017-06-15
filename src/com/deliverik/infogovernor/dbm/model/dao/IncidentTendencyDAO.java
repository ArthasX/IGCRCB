package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dbm.model.IncidentTendency;
import com.deliverik.infogovernor.dbm.model.condition.IncidentTendencySearchCond;

public interface IncidentTendencyDAO extends BaseHibernateDAO<IncidentTendency>{

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public abstract List<IncidentTendency> findAll();

	/**
	 * 主键检索处理
	 * @param id 主键
	 * @return 检索结果
	 */
	public abstract IncidentTendency findByPK(Serializable id);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public abstract int getSearchCount(final IncidentTendencySearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public abstract List<IncidentTendency> findByCond(
			final IncidentTendencySearchCond cond, final int start,
			final int count);

}