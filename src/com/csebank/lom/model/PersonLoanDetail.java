/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.user.model.entity.OrganizationTB;


/**
 * 
 *人员借款明细统计实体接口
 *
 */
public interface PersonLoanDetail {

	/**
	 * ID取得
	 * @return ID
	 */
	public String getId();
	
	/**
	 * 交易日期取得
	 * @return 交易日期
	 */
	public String getDate();

	/**
	 * 交易类型取得
	 * @return 交易类型
	 */
	public String getType();

	/**
	 * 金额取得
	 * @return 金额
	 */
	public BigDecimal getAmount();

	/**
	 * 发票金额取得
	 * @return 发票金额
	 */
	public BigDecimal getInvoiceamount();
	
	/**
	 * 用途取得
	 * @return 用途
	 */
	public String getComment();

	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getStatus();
	
	public String getLpduserorg();
	
	public OrganizationTB getOrganizationTB();
	
}
