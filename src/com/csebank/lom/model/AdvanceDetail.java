/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;


/**
 * 
 * 预支明细统计实体接口
 *
 */
public interface AdvanceDetail {
	
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
	 * 交易时间取得
	 * @return 交易时间
	 */
	public String getTime();

	/**
	 * 交易类型取得
	 * @return 交易类型
	 */
	public String getType();

	/**
	 * 人员取得
	 * @return 人员
	 */
	public String getUsername();

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
	 * 库存金额取得
	 * @return 库存金额
	 */
	public BigDecimal getStockamount();

	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getStatus();
	
}
