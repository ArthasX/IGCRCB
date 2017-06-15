/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.model.DealVWInfo;
import com.csebank.lom.model.condition.DealVWSearchCond;
import com.csebank.lom.model.entity.DealVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * ����Ͳ͹���DAOʵ��
 *
 */
public class DealVWDAOImpl extends BaseHibernateDAOImpl<DealVWInfo> implements DealVWDAO {

	/**
	 * ���캯��
	 */
	public DealVWDAOImpl(){
		super(DealVW.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<DealVWInfo> findByCond(final DealVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<DealVWInfo> list =null;
				
				query.append(session.getNamedQuery("DealVWInfoDAO.dealVW").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("vw",DealVW.class);
				setFetchPoint(q, 0, 0);
				 list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<DealVWInfo>) execute(action);
	}
	

}
