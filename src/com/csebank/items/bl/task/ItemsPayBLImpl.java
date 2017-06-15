package com.csebank.items.bl.task;

import java.util.List;

import com.csebank.items.model.ItemsPay;
import com.csebank.items.model.condition.ItemsPaySearchCond;
import com.csebank.items.model.dao.ItemsPayVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

public class ItemsPayBLImpl extends BaseBLImpl implements ItemsPayBL{
	
	private ItemsPayVWDAO itemsPayVWDAO;

	public void setItemsPayVWDAO(ItemsPayVWDAO itemsPayVWDAO) {
		this.itemsPayVWDAO = itemsPayVWDAO;
	}

	public List<ItemsPay> searchItemsPayment(ItemsPaySearchCond cond, int start,int count) {
		List<ItemsPay> paymentList = itemsPayVWDAO.findByCond(cond, start, count);
		return paymentList;
	}

}
