package com.csebank.items.bl.task;

import java.io.Serializable;
import java.util.List;

import com.csebank.items.model.Stock;
import com.csebank.items.model.condition.StockSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

public interface StockBL extends BaseBL{

	public Stock addToStock(Stock stock,String type) throws BLException;
	
	public List<Stock> searchStock(StockSearchCond cond, int start,int count);
	
	public Stock findStockByPk(Serializable stockid);

	public Stock saveOrUpdateStock(Stock stock);
}
