package com.deliverik.infogovernor.dbm.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dbm.model.BussinessAvailval;
import com.deliverik.infogovernor.dbm.model.entity.BussinessAvailvalVW;

public class BussinessAvailvalVWDAOImpl extends BaseHibernateDAOImpl<BussinessAvailval> implements BussinessAvailvalVWDAO {

	/**
	 * 业务系统DTO
	 */
	public BussinessAvailvalVWDAOImpl(){
		super(BussinessAvailvalVW.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<BussinessAvailval> getAllBusinessAvailvalList(){
		HibernateCallback action = new HibernateCallback() {
			String sql = "select * from (SELECT GNAME,MIN(AVAILVAL) AS AVAILVAL FROM HQ_GROUP_PLATFORM_VIEW GROUP BY GNAME)  BussinessAvailvalVW order by AVAILVAL,GNAME";
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				SQLQuery q = session.createSQLQuery(sql);
				q.addEntity("BussinessAvailvalVW",BussinessAvailvalVW.class);

				List<BussinessAvailval> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<BussinessAvailval>) execute(action);
	}
}
