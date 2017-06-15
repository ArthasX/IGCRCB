package com.deliverik.infogovernor.prj.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prj.model.ProjectLog;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogSearchCond;




/**
 * 
 */
public interface ProjectLogTBDAO extends BaseHibernateDAO<ProjectLog> {

	/**
	 *
	 * @return 
	 */
	public List<ProjectLog> findAll();

	/**
	 *
	 * @param
	 * @return 
	 */
	public ProjectLog findByPK(Serializable plid);

	public List<ProjectLog> findByCond(final ProjectLogSearchCond cond, final int start, final int count);

}
