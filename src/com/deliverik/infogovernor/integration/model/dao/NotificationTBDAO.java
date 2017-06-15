package com.deliverik.infogovernor.integration.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.integration.model.Notification;
import com.deliverik.infogovernor.integration.model.condition.NotificationSearchCond;

/**
 * 
 */
public interface NotificationTBDAO extends BaseHibernateDAO<Notification> {

	/**
	 *
	 * @return 
	 */
	public List<Notification> findAll();

	/**
	 *
	 * @param noticeid
	 * @return 
	 */
	public Notification findByPK(Serializable nfid);

	public List<Notification> findByCond(final NotificationSearchCond cond, final int start, final int count);
	
	public int getSearchCount(final NotificationSearchCond cond);
}
