/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 预支汇总实体接口
 * 
 */
public interface AdvanceSummary extends BaseModel {

	/** 年度取得 */
	public String getAsyear();

	/** 月份取得 */
	public String getAsmonth();

	/** 上月余额取得 */
	public BigDecimal getAsprebalance();

	/** 本月预支金额取得 */
	public BigDecimal getAsadvancescost();

	/** 借款金额取得 */
	public BigDecimal getAsloan();

	/** 本月发票金额取得 */
	public BigDecimal getAsinvoice();

	/** 本月还款金额取得 */
	public BigDecimal getAspay();

	/** 本月余额取得 */
	public BigDecimal getAsbalance();

	/** 冻结金额取得 */
	public BigDecimal getAsfreeze();

}
