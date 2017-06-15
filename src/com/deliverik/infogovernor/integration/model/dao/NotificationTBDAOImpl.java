package com.deliverik.infogovernor.integration.model.dao;

import java.io.Serializable;
import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.integration.model.Notification;
import com.deliverik.infogovernor.integration.model.condition.NotificationSearchCond;
import com.deliverik.infogovernor.integration.model.entity.NotificationTB;

/**
 * 
 */
@SuppressWarnings("deprecation")
public class NotificationTBDAOImpl extends BaseHibernateDAOImpl<Notification> implements NotificationTBDAO {

	/**
	 * 
	 */
	public NotificationTBDAOImpl(){
		super(NotificationTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<Notification> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		List<Notification> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param user_id 
	 * @return 
	 */
	public Notification findByPK(Serializable nfid) {

		Notification notice = super.findByPK(nfid);
		if(notice == null) return null;

		return notice;
	}

	public List<Notification> findByCond(final NotificationSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("nfid"));
		List<Notification> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(NotificationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//
		if( !StringUtils.isEmpty(cond.getNftype())){
			c.add(Expression.eq("nftype", cond.getNftype()));
		}	
		if( !StringUtils.isEmpty(cond.getNfstatus())){
			c.add(Expression.eq("nfstatus", cond.getNfstatus()));
		}

		return c;
	}
	
	public int getSearchCount(final NotificationSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
}
