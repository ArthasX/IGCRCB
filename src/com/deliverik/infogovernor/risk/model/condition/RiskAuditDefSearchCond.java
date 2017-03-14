/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
 * 风险审计项信息查询条件接口
 * @author lipeng@deliverik.com
 */
public interface RiskAuditDefSearchCond {
	/**
	 * 风险审计版本id取得
	 * 
	 * @return 风险审计版本id
	 */
	public Integer getRaid();
	
	/**
	 * 审计项状态取得
	 * 
	 * @return 审计项状态
	 */
	public String getRadstatus();
	
	/**
	 * 风险审计项层次码取得
	 * @return 风险审计项层次码
	 */
	public String getRadcode();
	/**
	 * 风险审计项上级层次码取得
	 * @return 风险审计项上级层次码
	 */
	public String getRadparcode();
	
	/**
	 * 风险审计项上级层次码查询取得
	 * @return 风险审计项上级层次码查询
	 */
	public String getRadparcode_q();
	

	/**
	 * 风险审计项版本取得
	 * @return 风险审计项版本
	 */
	public String getRaversion();
	
	/**
	 * 按照层次降序排列取得
	 * @return 按照层次降序排列
	 */
	public String getByLevelDesc();
	
	/**
	 * 风险审计项层次码取得
	 * @return 风险审计项层次码
	 */
	public String getRadcode_q();
}
