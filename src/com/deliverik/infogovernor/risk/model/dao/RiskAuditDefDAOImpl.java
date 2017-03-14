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
import com.deliverik.infogovernor.risk.model.RiskAuditDef;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefSearchCond;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditDefTB;

/**
 * 风险审计项DAO实现
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("deprecation")
public class RiskAuditDefDAOImpl extends BaseHibernateDAOImpl<RiskAuditDef> implements RiskAuditDefDAO {

	/**
	 * 构造函数
	 */
	public RiskAuditDefDAOImpl(){
		super(RiskAuditDefTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RiskAuditDef> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("radid"));
		List<RiskAuditDef> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param radid 主键
	 * @return 检索结果
	 */
	public RiskAuditDef findByPK(Serializable radid) {

		RiskAuditDef result = super.findByPK(radid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskAuditDefSearchCond cond){
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
	public List<RiskAuditDef> findByCond(final RiskAuditDefSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(!StringUtils.isEmpty(cond.getByLevelDesc())){
			c.addOrder(Order.desc("radlevel"));
		}else{
			c.addOrder(Order.asc("radcode"));
		}
		
		List<RiskAuditDef> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskAuditDefSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getRaid() != null && cond.getRaid() != 0){
			c.add(Expression.eq("raid", cond.getRaid()));
		}
		if( StringUtils.isNotEmpty(cond.getRadstatus())){
			c.add(Expression.eq("radstatus", cond.getRadstatus()));
		}
		if( !StringUtils.isEmpty(cond.getRadcode())){
			c.add(Expression.like("radcode", cond.getRadcode()+"%"));
		}
		if( !StringUtils.isEmpty(cond.getRadparcode_q())){
			c.add(Expression.eq("radparcode", cond.getRadparcode_q()));
		}
		if( !StringUtils.isEmpty(cond.getRadparcode())){
			c.add(Expression.like("radparcode", cond.getRadparcode()+"%"));
		}
		if( !StringUtils.isEmpty(cond.getRadcode_q())){
			c.add(Expression.eq("radcode", cond.getRadcode_q()));
		}
		if( StringUtils.isNotEmpty(cond.getRaversion())){
			c.add(Expression.eq("raversion", cond.getRaversion()));
		}
		
		
		return c;
	}



}
