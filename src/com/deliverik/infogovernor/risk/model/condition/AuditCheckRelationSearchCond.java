package com.deliverik.infogovernor.risk.model.condition;



/**
 * 风险检查与风险审计项关系信息查询条件接口
 * 
 */
public interface AuditCheckRelationSearchCond {
	/**
	 * 风险检查与风险审计关系ID
	 * @return 风险检查与风险审计关系ID
	 */
	public Integer getAcrid();

	
	/**
	 * 风险检查ID
	 * @return 风险检查ID
	 */
	public Integer getRcid();

	/**
	 * 风险审计项ID
	 * @return 风险审计项ID
	 */
	public Integer getRadid();

	/**
	 * 风险审计项编码
	 * @return 风险审计项编码
	 */
	public String getRadcode();
	
	
}
