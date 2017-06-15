/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.util.List;
import java.io.Serializable;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeAppImpactSearchCond;
import com.deliverik.infogovernor.kgm.model.dao.KnowledgeAppImpactDAO;

/**
 * 
 * @Description:知识业务系统关联DAO接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeAppImpactDAO extends BaseHibernateDAO<KnowledgeAppImpact> {
	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<KnowledgeAppImpact> findAll();

	/**
	 * 主键检索处理
	 * 
	 * @param id 主键
	 * @return 检索结果
	 */
	public KnowledgeAppImpact findByPK(Serializable id);

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final KnowledgeAppImpactSearchCond cond);

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowledgeAppImpact> findByCond(
			final KnowledgeAppImpactSearchCond cond, final int start,
			final int count);
}
