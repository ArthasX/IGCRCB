/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.user.model.entity.OrganizationTB;


/**
 * 
 * 预支人员统计实体接口
 *
 */
public interface PersonLoanSummary {

	/** 借款人取得 */
	public String getLpduser();

	/** 借款金额取得 */
	public BigDecimal getLoanamount();
	
	/** 发票金额取得 */
	public BigDecimal getInvoiceamount();
	
	/** 还款现金取得 */
	public BigDecimal getPayamount();
	
	public String getLpduserorg();
	
	public OrganizationTB getOrganizationTB();
	
}
