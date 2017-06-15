package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.Notice;
import com.deliverik.infogovernor.sym.model.condition.NoticeSearchCond;
import com.deliverik.infogovernor.sym.model.entity.NoticeTB;

/**
 * 
 */
@SuppressWarnings("deprecation")
public class NoticeTBDAOImpl extends BaseHibernateDAOImpl<Notice> implements NoticeTBDAO {

	/**
	 * 
	 */
	public NoticeTBDAOImpl(){
		super(NoticeTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<Notice> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("ntime"));
		List<Notice> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param user_id 
	 * @return 
	 */
	public Notice findByPK(Serializable noticeid) {

		Notice notice = super.findByPK(noticeid);
		if(notice == null) return null;

		return notice;
	}

	public List<Notice> findByCond(final NoticeSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("ntime"));
		List<Notice> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(NoticeSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//
		if( !StringUtils.isEmpty(cond.getNname())){
			c.add(Expression.like("nname", "%"+cond.getNname()+"%"));
		}	
		if( !StringUtils.isEmpty(cond.getNtime_from())){
			c.add(Expression.ge("ntime", cond.getNtime_from()));
		}
		if( !StringUtils.isEmpty(cond.getNtime_to())){
			c.add(Expression.le("ntime", cond.getNtime_to()));
		}
		if(StringUtils.isNotEmpty(cond.getTuserid()) && cond.getTroleids() != null && cond.getTroleids().length > 0){
			c.add(Restrictions.or(Restrictions.like("ntargetuserid", "%"+cond.getTuserid()+"%"), Restrictions.or(Restrictions.in("ntargetroleid", cond.getTroleids()), Restrictions.and(Restrictions.eq("ntargetuserid",""),Restrictions.eq("ntargetroleid","")))));
		}
		return c;
	}
	
	public int getSearchCount(final NoticeSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
}
