package com.csebank.items.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.items.model.OutStockDetail;
import com.csebank.items.model.condition.OutStockDetailSearchCond;
import com.csebank.items.model.entity.OutStockDetailTB;
import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;


/**
 * 
 */
@SuppressWarnings("deprecation")
public class OutStockDetailTBDAOImpl extends BaseHibernateDAOImpl<OutStockDetail> implements OutStockDetailTBDAO {

	/**
	 * 
	 */
	public OutStockDetailTBDAOImpl(){
		super(OutStockDetailTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<OutStockDetail> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("outstockid"));
		List<OutStockDetail> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param user_id 
	 * @return 
	 */
	public OutStockDetail findByPK(Serializable icid) {

		OutStockDetail ic = super.findByPK(icid);
		if(ic == null) return null;

		return ic;
	}

	public List<OutStockDetail> findByCond(final OutStockDetailSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		if("seq_desc".equals(cond.getSerachtype())){//按seqno降序排列
			c.addOrder(Order.desc("reqorg"));
			c.addOrder(Order.desc("seqno"));
		}else if(DefineUtils.OUTSTOCK_SORT_BYOUTTIME.equals(cond.getSortType())){
			c.addOrder(Order.asc("outtime"));
			c.addOrder(Order.asc("outstockorg"));
		}else if(DefineUtils.OUTSTOCKDETAIL_SORTTYPE_0171.equals(cond.getSortType())){
			c.addOrder(Order.asc("id"));
		}else{
			c.addOrder(Order.asc("reqorg"));
			c.addOrder(Order.asc("seqcode"));
		}
		
		List<OutStockDetail> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(OutStockDetailSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//
		if(cond.getStockid()!=null && cond.getStockid()!=0){
			c.add(Expression.eq("stockid", cond.getStockid()));
		}
		if(cond.getOutstockid()!=null && cond.getOutstockid()!=0){
			c.add(Expression.eq("outstockid", cond.getOutstockid()));
		}
		if(StringUtils.isNotEmpty(cond.getOutstockorg())){
			c.add(Expression.eq("outstockorg", cond.getOutstockorg()));
		}
		if(StringUtils.isNotEmpty(cond.getCategory())){
			c.add(Expression.eq("category", cond.getCategory()));
		}
		if(StringUtils.isNotEmpty(cond.getRcvtime())){
			c.add(Expression.like("rcvtime", cond.getRcvtime() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getOuttype())){
			c.add(Expression.eq("outtype", cond.getOuttype()));
		}
		if(StringUtils.isNotEmpty(cond.getItemsname())){
			c.add(Expression.eq("itemsname", cond.getItemsname()));
		}
		
		
		if(StringUtils.isNotEmpty(cond.getSeqcode())){
			c.add(Expression.eq("seqcode", cond.getSeqcode()));
		}
		if(StringUtils.isNotEmpty(cond.getReqorg())){
			c.add(Expression.eq("reqorg", cond.getReqorg()));
		}
		if(StringUtils.isNotEmpty(cond.getReqstatus())){
			c.add(Expression.eq("reqstatus", cond.getReqstatus()));
		}
		if(StringUtils.isNotEmpty(cond.getAccountstatus())){
			c.add(Expression.eq("accountstatus", cond.getAccountstatus()));
		}
		if(StringUtils.isNotEmpty(cond.getInstockid())){
			c.add(Expression.eq("instockid", Integer.valueOf(cond.getInstockid())));
		}
		
		//出库时取得批次号时调用
		if(cond.getOuttypelist()!=null && cond.getOuttypelist().size()>0){
			c.add(Expression.in("outtype", cond.getOuttypelist()));
		}
		
		if(cond.getReqstatusList()!=null && cond.getReqstatusList().size()>0){
			c.add(Expression.in("reqstatus", cond.getReqstatusList()));
		}
		
		if(StringUtils.isNotEmpty(cond.getOutstockorg_q())){
			c.add(Expression.like("outstockorg", cond.getOutstockorg_q() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getIntime_f())){
			c.add(Expression.ge("rcvtime", cond.getIntime_f() + " 00:00"));
		}
		if(StringUtils.isNotEmpty(cond.getIntime_t())){
			c.add(Expression.le("rcvtime", cond.getIntime_t() + " 23:59"));
		}
		
		//出库时间从
		if(StringUtils.isNotEmpty(cond.getOuttime_f())){
			c.add(Expression.ge("outtime", cond.getOuttime_f() + " 00:00"));
		}
		//出库时间到
		if(StringUtils.isNotEmpty(cond.getOuttime_t())){
			c.add(Expression.le("outtime", cond.getOuttime_t() + " 23:59"));
		}
		if(StringUtils.isNotEmpty(cond.getReqstatus_q())){
			c.add(Expression.eq("reqstatus", cond.getReqstatus_q()));
		}

		
		return c;
	}

	public int getSearchCount(final OutStockDetailSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

}