package com.deliverik.framework.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.asset.model.IG445Info;
import com.deliverik.framework.asset.model.condition.IG445SearchCond;
import com.deliverik.framework.asset.model.entity.IG445VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;


public class IG445DAOImpl extends BaseHibernateDAOImpl<IG445Info> implements IG445DAO {

	/**
	 * 设备分布式统计分析
	 * 
	 */
	public IG445DAOImpl(){
		super(IG445VW.class);
	}
	
	/**
	 * 条件检索处理(按所属机构)
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG445Info> findByCond(final IG445SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();		
				StringBuffer query = new StringBuffer();			
				query.append(session.getNamedQuery("IG445DAO.EquDisCountQuery").getQueryString());
				getSQL(cond, query);
				
				query.append(" group by  B.CIVALUE ) a on (a.CIVALUE = b.orgsyscoding) WHERE b.orgsyscoding <>'0001'");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("a",IG445VW.class);
				setFetchPoint(q, start, count);
				List<IG445Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IG445Info>) execute(action);
	}
	

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(IG445SearchCond cond, StringBuffer query){
		
		//时间从
		if( !StringUtils.isEmpty(cond.getCiupdtime_from())){
			query.append("  AND A.eiinsdate >= :ciupdtime_from ");
		}	
		
		//时间到
		if( !StringUtils.isEmpty(cond.getCiupdtime_to())){
			query.append(" AND A.eiinsdate <= (:ciupdtime_to||' 23:59') ");
		}	
		

		//使用机构
		query.append(" AND C.CLABEL = '");
		query.append(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE);
		query.append("'");
		if(!StringUtils.isEmpty(cond.getEid())){
			query.append(" AND A.esyscoding like '");
			query.append(cond.getEid());
			query.append("%' ");
		}
		
	}
}
