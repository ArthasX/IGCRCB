/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.CicollecttaskInfo;
import com.deliverik.framework.soc.asset.model.condition.CicollecttaskSearchCond;
import com.deliverik.framework.soc.asset.model.entity.CicollecttaskVW;

/**
 * 概述: cicollecttaskDAO实现 功能描述: cicollecttaskDAO实现 创建记录: 2013/07/05 修改记录: 王省
 */
public class CicollecttaskDAOImpl extends
		BaseHibernateDAOImpl<CicollecttaskInfo> implements CicollecttaskDAO {

	public CicollecttaskDAOImpl() {
		super(CicollecttaskVW.class);
	}

	@SuppressWarnings("unchecked")
	public List<CicollecttaskInfo> findByCond(
			final CicollecttaskSearchCond cond, final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<CicollecttaskInfo> list = null;

				// query.append(session.getNamedQuery("DealOrgVWDAO.dealOrgVW").getQueryString());
				query.append("select A.resource_id as resourceid,B.name as typename,C.name as servername,D.name as platformname,");
				query.append("E.uuid,E.name,E.startrule,E.stoprule,E.starttime,E.stoptime,");
				query.append("E.newstarttime,E.newstoptime,E.executstatus,E.periodtype from( ");
				query.append("select resource_id, server_type_id,platform_id from eam_server ");
				getSQL(cond, query, 1);
				query.append(") A left join eam_server_type B on A.server_type_id = B.id ");
				query.append("left join eam_resource C on A.resource_id = C.id ");
				query.append("left join(select x.id,y.name from eam_platform x left join eam_resource y ");
				query.append("on x.resource_id = y.id) D on A.platform_id = D.id ");
				query.append("left join timer01 E on A.resource_id = E.resourceid where 1=1 ");
				getSQL(cond, query, 2);
				query.append(" order by D.name");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("CicollecttaskVW", CicollecttaskVW.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<CicollecttaskInfo>) execute(action);
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getTypeIdByName(final List<String> names) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<String> ids = null;
				query.append("select id from eam_server_type where Upper(name) in(");
				for (int i = 0; i < names.size(); i++) {
					query.append("'" + names.get(i).toUpperCase() + "'");
					if (i < names.size() - 1)
						query.append(",");
				}
				query.append(")");
				SQLQuery q = session.createSQLQuery(query.toString());
				ids = q.list();
				session.clear();
				session.close();
				return ids;
			}
		};
		return (List<Integer>) execute(action);
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getResourceIdByType(final List<Integer> typeids) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<String> ids = null;
				query.append("select resource_id from eam_server where server_type_id in(");
				for (int i = 0; i < typeids.size(); i++) {
					query.append(typeids.get(i));
					if (i < typeids.size() - 1)
						query.append(",");
				}
				query.append(")");
				SQLQuery q = session.createSQLQuery(query.toString());
				ids = q.list();
				session.clear();
				session.close();
				return ids;
			}
		};
		return (List<Integer>) execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(CicollecttaskSearchCond cond, StringBuffer query,
			int location) {
		if (location == 1) {
			List<Integer> ids = cond.getTypeIds();
			if (ids != null && ids.size() != 0) {
				query.append("where server_type_id in(");
				for (int i = 0; i < ids.size(); i++) {
					query.append(ids.get(i));
					if (i < ids.size() - 1)
						query.append(",");
				}
				query.append(")");
			}
		}
		if (location == 2) {
			if (StringUtils.isNotEmpty(cond.getExecutstatus())) {
				query.append(" and E.executstatus = '" + cond.getExecutstatus()
						+ "'");
			}
			if (StringUtils.isNotEmpty(cond.getNewstarttime())) {
				query.append(" and E.newstarttime like '"
						+ cond.getNewstarttime() + "%'");
			}
		}

	}

	@SuppressWarnings("unchecked")
	public Integer getSearchCount(final CicollecttaskSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<String> list = null;

				query.append("select count(*) from( ");
				query.append("select resource_id, server_type_id,platform_id from eam_server ");
				getSQL(cond, query, 1);
				query.append(") A left join eam_server_type B on A.server_type_id = B.id ");
				query.append("left join eam_resource C on A.resource_id = C.id ");
				query.append("left join(select x.id,y.name from eam_platform x left join eam_resource y ");
				query.append("on x.resource_id = y.id) D on A.platform_id = D.id ");
				query.append("left join timer01 E on A.resource_id = E.resourceid where 1=1 ");
				getSQL(cond, query, 2);
				SQLQuery q = session.createSQLQuery(query.toString());
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return ((List<java.math.BigInteger>) execute(action)).get(0).intValue();
	}

	/**
	 * get Plateform Name List
	 */
	public List<String> getPlateformNameList() throws Exception {

		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<String> ids = null;
				query.append("select t2.name from eam_platform t1, eam_resource t2 ");
				query.append("where t1.resource_id=t2.id ");
				SQLQuery q = session.createSQLQuery(query.toString());
				ids = q.list();
				session.clear();
				session.close();
				return ids;
			}
		};
		return (List<String>) execute(action);
	}
}