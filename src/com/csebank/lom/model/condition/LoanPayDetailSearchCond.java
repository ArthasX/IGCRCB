/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 借还款明细查询接口
 *
 */
public interface LoanPayDetailSearchCond {
	
	/** 借款人取得 */
	public String getLpduser_q();
	
	/** 发票日期开始取得 */
	public String getLpdinvoicedate_from();
	
	/** 发票日期结束取得 */
	public String getLpdinvoicedate_to();
	
	/** 借款区分取得 */
	public String getLpdtype_q();
	
	/** 发票金额取得 */
	public String getLpdinvoiceamount_q();
	
	/** 状态取得 */
	public String getLpdstatus_q();
	
	/** 接待ID */
	public Integer getRid_q();
	
	/** 发票借款ID */
	public Integer getLdid_invoice();
	
	/**借款查询开始时间 */
	public String getTime_from();
	/**借款查询结束时间 */
	public String getTime_to();
	/**借款审批状态 */
	public String getSpType();
	
}
