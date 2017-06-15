package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0128VW;

/**
 * ��ʷ�汾����ʱ���ѯDAOʵ��
 * 
 */
public class SOC0128DAOImpl extends BaseHibernateDAOImpl<SOC0128Info> implements SOC0128DAO {

	/**
	 * ���캯��
	 */
	public SOC0128DAOImpl(){
		super(SOC0128VW.class);
	}
	
	/**
	 *  ��ȡ�ʲ���ʷ�汾����ʱ��
	 * 
	 * @param eiid �ʲ�ID
	 * @return ���汾����ʱ��
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0128Info> searchVersionUpdateTime(final Integer eiid){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<SOC0128Info> list =null;
				query.append(session.getNamedQuery("ConfigItemVersionTimeVWDAO.searchVersionUpdateTime").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("eiid", eiid);
				q.addEntity("VERSIONTIME",SOC0128VW.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0128Info>)execute(action);
	}
	
	

}
