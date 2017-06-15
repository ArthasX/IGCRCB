package com.csebank.items.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.items.model.ItemsCategory;
import com.csebank.items.model.condition.ItemsCategorySearchCond;
import com.csebank.items.model.entity.ItemsCategoryTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;


/**
 * 
 */
@SuppressWarnings("deprecation")
public class ItemsCategoryTBDAOImpl extends BaseHibernateDAOImpl<ItemsCategory> implements ItemsCategoryTBDAO {

	/**
	 * 
	 */
	public ItemsCategoryTBDAOImpl(){
		super(ItemsCategoryTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<ItemsCategory> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("category"));
		c.addOrder(Order.asc("seqcode"));
		List<ItemsCategory> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param user_id 
	 * @return 
	 */
	public ItemsCategory findByPK(Serializable icid) {

		ItemsCategory ic = super.findByPK(icid);
		if(ic == null) return null;

		return ic;
	}

	public List<ItemsCategory> findByCond(final ItemsCategorySearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("category"));
		c.addOrder(Order.asc("seqcode"));
		List<ItemsCategory> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(ItemsCategorySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//
		if(StringUtils.isNotEmpty(cond.getCategory())){
			c.add(Expression.eq("category", cond.getCategory()));
		}
		if(StringUtils.isNotEmpty(cond.getTypecode())){
			c.add(Expression.like("typecode", "%" + cond.getTypecode() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getStatus())){
			c.add(Expression.eq("status", cond.getStatus()));
		}
		if(StringUtils.isNotEmpty(cond.getSeqcode())){
			c.add(Expression.eq("seqcode", cond.getSeqcode()));
		}
		return c;
	}

	public int getSearchCount(final ItemsCategorySearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

}