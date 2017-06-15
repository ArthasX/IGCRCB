/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ram.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;
import com.deliverik.infogovernor.ram.model.condition.AssessmentScoreVWSearchCond;

/**
  * 概述: 评分历史查询DAO接口
  * 功能描述: 评分历史查询DAO接口
  * 创建记录: 2013/10/10
  * 修改记录: 
  */
public interface AssessmentScoreVWDAO extends BaseHibernateDAO<AssessmentScoreVWInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AssessmentScoreVWInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AssessmentScoreVWInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AssessmentScoreVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AssessmentScoreVWInfo> findByCond(
			final AssessmentScoreVWSearchCond cond, final int start,
			final int count);
	/**
	 * 条件检索处理
	 * @return 评估年度报表
	 */
	public List<Object[]> assessmentYearReport(final AssessmentScoreVWSearchCond cond);
	
	/**
	 * 部门评估报表检索处理
	 * @return 评估年度报表
	 */
	public List<Object[]> assessmentOrganizationReport(final AssessmentScoreVWSearchCond cond);

}