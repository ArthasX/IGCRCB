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
import com.deliverik.infogovernor.risk.model.RiskAuditIns;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCond;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditInsTB;

/**
 * 审计发起实体DAO实现
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("deprecation")
public class RiskAuditInsDAOImpl extends BaseHibernateDAOImpl<RiskAuditIns> implements RiskAuditInsDAO {

	/** RiskAuditIns DAO */
	protected RiskAuditInsDAO riskAuditInsDAO;
	/**
	 * 构造函数
	 */
	public RiskAuditInsDAOImpl(){
		super(RiskAuditInsTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RiskAuditIns> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("raiid"));
		List<RiskAuditIns> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param raiid 主键
	 * @return 检索结果
	 */
	public RiskAuditIns findByPK(Serializable raiid) {

		RiskAuditIns result = super.findByPK(raiid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskAuditInsSearchCond cond){
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
	public List<RiskAuditIns> findByCond(final RiskAuditInsSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("raiid"));
		List<RiskAuditIns> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskAuditInsSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if( StringUtils.isNotEmpty(cond.getRaicode())){
			c.add(Expression.eq("raicode", cond.getRaicode()));
		}
		if( cond.getRaid() != null && cond.getRaid() != 0){
			c.add(Expression.eq("raid", cond.getRaid()));
		}
		if( cond.getRaiid() != null && cond.getRaiid() != 0){
			c.add(Expression.eq("raiid", cond.getRaiid()));
		}
		if( StringUtils.isNotEmpty(cond.getRaistart())){
			c.add(Expression.ge("raistart", cond.getRaistart()));
		}
		if( StringUtils.isNotEmpty(cond.getRaiend())){
			c.add(Expression.le("raiend", cond.getRaiend()));
		}
		if( StringUtils.isNotEmpty(cond.getRaistatus())){
			c.add(Expression.eq("raistatus", cond.getRaistatus()));
		}
		return c;
	}

}
