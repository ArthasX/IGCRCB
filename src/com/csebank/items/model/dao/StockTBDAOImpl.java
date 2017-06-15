package com.csebank.items.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.items.model.Stock;
import com.csebank.items.model.condition.StockSearchCond;
import com.csebank.items.model.entity.StockTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;


/**
 * 
 */
@SuppressWarnings("deprecation")
public class StockTBDAOImpl extends BaseHibernateDAOImpl<Stock> implements StockTBDAO {

	/**
	 * 
	 */
	public StockTBDAOImpl(){
		super(StockTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<Stock> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("stockid"));
		List<Stock> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param user_id 
	 * @return 
	 */
	public Stock findByPK(Serializable icid) {

		Stock ic = super.findByPK(icid);
		if(ic == null) return null;

		return ic;
	}

	public List<Stock> findByCond(final StockSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("seqcode"));
		List<Stock> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(StockSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//
		if(StringUtils.isNotEmpty(cond.getCategory())){
			c.add(Expression.eq("category", cond.getCategory()));
		}
		if(StringUtils.isNotEmpty(cond.getStockorg())){
			c.add(Expression.eq("stockorg", cond.getStockorg()));
		}
		if(StringUtils.isNotEmpty(cond.getStockorg_q())){
			c.add(Expression.like("stockorg", cond.getStockorg_q()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getType())){
			c.add(Expression.eq("type", cond.getType()));
		}
		
		//物品名称模糊查询
		if(StringUtils.isNotEmpty(cond.getItemsname())){
			c.add(Expression.like("itemsname", "%"+cond.getItemsname()+"%"));
		}
		//物品编号模糊查询
		if(StringUtils.isNotEmpty(cond.getSeqcode_q())){
			c.add(Expression.like("seqcode", "%"+cond.getSeqcode_q()+"%"));
		}
		
		return c;
	}

	public int getSearchCount(final StockSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

}