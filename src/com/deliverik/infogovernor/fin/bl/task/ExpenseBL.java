package com.deliverik.infogovernor.fin.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.fin.model.Expense;
import com.deliverik.infogovernor.fin.model.condition.ExpenseSearchCond;

public interface ExpenseBL extends BaseBL {
	
	
	
	public Expense findByPK(Serializable bid);
	
	public List<Expense> findByCond(final ExpenseSearchCond cond, final int start, final int count);
	
	public int getSearchCount(final ExpenseSearchCond cond);
	
	public Expense save(Expense expense) throws BLException;
	
	public void delete(Integer radid) throws BLException;
	
	public List<Expense> findAll() throws BLException;

}
