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
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_RfbVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Dir_RfbVWDAO;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_Dir_RfbVW;

public class Collect_Dir_RfbVWDAOImpl extends BaseHibernateDAOImpl<Collect_Dir_RfbVWInfo> implements Collect_Dir_RfbVWDAO {

	@SuppressWarnings("unchecked")
	public List<Collect_Dir_RfbVWInfo> findByCond(final Collect_BusySearchCond cond, int start, int count) {
		
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if ("MAX".equals(cond.getFlag())) {
					query.append(session.getNamedQuery("Collect_Dir_RfbVWDAO.findByCond1").getQueryString());
					getSQL(cond, query);
					query.append(session.getNamedQuery("Collect_Dir_RfbVWDAO.findByCond2").getQueryString());
					getSQL(cond, query);
					query.append(session.getNamedQuery("Collect_Dir_RfbVWDAO.findByCond3").getQueryString());
				} else if ("AVG".equals(cond.getFlag())) {
					query.append(session.getNamedQuery("Collect_Dir_RfbVWDAO.findByCond4").getQueryString());
					getSQL(cond, query);
					query.append(" group by device_name");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				//q.addEntity("csmr",Collect_Dir_RfbVW.class);            
				q.setProperties(cond);
				
				ScrollableResults sr =  q.scroll();
				List<Collect_Dir_RfbVWInfo> astCollect_Dir_RfbVW = new ArrayList<Collect_Dir_RfbVWInfo>();
				while(sr.next()){
				    Collect_Dir_RfbVW collect_Dir_RfbVW = new Collect_Dir_RfbVW();
				    if ("MAX".equals(cond.getFlag())) {
				    	collect_Dir_RfbVW.setSymtime(String.valueOf(sr.get()[0]));
				    	collect_Dir_RfbVW.setDirector_number(String.valueOf(sr.get()[1]));		
				    	collect_Dir_RfbVW.setSysBusy((BigDecimal)sr.get()[2]);
				    }else if ("AVG".equals(cond.getFlag())) {
				    	collect_Dir_RfbVW.setSymtime("");
				    	collect_Dir_RfbVW.setDirector_number(String.valueOf(sr.get()[0]));		
				    	collect_Dir_RfbVW.setSysBusy((BigDecimal)sr.get()[1]);
				    }
					astCollect_Dir_RfbVW.add(collect_Dir_RfbVW);  
				}
				
				
				session.flush();
				session.clear();
				session.close();
				
				return parse(astCollect_Dir_RfbVW);
			}
				
		};
		return (List<Collect_Dir_RfbVWInfo>) execute(action);
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
	 * 	去除重复的设备
	 */
	private List<Collect_Dir_RfbVWInfo> parse(List<Collect_Dir_RfbVWInfo> list){	
		
		List<String> nameList = new ArrayList<String>();
		
		List<Collect_Dir_RfbVWInfo>  newList = new ArrayList<Collect_Dir_RfbVWInfo>();
		
		for(int i=0;i<list.size();i++){
			
			Collect_Dir_RfbVWInfo info = list.get(i);
		
			if(!nameList.contains(info.getDirector_number())){
				nameList.add(info.getDirector_number());
				newList.add(info);
			}
		}	
		return newList; 
	}
}
