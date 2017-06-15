package com.csebank.items.bl.task;

import java.util.List;

import com.csebank.items.model.OutStock;
import com.csebank.items.model.condition.OutStockSearchCond;
import com.deliverik.framework.base.BaseBL;

public interface OutStockBL extends BaseBL{

	public List<OutStock> searchOutStock(OutStockSearchCond cond, int start, int count);

	public OutStock insertOutStock(OutStock outStock);
	
	public void saveOrUpdateAll(List<OutStock> outStockList);

	public OutStock findOutStockByPk(int outstockid);

	public List<OutStock> findOutStockByCond(OutStockSearchCond cond, int start, int count);
	
	public void deleteOutStock(OutStock outStock);
	/**
	 * 同步操作OutStock表
	 */
	//public OutStock operationOutStock(OutStock outStock,String type);
	
}
