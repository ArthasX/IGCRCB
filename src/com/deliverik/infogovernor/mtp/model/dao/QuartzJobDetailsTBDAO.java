package com.deliverik.infogovernor.mtp.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCond;




/**
 * 
 */
public interface QuartzJobDetailsTBDAO extends BaseHibernateDAO<QuartzJobDetails> {

	/**
	 *
	 * @return 
	 */
	public List<QuartzJobDetails> findAll();

	/**
	 *
	 * @param rlid
	 * @return 
	 */
	public QuartzJobDetails findByPK(Serializable piid);

	public List<QuartzJobDetails> findByCond(final QuartzJobDetailsSearchCond cond, final int start, final int count);
	
	public int getSearchCount(final QuartzJobDetailsSearchCond cond);

}
