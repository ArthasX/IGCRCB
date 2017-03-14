/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.dbs.model.dao.Impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.dbs.model.Collect_CXVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_CXVWDAO;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_CXVW;

public class Collect_CXVWDAOImpl extends BaseHibernateDAOImpl<Collect_CXVWInfo>
		implements Collect_CXVWDAO {
	// 动态画出CX
	@SuppressWarnings("unchecked")
	public List<Collect_CXVWInfo> CX_findProtDeviceName(
			final Collect_BusySearchCond cond, final int start, final int count) {
		List<Collect_CXVWInfo> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						session.flush();
						StringBuffer query = new StringBuffer();

						query.append(session.getNamedQuery(
								"Collect_ProtVWDAO.CX_findProtDeviceName")
								.getQueryString());
						SQLQuery q = session.createSQLQuery(query.toString());
						q.setProperties(cond);
						ScrollableResults sr = q.scroll();
						List<Collect_CXVWInfo> lstCollect_CXVW = new ArrayList<Collect_CXVWInfo>();
						while (sr.next()) {
							Collect_CXVW collect_CXVW = new Collect_CXVW();
							collect_CXVW.setObject_Name(String
									.valueOf(sr.get()[0]));
							collect_CXVW.setSysBusy(BigDecimal.ZERO);
							lstCollect_CXVW.add(collect_CXVW);
						}
						session.flush();
						session.clear();
						session.close();
						return lstCollect_CXVW;
					}
				});
		return list;
	}

	// 查询CX性能总图的使用率
	@SuppressWarnings("unchecked")
	public List<Collect_CXVWInfo> findSPByCond_CX(
			final Collect_BusySearchCond cond, int start, int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if ("MAX".equals(cond.getFlag())) {
					query.append(session.getNamedQuery(
							"Collect_SPVWDAO_CX.findByCond1").getQueryString());
					getSQL_CX(cond, query);
					query.append(session.getNamedQuery(
							"Collect_SPVWDAO_CX.findByCond2").getQueryString());
					getSQL_CX(cond, query);
					query.append(session.getNamedQuery(
							"Collect_SPVWDAO_CX.findByCond3").getQueryString());
				} else if ("AVG".equals(cond.getFlag())) {
					query.append(session.getNamedQuery(
							"Collect_SPVWDAO_CX.findByCond4").getQueryString());
					getSQL_CX(cond, query);
					query.append(" group by object_name");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				// q.addEntity("csmr",Collect_Dir_RfbVW.class);
				q.setProperties(cond);

				ScrollableResults sr = q.scroll();
				List<Collect_CXVWInfo> lstCollect_CXVW = new ArrayList<Collect_CXVWInfo>();
				while (sr.next()) {
					Collect_CXVW collect_CXVW = new Collect_CXVW();
					if ("MAX".equals(cond.getFlag())) {
						collect_CXVW.setSymtime(String.valueOf(sr.get()[0]));
						collect_CXVW.setDirector_number(String
								.valueOf(sr.get()[1]));
						collect_CXVW.setSysBusy((BigDecimal) sr.get()[2]);
					} else if ("AVG".equals(cond.getFlag())) {
						collect_CXVW.setSymtime("");
						collect_CXVW.setDirector_number(String
								.valueOf(sr.get()[0]));
						collect_CXVW.setSysBusy((BigDecimal) sr.get()[1]);
					}
					lstCollect_CXVW.add(collect_CXVW);
				}

				session.flush();
				session.clear();
				session.close();

				return lstCollect_CXVW;
			}

		};
		return (List<Collect_CXVWInfo>) execute(action);
	}

	private void getSQL_CX(final Collect_BusySearchCond cond, StringBuffer query) {

		if (cond.getDate_from() != null) {
			query.append(" and poll_time>=:date_from ");
		}
		if (cond.getDate_to() != null) {
			query.append(" and poll_time<=:date_to ");
		}
		// if (cond.getDate_from() != null) {
		// query.append(" and savetime>=:date_from ");
		// }
		// if (cond.getDate_to() != null) {
		// query.append(" and savetime<=:date_to ");
		// }
		// query.append(" ");
	}

	@SuppressWarnings("unchecked")
	public List<Collect_CXVWInfo> findProtByCond_CX(
			final Collect_BusySearchCond cond, int start, int count) {

		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if ("MAX".equals(cond.getFlag())) {
					query.append(session.getNamedQuery(
							"Collect_ProtVWDAO_CX.findByCond1")
							.getQueryString());
					getSQL_CX(cond, query);
					query.append(session.getNamedQuery(
							"Collect_ProtVWDAO_CX.findByCond2")
							.getQueryString());
					getSQL_CX(cond, query);
					query.append(session.getNamedQuery(
							"Collect_ProtVWDAO_CX.findByCond3")
							.getQueryString());
				} else if ("AVG".equals(cond.getFlag())) {
					query.append(session.getNamedQuery(
							"Collect_ProtVWDAO_CX.findByCond4")
							.getQueryString());
					getSQL_CX(cond, query);
					query.append(" group by object_name");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				// q.addEntity("csmr",Collect_Dir_RfbVW.class);
				q.setProperties(cond);

				ScrollableResults sr = q.scroll();
				List<Collect_CXVWInfo> lstCollect_CXVW = new ArrayList<Collect_CXVWInfo>();
				while (sr.next()) {
					Collect_CXVW collect_CXVW = new Collect_CXVW();
					if ("MAX".equals(cond.getFlag())) {
						collect_CXVW.setSymtime(String.valueOf(sr.get()[0]));
						collect_CXVW.setDirector_number(String
								.valueOf(sr.get()[1]));
						collect_CXVW.setSysBusy((BigDecimal) sr.get()[2]);
					} else if ("AVG".equals(cond.getFlag())) {
						collect_CXVW.setSymtime("");
						collect_CXVW.setDirector_number(String
								.valueOf(sr.get()[0]));
						collect_CXVW.setSysBusy((BigDecimal) sr.get()[1]);
					}
					lstCollect_CXVW.add(collect_CXVW);
				}

				session.flush();
				session.clear();
				session.close();

				return lstCollect_CXVW;
			}

		};
		return (List<Collect_CXVWInfo>) execute(action);
	}
}
