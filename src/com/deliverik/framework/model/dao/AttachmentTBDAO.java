package com.deliverik.framework.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.condition.AttachmentSearchCond;




/**
 * 
 */
public interface AttachmentTBDAO extends BaseHibernateDAO<Attachment> {

	/**
	 *
	 * @return 
	 */
	public List<Attachment> findAll();

	/**
	 *
	 * @param userid
	 * @return 
	 */
	public Attachment findByPK(Serializable attid);

	public List<Attachment> findByCond(final AttachmentSearchCond cond, final int start, final int count);

}
