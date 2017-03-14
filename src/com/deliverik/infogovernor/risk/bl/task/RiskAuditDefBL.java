/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefSearchCond;

/**
 * 
 * 审计项信息业务逻辑接口
 * @author liupeng@deliverik.com
 *
 */
public interface RiskAuditDefBL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RiskAuditDefSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param radid 审计项信息ID
	 * @return 审计项信息
	 */
	public RiskAuditDef searchRiskAuditDefByKey(Integer radid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部审计项信息信息
	 */
	public List<RiskAuditDef> searchRiskAuditDefAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskAuditDef> searchRiskAuditDef(RiskAuditDefSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param RiskAuditDef 登录数据
	 * @return 审计项信息
	 */
	public RiskAuditDef registRiskAuditDef(RiskAuditDef riskAuditDef) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param radid 审计项信息ID
	 * @return
	 */
	public void deleteRiskAuditDef(Integer radid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param riskAuditDef 变更数据
	 * @return 审计项信息
	 */
	public RiskAuditDef updateRiskAuditDef(RiskAuditDef riskAuditDef) throws BLException;

}
