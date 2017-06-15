package com.csebank.items.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.items.model.InStock;
import com.csebank.items.model.condition.InStockSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;


public interface InStockTBDAO extends BaseHibernateDAO<InStock> {

	public List<InStock> findAll();

	public InStock findByPK(Serializable icid);

	public List<InStock> findByCond(final InStockSearchCond cond, 
			final int start, final int count);
	
	public int getSearchCount(InStockSearchCond cond);
}
