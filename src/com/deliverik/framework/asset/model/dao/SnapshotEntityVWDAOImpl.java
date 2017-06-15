package com.deliverik.framework.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.SwitchPortVW;
import com.deliverik.framework.asset.model.SwitchZoneVW;
import com.deliverik.framework.asset.model.condition.SnapshotRelationSearchCond;
import com.deliverik.framework.asset.model.entity.ShowEntityVW;
import com.deliverik.framework.asset.model.entity.SnapshotEntityVW;
import com.deliverik.framework.asset.model.entity.SnapshotRelationTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;


/**
 * 资产项视图DAO实现
 * 
 */
public class SnapshotEntityVWDAOImpl extends BaseHibernateDAOImpl<SnapshotEntityVW> implements SnapshotEntityVWDAO {

	static Log log = LogFactory.getLog(SnapshotEntityVWDAOImpl.class);

	/**
	 * 资产项视图构造函数
	 * 
	 */
	public SnapshotEntityVWDAOImpl(){
		super(SnapshotEntityVW.class);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SnapshotEntityVW> findByCond(final SnapshotRelationSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append("select * from snapshotentityvw where 1=1 ");
									
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ei",SnapshotEntityVW.class);
				
				List<SnapshotEntityVW> list = q.list();
				
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<SnapshotEntityVW>) execute(action);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<ShowEntityVW> findDiskByCond(final SnapshotRelationSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append(" select C.eiid,C.civersion as version,C.cismallversion as smallversion,C.civalue ");
			    query.append(" from snapshotentityvw vw ");
				query.append(" join (select civersion,cismallversion,eiid,civalue ");
				query.append(" from IG800 C where C.cid = 1126 and C.eid = 112) C on ");   
				query.append(" C.eiid = srcldeiid and C.civersion = srcldversion and C.cismallversion = srcldsmallversion where 1=1 ");
									
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(ShowEntityVW.class);			
				List<ShowEntityVW> list = q.list();
				
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<ShowEntityVW>) execute(action);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<String> findDaByCond(final SnapshotRelationSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append("  select C.civalue  ");
			    query.append(" from snapshotentityvw vw ");
				query.append(" join (select civersion,cismallversion,eiid,civalue ");
				query.append(" from IG800 C where C.cid = 893 and C.eid = 111) C on ");   
				query.append(" C.eiid = srcldeiid and C.civersion = srcldversion and C.cismallversion = srcldsmallversion where 1=1 ");
									
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());
//				q.addEntity(ShowEntityVW.class);		
				List<String> list = q.list();
				
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<String>) execute(action);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<String> findFaByCond(final SnapshotRelationSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append("  select C.civalue  ");
			    query.append(" from snapshotentityvw vw ");
				query.append(" join (select civersion,cismallversion,eiid,civalue ");
				query.append(" from IG800 C where C.cid = 1127 and C.eid = 110) C on ");   
				query.append(" C.eiid = srcldeiid and C.civersion = srcldversion and C.cismallversion = srcldsmallversion where 1=1 ");
									
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());
//				q.addEntity(ShowEntityVW.class);		
				List<String> list = q.list();
				
				session.clear();
				session.close();
							
