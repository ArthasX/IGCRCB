package com.deliverik.infogovernor.soc.model.condition;



/**
 * 资产信息查询条件接口
 * 
 */
public interface SocRelationSearchCond {
	
	/**
	 * 资产label
	 * @return 资产label
	 */
	public String getSreilabel();

	
	/**
	 * 关联资产label
	 * @return 关联资产label
	 */
	public String getSrpareilabel();

	/**
	 * 关联资产coding
	 * @return 关联资产coding
	 */
	public String getSresycoding();

	/**
	 * 关联资产类型名称
	 * @return 关联资产类型名称
	 */
	public String getSrename();
	
	/**
	 * 预留1(保存版本号)
	 * @return 预留1(保存版本号)
	 */
	public String getSrkey1();
	
	/**
	 * 版本号
	 * @return 版本号
	 */
	public Integer getVersion();
	
}
