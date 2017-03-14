package com.csebank.items.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.items.model.InStock;
import com.csebank.items.model.condition.InStockSearchCond;
import com.csebank.items.model.entity.InStockTB;
import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;


/**
 * 
 */
@SuppressWarnings("deprecation")
public class InStockTBDAOImpl extends BaseHibernateDAOImpl<InStock> implements InStockTBDAO {

	/**
	 * 
	 */
	public InStockTBDAOImpl(){
		super(InStockTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<InStock> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("instockid"));
		List<InStock> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param user_id 
	 * @return 
	 */
	public InStock findByPK(Serializable icid) {

		InStock ic = super.findByPK(icid);
		if(ic == null) return null;

		return ic;
	}

	public List<InStock> findByCond(final InStockSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		if(DefineUtils.INSTOCK_SORT_BYINTIME.equals(cond.getInstock_sort())){
			c.addOrder(Order.asc("intime"));
		}else if(DefineUtils.INSTOCK_SORT_BYINCODE.equals(cond.getInstock_sort())){
			c.addOrder(Order.asc("seqcode"));
		}else if(DefineUtils.INSTOCK_SORT_BYINTIME_DESC.equals(cond.getInstock_sort())){
			c.addOrder(Order.desc("intime"));
		}else{
			c.addOrder(Order.asc("instockid"));
		}
		
		List<InStock> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(InStockSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//
		if(cond.getOutstockid()!=null && cond.getOutstockid()!=0){
			c.add(Expression.eq("outstockid", cond.getOutstockid()));
		}
		
		if(StringUtils.isNotEmpty(cond.getInstockorg())){
			c.add(Expression.eq("instockorg", cond.getInstockorg()));
		}
		if(StringUtils.isNotEmpty(cond.getInstockorg_q())){
			c.add(Expression.like("instockorg", cond.getInstockorg_q()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getCategory())){
			c.add(Expression.eq("category", cond.getCategory()));
		}
		if(StringUtils.isNotEmpty(cond.getType())){
			c.add(Expression.eq("type", cond.getType()));
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
		
		if(StringUtils.isNotEmpty(cond.getIntime_f())){
			c.add(Expression.ge("intime", cond.getIntime_f() + " 00:00"));
		}
		if(StringUtils.isNotEmpty(cond.getIntime_t())){
			c.add(Expression.le("intime", cond.getIntime_t() + " 23:59"));
		}
		if(StringUtils.isNotEmpty(cond.getIntime())){
			c.add(Expression.like("intime", cond.getIntime() + "%"));
		}
		
		if(StringUtils.isNotEmpty(cond.getSeqno())){
			c.add(Expression.eq("seqno", cond.getSeqno()));
		}
		if(StringUtils.isNotEmpty(cond.getTypecode())){
			c.add(Expression.eq("typecode", cond.getTypecode()));
		}
		if(StringUtils.isNotEmpty(cond.getStatus())){
			c.add(Expression.eq("status", cond.getStatus()));
		}
		//“使用调整“、”损耗调整“、“销毁调整”某个操作时，实际库存为零的记录不显示 
		if(!cond.isShowNoneStock()){
			c.add(Expression.sql(" innum <> (outnum + lossnum + havocnum)"));			
		}
		
		//损耗数量不为0
		if(cond.isLossnumIsNotZero()){
			c.add(Expression.ne("lossnum", 0));
		}
		
		//出库时查询入库明细使用
		if(cond.getStatus_q()!=null && cond.getStatus_q().size()>0){
			c.add(Expression.in("status", cond.getStatus_q()));
		}
		return c;
	}

	public int getSearchCount(final InStockSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

}