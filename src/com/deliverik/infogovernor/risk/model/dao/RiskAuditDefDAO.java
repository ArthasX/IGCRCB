/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefSearchCond;

/**
 * 风险审计项DAO接口
 * @author lipeng@deliverik.com
 */
public interface RiskAuditDefDAO extends BaseHibernateDAO<RiskAuditDef> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RiskAuditDef> findAll();

	/**
	 * 主键检索处理
	 * @param radid 主键
	 * @return 检索结果
	 */
	public RiskAuditDef findByPK(Serializable radid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskAuditDefSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskAuditDef> findByCond(final RiskAuditDefSearchCond cond, final int start, final int count);
	
	
}
