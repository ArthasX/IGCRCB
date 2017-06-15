package com.deliverik.infogovernor.prj.model.dao;

import java.io.Serializable;
import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.prj.model.Project;
import com.deliverik.infogovernor.prj.model.condition.ProjectSearchCond;
import com.deliverik.infogovernor.prj.model.entity.ProjectTB;

/**
 * 
 */
@SuppressWarnings("deprecation")
public class ProjectTBDAOImpl extends BaseHibernateDAOImpl<Project> implements ProjectTBDAO {

	/**
	 * 
	 */
	public ProjectTBDAOImpl(){
		super(ProjectTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<Project> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("pid"));
		List<Project> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param 
	 * @return 
	 */
	public Project findByPK(Serializable pid) {

		Project rl = super.findByPK(pid);
		if(rl == null) return null;

		return rl;
	}

	public List<Project> findByCond(final ProjectSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("popentime"));
		List<Project> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(ProjectSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if( !StringUtils.isEmpty(cond.getPname())){
			c.add(Expression.like("pname", "%" + cond.getPname() + "%"));
		}
		if( !StringUtils.isEmpty(cond.getPstatus())){
			c.add(Expression.eq("pstatus", cond.getPstatus()));
		}
		if( !StringUtils.isEmpty(cond.getPtype())){
			c.add(Expression.eq("ptype", cond.getPtype()));
		}
		if( !StringUtils.isEmpty(cond.getPcode())){
			c.add(Expression.eq("pcode", cond.getPcode()));
		}
		if( !StringUtils.isEmpty(cond.getPopentime())){
			c.add(Expression.ge("popentime", cond.getPopentime()));
		}
		if( !StringUtils.isEmpty(cond.getPclosetime())){
			c.add(Expression.le("pclosetime", cond.getPclosetime()));
		}
		if(cond.getPbid_q()!=null&&cond.getPbid_q()!=0){
			c.add(Expression.eq("pbid", cond.getPbid_q()));
		}
		return c;
	}

	public int getSearchCount(final ProjectSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}


}
