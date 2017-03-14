package com.csebank.items.bl.task;

import java.util.List;

import com.csebank.items.model.ItemsCodes;
import com.deliverik.framework.base.BaseBL;

public interface ItemsCodesBL extends BaseBL{

	public List<ItemsCodes> getItemsCodesList(String selectid);
	public List<ItemsCodes> findAll();
	public ItemsCodes changeStatus(String selectId,String status);
}
