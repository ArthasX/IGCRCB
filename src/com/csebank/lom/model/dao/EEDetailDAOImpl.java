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

import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.condition.EESearchCond;
import com.csebank.lom.model.entity.EEOrgDetail;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 模块：后勤管理-食堂管理
 * 说明：食堂招待部门汇总明细DAO实现
 * 作者：唐晓娜
 */
public class EEDetailDAOImpl extends BaseHibernateDAOImpl<Eentertainment> implements EEDetailDAO {

	/**
	 * 构造函数
	 */
	public EEDetailDAOImpl(){
		super(EEOrgDetail.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Eentertainment> findByCond(final EESearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<Eentertainment> list =null;
				query.append(session.getNamedQuery("EEOrgVWDAO.eedtail").getQueryString());
			
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("eedetail",EEOrgDetail.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<Eentertainment>) execute(action);
	}
	
	

}
