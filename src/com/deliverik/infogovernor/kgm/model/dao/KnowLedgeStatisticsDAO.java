/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.KnowledgeStatisticsInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeStatisticsSearchCond;

/**
 * 概述: 知识库统计DAO接口
 * 功能描述：知识库统计DAO接口
 * 创建记录：wanglei 2014/3/13
 * 修改记录：
 */
public interface KnowLedgeStatisticsDAO extends BaseHibernateDAO<KnowLedgeInfo> {

	/**
	 * 条件检索处理(按贡献人)
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowledgeStatisticsInfo> findByKnprofferCond(final KnowledgeStatisticsSearchCond cond,
			final int start, final int count);
	
	/**
	 * 条件检索处理(按分类)
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowledgeStatisticsInfo> findByKnclassCond(final KnowledgeStatisticsSearchCond cond,
			final int start, final int count);
}
