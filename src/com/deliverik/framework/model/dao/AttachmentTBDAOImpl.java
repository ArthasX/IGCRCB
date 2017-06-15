package com.deliverik.framework.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.condition.AttachmentSearchCond;
import com.deliverik.framework.model.entity.AttachmentTB;


/**
 * 
 */
@SuppressWarnings("deprecation")
public class AttachmentTBDAOImpl extends BaseHibernateDAOImpl<Attachment> implements AttachmentTBDAO {

	/**
	 * 
	 */
	public AttachmentTBDAOImpl(){
		super(AttachmentTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<Attachment> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("attid"));
		List<Attachment> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param user_id 
	 * @return 
	 */
	public Attachment findByPK(Serializable attid) {

		Attachment att = super.findByPK(attid);
		if(att == null) return null;

		return att;
	}

	public List<Attachment> findByCond(final AttachmentSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("attid"));
		List<Attachment> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(AttachmentSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//
		if( !StringUtils.isEmpty(cond.getAttname())){
			c.add(Expression.eq("attname", cond.getAttname()));
		}	
		if( !StringUtils.isEmpty(cond.getAttkey())){
			c.add(Expression.eq("attkey", cond.getAttkey()));
		}	
		return c;
	}

}
