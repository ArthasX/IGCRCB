package com.deliverik.infogovernor.fin.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.fin.model.Expense;
import com.deliverik.infogovernor.fin.model.condition.ExpenseSearchCond;
import com.deliverik.infogovernor.fin.model.dao.ExpenseTBDAO;

public class ExpenseBLImpl extends BaseBLImpl implements ExpenseBL{
	
	protected ExpenseTBDAO expenseTBDAO;
	
	public void setExpenseTBDAO(ExpenseTBDAO expenseTBDAO) {
		this.expenseTBDAO = expenseTBDAO;
	}

	public List<Expense> findByCond(final ExpenseSearchCond cond, final int start, final int count) {
		List<Expense> ret=expenseTBDAO.findByCond(cond, start, count);
		return ret;
	}
	
	public Expense findByPK(Serializable bid) {
		Expense rl = expenseTBDAO.findByPK(bid);
		return rl;
	}
	
	public int getSearchCount(final ExpenseSearchCond cond){
		int c=expenseTBDAO.getSearchCount(cond);
		return c;
	}
	
	public Expense save(Expense expense) {	
		Expense budgets = this.expenseTBDAO.save(expense);
		return budgets;
	}
	
    public void delete(Integer bid) throws BLException {
		
		Expense info = checkExistBudget(bid);
	    expenseTBDAO.delete(info);
		
	}
    
    protected Expense checkExistBudget(Integer bid) throws BLException{
    	Expense info = expenseTBDAO.findByPK(bid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","费用基本");
		}
		return info;
	}
    
    public List<Expense> findAll() throws BLException{
		
		return expenseTBDAO.findAll();
	}

}
