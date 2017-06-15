package com.deliverik.infogovernor.fin.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;




/**
 * 
 */
public interface BudgetTBDAO extends BaseHibernateDAO<Budget> {

	/**
	 *
	 * @return 
	 */
	public List<Budget> findAll();

	/**
	 *
	 * @param
	 * @return 
	 */
	public Budget findByPK(Serializable bid);

	public List<Budget> findByCond(final BudgetSearchCond cond, final int start, final int count);
	
	public int getSearchCount(final BudgetSearchCond cond);

}
