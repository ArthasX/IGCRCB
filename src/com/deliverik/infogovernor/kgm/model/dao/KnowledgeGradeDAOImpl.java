/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeGradeSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeGradeTB;

/**
 * 
 * @Description:知识评分DAO实现
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("deprecation")
public class KnowledgeGradeDAOImpl extends BaseHibernateDAOImpl<KnowledgeGrade>
		implements KnowledgeGradeDAO {
	/**
	 * 构造函数
	 */
	public KnowledgeGradeDAOImpl() {
		super(KnowledgeGradeTB.class);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<KnowledgeGrade> findAll() {
		return null;
	}

	/**
	 * 主键检索处理
	 * 
	 * @param id
	 *            主键
	 * @return 检索结果
	 */
	public KnowledgeGrade findByPK(Serializable id) {
		KnowledgeGrade result = super.findByPK(id);
		if (result == null)
			return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final KnowledgeGradeSearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

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
			final int start, final int count) {
		 	DetachedCriteria c = getCriteria(cond);
		 	c.addOrder(Order.desc("kgtime"));
			List<KnowledgeGrade> ret = findByCriteria(c, start, count);
	       return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(KnowledgeGradeSearchCond cond) {
	       DetachedCriteria c = getDetachedCriteria();
	        //知识ID
			if(cond.getKnid()!=null){
				c.add(Expression.eq("knid", cond.getKnid()));
			}
		
	       return c;
	   }
}
