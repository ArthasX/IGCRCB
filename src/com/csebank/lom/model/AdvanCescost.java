/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 预支费用实体接口
 *
 */
public interface AdvanCescost extends BaseModel {

	/** 预支费用ID取得 */
	public Integer getAcid();
	
	/** 预支金额取得 */
	public BigDecimal getAcamount();
	
	/** 计财记帐日期取得 */
	public String getAcdate();
	
	/** 预支方式取得 */
	public String getActype();
	
	/** 支票号取得 */
	public String getAcchequenum();
	
	/** 预支审批号取得 */
	public String getAcserial();
	
	/** 预支主要用途说明取得 */
	public String getAccomment();
	
	/** 预支状态取得 */
	public String getAcstatus();
	
	/** 还款现金金额取得 */
	public BigDecimal getAcfreezeamount();
	
	/** 还款发票金额取得 */
	public BigDecimal getAcinvoiceamount();
	
	/** 库存金额取得 */
	public BigDecimal getAcstockamount();
	
	/** 预支冲抵日期取得 */
	public String getAccreditdate();
	
	/** 登记人ID取得 */
	public String getAcuserid();
	
	/** 登记人姓名取得 */
	public String getAcusername();
	
	/** 预支登记日期取得 */
	public String getAcinsdate();
	
	/** 预支登记时间取得 */
	public String getAcinstime();
	
}
