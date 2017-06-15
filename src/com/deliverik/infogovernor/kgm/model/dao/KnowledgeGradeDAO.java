/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeGradeSearchCond;

/**
 * 
 * @Description:知识评分DAO接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeGradeDAO extends BaseHibernateDAO<KnowledgeGrade> {
	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<KnowledgeGrade> findAll();

	/**
	 * 主键检索处理
	 * 
	 * @param id
	 *            主键
	 * @return 检索结果
	 */
	public KnowledgeGrade findByPK(Serializable id);

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final KnowledgeGradeSearchCond cond);

	/**
	 * 条件检索处理
	 * 
	 * @param cond
	 *            检索条件
	 * @param start
	 *            检索记录起始行号
	 * @param count
	 *            检索记录件数
	 * @return 检索结果列表
	 */
	public List<KnowledgeGrade> findByCond(final KnowledgeGradeSearchCond cond,
			final int start, final int count);
}
