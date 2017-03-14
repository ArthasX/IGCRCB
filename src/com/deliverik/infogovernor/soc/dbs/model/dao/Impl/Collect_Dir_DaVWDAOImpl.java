package com.deliverik.infogovernor.soc.dbs.model.dao.Impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_DaVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Dir_DaVWDAO;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_Dir_DaVW;

public class Collect_Dir_DaVWDAOImpl extends BaseHibernateDAOImpl<Collect_Dir_DaVWInfo> implements Collect_Dir_DaVWDAO {

	@SuppressWarnings("unchecked")
	public List<Collect_Dir_DaVWInfo> findByCond(
			final Collect_BusySearchCond cond, int start, int count) {

		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();

				if ("MAX".equals(cond.getFlag())) {
					query.append(session.getNamedQuery("Collect_Dir_DaVWDAO.findByCond1").getQueryString());
					getSQL(cond, query);
					query.append(session.getNamedQuery("Collect_Dir_DaVWDAO.findByCond2").getQueryString());
					getSQL(cond, query);
					query.append(session.getNamedQuery("Collect_Dir_DaVWDAO.findByCond3").getQueryString());
				} else if ("AVG".equals(cond.getFlag())) {
					query.append(session.getNamedQuery("Collect_Dir_DaVWDAO.findByCond4").getQueryString());
					getSQL(cond, query);
					query.append(" group by device_name");
				}
				SQLQuery q = session.createSQLQuery(query.toString());

				q.setProperties(cond);

				ScrollableResults sr = q.scroll();
				List<Collect_Dir_DaVWInfo> astCollect_Dir_DaVW = new ArrayList<Collect_Dir_DaVWInfo>();
				while (sr.next()) {
					Collect_Dir_DaVW collect_Dir_DaVW = new Collect_Dir_DaVW();
					if ("MAX".equals(cond.getFlag())) {
						collect_Dir_DaVW.setSymtime(String.valueOf(sr.get()[0]));
						collect_Dir_DaVW.setDirector_number(String.valueOf(sr.get()[1]));
						collect_Dir_DaVW.setSysBusy((BigDecimal) sr.get()[2]);
					} else if ("AVG".equals(cond.getFlag())) {
						collect_Dir_DaVW.setSymtime("");
						collect_Dir_DaVW.setDirector_number(String.valueOf(sr.get()[0]));
						collect_Dir_DaVW.setSysBusy((BigDecimal) sr.get()[1]);
					}
					astCollect_Dir_DaVW.add(collect_Dir_DaVW);
				}
				session.clear();
				return parse(astCollect_Dir_DaVW);
			}
		};
		return (List<Collect_Dir_DaVWInfo>) execute(action);
	}

	private void getSQL(final Collect_BusySearchCond cond, StringBuffer query) {

//		if (cond.getDate_from() != null) {
//			query.append(" and data_times>=:date_from ");
//		}
//		if (cond.getDate_to() != null) {
//			query.append(" and data_times<=:date_to ");
//		}
		if (cond.getDate_from() != null) {
		query.append(" and savetime>=:date_from ");
	    }
		if (cond.getDate_to() != null) {
		query.append(" and savetime<=:date_to ");
		}
		query.append(" ");
	}

	/**
	 * 去除重复的设备
	 */
	private List<Collect_Dir_DaVWInfo> parse(List<Collect_Dir_DaVWInfo> list) {

		List<String> nameList = new ArrayList<String>();

		List<Collect_Dir_DaVWInfo> newList = new ArrayList<Collect_Dir_DaVWInfo>();

		for (int i = 0; i < list.size(); i++) {

			Collect_Dir_DaVWInfo info = list.get(i);

			if (!nameList.contains(info.getDirector_number())) {
				nameList.add(info.getDirector_number());
				newList.add(info);
			}
		}
		return newList;
	}

	/**
	 * 判断时间范围是否为昨天 00:00 至 23:59
	 * 
	 * @param cond
	 * @return
	 */
	@SuppressWarnings("unused")
	private String isYesterday(final Collect_BusySearchCond cond) {
		String flag = "";
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy/MM/dd");
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int day = c.get(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, day - 1);
		Date new_time = c.getTime();
		String lastdate = sdfTime.format(new_time);

		if ((lastdate + " 00:00").equals(cond.getDate_from())
				&& (lastdate + " 23:59").equals(cond.getDate_to())) {
			flag = "Yesterday";
		}
		return flag;
	}
}
