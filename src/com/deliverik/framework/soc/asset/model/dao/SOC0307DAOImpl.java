/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0307Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0307VW;


public class SOC0307DAOImpl extends BaseHibernateDAOImpl<SOC0307Info>
		implements SOC0307DAO {

	/**
	 * 构造函数
	 */
	public SOC0307DAOImpl() {
		super(SOC0307VW.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<SOC0307Info> findByCond(final SOC0305SearchCond cond,
			final int start,final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("SOC0307DAO.findByCond").getQueryString());
				
				getSQL(cond, query);
				query.append(") vw order by detectiontime desc"); //query.append(") as vw order by detectiontime desc");
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity(SOC0307VW.class);
				setFetchPoint(q, start, count);
				List<SOC0307Info> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<SOC0307Info>) execute(action);
	}


	public int getSearchCount(final SOC0305SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("SOC0307DAO.getSearchCount").getQueryString());
				
				getSQL(cond, query);
				
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.setProperties(cond);

				session.clear();

				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}


	/**
	 * 检索条件生成
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(SOC0305SearchCond cond, StringBuffer query){
		
		if( !StringUtils.isEmpty(cond.getImpcitype())){
			 query.append(" AND imptypeid ='"+cond.getImpcitype()+"'");
		}
		
		if( !StringUtils.isEmpty(cond.getEirootmark_eq())){
			 query.append(" AND eirootmark ='"+cond.getEirootmark_eq()+"'");
		}
		
		if( !StringUtils.isEmpty(cond.getDir_eq())){
			 query.append(" AND dir ='"+cond.getDir_eq()+"'");
		}
		
		if( !StringUtils.isEmpty(cond.getErrornum_eq())){
			 query.append(" AND errornum ='"+cond.getErrornum_eq()+"'");
		}
		
		if( !StringUtils.isEmpty(cond.getDetectiontime_from())){
			 query.append(" AND detectiontime >='"+cond.getDetectiontime_from()+"'");
		}
		
		if( !StringUtils.isEmpty(cond.getDetectiontime_to())){
			 query.append(" AND detectiontime <='"+cond.getDetectiontime_to()+"'");
		}
		
		if( !StringUtils.isEmpty(cond.getSeverity_eq())){
			 query.append(" AND severity ='"+cond.getSeverity_eq()+"'");
		}
		
		if( !StringUtils.isEmpty(cond.getErrorDesc())){
			 query.append(" AND errordesc ='"+cond.getErrorDesc()+"'");
		}
		
		if( !StringUtils.isEmpty(cond.getAlarmType())){
			 query.append(" AND alarmType ='"+cond.getAlarmType()+"'");
		}
		
		if( !StringUtils.isEmpty(cond.getId())){
			 query.append(" AND id ="+cond.getId());
		}
		
		//处理状态
		if( !StringUtils.isEmpty(cond.getStatus())){
			 query.append(" AND status ='"+cond.getStatus()+"'");
		}
	}
}