/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * 借还款明细实体接口
 * 
 */
public interface LoanPayDetail extends BaseModel {

	/** 借还款明细ID取得 */
	public Integer getLpdid();

	/** 借还款区分取得 */
	public String getLpdtype();

	/** 借还款人取得 */
	public String getLpduser();

	/** 借还款日期取得 */
	public String getLpddate();

	/** 借还款金额取得 */
	public BigDecimal getLpdamount();

	/** 用途取得 */
	public String getLpdcomment();

	/** 状态取得 */
	public String getLpdstatus();

	/** 审批人ID取得 */
	public String getLpdpersion();

	/** 审批人姓名取得 */
	public String getLpdpersionname();

	/** 发票日期取得 */
	public String getLpdinvoicedate();

	/** 发票号取得 */
	public String getLpdinvoicenum();

	/** 发票签发单位取得 */
	public String getLpdinvoicecor();

	/** 发票金额取得 */
	public BigDecimal getLpdinvoiceamount();

	/** 实际用途说明取得 */
	public String getLpdinvoicecomment();

	/** 借款ID取得 */
	public Integer getLdid();
	
	/** 接待管理ID */
	public Integer getRid();
	
	/** 预支费用ID取得 */
	public Integer getAcid();
	
	/**库存金额取得*/
	public BigDecimal getLpdstockamount();
	
	/** 借款人机构取得 */
	public String getLpduserorg();
	
	/** 机构 */
	public OrganizationTB getOrganizationTB();
	
	/** 实际发票金额 */
	public BigDecimal getLpdactinvoice();
	
	/** 实际还款人 */
	public String getLpdactuser();
	
	/** 借还款时间取得 */
	public String getLpdtime();

}
