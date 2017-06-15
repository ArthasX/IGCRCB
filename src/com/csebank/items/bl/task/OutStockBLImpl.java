package com.csebank.items.bl.task;

import java.util.List;

import com.csebank.items.model.OutStock;
import com.csebank.items.model.condition.OutStockSearchCond;
import com.csebank.items.model.dao.OutStockTBDAO;
import com.deliverik.framework.base.BaseBLImpl;

public class OutStockBLImpl extends BaseBLImpl implements OutStockBL{
	
	private OutStockTBDAO outStockTBDAO;

	public void setOutStockTBDAO(OutStockTBDAO outStockTBDAO) {
		this.outStockTBDAO = outStockTBDAO;
	}

	public List<OutStock> searchOutStock(OutStockSearchCond cond, int start, int count) {
		List<OutStock> outStockList = outStockTBDAO.findByCond(cond, start, count);
		return outStockList;
	}

	public OutStock insertOutStock(OutStock outStock) {
		return outStockTBDAO.save(outStock);
	}

	public void deleteOutStock(OutStock outStock) {
		outStockTBDAO.delete(outStock);
	}
	
	public OutStock findOutStockByPk(int outstockid) {
		return outStockTBDAO.findByPK(outstockid);
	}

	public List<OutStock> findOutStockByCond(OutStockSearchCond cond, int start, int count) {
		List<OutStock> outStockList = outStockTBDAO.findByCond(cond, start, count);
		return outStockList;
	}

	public void saveOrUpdateAll(List<OutStock> outStockList) {
		outStockTBDAO.saveOrUpdateAll(outStockList);
	}
	
}
