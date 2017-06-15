package com.csebank.items.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.items.model.ItemsCategory;
import com.csebank.items.model.condition.ItemsCategorySearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;


public interface ItemsCategoryTBDAO extends BaseHibernateDAO<ItemsCategory> {

	public List<ItemsCategory> findAll();

	public ItemsCategory findByPK(Serializable icid);

	public List<ItemsCategory> findByCond(final ItemsCategorySearchCond cond, 
			final int start, final int count);
	
	public int getSearchCount(ItemsCategorySearchCond cond);
}
