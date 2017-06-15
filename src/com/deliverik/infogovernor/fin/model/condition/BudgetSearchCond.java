package com.deliverik.infogovernor.fin.model.condition;

/**
 * 
 */
public interface BudgetSearchCond {
	/**
	 * 
	 * @return
	 */
	public String getBtype();

	public String getBstatus();

	public String getBinittime();

	public String getBopentime();

	public String getBclosetime();

	public String getBtitle();
	
	public String getBtitle_q();

	public String getBtype_q();
	
	public String getByear_q();
	
	public String getPcode();

	public String getSelectMode();// 图形显示用

	public String getBstatus_q();

	public String getPquality();//项目性质
	
	public String getPstorecode();// 储备项目编号

	public String getPneeddispart();// 需求部门

	public String getPbuggetform();// 预算组成

	public String getRemark();// 备注

	public String getByear_before();//前年的年份
	
	public String getByear_now();//今年的年份
	
}
