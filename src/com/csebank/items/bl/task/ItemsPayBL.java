package com.csebank.items.bl.task;

import java.util.List;

import com.csebank.items.model.ItemsPay;
import com.csebank.items.model.condition.ItemsPaySearchCond;
import com.deliverik.framework.base.BaseBL;

public interface ItemsPayBL extends BaseBL{

	public List<ItemsPay> searchItemsPayment(ItemsPaySearchCond cond, int start,int count);
	
}
