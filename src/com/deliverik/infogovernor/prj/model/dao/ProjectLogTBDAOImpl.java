package com.deliverik.infogovernor.prj.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.prj.model.ProjectLog;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogSearchCond;
import com.deliverik.infogovernor.prj.model.entity.ProjectLogTB;


/**
 * 
 */
@SuppressWarnings("deprecation")
public class ProjectLogTBDAOImpl extends BaseHibernateDAOImpl<ProjectLog> implements ProjectLogTBDAO {

	/**
	 * 构造函数
	 */
	public ProjectLogTBDAOImpl(){
		super(ProjectLogTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ProjectLog> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("plid"));
		List<ProjectLog> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ProjectLog findByPK(Serializable plid) {

		ProjectLog rl = super.findByPK(plid);
		if(rl == null) return null;

		return rl;
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProjectLog> findByCond(final ProjectLogSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("plid"));
		List<ProjectLog> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ProjectLogSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if((cond.getPid()!=null && cond.getPid() != 0)) {
			c.add(Expression.eq("pid", cond.getPid()));
		}
		if(StringUtils.isNotEmpty(cond.getPltime_from())){
			c.add(Expression.ge("pltime", cond.getPltime_from()));
		}
		if(StringUtils.isNotEmpty(cond.getPltime_to())){
			c.add(Expression.le("pltime", cond.getPltime_to()));
		}
		if(StringUtils.isNotEmpty(cond.getPlinfo())){
			c.add(Expression.like("plinfo","%"+cond.getPlinfo()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getPltype())){
			c.add(Expression.eq("pltype", cond.getPltype()));
		}
		if(StringUtils.isNotEmpty(cond.getPltype_ne())){
			c.add(Expression.ne("pltype",cond.getPltype_ne()));
		}
		return c;
	}

}
