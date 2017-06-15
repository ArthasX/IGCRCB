/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;

/**
 * 概述: 知识库查询表DAO接口
 * 功能描述：知识库查询表DAO接口
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
public interface KnowLedgeInfoDAO extends BaseHibernateDAO<KnowLedgeInfo> {

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final KnowledgeSearchCond cond);

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowLedgeInfo> findByCond(final KnowledgeSearchCond cond,
			final int start, final int count);
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowLedgeInfo> findByCondTime(final KnowledgeSearchCond cond, final int start, final int count);
	
	/**
	 * 检索个部门贡献知识数量
	 * @return 检索个部门贡献知识数量
	 */
	public List<KnowLedgeInfo> findKgmSummary();
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public int findByCondForCount(final KnowledgeSearchCond cond);
}
