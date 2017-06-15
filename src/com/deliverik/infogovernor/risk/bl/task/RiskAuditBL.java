/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.RiskAudit;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditSearchCond;

/**
 * 
 * 审计信息业务逻辑接口
 * @author liupeng@deliverik.com
 *
 */
public interface RiskAuditBL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RiskAuditSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param raid 审计信息ID
	 * @return 审计信息
	 */
	public RiskAudit searchRiskAuditByKey(Integer raid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部审计信息信息
	 */
	public List<RiskAudit> searchRiskAuditAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskAudit> searchRiskAudit(RiskAuditSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param RiskAudit 登录数据
	 * @return 审计信息
	 */
	public RiskAudit registRiskAudit(RiskAudit riskAudit) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param raid 审计信息ID
	 * @return
	 */
	public void deleteRiskAudit(Integer raid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param riskAudit 变更数据
	 * @return 审计信息
	 */
	public RiskAudit updateRiskAudit(RiskAudit riskAudit) throws BLException;
	
	/**
	 * 版本下拉列表查询
	 * 
	 * @return 版本下拉列表
	 */
	public List<LabelValueBean> searchRiskAuditLabelInUse();
	
	/**
	 * 获取当前最大版本根标识
	 * @return 最大版本根标识
	 */
	
	public String getMaxRacode();

}
