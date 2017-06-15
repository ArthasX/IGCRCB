/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
 * 风险审计评估结果信息查询条件接口
 * @author lipeng@deliverik.com
 */
public interface RiskAuditResultSearchCond {
	
	/**
	 * 风险审计评估结果ID取得
	 * @return 风险审计评估结果ID
	 */
	public Integer getRarid();
	/**
	 * 风险审计发起ID取得
	 * @return 风险审计发起ID
	 */
	public Integer getRaiid();
	/**
	 * 风险审计项ID取得
	 * @return 风险审计项ID
	 */
	public Integer getRadid();
	/**
	 * 风险审计评估人ID取得
	 * @return 风险审计评估人ID
	 */
	public String getRaruserid();
	
	/**
	 * 风险审计项层次码取得
	 * @return 风险审计项层次码
	 */
	public String getRadcode();
}
