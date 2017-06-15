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

import com.csebank.lom.model.DeptEentertainment;
import com.csebank.lom.model.condition.DeptEentertainmentSearchCond;
import com.csebank.lom.model.entity.DeptEentertainmentVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 部门接待统计DAO实现
 *
 */
public class DeptEentertainmentDAOImpl extends BaseHibernateDAOImpl<DeptEentertainment> implements DeptEentertainmentDAO {

	/**
	 * 构造函数
	 */
	public DeptEentertainmentDAOImpl(){
		super(DeptEentertainmentVW.class);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<DeptEentertainment> findByCond(final DeptEentertainmentSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if("all".equals(cond.getEwhere())){
					query.append(session.getNamedQuery("DeptEentertainmentDAO.DeptEentertainment").getQueryString());
				}else if("FT".equals(cond.getEwhere())){
					query.append(session.getNamedQuery("DeptEentertainmentDAO.DeptEentertainmentFT").getQueryString());
				}else if("F".equals(cond.getEwhere())){
					query.append(session.getNamedQuery("DeptEentertainmentDAO.DeptEentertainmentF").getQueryString());
				}else if("T".equals(cond.getEwhere())){
					query.append(session.getNamedQuery("DeptEentertainmentDAO.DeptEentertainmentT").getQueryString());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("EEntertainment",DeptEentertainmentVW.class);
				setFetchPoint(q, start, count);
				List<DeptEentertainment> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<DeptEentertainment>) execute(action);
	}

}
