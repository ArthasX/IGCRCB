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
import com.deliverik.infogovernor.soc.dbs.model.Collect_DisksVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_DisksVWDAO;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_DisksVW;

public class Collect_DisksVWDAOImpl extends BaseHibernateDAOImpl<Collect_DisksVWInfo> implements Collect_DisksVWDAO {

	@SuppressWarnings("unchecked")
	public List<Collect_DisksVWInfo> findByCond(final Collect_BusySearchCond cond, int start, int count) {
		
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if ("MAX".equals(cond.getFlag())) {
					query.append(session.getNamedQuery("Collect_DisksVWDAO.findByCond1").getQueryString());
					getSQL(cond, query);
					query.append(session.getNamedQuery("Collect_DisksVWDAO.findByCond2").getQueryString());
					getSQL(cond, query);
					query.append(session.getNamedQuery("Collect_DisksVWDAO.findByCond3").getQueryString());
				} else if ("AVG".equals(cond.getFlag())) {
					query.append(session.getNamedQuery("Collect_DisksVWDAO.findByCond4").getQueryString());
					getSQL(cond, query);
					query.append(" group by device_name");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				//q.addEntity("csmr",Collect_DisksVW.class);            
				q.setProperties(cond);
				
				ScrollableResults sr =  q.scroll();
				List<Collect_DisksVWInfo> astCollect_DisksVW = new ArrayList<Collect_DisksVWInfo>();
				while(sr.next()){
					Collect_DisksVW collect_DisksVW = new Collect_DisksVW();
					if ("MAX".equals(cond.getFlag())) {
						collect_DisksVW.setSymtime(String.valueOf(sr.get()[0]));
						collect_DisksVW.setDirector_number(String.valueOf(sr.get()[1]));		
						collect_DisksVW.setSysBusy((BigDecimal)sr.get()[2]);
					}else if ("AVG".equals(cond.getFlag())) {
						collect_DisksVW.setSymtime("");
						collect_DisksVW.setDirector_number(String.valueOf(sr.get()[0]));		
						collect_DisksVW.setSysBusy((BigDecimal)sr.get()[1]);
					}
					astCollect_DisksVW.add(collect_DisksVW);  
				}
				
				session.clear();
				
				return parse(astCollect_DisksVW);
			}
				
		};
		return (List<Collect_DisksVWInfo>) execute(action);
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
	private List<Collect_DisksVWInfo> parse(List<Collect_DisksVWInfo> list){	
		
		List<String> nameList = new ArrayList<String>();
		
		List<Collect_DisksVWInfo>  newList = new ArrayList<Collect_DisksVWInfo>();
		
		for(int i=0;i<list.size();i++){
			
			Collect_DisksVWInfo info = list.get(i);
		
			if(!nameList.contains(info.getDirector_number())){
				nameList.add(info.getDirector_number());
				newList.add(info);
			}
		}	
		return newList; 
	}
	/**
     * 获取全部磁盘名称
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
	@SuppressWarnings("unchecked")
    public List<Collect_DisksVWInfo> findDisksDeviceName(final Collect_BusySearchCond cond, final int start, final int count){
    	
    	List<Collect_DisksVWInfo> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						session.flush();
						StringBuffer query = new StringBuffer();

						query.append(session.getNamedQuery("Collect_DisksVWDAO.findDisksDeviceName").getQueryString());
						SQLQuery q = session.createSQLQuery(query.toString());
						q.setProperties(cond);
						ScrollableResults sr = q.scroll();
						List<Collect_DisksVWInfo> astCollect_DisksVW = new ArrayList<Collect_DisksVWInfo>();
						while (sr.next()) {
							Collect_DisksVW collect_DisksVW = new Collect_DisksVW();
							collect_DisksVW.setSymtime("");
							collect_DisksVW.setDirector_number(String.valueOf(sr.get()[0]));
							collect_DisksVW.setSysBusy(BigDecimal.ZERO);
							astCollect_DisksVW.add(collect_DisksVW);
						}
						session.flush();
						session.clear();
						session.close();
						return parse(astCollect_DisksVW);
					}
				});
		return list;
    }  
    
    @SuppressWarnings("unchecked")
	public List<Collect_DisksVWInfo> CX_findDisksDeviceName(
			final Collect_BusySearchCond cond, int start, int count) {
		List<Collect_DisksVWInfo> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						session.flush();
						StringBuffer query = new StringBuffer();

						query.append(session.getNamedQuery("Collect_DisksVWDAO.CX_findDisksDeviceName").getQueryString());
						SQLQuery q = session.createSQLQuery(query.toString());
						q.setProperties(cond);
						ScrollableResults sr = q.scroll();
						List<Collect_DisksVWInfo> astCollect_DisksVW = new ArrayList<Collect_DisksVWInfo>();
						while (sr.next()) {
							Collect_DisksVW collect_DisksVW = new Collect_DisksVW();
							collect_DisksVW.setSymtime("");
							collect_DisksVW.setObject_Name(String.valueOf(sr.get()[0]));
							collect_DisksVW.setSysBusy(BigDecimal.ZERO);
							astCollect_DisksVW.add(collect_DisksVW);
						}
						session.flush();
						session.clear();
						session.close();
						return astCollect_DisksVW;
					}
				});
		return list;
	}
//
//	@SuppressWarnings("unchecked")
//	public List<Collect_DisksVWInfo> findDisksByCond_cx(
//			final Collect_BusySearchCond cond, int start, int count) {
//		List<Collect_DisksVWInfo> list = getHibernateTemplate().executeFind(
//				new HibernateCallback() {
//					public Object doInHibernate(Session session)
//							throws HibernateException, SQLException {
//						session.flush();
//						StringBuffer query = new StringBuffer();
//
//						query.append(session.getNamedQuery("Collect_DisksVWDAO.findDisksByCond_CX").getQueryString());
//						SQLQuery q = session.createSQLQuery(query.toString());
//						q.setProperties(cond);
//						ScrollableResults sr = q.scroll();
//						List<Collect_DisksVWInfo> astCollect_DisksVW = new ArrayList<Collect_DisksVWInfo>();
//						while (sr.next()) {
//							Collect_DisksVW collect_DisksVW = new Collect_DisksVW();
//							collect_DisksVW.setSymtime("");
//							collect_DisksVW.setObject_Name(String.valueOf(sr.get()[0]));
//							collect_DisksVW.setSysBusy(BigDecimal.ZERO);
//							astCollect_DisksVW.add(collect_DisksVW);
//						}
//						session.flush();
//						session.clear();
//						session.close();
//						return astCollect_DisksVW;
//					}
//				});
//		return list;
//	}
	@SuppressWarnings("unchecked")
	public List<Collect_DisksVWInfo> findDisksByCond_CX(final Collect_BusySearchCond cond, int start, int count) {
		
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if ("MAX".equals(cond.getFlag())) {
					query.append(session.getNamedQuery("Collect_DisksVWDAO_CX.findByCond1").getQueryString());
					getSQL_CX(cond, query);
					query.append(session.getNamedQuery("Collect_DisksVWDAO_CX.findByCond2").getQueryString());
					getSQL_CX(cond, query);
					query.append(session.getNamedQuery("Collect_DisksVWDAO_CX.findByCond3").getQueryString());
				} else if ("AVG".equals(cond.getFlag())) {
					query.append(session.getNamedQuery("Collect_DisksVWDAO_CX.findByCond4").getQueryString());
					getSQL_CX(cond, query);
					query.append(" group by object_name");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				//q.addEntity("csmr",Collect_DisksVW.class);            
				q.setProperties(cond);
				
				ScrollableResults sr =  q.scroll();
				List<Collect_DisksVWInfo> astCollect_DisksVW = new ArrayList<Collect_DisksVWInfo>();
				while(sr.next()){
					Collect_DisksVW collect_DisksVW = new Collect_DisksVW();
					if ("MAX".equals(cond.getFlag())) {
						collect_DisksVW.setSymtime(String.valueOf(sr.get()[0]));
						collect_DisksVW.setDirector_number(String.valueOf(sr.get()[1]));		
						collect_DisksVW.setSysBusy((BigDecimal)sr.get()[2]);
					}else if ("AVG".equals(cond.getFlag())) {
						collect_DisksVW.setSymtime("");
						collect_DisksVW.setDirector_number(String.valueOf(sr.get()[0]));		
						collect_DisksVW.setSysBusy((BigDecimal)sr.get()[1]);
					}
					astCollect_DisksVW.add(collect_DisksVW);  
				}
				
				session.clear();
				
				return astCollect_DisksVW;
			}
				
		};
		return (List<Collect_DisksVWInfo>) execute(action);
	}
	private void getSQL_CX(final Collect_BusySearchCond cond, StringBuffer query) {

		if (cond.getDate_from() != null) {
			query.append(" and poll_time>=:date_from ");
		}
		if (cond.getDate_to() != null) {
			query.append(" and poll_time<=:date_to ");
		}
//		if (cond.getDate_from() != null) {
//		query.append(" and savetime>=:date_from ");
//	    }
//		if (cond.getDate_to() != null) {
//		query.append(" and savetime<=:date_to ");
//		}
//		query.append(" ");
	}
}
