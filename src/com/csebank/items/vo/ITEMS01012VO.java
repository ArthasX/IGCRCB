/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.items.vo;

import com.csebank.items.model.ItemsPay;
import com.deliverik.framework.base.BaseVO;

/**
 * @author sunkaiyu
 *
 */
public class ITEMS01012VO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private ItemsPay itemsPay;
	private double total;
	public ItemsPay getItemsPay() {
		return itemsPay;
	}
	public void setItemsPay(ItemsPay itemsPay) {
		this.itemsPay = itemsPay;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}