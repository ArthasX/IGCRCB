/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.vo;

import com.csebank.items.model.OutStockDetail;
import com.deliverik.framework.base.BaseVO;

/**
 * 物品收益相关VO
 *
 */
@SuppressWarnings("serial")
public class ITEMS01712VO extends BaseVO {

	/** 出库明细信息 */
	protected OutStockDetail outStockDetail;
	
	/** 交易日期 */
	protected String date;
	
	/** 入库单价 */
	protected String inPrice;
	
	/** 出库单价 */
	protected String outPrice;
	
	/** 入库金额 */
	protected String inCountPrice;
	
	/** 出库金额 */
	protected String outCountPrice;
	
	/** 收益 */
	protected String income;
	
	/** 库存数量 */
	protected String stockNum;
	
	/** 入库数量 */
	protected String inNum;
	
	/** 出库数量 */
	protected String outNum;

	public OutStockDetail getOutStockDetail() {
		return outStockDetail;
	}

	public void setOutStockDetail(OutStockDetail outStockDetail) {
		this.outStockDetail = outStockDetail;
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

	public String getInCountPrice() {
		return inCountPrice;
	}

	public void setInCountPrice(String inCountPrice) {
		this.inCountPrice = inCountPrice;
	}

	public String getOutCountPrice() {
		return outCountPrice;
	}

	public void setOutCountPrice(String outCountPrice) {
		this.outCountPrice = outCountPrice;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getStockNum() {
		return stockNum;
	}

	public void setStockNum(String stockNum) {
		this.stockNum = stockNum;
	}

	public String getInNum() {
		return inNum;
	}

	public void setInNum(String inNum) {
		this.inNum = inNum;
	}

	public String getOutNum() {
		return outNum;
	}

	public void setOutNum(String outNum) {
		this.outNum = outNum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
