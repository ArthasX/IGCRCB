/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
 * 风险审计信息查询条件接口
 * @author lipeng@deliverik.com
 */
public interface RiskAuditSearchCond {
	
	/**
	 * 风险审计版本id取得
	 * 
	 * @return 风险审计版本id
	 */
	public Integer getRaid();
	
	/**
	 * 风险审计版本取得
	 * 
	 * @return 风险审计版本
	 */
	public String getRaversion();
	
	/**
	 * 风险审计状态取得
	 * 
	 * @return 风险审计状态
	 */
	public String getRastatus();
	
}
