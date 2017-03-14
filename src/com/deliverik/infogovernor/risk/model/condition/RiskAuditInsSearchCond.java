/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
 * 风险审计信息查询条件接口
 * @author lipeng@deliverik.com
 */
public interface RiskAuditInsSearchCond {
	
	/**
	 * 风险审计ID取得
	 * @return 风险审计ID
	 */
	public Integer getRaid();
	
	/**
	 * 风险审计发起ID取得
	 * @return 风险审计发起ID
	 */
	public Integer getRaiid();
	
	/**
	 * 风险审计发起编号取得
	 * @return 风险审计发起编号
	 */
	public String getRaicode();
	
	/**
	 * 风险审计发起创建日期取得
	 * @return 风险审计发起创建日期
	 */
	public String getRaistart();

	/**
	 * 风险审计发起结束日期取得
	 * @return 风险审计发起结束日期
	 */
	public String getRaiend();
	
	/**
	 * 风险审计发起状态取得
	 * @return 风险审计发起状态
	 */
	public String getRaistatus();
}
