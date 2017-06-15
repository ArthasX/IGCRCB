/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.RiskAuditResult;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditResultSearchCond;

/**
 * 
 * 审计结果实体业务逻辑接口
 * @author liupeng@deliverik.com
 *
 */
public interface RiskAuditResultBL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RiskAuditResultSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param rarid 审计结果实体ID
	 * @return 审计结果实体
	 */
	public RiskAuditResult searchRiskAuditResultByKey(Integer rarid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部审计结果实体信息
	 */
	public List<RiskAuditResult> searchRiskAuditResultAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskAuditResult> searchRiskAuditResult(RiskAuditResultSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param RiskAuditResult 登录数据
	 * @return 审计结果实体
	 */
	public RiskAuditResult registRiskAuditResult(RiskAuditResult riskAuditResult) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param rarid 审计结果实体ID
	 * @return
	 */
	public void deleteRiskAuditResult(Integer rarid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param riskAuditResult 变更数据
	 * @return 审计结果实体
	 */
	public RiskAuditResult updateRiskAuditResult(RiskAuditResult riskAuditResult) throws BLException;

}
