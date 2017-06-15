package com.csebank.items.model.dao;

import java.util.List;

import com.csebank.items.model.ItemsPay;
import com.csebank.items.model.condition.ItemsPaySearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;


public interface ItemsPayVWDAO extends BaseHibernateDAO<ItemsPay> {

	public List<ItemsPay> findByCond(final ItemsPaySearchCond cond, final int start, final int count);

}
