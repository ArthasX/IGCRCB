package com.csebank.items.model.dao;

import java.io.Serializable;
import java.util.List;


import com.csebank.items.model.OutStock;
import com.csebank.items.model.condition.OutStockSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;


public interface OutStockTBDAO extends BaseHibernateDAO<OutStock> {

	public List<OutStock> findAll();

	public OutStock findByPK(Serializable icid);

	public List<OutStock> findByCond(final OutStockSearchCond cond, 
			final int start, final int count);
	
	public int getSearchCount(OutStockSearchCond cond);
}
