package com.deliverik.infogovernor.scheduling.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzJobsDetail;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzJobsSearchCond;
import com.deliverik.infogovernor.scheduling.model.entity.QuartzJobsDetailVW;
import com.deliverik.infogovernor.scheduling.model.entity.QuartzJobsTB;

/**
 * 
 */
@SuppressWarnings("deprecation")
public class QuartzJobsTBDAOImpl extends BaseHibernateDAOImpl<QuartzJobs> implements QuartzJobsTBDAO {

	/**
	 * 
	 */
	public QuartzJobsTBDAOImpl(){
		super(QuartzJobsTB.class);
	}

	/**
	 *
	 * @return 
	 */
	public List<QuartzJobs> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		List<QuartzJobs> ret = findByCriteria(c);

		return ret;
	}

	/**
	 *
	 * @param user_id 
	 * @return 
	 */
	public QuartzJobs findByPK(Serializable qjid) {

		QuartzJobs jobs = super.findByPK(qjid);
		if(jobs == null) return null;

		return jobs;
	}

	public List<QuartzJobs> findByCond(final QuartzJobsSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("qjid"));
		List<QuartzJobs> ret = findByCriteria(c, start, count);
		return ret;
	}

	
	/**
	 * 根据登记用户,处理用户和时间查询运维计划记录数
	 * @return int
	 */
	public int queryQuartzJobsCountByUserDate(final QuartzJobsSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("Qjcrutser.QjcrutserAndParticipantQueryCount").getQueryString());
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());		
				q.setString("userid", cond.getUserid());
				q.setString("date_q", cond.getDate_q());
				q.setString("date_j", cond.getDate_j());
				
				//q.setProperties(cond);
				session.clear();
				return getCount(q.list());

			}
		};
		return (Integer) execute(action);
	}
	
	/**
	 * 根据时间和登录用户查询服务策略
	 * @param QuartzJobsSearchCond 查询条件
	 * date_q 开始时间
	 * date_j 结束时间
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<QuartzJobsDetail> queryQuartzJobsByUserDate(final QuartzJobsSearchCond cond,final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("Qjcrutser.QjcrutserAndParticipantQuery").getQueryString());
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("userid", cond.getUserid());
				q.setString("date_q", cond.getDate_q());
				q.setString("date_j", cond.getDate_j());
				
				q.addEntity("qj",QuartzJobsDetailVW.class);
				setFetchPoint(q, start, count);
				List<IG337Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<QuartzJobsDetail>) execute(action);
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(QuartzJobsSearchCond cond, StringBuffer query){
		if( !StringUtils.isEmpty(cond.getQjassetid())){
			query.append(" AND e.qjassetid = '").append(cond.getQjassetid()).append("'");
		}
		if( !StringUtils.isEmpty(cond.getQjassettypeid())){
			query.append(" AND e.qjassettypeid like '").append(cond.getQjassettypeid()).append("%'");
		}
	
		
	}
	
	
	/**
	 * 
	 * 
	 * @param cond
	 * @return
	 */
	protected DetachedCriteria getCriteria(QuartzJobsSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if(cond.getQjid()!=null && cond.getQjid()!=0){
			c.add(Expression.eq("qjid", cond.getQjid()));
		}
		if(!StringUtils.isEmpty(cond.getQjtype())){
			c.add(Expression.eq("qjtype", cond.getQjtype()));
		}	
		if(!StringUtils.isEmpty(cond.getQjstatus())){
			c.add(Expression.eq("qjstatus", cond.getQjstatus()));
		}
		if(!StringUtils.isEmpty(cond.getQjimpluser())||!StringUtils.isEmpty(cond.getQjcrtuser())){
			c.add(Expression.or(
				Expression.eq("qjcrtuser", cond.getQjcrtuser()),
				Expression.eq("qjimpluser", cond.getQjimpluser())));
		}
		if(!StringUtils.isEmpty(cond.getQjname())){
			c.add(Expression.eq("qjname", cond.getQjname()));
		}
		if(!StringUtils.isEmpty(cond.getQjtriname())){
			c.add(Expression.eq("qjtriname", cond.getQjtriname()));
		}
		
		if(StringUtils.isNotEmpty(cond.getEndTime())){
			c.add(Expression.le("qjcrttime", cond.getEndTime()));
		}
		if(StringUtils.isNotEmpty(cond.getStartTime())){
//			c.add(Expression.ge("qjendtime", cond.getStartTime()));
			c.add(Expression.or(
					Expression.ge("qjendtime", cond.getStartTime()),
					Expression.ge("qjcrttime", cond.getStartTime())));
		}
		
		if(StringUtils.isNotEmpty(cond.getQjassetid())){
			c.add(Expression.eq("qjassetid", cond.getQjassetid()));
		}
		if(StringUtils.isNotEmpty(cond.getQjassettypeid())){
			c.add(Expression.like("qjassettypeid", cond.getQjassettypeid()+"%"));
		}
		
		if(!StringUtils.isEmpty(cond.getQjtype_q())){
			c.add(Expression.isNotNull("qjtype"));
		}
		
		if(!StringUtils.isEmpty(cond.getDate_q())){
			c.add(Expression.or(Expression.le("qjcrttime", cond.getDate_j()), Expression.eq("qjcrttime", cond.getDate_q())));
		}
		
		if(!StringUtils.isEmpty(cond.getDate())){
			c.add(Expression.or(Expression.and(Expression.ge("qjendtime", cond.getDate()), Expression.le("qjcrttime", cond.getDate())), Expression.eq("qjcrttime", cond.getDate())));			
		}
		
		if(!StringUtils.isEmpty(cond.getYmonth_q())){
			c.add(Expression.le("qjcrttime", cond.getYmonth_q()+"/31"));
		}
		
		return c;
	}
	
	public int getSearchCount(final QuartzJobsSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
}
