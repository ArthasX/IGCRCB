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
import com.deliverik.infogovernor.risk.model.RiskAudit;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditSearchCond;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditTB;

/**
 * 风险审计DAO实现
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("deprecation")
public class RiskAuditDAOImpl extends BaseHibernateDAOImpl<RiskAudit> implements RiskAuditDAO {

	/**
	 * 构造函数
	 */
	public RiskAuditDAOImpl(){
		super(RiskAuditTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RiskAudit> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("raid"));
		List<RiskAudit> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param raid 主键
	 * @return 检索结果
	 */
	public RiskAudit findByPK(Serializable raid) {

		RiskAudit result = super.findByPK(raid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskAuditSearchCond cond){
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
	public List<RiskAudit> findByCond(final RiskAuditSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("raid"));
		List<RiskAudit> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskAuditSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getRaid() != null && cond.getRaid() != 0){
			c.add(Expression.eq("raid", cond.getRaid()));
		}
		if( StringUtils.isNotEmpty(cond.getRaversion())){
			c.add(Expression.eq("raversion", cond.getRaversion()));
		}
		if( StringUtils.isNotEmpty(cond.getRastatus())){
			c.add(Expression.eq("rastatus", cond.getRastatus()));
		}
		return c;
	}

	/**
	 * 获取当前最大版本根标识
	 * @return 最大版本根标识
	 */
	
	@SuppressWarnings("unchecked")
	public String getMaxRacode() {
		String sql =  "select max(ra.racode) from RiskAuditTB ra";
		NamedParamMap p = getNamedParamMap();
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
	}

}
