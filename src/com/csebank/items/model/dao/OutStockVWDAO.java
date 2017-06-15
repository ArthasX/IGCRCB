package com.csebank.items.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.items.model.OutStockVWInfo;
import com.csebank.items.model.condition.OutStockSearchVWCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;


public interface OutStockVWDAO extends BaseHibernateDAO<OutStockVWInfo> {

	public List<OutStockVWInfo> findAll();

	public OutStockVWInfo findByPK(Serializable id);

	public List<OutStockVWInfo> findByCond(final OutStockSearchVWCond cond, 
			final int start, final int count);
	
	public int getSearchCount(OutStockSearchVWCond cond);
}
