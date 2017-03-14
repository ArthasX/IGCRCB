package com.deliverik.infogovernor.risk.model.condition;



/**
 * 风险检查结果实体查询条件接口
 * 
 */
public interface RiskCheckResultSearchCond {
	/**
	 * 风险检查结果id
	 * @return 风险检查结果id
	 */
	public Integer getRcrid();

	/**
	 * 风险检查id
	 * @return 风险检查id
	 */
	public Integer getRcid();

	/**
	 * 风险检查计划检查时间
	 * @return 风险检查计划检查时间
	 */
	public String getRcrplandate();

	/**
	 * 风险检查实际检查时间
	 * @return 风险检查实际检查时间
	 */
	public String getRcrrealtime();

	/**
	 * 风险检查结果提交人id
	 * @return 风险检查结果提交人id
	 */
	public String getRcruserid();

	/**
	 * 风险检查结果提交人姓名
	 * @return 风险检查结果提交人姓名
	 */
	public String getRcrusername();

	/**
	 * 风险检查结果
	 * @return 风险检查结果
	 */
	public String getRcrresult();

	/**
	 * 风险检查结果说明
	 * @return 风险检查结果说明
	 */
	public String getRcrcomment();
	
	/**
	 * 风险检查项类别取得
	 * @return 风险检查项类别
	 */
	public String getRccategory();
	
	public String getRcruserid_isNull();
	
	public String getStartdate();

	public String getEnddate();
	
	public String getRcname();
	
	public String getRcusername_like();
	
	public String getRcname_like();
	
	public String getNtime_from();
	
	public String getNtime_to();
	
	/**
	 * 未检查工作标识取得
	 * @return 未检查工作标识
	 */
	public String getChtype();
	
	/**
	 * 风险检查实际检查时间取得
	 * @return 风险检查实际检查时间
	 */
	public String getRcrrealtime_isNull();
	
	/**
	 * 风险检查状态取得
	 * @return 风险检查状态
	 */
	public String getRcrstatic();
	
	/**
	 * 风险检查可检查角色取得
	 * @return 风险检查可检查角色
	 */
	public Integer[] getRcroleid();
	
	/**
	 * 风险检查不包含的责任人ID取得
	 * @return 风险检查不包含的责任人ID
	 */
	public String getRcuserid_ne();

	/**
	 * 重要程度获取
	 * 
	 * @return 重要程度
	 */
	public String getRctype_eq() ;
	
	/**
	 * 风险检查责任人ID取得
	 * @return 风险检查责任人ID
	 */
	public String getRcuserid();
	
	/**
	 * 风险检查相关人员获取
	 * @return 风险检查相关人员
	 */
	public String getRcrelateduser();
	
	/**
	 * 风险检查项类型
	 * @return 风险检查项类型
	 */
	public String getRcclass();
	public String getYear();

	public String getRcrplandate_from();

	public String getRcrplandate_to();
	
	
	/**
	 * 风险检查实际检查时间取得
	 * @return rcrrealtime_like 风险检查实际检查时间
	 */
	public String getRcrrealtime_like();
	
	public Integer[] getRcrid_in();
	
	/**
	 * 检查方式取得
	 * @return rcrtestmode 检查方式
	 */
	public String getRcrtestmode();
	public String getRcusername();
	public String getCiiop();
	public String getRcapprovetime();
}
