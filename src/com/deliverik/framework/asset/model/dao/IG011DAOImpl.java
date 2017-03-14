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
	 * �豸ͳ�Ʒ���
	 * 
	 */
	public IG011DAOImpl(){
		super(IG011VW.class);
	}
	
	/**
	 * �����ʲ�ģ�Ͳ����ͳ�Ƹ��ʲ�ģ���µ��ʲ���������(����������)
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
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
	 * ������������(����������)
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
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
	 * ������������(��ʹ�û���)
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
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
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(IG011SearchCond cond, StringBuffer query){
		
		if( !StringUtils.isEmpty(cond.getEparcoding())){
			query.append("  AND B.eparcoding=:eparcoding  ");
		}
		
		
		//ʱ���
		if( !StringUtils.isEmpty(cond.getCiupdtime_from())){
			query.append("  AND C.eiinsdate>=:ciupdtime_from ");
		}	
		
		//ʱ�䵽
		if( !StringUtils.isEmpty(cond.getCiupdtime_to())){
			query.append(" AND C.eiinsdate <= (:ciupdtime_to||' 23:59') ");
		}	
		
		//��������
		if( !StringUtils.isEmpty(cond.getEiorgsyscoding_q())){
			query.append(" AND C.eiorgsyscoding like (:eiorgsyscoding_q || '%') ");
		}	
		
	}
	
	

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(IG011SearchCond cond, StringBuffer query, String flag){
		
		if( !StringUtils.isEmpty(cond.getEparcoding())){
			query.append("  AND B.eparcoding = :eparcoding  ");
		}
		
		
		//ʱ���
		if( !StringUtils.isEmpty(cond.getCiupdtime_from())){
			query.append("  AND C.eiinsdate >= :ciupdtime_from ");
		}	
		
		//ʱ�䵽
		if( !StringUtils.isEmpty(cond.getCiupdtime_to())){
			query.append(" AND C.eiinsdate <= (:ciupdtime_to || ' 23:59') ");
		}	
		
		
		if(!StringUtils.isEmpty(cond.getOrgType()) && "0".equals(cond.getOrgType())){
			//��������
			if( !StringUtils.isEmpty(cond.getEiorgsyscoding_q())){
				query.append(" AND C.eiorgsyscoding like (:eiorgsyscoding_q||'%') ");
			}	
		}
		
		if(!StringUtils.isEmpty(cond.getOrgType()) && "1".equals(cond.getOrgType()) && !"1".equals(flag)){
			//ʹ�û���
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
