package com.csebank.items.model.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.items.model.OutStock;
import com.csebank.items.model.condition.OutStockSearchCond;
import com.csebank.items.model.entity.OutStockTB;
import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;


/**
 * 
 */
@SuppressWarnings("deprecation")
public class OutStockTBDAOImpl extends BaseHibernateDAOImpl<OutStock> implements OutStockTBDAO {

	/**
	 * 
	 */
	public OutStockTBDAOImpl(){
		super(OutStockTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<OutStock> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("outstockid"));
		List<OutStock> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param user_id 
	 * @return 
	 */
	public OutStock findByPK(Serializable icid) {

		OutStock ic = super.findByPK(icid);
		if(ic == null) return null;

		return ic;
	}

	public List<OutStock> findByCond(final OutStockSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		if("seq_desc".equals(cond.getSerachtype())){//按seqno降序排列
			c.addOrder(Order.desc("reqorg"));
			c.addOrder(Order.desc("seqno"));
		}else if(DefineUtils.OUTSTOCK_SORT_BYOUTTIME.equals(cond.getSortType())){
			c.addOrder(Order.asc("outtime"));
			c.addOrder(Order.asc("outstockorg"));
		}else if(DefineUtils.OUTSTOCK_SORT_BYORG.equals(cond.getSortType())){
			c.addOrder(Order.asc("reqorg"));
			c.addOrder(Order.asc("packno"));
		}else if(DefineUtils.OUTSTOCK_SORT_BYSEQCODE.equals(cond.getSortType())){
			c.addOrder(Order.asc("seqcode"));
			c.addOrder(Order.asc("outtime"));
			c.addOrder(Order.asc("reqorg"));
		}else if(DefineUtils.OUTSTOCK_SORTTYPE_0169.equals(cond.getSortType())){
			c.addOrder(Order.asc("reqorg"));
			c.addOrder(Order.asc("category"));
		} else if("outtime".equals(cond.getSortType())){
			c.addOrder(Order.asc("outtime"));
		} else if("reqorg".equals(cond.getSortType())){
			c.addOrder(Order.desc("accountstatus"));
			c.addOrder(Order.asc("reqorg"));
			c.addOrder(Order.asc("category"));
			c.addOrder(Order.asc("seqcode"));
			c.addOrder(Order.asc("outtype"));
			c.addOrder(Order.asc("reqtime"));
		} else {
			c.addOrder(Order.asc("outstockid"));
		}
		
		List<OutStock> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(OutStockSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//
		if(cond.getStockid()!=null){
			c.add(Expression.eq("stockid", cond.getStockid()));
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
		
		if(StringUtils.isNotEmpty(cond.getSeqcode())){
			c.add(Expression.eq("seqcode", cond.getSeqcode()));
		}
		if(StringUtils.isNotEmpty(cond.getSeqcode_q())){
			c.add(Expression.like("seqcode", "%"+cond.getSeqcode_q()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getItemsname_q())){
			c.add(Expression.like("itemsname", "%"+cond.getItemsname_q()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getReqorg())){
			c.add(Expression.eq("reqorg", cond.getReqorg()));
		}
		if(StringUtils.isNotEmpty(cond.getReqstatus())){
			if(StringUtils.isNotEmpty(cond.getReqstatusa())){
				c.add(Expression.or(Expression.eq("reqstatus", cond.getReqstatusa()), Expression.eq("reqstatus", cond.getReqstatus())));
			}else{
				if("searchPaymentDetail".equals(cond.getReqstatus())){//如果当前是从结账清单明细查询中点击的查询
					List<String> list=new ArrayList<String>();
					list.add("0");
					list.add("3");
					c.add(Expression.in("reqstatus",list));
				}else{
				    c.add(Expression.eq("reqstatus", cond.getReqstatus()));
				
				
			}
			}
		}
		if(StringUtils.isNotEmpty(cond.getAccountstatus())){
			c.add(Expression.eq("accountstatus", cond.getAccountstatus()));
		}
		if(StringUtils.isNotEmpty(cond.getAccountstatus_q())){
			c.add(Expression.eq("accountstatus", cond.getAccountstatus_q()));
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
		if(StringUtils.isNotEmpty(cond.getOuttime_f()) && cond.getOuttime_f().length()==10){
			c.add(Expression.ge("outtime", cond.getOuttime_f() + " 00:00"));
		}else{
			if(StringUtils.isNotEmpty(cond.getOuttime_f())){
				c.add(Expression.ge("outtime", cond.getOuttime_f()));
			}
		}
		//出库时间到
		if(StringUtils.isNotEmpty(cond.getOuttime_t()) && cond.getOuttime_t().length()==10){
			c.add(Expression.le("outtime", cond.getOuttime_t() + " 23:59"));
		}else{
			if(StringUtils.isNotEmpty(cond.getOuttime_t())){
				c.add(Expression.le("outtime", cond.getOuttime_t()));
			}
		}
		
		
		//领用时间从
		if(StringUtils.isNotEmpty(cond.getReqtime_f())){
			c.add(Expression.ge("reqtime", cond.getReqtime_f() + " 00:00"));
		}
		//领用时间到
		if(StringUtils.isNotEmpty(cond.getReqtime_t())){
			c.add(Expression.le("reqtime", cond.getReqtime_t() + " 23:59"));
		}
		if(StringUtils.isNotEmpty(cond.getReqstatus_q())){
			if((DefineUtils.ITEMSCODES_REQSTATUS_DJS_CKWC).equals(cond.getReqstatus_q())) {
				c.add(Expression.or(Expression.eq("reqstatus", DefineUtils.ITEMSCODES_REQSTATUS_DJS), 
						Expression.eq("reqstatus", DefineUtils.ITEMSCODES_REQSTATUS_CKWC)));
			} else {
				c.add(Expression.eq("reqstatus", cond.getReqstatus_q()));
			}
		}
		
		if(true == cond.isCanPayment()){
			List<String> outtypeList = new ArrayList<String>();
			outtypeList.add(DefineUtils.ITEMSCODES_OUTTYPE_ZHSL);
			outtypeList.add(DefineUtils.ITEMSCODES_OUTTYPE_ZHXB);
			outtypeList.add(DefineUtils.ITEMSCODES_OUTTYPE_SY);
			c.add(Expression.in("outtype", outtypeList));
			c.add(Expression.isNotNull("accountstatus"));
		}
		
//		if(StringUtils.isNotEmpty(cond.getType())){
////			List<String> outtypeList = new ArrayList<String>();
////			List<String> reqstatusList = new ArrayList<String>();
//			if("outstock".equals(cond.getType())){
////				outtypeList.add(DefineUtils.ITEMSCODES_OUTTYPE_SY);
////				reqstatusList.add(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);
////				Expression.in("outtype", outtypeList);
//				Expression.eq("reqstatus", DefineUtils.ITEMSCODES_REQSTATUS_CKWC);
////				c.add(Expression.or(Expression.in("outtype", outtypeList), Expression.eq("reqstatus", DefineUtils.ITEMSCODES_REQSTATUS_CKWC)));
//			}
//		}
		
//		if(cond.getOuttype()!=null && 
//				!DefineUtils.ITEMSCODES_OUTTYPE_SY.equals(cond.getOuttype())
//				&& !DefineUtils.ITEMSCODES_OUTTYPE_SH.equals(cond.getOuttype())){
//			List<String> reqStatusList = new ArrayList<String>();
//			reqStatusList.add(DefineUtils.ITEMSCODES_REQSTATUS_DJS);
//			reqStatusList.add(DefineUtils.ITEMSCODES_REQSTATUS_CKWC);
//			c.add(Expression.in("reqstatus", reqStatusList));
//		}
		
		return c;
	}

	public int getSearchCount(final OutStockSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

}