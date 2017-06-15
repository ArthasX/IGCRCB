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
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefResultVWSearchCond;

/**
 * 审计项和相关审计人外联视图接口
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("deprecation")
public class RiskAuditDefResultVWDAOImpl extends BaseHibernateDAOImpl<RiskAuditDefResultVWInfo> implements RiskAuditDefResultVWDAO {

	/**
	 * 构造函数
	 */
	public RiskAuditDefResultVWDAOImpl(){
		super(RiskAuditDefResultVWInfo.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RiskAuditDefResultVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("radcode"));
		List<RiskAuditDefResultVWInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param acrid 主键
	 * @return 检索结果
	 */
	public RiskAuditDefResultVWInfo findByPK(Serializable acrid) {

		RiskAuditDefResultVWInfo result = super.findByPK(acrid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskAuditDefResultVWSearchCond cond){
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
	public List<RiskAuditDefResultVWInfo> findByCond(final RiskAuditDefResultVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("radcode"));
		List<RiskAuditDefResultVWInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskAuditDefResultVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getRaiid() != null && cond.getRaiid() != 0){
			c.add(Expression.eq("raiid", cond.getRaiid()));
		}
		if( StringUtils.isNotEmpty(cond.getRadstatus())){
			c.add(Expression.eq("radstatus", cond.getRadstatus()));
		}
		return c;
	}

	/**
	 * 获取审计项最大级次
	 * @return 审计项最大级次
	 */
	
	@SuppressWarnings("unchecked")
	public String getMaxRadlevel(final RiskAuditDefResultVWSearchCond cond) {
		String sql =  "select max(radrVW.radlevel) from RiskAuditDefResultVW radrVW where raiid = :raiid and radstatus =:radstatus";
		NamedParamMap p = getNamedParamMap();
		p.setInteger("raiid", cond.getRaiid());
		p.setString("radstatus", cond.getRadstatus());
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
	}

}
