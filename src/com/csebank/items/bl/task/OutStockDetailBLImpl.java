package com.csebank.items.bl.task;

import java.util.List;

import com.csebank.items.model.OutStockDetail;
import com.csebank.items.model.condition.OutStockDetailSearchCond;
import com.csebank.items.model.dao.OutStockDetailTBDAO;
import com.deliverik.framework.base.BaseBLImpl;

public class OutStockDetailBLImpl extends BaseBLImpl implements OutStockDetailBL{
	
	private OutStockDetailTBDAO outStockDetailTBDAO;

	/**
	 * @param outStockDetailTBDAO the outStockDetailTBDAO to set
	 */
	public void setOutStockDetailTBDAO(OutStockDetailTBDAO outStockDetailTBDAO) {
		this.outStockDetailTBDAO = outStockDetailTBDAO;
	}

	public List<OutStockDetail> searchOutStockDetail(OutStockDetailSearchCond cond, int start, int count) {
		List<OutStockDetail> outStockDetailList = outStockDetailTBDAO.findByCond(cond, start, count);
		return outStockDetailList;
	}

	public OutStockDetail insertOutStockDetail(OutStockDetail outStockDetail) {
		return outStockDetailTBDAO.save(outStockDetail);
	}

	public void deleteOutStockDetail(OutStockDetail outStockDetail) {
		outStockDetailTBDAO.delete(outStockDetail);
	}
	
	public OutStockDetail findOutStockDetailByPk(int id) {
		return outStockDetailTBDAO.findByPK(id);
	}

	
	public void saveOrUpdateAll(List<OutStockDetail> outStockDetailList) {
		outStockDetailTBDAO.saveOrUpdateAll(outStockDetailList);
	}

	
}
