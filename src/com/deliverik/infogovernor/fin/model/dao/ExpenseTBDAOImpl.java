package com.deliverik.infogovernor.fin.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.fin.model.Expense;
import com.deliverik.infogovernor.fin.model.condition.ExpenseSearchCond;
import com.deliverik.infogovernor.fin.model.entity.ExpenseTB;

@SuppressWarnings("deprecation")
public class ExpenseTBDAOImpl extends BaseHibernateDAOImpl<Expense> implements ExpenseTBDAO {

	public ExpenseTBDAOImpl(){
		super(ExpenseTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<Expense> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("exid"));
		List<Expense> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param 
	 * @return 
	 */
	public Expense findByPK(Serializable bid) {

		Expense rl = super.findByPK(bid);
		if(rl == null) return null;

		return rl;
	}

	public List<Expense> findByCond(final ExpenseSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("exid"));
		List<Expense> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(ExpenseSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if( !StringUtils.isEmpty(cond.getExclosetime())){
			c.add(Expression.le("exopentime", cond.getExclosetime()));
		}
		if( !StringUtils.isEmpty(cond.getExopentime())){
			c.add(Expression.ge("exopentime", cond.getExopentime()));
		}
		if( !StringUtils.isEmpty(cond.getExstatus())){
			c.add(Expression.eq("exstatus", cond.getExstatus()));
		}
		if( null != cond.getExamount() && cond.getExamount() > 0){
			c.add(Expression.eq("examount", cond.getExamount()));
		}
		if( !StringUtils.isEmpty(cond.getExapvname())){
			c.add(Expression.like("exapvname", "%"+ cond.getExapvname()+"%"));
		}
		if( !StringUtils.isEmpty(cond.getBtitle())){
			c.add(Expression.like("btitle", "%"+cond.getBtitle()+"%"));
		}
		if (cond.getBid() != null && cond.getBid() != 0) {
			c.add(Expression.eq("bid", cond.getBid()));
		}

		return c;
	}

	public int getSearchCount(final ExpenseSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}



}
