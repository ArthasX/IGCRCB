/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.AuditCheckRelation;
import com.deliverik.infogovernor.risk.model.condition.AuditCheckRelationSearchCond;
import com.deliverik.infogovernor.risk.model.entity.AuditCheckRelationTB;

/**
 * 风险审计与风险检查关系DAO实现
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("deprecation")
public class AuditCheckRelationDAOImpl extends BaseHibernateDAOImpl<AuditCheckRelation> implements AuditCheckRelationDAO {

	/**
	 * 构造函数
	 */
	public AuditCheckRelationDAOImpl(){
		super(AuditCheckRelationTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<AuditCheckRelation> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("acrid"));
		List<AuditCheckRelation> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param acrid 主键
	 * @return 检索结果
	 */
	public AuditCheckRelation findByPK(Serializable acrid) {

		AuditCheckRelation result = super.findByPK(acrid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AuditCheckRelationSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AuditCheckRelation> findByCond(final AuditCheckRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("acrid"));
		List<AuditCheckRelation> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(AuditCheckRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getRadid() != null && cond.getRadid() != 0){
			c.add(Expression.eq("radid", cond.getRadid()));
		}
		if(cond.getRcid() != null && cond.getRcid() != 0){
			c.add(Expression.eq("rcid", cond.getRcid()));
		}
		return c;
	}



}
