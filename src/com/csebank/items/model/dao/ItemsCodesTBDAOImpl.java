package com.csebank.items.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.items.model.ItemsCodes;
import com.csebank.items.model.condition.ItemsCodesSearchCond;
import com.csebank.items.model.entity.ItemsCodesTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;


/**
 * 
 */
@SuppressWarnings("deprecation")
public class ItemsCodesTBDAOImpl extends BaseHibernateDAOImpl<ItemsCodes> implements ItemsCodesTBDAO {

	/**
	 * 
	 */
	public ItemsCodesTBDAOImpl(){
		super(ItemsCodesTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<ItemsCodes> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("icid"));
		List<ItemsCodes> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param 
	 * @return 
	 */
	public ItemsCodes findByPK(Serializable icid) {

		ItemsCodes ic = super.findByPK(icid);
		if(ic == null) return null;

		return ic;
	}

	public List<ItemsCodes> findByCond(final ItemsCodesSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("icid"));
		List<ItemsCodes> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(ItemsCodesSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//
		if(StringUtils.isNotEmpty(cond.getSelectid())){
			c.add(Expression.eq("selectid", cond.getSelectid()));
		}
		if(StringUtils.isNotEmpty(cond.getTypecode())){
			c.add(Expression.eq("typecode", cond.getTypecode()));
		}
		if(StringUtils.isNotEmpty(cond.getStatus())){
			c.add(Expression.eq("status", cond.getStatus()));
		}
		return c;
	}

	public int getSearchCount(final ItemsCodesSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

}