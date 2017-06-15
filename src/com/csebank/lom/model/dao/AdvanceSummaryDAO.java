/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.AdvanceSummary;
import com.csebank.lom.model.condition.AdvanceSummarySearchCond;
import com.csebank.lom.model.condition.AdvancesummaryCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * 预支汇总DAO接口
 *
 */
public interface AdvanceSummaryDAO extends BaseHibernateDAO<AdvanceSummary> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<AdvanceSummary> findAll();

	/**
	 * 主键检索处理
	 * @param advanceSummaryTBPK 主键
	 * @return 检索结果
	 */
	public AdvanceSummary findByPK(Serializable advanceSummaryTBPK);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AdvanceSummarySearchCond cond);
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AdvancesummaryCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AdvanceSummary> findByCond(final AdvanceSummarySearchCond cond, final int start, final int count);
	
	
	/**预支月度统计
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AdvanceSummary> findByCond(final AdvancesummaryCond cond, final int start, final int count);
	
}
