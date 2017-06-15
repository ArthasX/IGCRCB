/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefResultVWSearchCond;

/**
 * 审计项和相关审计人外联视图接口
 * @author lipeng@deliverik.com
 */
public interface RiskAuditDefResultVWDAO extends BaseHibernateDAO<RiskAuditDefResultVWInfo> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RiskAuditDefResultVWInfo> findAll();

	/**
	 * 主键检索处理
	 * @param acrid 主键
	 * @return 检索结果
	 */
	public RiskAuditDefResultVWInfo findByPK(Serializable acrid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskAuditDefResultVWSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskAuditDefResultVWInfo> findByCond(final RiskAuditDefResultVWSearchCond cond, final int start, final int count);
	
	/**
	 * 获取审计项最大级次
	 * @return 审计项最大级次
	 */
	public String getMaxRadlevel(final RiskAuditDefResultVWSearchCond cond);
	
	
}
