/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0604Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0604SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0604VW;

public class SOC0604DAOImpl extends BaseHibernateDAOImpl<SOC0604Info> implements SOC0604DAO {

	/**
	 * 机房机柜统计分析
	 * 
	 */
	public SOC0604DAOImpl(){
		super(SOC0604VW.class);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0604Info> findByCond(final SOC0604SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();		
				StringBuffer query = new StringBuffer();			
				query.append(session.getNamedQuery("SOC0604DAO.RoomAndContainerQuery").getQueryString());
				getSQL(cond, query);
				//2010.07.22 排序方法修改 songhaiyang
				query.append(" )) ecount ORDER BY room_name,ename,eilabel");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("ecount",SOC0604VW.class);
				setFetchPoint(q, start, count);
				List<SOC0604Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}

		};
		return (List<SOC0604Info>) execute(action);
	}
	

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(SOC0604SearchCond cond, StringBuffer query){
		
		//机房ID
		if( cond.getRoomeiid_q()!=null && cond.getRoomeiid_q()!=0){
			query.append("  AND d.room_eiid =:roomeiid_q ");
		}	
		
		
	}
}
