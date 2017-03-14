package com.csebank.items.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.items.model.ItemsCodes;
import com.csebank.items.model.condition.ItemsCodesSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;


public interface ItemsCodesTBDAO extends BaseHibernateDAO<ItemsCodes> {

	public List<ItemsCodes> findAll();

	public ItemsCodes findByPK(Serializable icid);

	public List<ItemsCodes> findByCond(final ItemsCodesSearchCond cond, 
			final int start, final int count);
	
	public int getSearchCount(ItemsCodesSearchCond cond);
}
