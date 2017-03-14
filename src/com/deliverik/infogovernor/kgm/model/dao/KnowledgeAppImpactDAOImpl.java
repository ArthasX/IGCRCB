/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.model.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import java.io.Serializable;
import java.util.List;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeAppImpactSearchCond;
import com.deliverik.infogovernor.kgm.model.dao.KnowledgeAppImpactDAO;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeAppImpactTB;

/**
 * 
 * @Description:知识业务系统关联DAO实现
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("deprecation")
public class KnowledgeAppImpactDAOImpl extends
		BaseHibernateDAOImpl<KnowledgeAppImpact> implements
		KnowledgeAppImpactDAO {
	/**
	 * 构造函数
	 */
	public KnowledgeAppImpactDAOImpl() {
		super(KnowledgeAppImpactTB.class);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<KnowledgeAppImpact> findAll() {
		return null;
	}

	/**
	 * 主键检索处理
	 * 
	 * @param id 主键
	 * @return 检索结果
	 */
	public KnowledgeAppImpact findByPK(Serializable id) {
		KnowledgeAppImpact result = super.findByPK(id);
		if (result == null)
			return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final KnowledgeAppImpactSearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

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
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		List<KnowledgeAppImpact> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(KnowledgeAppImpactSearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		//知识ID
		if(cond.getKnid() != null && cond.getKnid() > 0){
			c.add(Expression.eq("knid", cond.getKnid()));
		}
		//知识版本
		if(cond.getKnversion() != null && cond.getKnversion() > 0){
			c.add(Expression.eq("knversion", cond.getKnversion()));
		}
		return c;
	}
}
