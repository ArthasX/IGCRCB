/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.sym.model.DateWorkVWInfo;
import com.deliverik.infogovernor.sym.model.condition.NoticeSearchCond;
import com.deliverik.infogovernor.sym.model.entity.DateWorkVW;

/**
 * @Description: 通知管理
 * @Author  
 * @History 2009-8-18     新建 
 * @Version V2.0
 */
public class DateWorkVWDAOImpl extends BaseHibernateDAOImpl<DateWorkVWInfo> implements DateWorkVWDAO {
	/**
	 * 
	 */
	public DateWorkVWDAOImpl(){
		super(DateWorkVW.class);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<DateWorkVWInfo> findByCond(final NoticeSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("DateWorkVWDAO.dateWorkInfo").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("DateWork",DateWorkVW.class);
				List<DateWorkVWInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<DateWorkVWInfo>) execute(action);
	}
	public List<DateWorkVWInfo> findByCond(final NoticeSearchCond cond, final List<UserRoleInfo> list){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("DateWorkVWDAO.dateWorkUnInfo").getQueryString());
				if(list.size()>0){
					query.append(" AND a.PRROLEID in (");
					for(int i=0; i<list.size(); i++){
						if(i==0){
							query.append(list.get(i).getRoleid());
						}else{
							query.append(", "+list.get(i).getRoleid());
						}
					}
					query.append(")");
				}
				query.append(" GROUP BY substr(a.PRPLANTIME,9,2)) DateWork ORDER BY DateWork.date");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("DateWork",DateWorkVW.class);
				List<DateWorkVWInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<DateWorkVWInfo>) execute(action);
	}
	public List<DateWorkVWInfo> findByCond(final NoticeSearchCond cond, final List<UserRoleInfo> list, final String temp){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("DateWorkVWDAO.dateWorkUnInfo").getQueryString());
				if(list.size()>0){
					query.append(" AND a.PRROLEID not in (");
					for(int i=0; i<list.size(); i++){
						if(i==0){
							query.append(list.get(i).getRoleid());
						}else{
							query.append(", "+list.get(i).getRoleid());
						}
					}
					query.append(")");
				}
				query.append(" GROUP BY substr(a.PRPLANTIME,9,2)) DateWork ORDER BY DateWork.date");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("DateWork",DateWorkVW.class);
				List<DateWorkVWInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<DateWorkVWInfo>) execute(action);
	}
}
