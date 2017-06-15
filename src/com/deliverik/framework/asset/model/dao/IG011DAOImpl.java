package com.deliverik.framework.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.asset.model.IG011Info;
import com.deliverik.framework.asset.model.condition.IG011SearchCond;
import com.deliverik.framework.asset.model.entity.IG011VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;


public class IG011DAOImpl extends BaseHibernateDAOImpl<IG011Info> implements IG011DAO {

	/**
	 * 设备统计分析
	 * 
	 */
	public IG011DAOImpl(){
		super(IG011VW.class);
	}
	
	/**
	 * 根据资产模型层次码统计该资产模型下的资产数量处理(按所属机构)
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG011Info> findByCond(final IG011SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();			
				query.append(session.getNamedQuery("IG011DAO.EntityStatisticsQuery").getQueryString());
				getSQL(cond, query);			
				query.append(" ) WHERE 1=1 ");
				getSQL(cond, query);				
				query.append(" ) ecount GROUP BY esyscoding,ename ) AS ecount ORDER BY cid");
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("ecount",IG011VW.class);
				setFetchPoint(q, 0, 0);
				List<IG011Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IG011Info>) execute(action);
	}
	
	/**
	 * 条件检索处理(按所属机构)
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG011Info> findByCond(final IG011SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();			
				StringBuffer query = new StringBuffer();			
				query.append(session.getNamedQuery("IG011DAO.EntityCountQuery").getQueryString());
				getSQL(cond, query,"1");
				
				query.append(" ) WHERE B.eparcoding = '999001' ) ecount GROUP BY esyscoding,ename ) ecount ORDER BY cid");
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("ecount",IG011VW.class);
				setFetchPoint(q, start, count);
				List<IG011Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IG011Info>) execute(action);
	}
	
	/**
	 * 条件检索处理(按使用机构)
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG011Info> findIG011InfoCondByUseOrg(final IG011SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();			
				StringBuffer query = new StringBuffer();			
				query.append(session.getNamedQuery("IG011DAO.EntityCountByUseOrgQuery").getQueryString());
				getSQL(cond, query,"0");
				
				query.append(") ");
				
				query.append(") C ON (B.esyscoding = substr(C.esyscoding,1,12) ");
				
				getSQL(cond, query,"1");
				query.append(" ) WHERE B.eparcoding = '999001' ) ecount GROUP BY esyscoding,ename ) ecount ORDER BY cid");
				

				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("ecount",IG011VW.class);
				setFetchPoint(q, start, count);
				List<IG011Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IG011Info>) execute(action);
	}
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(IG011SearchCond cond, StringBuffer query){
		
		if( !StringUtils.isEmpty(cond.getEparcoding())){
			query.append("  AND B.eparcoding=:eparcoding  ");
		}
		
		
		//时间从
		if( !StringUtils.isEmpty(cond.getCiupdtime_from())){
			query.append("  AND C.eiinsdate>=:ciupdtime_from ");
		}	
		
		//时间到
		if( !StringUtils.isEmpty(cond.getCiupdtime_to())){
			query.append(" AND C.eiinsdate <= (:ciupdtime_to||' 23:59') ");
		}	
		
		//所属机构
		if( !StringUtils.isEmpty(cond.getEiorgsyscoding_q())){
			query.append(" AND C.eiorgsyscoding like (:eiorgsyscoding_q || '%') ");
		}	
		
	}
	
	

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(IG011SearchCond cond, StringBuffer query, String flag){
		
		if( !StringUtils.isEmpty(cond.getEparcoding())){
			query.append("  AND B.eparcoding = :eparcoding  ");
		}
		
		
		//时间从
		if( !StringUtils.isEmpty(cond.getCiupdtime_from())){
			query.append("  AND C.eiinsdate >= :ciupdtime_from ");
		}	
		
		//时间到
		if( !StringUtils.isEmpty(cond.getCiupdtime_to())){
			query.append(" AND C.eiinsdate <= (:ciupdtime_to || ' 23:59') ");
		}	
		
		
		if(!StringUtils.isEmpty(cond.getOrgType()) && "0".equals(cond.getOrgType())){
			//所属机构
			if( !StringUtils.isEmpty(cond.getEiorgsyscoding_q())){
				query.append(" AND C.eiorgsyscoding like (:eiorgsyscoding_q||'%') ");
			}	
		}
		
		if(!StringUtils.isEmpty(cond.getOrgType()) && "1".equals(cond.getOrgType()) && !"1".equals(flag)){
			//使用机构
			query.append(" AND F.CLABEL = '");
			query.append(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE);
			query.append("'");
			if(!StringUtils.isEmpty(cond.getEiorgsyscoding_q())){
				query.append(" AND E.CIVALUE LIKE '");
				query.append(cond.getEiorgsyscoding_q());
				query.append("%'");
			}
		}
	}
}
