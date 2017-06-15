package com.csebank.items.bl.task;

import java.util.List;

import com.csebank.items.model.OutStockDetail;
import com.csebank.items.model.condition.OutStockDetailSearchCond;
import com.deliverik.framework.base.BaseBL;

public interface OutStockDetailBL extends BaseBL{

	public List<OutStockDetail> searchOutStockDetail(OutStockDetailSearchCond cond, int start, int count);

	public OutStockDetail insertOutStockDetail(OutStockDetail outStockDetail);
	
	public void saveOrUpdateAll(List<OutStockDetail> outStockDetailList);

	public OutStockDetail findOutStockDetailByPk(int id);
	
	public void deleteOutStockDetail(OutStockDetail outStockDetail);
	
	
}
