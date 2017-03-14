package com.deliverik.framework.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.IG790Info;
import com.deliverik.framework.asset.model.condition.IG790SearchCond;
import com.deliverik.framework.asset.model.entity.IG790VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

public class IG790DAOImpl extends BaseHibernateDAOImpl<IG790Info> implements IG790DAO {

	/**
	 * 机房机柜统计分析
	 * 
	 */
	public IG790DAOImpl(){
		super(IG790VW.class);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG790Info> findByCond(final IG790SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();		
				StringBuffer query = new StringBuffer();			
				query.append(session.getNamedQuery("IG790DAO.RoomAndContainerQuery").getQueryString());
				getSQL(cond, query);
				//2010.07.22 排序方法修改 songhaiyang
				query.append(" )) ecount ORDER BY room_name,ename,eilabel");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("ecount",IG790VW.class);
				setFetchPoint(q, start, count);
				List<IG790Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}

		};
		return (List<IG790Info>) execute(action);
	}
	

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(IG790SearchCond cond, StringBuffer query){
		
		//机房ID
		if( cond.getRoomeiid_q()!=null && cond.getRoomeiid_q()!=0){
			query.append("  AND d.room_eiid =:roomeiid_q ");
		}	
		
		
	}
}
