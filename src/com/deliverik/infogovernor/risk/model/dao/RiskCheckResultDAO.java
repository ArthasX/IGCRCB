/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCond;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCondImpl;

/**
 * 风险检查结果DAO接口
 */
public interface RiskCheckResultDAO extends BaseHibernateDAO<RiskCheckResult> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RiskCheckResult> findAll();

	/**
	 * 主键检索处理
	 * @param rcrid 主键
	 * @return 检索结果
	 */
	public RiskCheckResult findByPK(Serializable rcrid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskCheckResultSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheckResult> findByCond(final RiskCheckResultSearchCond cond, final int start, final int count);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheckResult> findResultByCond(final RiskCheckResultSearchCond cond, final int start, final int count);
	
	/**
	 * 首页检查工作查询
	 * @param userid 查询用户ID
	 * @param desc 是否按时间倒序排列
	 * @param group 是否查询相关检查工作信息(true:是;flase:否) 
	 * @return 检索结果列表
	 */
	public List<RiskCheckResult> riskCheckResultGoup(final String userid, final boolean desc, final boolean group);
	
	/**
	 * 条件查询
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheckResult> sel(final RiskCheckResultSearchCondImpl cond, final int start, final int count);
	public List<RiskCheckResult>  dbmrcrsel(String year);
	public List<RiskCheckResult>  getRiskCheckResult(final RiskCheckResultSearchCond cond);
	
	/**
	 * 条件检索结果(百分比)件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCountForRate(final RiskCheckResultSearchCond cond);
}
