/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.model.RecptionVWInfo;
import com.csebank.lom.model.condition.RecptionVWSearchCond;
import com.csebank.lom.model.entity.RecptionVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 接待管理DAO实现
 *
 */
public class RecptionVWDAOImpl extends BaseHibernateDAOImpl<RecptionVWInfo> implements RecptionVWDAO {

	/**
	 * 构造函数
	 */
	public RecptionVWDAOImpl(){
		super(RecptionVW.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<RecptionVWInfo> findByCond(final RecptionVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<RecptionVWInfo> list =null;
				
				query.append(session.getNamedQuery("RecptionVWInfoDAO.recptionVW").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("vw",RecptionVW.class);
				setFetchPoint(q, 0, 0);
				 list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<RecptionVWInfo>) execute(action);
	}
	

}
