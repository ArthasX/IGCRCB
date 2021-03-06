/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.RiskAuditIns;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCond;

/**
 * 
 * 审计发起信息业务逻辑接口
 * @author liupeng@deliverik.com
 *
 */
public interface RiskAuditInsBL extends BaseBL{
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(RiskAuditInsSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param raiid 审计发起信息ID
	 * @return 审计发起信息
	 */
	public RiskAuditIns searchRiskAuditInsByKey(Integer raiid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部审计发起信息信息
	 */
	public List<RiskAuditIns> searchRiskAuditInsAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskAuditIns> searchRiskAuditIns(RiskAuditInsSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param RiskAuditIns 登录数据
	 * @return 审计发起信息
	 */
	public RiskAuditIns registRiskAuditIns(RiskAuditIns riskAuditIns) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param raiid 审计发起信息ID
	 * @return
	 */
	public void deleteRiskAuditIns(Integer raiid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param riskAuditIns 变更数据
	 * @return 审计发起信息
	 */
	public RiskAuditIns updateRiskAuditIns(RiskAuditIns riskAuditIns) throws BLException;
	
	
	/**
	 * 版本下拉列表查询
	 * 
	 * @return 版本下拉列表
	 */
	public List<LabelValueBean> searchRiskAuditInsLabelInUse() ;

}
