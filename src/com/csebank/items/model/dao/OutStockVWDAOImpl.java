package com.csebank.items.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.items.model.OutStockVWInfo;
import com.csebank.items.model.condition.OutStockSearchVWCond;
import com.csebank.items.model.entity.OutStockVW;
import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;


/**
 * 
 */
@SuppressWarnings("deprecation")
public class OutStockVWDAOImpl extends BaseHibernateDAOImpl<OutStockVWInfo> implements OutStockVWDAO {

	/**
	 * 
	 */
	public OutStockVWDAOImpl(){
		super(OutStockVW.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<OutStockVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("outstockid"));
		List<OutStockVWInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @return 
	 */
	public OutStockVWInfo findByPK(Serializable id) {

		OutStockVWInfo ic = super.findByPK(id);
		if(ic == null) return null;

		return ic;
	}

	public List<OutStockVWInfo> findByCond(final OutStockSearchVWCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		if(DefineUtils.OUTSTOCK_SORT_BYOUTTIME.equals(cond.getSortType())){
			c.addOrder(Order.asc("outtime"));
			c.addOrder(Order.asc("outstockorg"));
		}else{
			c.addOrder(Order.asc("outstockid"));
		}
		
		List<OutStockVWInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(OutStockSearchVWCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if(StringUtils.isNotEmpty(cond.getStockorg())){
			c.add(Expression.eq("stockorg", cond.getStockorg()));
		}
		if(StringUtils.isNotEmpty(cond.getReqorg_q())){
			c.add(Expression.eq("reqorg", cond.getReqorg_q()));
		}
		
		if(StringUtils.isNotEmpty(cond.getOutstockorg())){
			c.add(Expression.eq("outstockorg", cond.getOutstockorg()));
		}
		
		if(StringUtils.isNotEmpty(cond.getCategory_q())){
			c.add(Expression.eq("category", cond.getCategory_q()));
		}
		if(StringUtils.isNotEmpty(cond.getReqstatus_q())){
			c.add(Expression.eq("reqstatus", cond.getReqstatus_q()));
		}
		if(StringUtils.isNotEmpty(cond.getOuttype_q())){
			c.add(Expression.eq("outtype", cond.getOuttype_q()));
		}
		
		
		if(null!=cond.getOutTypeList() &&  cond.getOutTypeList().size()>0){
			c.add(Expression.in("outtype", cond.getOutTypeList()));
		}
		
		if(StringUtils.isNotEmpty(cond.getReqtime_f())){
			c.add(Expression.ge("reqtime", cond.getReqtime_f() + " 00:00"));
		}
		if(StringUtils.isNotEmpty(cond.getReqtime_t())){
			c.add(Expression.le("reqtime", cond.getReqtime_t() + " 23:59"));
		}
		
		if(StringUtils.isNotEmpty(cond.getChktime_f())){
			c.add(Expression.ge("chktime", cond.getChktime_f() + " 00:00"));
		}
		if(StringUtils.isNotEmpty(cond.getChktime_t())){
			c.add(Expression.le("chktime", cond.getChktime_t() + " 23:59"));
		}
		
		
		//配送时间从
		if(StringUtils.isNotEmpty(cond.getOuttime_f())){
			c.add(Expression.ge("outtime", cond.getOuttime_f() + " 00:00"));
		}
		//配送时间到
		if(StringUtils.isNotEmpty(cond.getOuttime_t())){
			c.add(Expression.le("outtime", cond.getOuttime_t() + " 23:59"));
		}
		
		if(StringUtils.isNotEmpty(cond.getRcvtime_f())){
			c.add(Expression.ge("rcvtime", cond.getRcvtime_f() + " 00:00"));
		}
		if(StringUtils.isNotEmpty(cond.getRcvtime_t())){
			c.add(Expression.le("rcvtime", cond.getRcvtime_t() + " 23:59"));
		}
		
		
		
//		if(StringUtils.isNotEmpty(cond.getOuttype())){
//			c.add(Expression.eq("outtype", cond.getOuttype()));
//		}
		
		return c;
	}

	public int getSearchCount(final OutStockSearchVWCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

}