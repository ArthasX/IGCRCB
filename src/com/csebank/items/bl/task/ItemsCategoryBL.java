package com.csebank.items.bl.task;

import java.io.Serializable;
import java.util.List;

import com.csebank.items.model.ItemsCategory;
import com.csebank.items.model.condition.ItemsCategorySearchCond;
import com.deliverik.framework.base.BaseBL;

public interface ItemsCategoryBL extends BaseBL{

	public List<ItemsCategory> searchItemsCategory(ItemsCategorySearchCond cond, int start,int count);
	
	public ItemsCategory insertItemsCategory(ItemsCategory itemsCategory);
	
	public ItemsCategory findItemsCategoryByPk(Serializable icid);
	
}
