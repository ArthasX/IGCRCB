package com.csebank.lom.model.condition;

public interface InvoiceInfoSearchCond {
	
	/**
	 * 发票类型
	 */
	public String getItype();
	
	/**
	 * 开票查询时间开始
	 */
	public String getIdate_from();
	
	/**
	 * 开票查询时间结束
	 */
	public String getIdate_to();
	
	/**
	 * 申请部门层次码
	 */
	public String getIreqemp();
	
	/**
	 * 申请人ID
	 */
	public String getIrequser();
	
	/**
	 * 发票金额
	 */
	public String getIamount();
	
	/**
	 * 状态
	 */
	public String getIstatus();
	
	/**
	 * 按年统计
	 */
	public String getIyear();
	
	/**  */
	public String getIreqempid();
	
	/** 申请人姓名 */
	public String getIrequsername();
	
	/** 资产项所属机构 */
	public String getEiorgsyscoding();

}
