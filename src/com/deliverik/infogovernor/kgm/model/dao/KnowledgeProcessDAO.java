/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeProcessSearchCond;

/**
 * 概述: 知识库查询信息DAO接口
 * 功能描述：知识库查询信息DAO接口
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
public interface KnowledgeProcessDAO extends BaseHibernateDAO<KnowledgeProcess> {
	
	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<KnowledgeProcess> findAll();

	/**
	 * 主键检索处理
	 * 
	 * @param kpid主键
	 * @return 检索结果
	 */
	public KnowledgeProcess findByPK(Serializable kpid);

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final KnowledgeProcessSearchCond cond);

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> findByCond(
			final KnowledgeProcessSearchCond cond, final int start,
			final int count);
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowledgeProcess> findByCond_KnowledgeProcess(
			final KnowledgeProcessSearchCond cond, final int start,
			final int count);
}
