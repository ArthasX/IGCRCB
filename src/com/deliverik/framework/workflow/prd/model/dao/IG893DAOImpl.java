package com.deliverik.framework.workflow.prd.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG893SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG893VW;

/**
 * 流程参与者变量权限视图DAO实现
 */
public class IG893DAOImpl extends
		BaseHibernateDAOImpl<IG893Info> implements
		IG893DAO {

	/**
	 * 流程参与者变量权限DAO构造函数
	 * 
	 */
	public IG893DAOImpl() {
		super(IG893VW.class);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG893Info> findByCond(final IG893SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG893DAO.searchIG893").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IG893VW", IG893VW.class);
				setFetchPoint(q, 0, 0);
				List<IG893Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG893Info>) execute(action);
	}
}
