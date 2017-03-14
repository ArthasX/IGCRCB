package com.csebank.items.bl.task;

import java.io.Serializable;
import java.util.List;

import com.csebank.items.model.InStock;
import com.csebank.items.model.condition.InStockSearchCond;
import com.csebank.items.model.dao.InStockTBDAO;
import com.deliverik.framework.base.BaseBLImpl;

public class InStockBLImpl extends BaseBLImpl implements InStockBL{
	
	private InStockTBDAO inStockTBDAO;

	public void setInStockTBDAO(InStockTBDAO inStockTBDAO) {
		this.inStockTBDAO = inStockTBDAO;
	}

	public InStock insertInStock(InStock inStock) {
		inStock = inStockTBDAO.save(inStock);
		return inStock;
	}

	public List<InStock> searchInStock(InStockSearchCond cond, int start, int count) {
		List<InStock> inStockList = inStockTBDAO.findByCond(cond, start, count);
		return inStockList;
	}

	public InStock findInStockByPk(Serializable inStockId) {
		return inStockTBDAO.findByPK(inStockId);
	}

	public void saveOrUpdateAll(List<InStock> inStockList) {
		inStockTBDAO.saveOrUpdateAll(inStockList);
	}

}
