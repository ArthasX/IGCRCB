/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.items.vo;

import com.csebank.items.model.OutStock;
import com.deliverik.framework.base.BaseVO;

/**
 * �ֿ��������VO
 *
 */
@SuppressWarnings("serial")
public class ITEMS01692VO extends BaseVO {

	/** ������Ϣ */
	protected OutStock outStock;
	
	/** ��ⵥ�� */
	protected String inPrice;
	
	/** ���ⵥ�� */
	protected String outPrice;
	
	/** ���� */
	protected String count;
	
	/** ������ */
	protected String countPrice;
	
	/** ���� */
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
