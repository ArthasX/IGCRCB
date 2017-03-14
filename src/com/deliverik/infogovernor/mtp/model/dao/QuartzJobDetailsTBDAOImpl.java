package com.deliverik.infogovernor.mtp.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCond;
import com.deliverik.infogovernor.mtp.model.entity.QuartzJobDetailsTB;


/**
 * 
 */
@SuppressWarnings("deprecation")
public class QuartzJobDetailsTBDAOImpl extends BaseHibernateDAOImpl<QuartzJobDetails> implements QuartzJobDetailsTBDAO {

	/**
	 * 
	 */
	public QuartzJobDetailsTBDAOImpl(){
		super(QuartzJobDetailsTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<QuartzJobDetails> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("qjdtime"));
		List<QuartzJobDetails> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param user_id 
	 * @return 
	 */
	public QuartzJobDetails findByPK(Serializable qjdid) {

		QuartzJobDetails rl = super.findByPK(qjdid);
		if(rl == null) return null;

		return rl;
	}

	public List<QuartzJobDetails> findByCond(final QuartzJobDetailsSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("qjdtime"));
		List<QuartzJobDetails> ret = findByCriteria(c, start, count);
		return ret;
	}

	public int getSearchCount(final QuartzJobDetailsSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	
	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(QuartzJobDetailsSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//运维任务ID
		if( cond.getQjid()!=null && cond.getQjid()>0){
			c.add(Expression.eq("qjid", cond.getQjid()));
		}
		

		//执行时间大于等于传入时间
		if( !StringUtils.isEmpty(cond.getQjdtime())){
			c.add(Expression.ge("qjdtime", cond.getQjdtime()));
		}
		
		//执行时间小于等于传入时间
		if( !StringUtils.isEmpty(cond.getQjdtime())){
			c.add(Expression.le("qjdtime", cond.getQjdtime()));
		}
		
		//执行状态
		if( !StringUtils.isEmpty(cond.getQjdtype())){
			c.add(Expression.eq("qjdtype", cond.getQjdtype()));
		}
		
		//qjdtriname触发器名称
		if( !StringUtils.isEmpty(cond.getQjdtriname())){
			c.add(Expression.eq("qjdtriname", cond.getQjdtriname()));
		}
		
		return c;
	}

}
