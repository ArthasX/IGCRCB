/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.RiskAudit;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditSearchCond;

/**
 * 风险审计DAO接口
 * @author lipeng@deliverik.com
 */
public interface RiskAuditDAO extends BaseHibernateDAO<RiskAudit> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RiskAudit> findAll();

	/**
	 * 主键检索处理
	 * @param raid 主键
	 * @return 检索结果
	 */
	public RiskAudit findByPK(Serializable raid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskAuditSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskAudit> findByCond(final RiskAuditSearchCond cond, final int start, final int count);
	
	/**
	 * 获取当前最大版本根标识
	 * @return 最大版本根标识
	 */
	
	public String getMaxRacode();
}
