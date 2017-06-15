/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.RiskAuditIns;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCond;

/**
 * 审计发起实体DAO接口
 * @author lipeng@deliverik.com
 */
public interface RiskAuditInsDAO extends BaseHibernateDAO<RiskAuditIns> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RiskAuditIns> findAll();

	/**
	 * 主键检索处理
	 * @param raiid 主键
	 * @return 检索结果
	 */
	public RiskAuditIns findByPK(Serializable raiid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskAuditInsSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskAuditIns> findByCond(final RiskAuditInsSearchCond cond, final int start, final int count);

	
}
