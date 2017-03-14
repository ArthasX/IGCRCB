package com.deliverik.framework.workflow.prr.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG019Info;
import com.deliverik.framework.workflow.prr.model.condition.IG019SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG019VW;

public class IG019DAOImpl extends BaseHibernateDAOImpl<IG019Info> implements IG019DAO {

	/**
	 * 事件和服务请求流程汇总视图构造函数
	 * 
	 */
	public IG019DAOImpl(){
		super(IG019VW.class);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public int getSearchCount(final IG019SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG019DAO.serviceRequestCountQuery").getQueryString());
				getServiceRequestSQL(cond, query);
				query.append(" GROUP BY prorgid,prorgname ");
				query.append(session.getNamedQuery("IG019DAO.incidentCountQuery").getQueryString());
				getIncidentSQL(cond, query);
				query.append(" GROUP BY c.orgsyscoding,c.orgname) d GROUP BY orgsyscoding,orgname) prcount ORDER BY count DESC");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount",IG019VW.class);
				setFetchPoint(q, 0, 0);
				List<IG019Info> list = q.list();
				session.clear();
				return list.size();
			}
		};
		return (Integer) execute(action);
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG019Info> findByCond(final IG019SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG019DAO.serviceRequestCountQuery").getQueryString());
				getServiceRequestSQL(cond, query);
				query.append(" GROUP BY prorgid,prorgname ");
				query.append(session.getNamedQuery("IG019DAO.incidentCountQuery").getQueryString());
				getIncidentSQL(cond, query);
				query.append(" GROUP BY c.orgsyscoding,c.orgname) d GROUP BY orgsyscoding,orgname) prcount ORDER BY count DESC");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount",IG019VW.class);
				setFetchPoint(q, start, count);
				List<IG019Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG019Info>) execute(action);
	}
	
	/**
	 * 服务请求检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getServiceRequestSQL(IG019SearchCond cond, StringBuffer query){
		//机构层次码
		if( StringUtils.isNotEmpty(cond.getOrgsyscoding()) ){
			query.append(" AND prorgid like :orgsyscoding");
		}	
		//年度
		if( StringUtils.isNotEmpty(cond.getYear()) ){
			query.append(" AND substr(propentime,1,4) =:year");
		}	
	}
	
	/**
	 * 事件检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getIncidentSQL(IG019SearchCond cond, StringBuffer query){
		//机构层次码
		if( StringUtils.isNotEmpty(cond.getOrgsyscoding()) ){
			query.append(" AND c.orgsyscoding like :orgsyscoding");
		}	
		//年度
		if( StringUtils.isNotEmpty(cond.getYear()) ){
			query.append(" AND substr(prplantime,1,4) =:year");
		}	
	}
}
