package com.csebank.items.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.items.model.ItemsPay;
import com.csebank.items.model.condition.ItemsPaySearchCond;
import com.csebank.items.model.entity.ItemsPayVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

public class ItemsPayVWDAOImpl extends BaseHibernateDAOImpl<ItemsPay> implements ItemsPayVWDAO {


	public ItemsPayVWDAOImpl(){
		super(ItemsPayVW.class);
	}

	@SuppressWarnings("unchecked")
	public List<ItemsPay> findByCond(final ItemsPaySearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("ItemsPayVWDAO.payListQuery").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("outtime",ItemsPayVW.class);
				setFetchPoint(q, start, count);
				List<ItemsPay> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<ItemsPay>) execute(action);
	}

}
