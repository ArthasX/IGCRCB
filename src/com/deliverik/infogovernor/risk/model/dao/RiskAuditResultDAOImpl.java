/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.RiskAuditResult;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditResultSearchCond;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditResultTB;

/**
 * 风险审计结果DAO实现
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("deprecation")
public class RiskAuditResultDAOImpl extends BaseHibernateDAOImpl<RiskAuditResult> implements RiskAuditResultDAO {

	/**
	 * 构造函数
	 */
	public RiskAuditResultDAOImpl(){
		super(RiskAuditResultTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RiskAuditResult> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rarid"));
		List<RiskAuditResult> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param rarid 主键
	 * @return 检索结果
	 */
	public RiskAuditResult findByPK(Serializable rarid) {

		RiskAuditResult result = super.findByPK(rarid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskAuditResultSearchCond cond){
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
	public List<RiskAuditResult> findByCond(final RiskAuditResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rarid"));
		List<RiskAuditResult> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskAuditResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getRaiid() != null && cond.getRaiid() != 0){
			c.add(Expression.eq("raiid", cond.getRaiid()));
		}
		if(cond.getRarid() != null && cond.getRarid() != 0){
			c.add(Expression.eq("rarid", cond.getRarid()));
		}
		if(cond.getRadid() != null && cond.getRadid() != 0){
			c.add(Expression.eq("radid", cond.getRadid()));
		}
		if( StringUtils.isNotEmpty(cond.getRaruserid())){
			c.add(Expression.eq("raruserid", cond.getRaruserid()));
		}
		if( !StringUtils.isEmpty(cond.getRadcode())){
			c.add(Expression.like("radcode", cond.getRadcode()+"%"));
		}
		return c;
	}



}
