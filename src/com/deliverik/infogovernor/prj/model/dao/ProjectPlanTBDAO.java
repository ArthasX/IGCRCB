package com.deliverik.infogovernor.prj.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prj.model.ProjectPlan;
import com.deliverik.infogovernor.prj.model.condition.ProjectPlanSearchCond;




/**
 * 
 */
public interface ProjectPlanTBDAO extends BaseHibernateDAO<ProjectPlan> {

	/**
	 *
	 * @return 
	 */
	public List<ProjectPlan> findAll();

	/**
	 *
	 * @param
	 * @return 
	 */
	public ProjectPlan findByPK(Serializable pplid);

	public List<ProjectPlan> findByCond(final ProjectPlanSearchCond cond, final int start, final int count);

}
