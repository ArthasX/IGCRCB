/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.items.vo;

import com.csebank.items.model.OutStockDetail;
import com.deliverik.framework.base.BaseVO;

/**
 * ��Ʒ�������VO
 *
 */
@SuppressWarnings("serial")
public class ITEMS01712VO extends BaseVO {

	/** ������ϸ��Ϣ */
	protected OutStockDetail outStockDetail;
	
	/** �������� */
	protected String date;
	
	/** ��ⵥ�� */
	protected String inPrice;
	
	/** ���ⵥ�� */
	protected String outPrice;
	
	/** ����� */
	protected String inCountPrice;
	
	/** ������ */
	protected String outCountPrice;
	
	/** ���� */
	protected String income;
	
	/** ������� */
	protected String stockNum;
	
	/** ������� */
	protected String inNum;
	
	/** �������� */
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
