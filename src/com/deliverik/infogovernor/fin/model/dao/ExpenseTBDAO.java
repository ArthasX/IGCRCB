package com.deliverik.infogovernor.fin.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.fin.model.Expense;
import com.deliverik.infogovernor.fin.model.condition.ExpenseSearchCond;
/**
 * 
 */
public interface ExpenseTBDAO extends BaseHibernateDAO<Expense> {

	/**
	 *
	 * @return 
	 */
	public List<Expense> findAll();

	/**
	 *
	 * @param
	 * @return 
	 */
	public Expense findByPK(Serializable bid);

	public List<Expense> findByCond(final ExpenseSearchCond cond, final int start, final int count);
	
	public int getSearchCount(final ExpenseSearchCond cond);
}
