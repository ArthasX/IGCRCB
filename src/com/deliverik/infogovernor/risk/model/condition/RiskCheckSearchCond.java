package com.deliverik.infogovernor.risk.model.condition;



/**
 * 资产信息查询条件接口
 * 
 */
public interface RiskCheckSearchCond {
	/**
	 * 风险检查id
	 * @return 风险检查id
	 */
	public Integer getRcid(); 
	
	public Integer[] getRcid_in(); 
	
	/**
	 * 风险检查名称
	 * @return 风险检查名称
	 */
	public String getRcname();

	/**
	 * 风险检查描述
	 * @return 风险检查描述
	 */
	public String getRcdesc();

	/**
	 * 风险检查重要度
	 * @return 风险检查重要度
	 */
	public String getRctype();

	/**
	 * 风险检查状态
	 * @return 风险检查状态
	 */
	public String getRcstatus(); 

	/**
	 * 风险检查起始时间
	 * @return 风险检查起始时间
	 */
	public String getRcstartdate();

	/**
	 * 风险检查结束时间
	 * @return 风险检查结束时间
	 */
	public String getRcenddate();

	/**
	 * 风险检查频率
	 * @return 风险检查频率
	 */
	public String getRcfrequency();

	/**
	 * 风险检查责任人id
	 * @return 风险检查责任人id
	 */
	public String getRcuserid();

	/**
	 * 风险检查责任人姓名
	 * @return 风险检查责任人姓名
	 */
	public String getRcusername();

	/**
	 * 风险检查责任组角色id
	 * @return 风险检查责任组角色id
	 */
	public String getRcroleid();

	/**
	 * 风险检查责任组角色名
	 * @return 风险检查责任组角色名
	 */
	public String getRcrolename();

	/**
	 * 风险检查相关资产id
	 * @return 风险检查相关资产id
	 */
	public Integer getRcasset();

	/**
	 * 风险检查附件id
	 * @return 风险检查附件id
	 */
	public String getRcattch();

	/**
	 * 风险检查选项
	 * @return 风险检查选项
	 */
	public String getRcoption();
	
	/**
	 * 风险检查名称查询条件
	 * @return 风险检查名称查询条件
	 */
	public String getRcname_q();
	
	/**
	 * 风险检查项类别取得
	 * @return 风险检查项类别
	 */
	public String getRccategory();
	
	/**
	 * 风险检查项类别名称取得
	 * @return 风险检查项类别名称
	 */
	public String getRccategoryname();
	
	/**
	 * 风险检查登记时间取得
	 * @return 风险检查登记时间
	 */
	public String getRccreatetime();
	
	/**
	 * 风险检查审批时间取得
	 * @return 风险检查审批时间
	 */
	public String getRcapprovetime();
	
	/**
	 * 风险检查审批人取得
	 * @return 风险检查审批人
	 */
	public String getRcapprover();
	
	
	/**
	 * 风险检查类型取得
	 * @return 风险检查类型人
	 */
	public String getRcclass();
	public String getYearMonth() ;
	public String getYear();
	public String getMonth();
	public String getEndDate() ;
	public String getStartDate() ;
	
	/**
	 * 创建时间取得
	 * @return rcCreateTime_like 创建时间
	 */
	public String getRcCreateTime_like();
}
