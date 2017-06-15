package com.csebank.items.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.items.model.Stock;
import com.csebank.items.model.condition.StockSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;


public interface StockTBDAO extends BaseHibernateDAO<Stock> {

	public List<Stock> findAll();

	public Stock findByPK(Serializable icid);

	public List<Stock> findByCond(final StockSearchCond cond, 
			final int start, final int count);
	
	public int getSearchCount(StockSearchCond cond);
}
