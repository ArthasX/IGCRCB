package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.Notice;
import com.deliverik.infogovernor.sym.model.condition.NoticeSearchCond;

/**
 * 
 */
public interface NoticeTBDAO extends BaseHibernateDAO<Notice> {

	/**
	 *
	 * @return 
	 */
	public List<Notice> findAll();

	/**
	 *
	 * @param noticeid
	 * @return 
	 */
	public Notice findByPK(Serializable noticeid);

	public List<Notice> findByCond(final NoticeSearchCond cond, final int start, final int count);
	
	public int getSearchCount(final NoticeSearchCond cond);
}