				return list;
			}
		};
		return (List<String>) execute(action);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SwitchPortVW> findSwitchPortByCond(final SnapshotRelationSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append(" select srcldeiid as eiid,A.civalue as port,B.civalue as wwn  from snapshotrelation ");
				query.append("    join (select civersion,cismallversion,eiid,civalue  ");
				query.append("       from IG800  where cid = 707 and eid = 107) A ");
				query.append("     on A.eiid = srcldeiid and A.civersion = srcldversion and A.cismallversion = srcldsmallversion ");
				query.append("    left join (select civersion,cismallversion,eiid,civalue  ");
				query.append("       from IG800  where cid = 708 and eid = 107) B ");
				query.append("     on B.eiid = srcldeiid and B.civersion = srcldversion and B.cismallversion = srcldsmallversion ");
				query.append("     where 1=1 ");					
				getSQL(cond, query);				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SwitchPortVW.class);		
				List<SwitchPortVW> list = q.list();
				
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<SwitchPortVW>) execute(action);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SnapshotRelationTB> findSwitchRelationByCond(final SnapshotRelationSearchCond cond1,final SnapshotRelationSearchCond cond2){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append("select e.* from ( select B.srid ");
				query.append(" from (select * from snapshotrelation where 1=1 ");
				getSQL(cond1, query);
				query.append(")A  join ");
				query.append(" (select * from snapshotrelation where 1=1 " );
				getSQL(cond2, query);
				query.append(" )B on A.srcldeiid = B.srpareiid and A.srcldversion = B.srparversion ");
				query.append("                   and A.srcldsmallversion = B.srparsmallversion group by b.srid) d inner join snapshotrelation e on(d.srid = e.srid)	 ");						
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SnapshotRelationTB.class);		
				List<SnapshotRelationTB> list = q.list();
				
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<SnapshotRelationTB>) execute(action);
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SwitchZoneVW> findSwitchZoneByCond(final SnapshotRelationSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append(" select srcldeiid as eiid,A.civalue as zonename,B.civalue as zonemember,C.civalue as effectivecfg  from snapshotrelation ");
				query.append("    join (select civersion,cismallversion,eiid,civalue  ");
				query.append("       from IG800  where cid = 1057 and eid = 130) A ");
				query.append("     on A.eiid = srcldeiid and A.civersion = srcldversion and A.cismallversion = srcldsmallversion ");
				query.append("    left join (select civersion,cismallversion,eiid,civalue  ");
				query.append("       from IG800  where cid = 1058 and eid = 130) B ");
				query.append("     on B.eiid = srcldeiid and B.civersion = srcldversion and B.cismallversion = srcldsmallversion ");
				query.append("    left join (select civersion,cismallversion,eiid,civalue  ");
				query.append("       from IG800  where cid = 1056 and eid = 130) C ");
				query.append("     on C.eiid = srcldeiid and C.civersion = srcldversion and C.cismallversion = srcldsmallversion ");
				query.append("     where 1=1 ");					
				getSQL(cond, query);				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SwitchZoneVW.class);		
				List<SwitchZoneVW> list = q.list();
				
				session.clear();
				session.close();	
				return list;
			}
		};
		return (List<SwitchZoneVW>) execute(action);
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(SnapshotRelationSearchCond cond, StringBuffer query){
		
		if (StringUtils.isNotEmpty(cond.getSrdomainid_eq())) {
			query.append(" and srdomainid ="+cond.getSrdomainid_eq());
		}
		//域版本
		if (StringUtils.isNotEmpty(cond.getSrdomainversion_eq())) {
			query.append(" and srdomainversion="+cond.getSrdomainversion_eq());
		}
		//删除标志
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			query.append(" and deleteflag='"+cond.getDeleteflag_eq()+"'");
		}
		//源资产ID
		if(StringUtils.isNotEmpty(cond.getSrpareiid_eq())){
			query.append(" and srpareiid="+cond.getSrpareiid_eq());
		}
		//源资产大版本
		if(StringUtils.isNotEmpty(cond.getSrparversion_eq())){
			query.append(" and srparversion="+cond.getSrparversion_eq());
		}
		//源资产小版本
		if(StringUtils.isNotEmpty(cond.getSrparsmallversion_eq())){
			query.append(" and srparsmallversion="+cond.getSrparsmallversion_eq());
		}
		//目的资产ID
		if(StringUtils.isNotEmpty(cond.getSrcldeiid_eq())){
			query.append(" and srcldeiid="+cond.getSrcldeiid_eq());
		}
		//目的资产大版本
		if(StringUtils.isNotEmpty(cond.getSrcldversion_eq())){
			query.append(" and srcldversion="+cond.getSrcldversion_eq());
		}
		//目的资产小版本
		if(StringUtils.isNotEmpty(cond.getSrcldsmallversion_eq())){
			query.append(" and srcldsmallversion="+cond.getSrcldsmallversion_eq());
		}
		//创建时间
		if(StringUtils.isNotEmpty(cond.getSrcreatetime_eq())){
			query.append(" and srcreatetime='"+cond.getSrcreatetime_eq()+"'");
		}
		//关系类型
		if(StringUtils.isNotEmpty(cond.getSrassetrelation_eq())){
			query.append(" and srassetrelation='"+cond.getSrassetrelation_eq()+"'");
		}
		//扩展算法类型
		if(StringUtils.isNotEmpty(cond.getSrarithmetictype_eq())){
			query.append(" and srarithmetictype='"+cond.getSrarithmetictype_eq()+"'");
		}
//		//扩展算法类型
//		if(StringUtils.isNotEmpty(cond.getSrcStorageEiname())){
//			query.append(" and srcldeilabel like '"+cond.getSrcStorageEiname()+"%'");
//		}			
	}	
}
