package com.deliverik.infogovernor.fin.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;

public interface BudgetBL extends BaseBL {
	/**
	 *
	 * @param 
	 * @return 
	 */
	public Budget findByPK(Serializable bid);
	
	public List<Budget> findByCond(final BudgetSearchCond cond, final int start, final int count);

	public int getSearchCount(final BudgetSearchCond cond);
	
	public void delete(Integer radid) throws BLException;

	public Budget save(Budget budget) throws BLException;
	
	public List<Budget> findAll() throws BLException;
}
