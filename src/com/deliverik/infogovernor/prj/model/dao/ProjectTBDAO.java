package com.deliverik.infogovernor.prj.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prj.model.Project;
import com.deliverik.infogovernor.prj.model.condition.ProjectSearchCond;

/**
 * 
 */
public interface ProjectTBDAO extends BaseHibernateDAO<Project> {

	/**
	 *
	 * @return 
	 */
	public List<Project> findAll();

	/**
	 *
	 * @param
	 * @return 
	 */
	public Project findByPK(Serializable pid);

	public List<Project> findByCond(final ProjectSearchCond cond, final int start, final int count);
	
	public int getSearchCount(final ProjectSearchCond cond);
}
