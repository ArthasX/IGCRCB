/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.vo;

import com.csebank.items.model.OutStock;
import com.deliverik.framework.base.BaseVO;

/**
 * 仓库收益相关VO
 *
 */
@SuppressWarnings("serial")
public class ITEMS01692VO extends BaseVO {

	/** 出库信息 */
	protected OutStock outStock;
	
	/** 入库单价 */
	protected String inPrice;
	
	/** 出库单价 */
	protected String outPrice;
	
	/** 数量 */
	protected String count;
	
	/** 出库金额 */
	protected String countPrice;
	
	/** 收益 */
	protected String income;

	public OutStock getOutStock() {
		return outStock;
	}

	public void setOutStock(OutStock outStock) {
		this.outStock = outStock;
	}

	public String getInPrice() {
		return inPrice;
	}

	public void setInPrice(String inPrice) {
		this.inPrice = inPrice;
	}

	public String getOutPrice() {
		return outPrice;
	}

	public void setOutPrice(String outPrice) {
		this.outPrice = outPrice;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getCountPrice() {
		return countPrice;
	}

	public void setCountPrice(String countPrice) {
		this.countPrice = countPrice;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}
	
}
