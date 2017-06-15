package com.csebank.items.bl.task;

import java.io.Serializable;
import java.util.List;

import com.csebank.items.model.InStock;
import com.csebank.items.model.condition.InStockSearchCond;
import com.deliverik.framework.base.BaseBL;

public interface InStockBL extends BaseBL{

	public InStock insertInStock(InStock inStock);
	
	public List<InStock> searchInStock(InStockSearchCond cond, int start,int count);
	
	public InStock findInStockByPk(Serializable inStockId);
	
	public void saveOrUpdateAll(List<InStock> inStockList);
}
