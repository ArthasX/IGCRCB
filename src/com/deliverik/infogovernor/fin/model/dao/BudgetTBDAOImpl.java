package com.deliverik.infogovernor.fin.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;
import com.deliverik.infogovernor.fin.model.entity.BudgetTB;


/**
 * 
 */
@SuppressWarnings("deprecation")
public class BudgetTBDAOImpl extends BaseHibernateDAOImpl<Budget> implements BudgetTBDAO {

	/**
	 * 
	 */
	public BudgetTBDAOImpl(){
		super(BudgetTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<Budget> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("bid"));
		List<Budget> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param 
	 * @return 
	 */
	public Budget findByPK(Serializable bid) {

		Budget rl = super.findByPK(bid);
		if(rl == null) return null;

		return rl;
	}

	public List<Budget> findByCond(final BudgetSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("byear"));
		c.addOrder(Order.asc("bid"));
		List<Budget> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(BudgetSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if( !StringUtils.isEmpty(cond.getByear_q())){
			c.add(Expression.like("byear", "%"+cond.getByear_q()+"%"));
		}
		if( !StringUtils.isEmpty(cond.getBtitle_q())){
			c.add(Expression.like("btitle", "%"+cond.getBtitle_q()+"%"));
		}
		if( !StringUtils.isEmpty(cond.getBstatus())){
			c.add(Expression.eq("bstatus", cond.getBstatus()));
		}
		
		if( !StringUtils.isEmpty(cond.getBstatus_q())){
			c.add(Expression.eq("bstatus", cond.getBstatus_q()));
		}
		
		if( !StringUtils.isEmpty(cond.getBtype_q())){
			c.add(Expression.eq("btype", cond.getBtype_q()));
		}
		
		if( !StringUtils.isEmpty(cond.getPcode())){
			c.add(Expression.eq("pcode", cond.getPcode()));
		}
		if( !StringUtils.isEmpty(cond.getBopentime())  && !"fin".equals(cond.getSelectMode())){
			c.add(Expression.ge("bopentime", cond.getBopentime()));
		}
		if(!StringUtils.isEmpty(cond.getBclosetime()) && !"fin".equals(cond.getSelectMode())){
			c.add(Expression.le("bopentime", cond.getBclosetime()));
		}
		
		//图形显示用
		if( !StringUtils.isEmpty(cond.getBopentime()) && "fin".equals(cond.getSelectMode())){
			c.add(Expression.ge("byear", cond.getBopentime()));
		}
		if( !StringUtils.isEmpty(cond.getBclosetime()) && "fin".equals(cond.getSelectMode())){
			c.add(Expression.lt("byear", cond.getBclosetime()));
		}
		
		//获得近三年的年份用
		if( !StringUtils.isEmpty(cond.getByear_before())){
			c.add(Expression.ge("byear", cond.getByear_before()));
		}
		if( !StringUtils.isEmpty(cond.getByear_now())){
			c.add(Expression.le("byear", cond.getByear_now()));
		}

		return c;
	}


	public int getSearchCount(final BudgetSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	

}
