package com.deliverik.infogovernor.fin.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;
import com.deliverik.infogovernor.fin.model.dao.BudgetTBDAO;

public class BudgetBLImpl extends BaseBLImpl implements BudgetBL {
	
	
	protected BudgetTBDAO budgetTBDAO;
	
	
	public void setBudgetTBDAO(BudgetTBDAO budgetTBDAO) {
		this.budgetTBDAO = budgetTBDAO;
	}


	/**
	 *
	 * @param 
	 * @return 
	 */
	public Budget findByPK(Serializable bid) {

		Budget budget = this.budgetTBDAO.findByPK(bid);

		return budget;
	}
	
	public List<Budget> findByCond(final BudgetSearchCond cond, final int start, final int count) {
		List<Budget> ret=budgetTBDAO.findByCond(cond, start, count);
		return ret;
	}
	
	public int getSearchCount(final BudgetSearchCond cond){
		int c=budgetTBDAO.getSearchCount(cond);	
		return c;
	}
	
	public void delete(Integer bid) throws BLException {
		
		Budget info = checkExistBudget(bid);
		budgetTBDAO.delete(info);
		
	}
	
	
	/**
	 * 预算信息存在检查
	 * 
	 * @param bid 预算信息ID
	 * @return 预算信息
	 * @throws BLException 
	 */
	protected Budget checkExistBudget(Integer bid) throws BLException{
		Budget info = budgetTBDAO.findByPK(bid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","预算基本");
		}
		return info;
	}
	/**
	 * 预算修改
	 * @param budget
	 * @return
	 * @throws BLException
	 */
	public Budget update(Budget budget) throws BLException{
		checkExistBudget(budget.getBid());
	
		Budget budgets = this.budgetTBDAO.save(budget);
		return budgets;
	}
	
	public Budget save(Budget budget) throws BLException{
		
		Budget budgets = this.budgetTBDAO.save(budget);

		return budgets;
	}

    public List<Budget> findAll() throws BLException{
		
		return budgetTBDAO.findAll();
	}

}
