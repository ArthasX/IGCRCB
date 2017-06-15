package com.deliverik.framework.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.entity.IG887VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 历史版本更新时间查询DAO实现
 * 
 */
public class IG887DAOImpl extends BaseHibernateDAOImpl<IG887Info> implements IG887DAO {

	/**
	 * 构造函数
	 */
	public IG887DAOImpl(){
		super(IG887VW.class);
	}
	
	/**
	 *  获取资产历史版本更新时间
	 * 
	 * @param eiid 资产ID
	 * @return 各版本更新时间
	 */
	@SuppressWarnings("unchecked")
	public List<IG887Info> searchVersionUpdateTime(final Integer eiid){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<IG887Info> list =null;
				query.append(session.getNamedQuery("IG887DAO.searchVersionUpdateTime").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("eiid", eiid);
				q.addEntity("VERSIONTIME",IG887VW.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IG887Info>)execute(action);
	}
	
	

}
