package com.deliverik.infogovernor.prj.model.dao;

import java.io.Serializable;
import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.prj.model.ProjectPlan;
import com.deliverik.infogovernor.prj.model.condition.ProjectPlanSearchCond;
import com.deliverik.infogovernor.prj.model.entity.ProjectPlanTB;


/**
 * 
 */
@SuppressWarnings("deprecation")
public class ProjectPlanTBDAOImpl extends BaseHibernateDAOImpl<ProjectPlan> implements ProjectPlanTBDAO {

	/**
	 * 
	 */
	public ProjectPlanTBDAOImpl(){
		super(ProjectPlanTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<ProjectPlan> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("pplid"));
		List<ProjectPlan> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param 
	 * @return 
	 */
	public ProjectPlan findByPK(Serializable pplid) {

		ProjectPlan rl = super.findByPK(pplid);
		if(rl == null) return null;

		return rl;
	}

	public List<ProjectPlan> findByCond(final ProjectPlanSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		if(StringUtils.isNotEmpty(cond.getOrderdesc())){
			c.addOrder(Order.desc(cond.getOrderdesc()));
		}else{
			c.addOrder(Order.asc("pplid"));
		}
		List<ProjectPlan> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(ProjectPlanSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if( !StringUtils.isEmpty(cond.getPplstatus())){
			c.add(Expression.eq("pplstatus", cond.getPplstatus()));
		}
		if( cond.getPplversion() != null && cond.getPplversion() != 0){
			c.add(Expression.eq("pplversion", cond.getPplversion()));
		}
		if( cond.getPid() != null && cond.getPid() != 0){
			c.add(Expression.eq("pid", cond.getPid()));
		}

		return c;
	}

}
