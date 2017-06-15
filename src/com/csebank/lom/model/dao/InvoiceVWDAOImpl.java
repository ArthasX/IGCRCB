package com.csebank.lom.model.dao;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.model.InvoiceTj;
import com.csebank.lom.model.condition.InvoiceInfoSearchCond;
import com.csebank.lom.model.entity.InvoiceVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;



public class InvoiceVWDAOImpl extends BaseHibernateDAOImpl<InvoiceTj> implements InvoiceVWDAO {

	public InvoiceVWDAOImpl(){
		super(InvoiceVW.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<InvoiceTj> findByCond(final InvoiceInfoSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<InvoiceVW> list =null;
				if("year".equals(cond.getIstatus())){
					query.append(session.getNamedQuery("InvoiceVWDAO.invoiceVWBYYEAR").getQueryString());
					SQLQuery q = session.createSQLQuery(query.toString());
					q.setProperties(cond);
					q.addEntity("InvoiceTj",InvoiceVW.class);
					setFetchPoint(q, start, count);
					 list = q.list();
					session.clear();
					session.close();
				}
				else
				{
					query.append(session.getNamedQuery("InvoiceVWDAO.invoiceVWBYEMP").getQueryString());
					if(!StringUtils.isEmpty(cond.getIdate_from())){
						query.append(" AND  IDATE >= :idate_from ");
					}
					if(!StringUtils.isEmpty(cond.getIdate_to())){
						query.append(" AND IDATE <= :idate_to");
					}
					if(!StringUtils.isEmpty(cond.getEiorgsyscoding())){
						query.append(" AND O.ORGSYSCODING = :eiorgsyscoding");
					}
					query.append("  GROUP BY IREQEMP,ORGNAME ");	
					SQLQuery q = session.createSQLQuery(query.toString());
					q.setProperties(cond);
					q.addEntity("InvoiceTj",InvoiceVW.class);
					setFetchPoint(q, start, count);
					 list = q.list();
					session.clear();
					session.close();
				}
				return list;
			}
		};
		return (List<InvoiceTj>) execute(action);
	}
}
