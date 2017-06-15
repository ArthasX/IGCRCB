/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.framework.workflow.prr.model.condition.CurrentMonthWorkVWSearchCond;
import com.deliverik.framework.workflow.prr.model.entity.CurrentMonthWorkVW;


/**
 * 概述:查询带有处理人的本月工作 
 * 功能描述：查询带有处理人的本月工作
 * 创建人：赵梓廷
 * 创建记录： 2013-04-22
 * 修改记录：
 */
public class CurrentMonthWorkVWDAOImpl extends 
BaseHibernateDAOImpl<CurrentMonthWorkVWInfo> implements CurrentMonthWorkVWDAO{



	public int getSearchCurrentMonthWorkCount(final CurrentMonthWorkVWSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				query.append("select count(*) from(");
				query.append( session.getNamedQuery("CurrentMonthWorkVWDAO.searchcurrent").getQueryString());
	            if(cond.getRoleid()!=null&&cond.getRoleid().length>0){
	            	 query.append(" and  b.pproleid in (");
	            	 for(int index=0;index<cond.getRoleid().length;index++){
	            		 if(index==cond.getRoleid().length-1){
	            			 query.append(cond.getRoleid()[index]);
	            		 }else{	            			 
	            			 query.append(cond.getRoleid()[index]+",");
	            		 }
	            	 }
	            	 query.append(")");
	            }
				query.append("where 1=1 and  a.prstatus<>'D'");
	            if(StringUtils.isNotEmpty(cond.getMonth())){
	            	 query.append(" and a.propentime like '%"+cond.getMonth()+"%'");
	            }
	            query.append(" GROUP BY a.prid,a.prtitle,a.prstatus,a.prtype,a.prsubstatus,a.propentime,a.prclosetime,a.prurgency,a.primpact,a.prusername,a.pruserid,a.prroleid,a.prrolename,a.prpdid,a.prpdname,a.prserialnum");
	            query.append(")temp5");  
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				session.close();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}

	@SuppressWarnings("unchecked")
	public List<CurrentMonthWorkVWInfo> findCurrentMonthWorkByCond(
			final CurrentMonthWorkVWSearchCond cond,final int start,final int count) {
		 HibernateCallback action = new HibernateCallback() {
	           public Object doInHibernate(Session session) throws HibernateException, SQLException {
	               session.flush();
	               StringBuffer query = new StringBuffer();
	               query.append( session.getNamedQuery("CurrentMonthWorkVWDAO.searchcurrent").getQueryString());
		            if(cond.getRoleid()!=null&&cond.getRoleid().length>0){
		            	 query.append(" and  b.pproleid in (");
		            	 for(int index=0;index<cond.getRoleid().length;index++){
		            		 if(index==cond.getRoleid().length-1){
		            			 query.append(cond.getRoleid()[index]);
		            		 }else{	            			 
		            			 query.append(cond.getRoleid()[index]+",");
		            		 }
		            	 }
		            	 query.append(")");
		            }
	               query.append("where 1=1 and  a.prstatus<>'D'");
	               if(StringUtils.isNotEmpty(cond.getMonth())){
		            	 query.append(" and a.propentime like '%"+cond.getMonth()+"%'");
		            }
		           query.append(" GROUP BY a.prid,a.prtitle,a.prstatus,a.prtype,a.prsubstatus,a.propentime,a.prclosetime,a.prurgency,a.primpact,a.prusername,a.pruserid,a.prroleid,a.prrolename,a.prpdid,a.prpdname,a.prserialnum");
		            if(StringUtils.isNotEmpty(cond.getOrder())){
		            	if("ppusername".equals(cond.getOrder())){
		            		query.append(" order by ").append(cond.getOrder()).append("  ").append(cond.getSing());
		            	}else{		            		
		            		query.append(" order by a.").append(cond.getOrder()).append("  ").append(cond.getSing());
		            	}
					}
	               SQLQuery q = session.createSQLQuery(query.toString());
	               q.addEntity("CurrentMonthWorkVW",CurrentMonthWorkVW.class);
	               setFetchPoint(q, start, count);
//	               System.out.println(query.toString());
	               List<CurrentMonthWorkVWInfo> list = q.list();
	               session.clear();
	               return list;
	           }
	       };
		return (List<CurrentMonthWorkVWInfo>) execute(action);
	}

	
}
