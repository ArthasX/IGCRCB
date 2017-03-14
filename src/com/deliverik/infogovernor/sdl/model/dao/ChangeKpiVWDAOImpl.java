package com.deliverik.infogovernor.sdl.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sdl.model.ChangeKpi;
import com.deliverik.infogovernor.sdl.model.condition.ChangeKpiSearchCond;
import com.deliverik.infogovernor.sdl.model.entity.ChangeKpiVW;

public class ChangeKpiVWDAOImpl extends BaseHibernateDAOImpl<ChangeKpi> implements ChangeKpiVWDAO {

	/**
	 * 变更kpi汇总视图构造函数
	 * 
	 */
	public ChangeKpiVWDAOImpl(){
		super(ChangeKpiVW.class);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<ChangeKpi> findByCond(final ChangeKpiSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("ChangeKpiVWDAO.ChangeKpiQuery").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("ChangeKpi",ChangeKpiVW.class);
				setFetchPoint(q, start, count);
				List<ChangeKpi> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<ChangeKpi>) execute(action);
	}

}
