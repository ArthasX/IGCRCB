package com.csebank.items.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.items.model.OutStockDetail;
import com.csebank.items.model.condition.OutStockDetailSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;


public interface OutStockDetailTBDAO extends BaseHibernateDAO<OutStockDetail> {

	public List<OutStockDetail> findAll();

	public OutStockDetail findByPK(Serializable icid);

	public List<OutStockDetail> findByCond(final OutStockDetailSearchCond cond, 
			final int start, final int count);
	
	public int getSearchCount(OutStockDetailSearchCond cond);
}
