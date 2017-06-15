package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0132VW;
import com.deliverik.framework.soc.asset.model.SOC0133VW;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0121TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0140VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0141VW;


/**
 * 资产项视图DAO实现
 * 修改记录：2011/7/13 增加IBM逻辑图显示 王龙宇
 */
public class SOC0141DAOImpl extends BaseHibernateDAOImpl<SOC0141VW> implements SOC0141DAO {

	static Log log = LogFactory.getLog(SOC0141DAOImpl.class);

	/**
	 * 资产项视图构造函数
	 * 
	 */
	public SOC0141DAOImpl(){
		super(SOC0141VW.class);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0141VW> findByCond(final SOC0121SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append("select * from SOC0141 where 1=1 ");
									
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ei",SOC0141VW.class);
				
				List<SOC0141VW> list = q.list();
				
				session.clear();
							
				return list;
			}
		};
		return (List<SOC0141VW>) execute(action);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0140VW> findDiskByCond(final SOC0121SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append(" select C.eiid,C.civersion as version,C.cismallversion as smallversion,C.civalue ");
			    query.append(" from SOC0141 vw ");
				query.append(" join (select civersion,cismallversion,eiid,civalue ");
				query.append(" from SOC0107 C where C.cid = 'CI010100130013' and C.eid = 'CM01010013') C on ");   
				query.append(" C.eiid = srcldeiid and C.civersion = srcldversion and C.cismallversion = srcldsmallversion where 1=1 ");
									
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0140VW.class);			
				List<SOC0140VW> list = q.list();
				
				session.clear();
							
				return list;
			}
		};
		return (List<SOC0140VW>) execute(action);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<String> findDaByCond(final SOC0121SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append("  select C.civalue  ");
			    query.append(" from SOC0141 vw ");
				query.append(" join (select civersion,cismallversion,eiid,civalue ");
				query.append(" from SOC0107 C where C.cid = 'CI010100120008' and C.eid = 'CM01010012') C on ");   
				query.append(" C.eiid = srcldeiid and C.civersion = srcldversion and C.cismallversion = srcldsmallversion where 1=1 ");
									
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());
//				q.addEntity(ShowEntityVW.class);		
				List<String> list = q.list();
				
				session.clear();
							
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
	public List<String> findFaByCond(final SOC0121SearchCond cond,final String strStorageEilabel){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append("  select C.civalue  ");
			    query.append(" from SOC0141 vw ");
				query.append(" join (select civersion,cismallversion,eiid,civalue ");
				query.append(" from SOC0107 C where C.cid = 'CI010100110010' and C.eid = 'CM01010011') C on ");   
				query.append(" C.eiid = srcldeiid and C.civersion = srcldversion and C.cismallversion = srcldsmallversion where 1=1 ");
				query.append(" and vw.srcldeilabel like '").append(strStorageEilabel).append("%'");
									
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());
//				q.addEntity(ShowEntityVW.class);		
				List<String> list = q.list();
				
				session.clear();
							
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
	public List<SOC0132VW> findSwitchPortByCond(final SOC0121SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append(" select srcldeiid as eiid,A.civalue as port,B.civalue as wwn  from SOC0121 ");
				query.append("    join (select civersion,cismallversion,eiid,civalue  ");
				query.append("       from SOC0107  where cid = 'CI010100080001' and eid = 'CM01010008') A ");
				query.append("     on A.eiid = srcldeiid and A.civersion = srcldversion and A.cismallversion = srcldsmallversion ");
				query.append("    left join (select civersion,cismallversion,eiid,civalue  ");
				query.append("       from SOC0107  where cid = 'CI010100080002' and eid = 'CM01010008') B ");
				query.append("     on B.eiid = srcldeiid and B.civersion = srcldversion and B.cismallversion = srcldsmallversion ");
				query.append("     where 1=1 ");					
				getSQL(cond, query);
				query.append(" order by A.civalue");
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.addEntity(SOC0132VW.class);		
				List<SOC0132VW> list = q.list();
				
				session.clear();
							
				return list;
			}
		};
		return (List<SOC0132VW>) execute(action);
	}
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0121TB> findSwitchRelationByCond(final SOC0121SearchCond cond1,final SOC0121SearchCond cond2){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append("select e.* from ( select B.srid ");
				query.append(" from (select * from SOC0121 where 1=1 ");
				getSQL(cond1, query);
				query.append(")A  join ");
				query.append(" (select * from SOC0121 where 1=1 " );
				getSQL(cond2, query);
				query.append(" )B on A.srcldeiid = B.srpareiid and A.srcldversion = B.srparversion ");
				query.append("                   and A.srcldsmallversion = B.srparsmallversion group by b.srid) d inner join SOC0121 e on(d.srid = e.srid)	 ");						
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0121TB.class);		
				List<SOC0121TB> list = q.list();
				
				session.clear();
							
				return list;
			}
		};
		return (List<SOC0121TB>) execute(action);
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0133VW> findSwitchZoneByCond(final SOC0121SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append(" select srcldeiid as eiid,A.civalue as zonename,B.civalue as zonemember,C.civalue as effectivecfg  from SOC0121 ");
				query.append("    join (select civersion,cismallversion,eiid,civalue  ");
				query.append("       from SOC0107  where cid = 'CI010200180003' and eid = 'CM01020018') A ");
				query.append("     on A.eiid = srcldeiid and A.civersion = srcldversion and A.cismallversion = srcldsmallversion ");
				query.append("    left join (select civersion,cismallversion,eiid,civalue  ");
				query.append("       from SOC0107  where cid = 'CI010200180004' and eid = 'CM01020018') B ");
				query.append("     on B.eiid = srcldeiid and B.civersion = srcldversion and B.cismallversion = srcldsmallversion ");
				query.append("    left join (select civersion,cismallversion,eiid,civalue  ");
				query.append("       from SOC0107  where cid = 'CI010200180002' and eid = 'CM01020018') C ");
				query.append("     on C.eiid = srcldeiid and C.civersion = srcldversion and C.cismallversion = srcldsmallversion ");
				query.append("     where 1=1 ");					
				getSQL(cond, query);	
				query.append(" order by A.civalue");				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0133VW.class);		
				List<SOC0133VW> list = q.list();
				
				session.clear();
							
				return list;
			}
		};
		return (List<SOC0133VW>) execute(action);
	}
	/**
	 * 
	 * <p>[功能描述]</p>
	 *
	 * @comment	[查询 IBM disk serial]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return disk serial检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0140VW> findIBMDiskSerialByCond(final SOC0121SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select C.eiid,C.civersion as version,C.cismallversion as smallversion,C.civalue ");
			    query.append(" from SOC0141 vw ");
				query.append(" join (select civersion,cismallversion,eiid,civalue ");
				query.append(" from SOC0107 C where C.cid = 'CI010100130001' and C.eid = 'CM01010013') C on ");   
				query.append(" C.eiid = srcldeiid and C.civersion = srcldversion and C.cismallversion = srcldsmallversion where 1=1 ");
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0140VW.class);			
				List<SOC0140VW> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0140VW>) execute(action);
	}
	/**
	 * 
	 * <p>[功能描述]</p>
	 *
	 * @comment	[查询 IBM disk pack]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return disk pack检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0140VW> findIBMDiskPackByCond(final SOC0121SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select C.eiid,C.civersion as version,C.cismallversion as smallversion,C.civalue ");
			    query.append(" from SOC0141 vw ");
				query.append(" join (select civersion,cismallversion,eiid,civalue ");
				query.append(" from SOC0107 C where C.cid = 'CI010100130014' and C.eid = 'CM01010013') C on ");   
				query.append(" C.eiid = srcldeiid and C.civersion = srcldversion and C.cismallversion = srcldsmallversion where 1=1 ");
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0140VW.class);			
				List<SOC0140VW> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0140VW>) execute(action);
	}
	/**
	 * 
	 * <p>[功能描述]</p>
	 *
	 * @comment	[查询 IBM FAport]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return faport检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0140VW> findIBMFaportByCond(final SOC0121SearchCond cond,final String strStorageEilabel){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select C.eiid,C.civersion as version,C.cismallversion as smallversion,C.civalue");
			    query.append(" from SOC0141 vw ");
				query.append(" join (select civersion,cismallversion,eiid,civalue ");
				query.append(" from SOC0107 C where C.cid = 'CI010100110003' and C.eid = 'CM01010011') C on ");   
				query.append(" C.eiid = srcldeiid and C.civersion = srcldversion and C.cismallversion = srcldsmallversion where 1=1 ");
				query.append(" and vw.srcldeilabel like '").append(strStorageEilabel).append("%'");
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0140VW.class);			
				List<SOC0140VW> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0140VW>) execute(action);
	}
	/**
	 * 
	 * <p>[功能描述]</p>
	 *
	 * @comment	[查询 IBM FA]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return fa检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0140VW> findIBMFaByCond(final SOC0121SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select C.eiid,C.civersion as version,C.cismallversion as smallversion,C.civalue ");
			    query.append(" from SOC0141 vw ");
				query.append(" join (select civersion,cismallversion,eiid,civalue ");
				query.append(" from SOC0107 C where C.cid = 'CI010100100006' and C.eid = 'CM01010010') C on ");   
				query.append(" C.eiid = srcldeiid and C.civersion = srcldversion and C.cismallversion = srcldsmallversion where 1=1 ");
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0140VW.class);			
				List<SOC0140VW> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0140VW>) execute(action);
	}
	/**
	 * 
	 * <p>[功能描述]</p>
	 *
	 * @comment	[查询 IBM DA LOC]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return da loc检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0140VW> findIBMDaLocByCond(final SOC0121SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select C.eiid,C.civersion as version,C.cismallversion as smallversion,C.civalue ");
			    query.append(" from SOC0141 vw ");
				query.append(" join (select civersion,cismallversion,eiid,civalue ");
				query.append(" from SOC0107 C where C.cid = 'CI010100120008' and C.eid = 'CM01010012') C on ");   
				query.append(" C.eiid = srpareiid and C.civersion = srparversion and C.cismallversion = srparsmallversion where 1=1 ");
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0140VW.class);			
				List<SOC0140VW> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0140VW>) execute(action);
	}
	/**
	 * 
	 * <p>[功能描述]</p>
	 *
	 * @comment	[查询 IBM DA PAIR]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return da pair检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0140VW> findIBMDaPairByCond(final SOC0121SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select C.eiid,C.civersion as version,C.cismallversion as smallversion,C.civalue ");
			    query.append(" from SOC0141 vw ");
				query.append(" join (select civersion,cismallversion,eiid,civalue ");
				query.append(" from SOC0107 C where C.cid = 'CI010100120006' and C.eid = 'CM01010012') C on ");   
				query.append(" C.eiid = srpareiid and C.civersion = srparversion and C.cismallversion = srparsmallversion where 1=1 ");
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0140VW.class);			
				List<SOC0140VW> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0140VW>) execute(action);
	}
	/**
	 * 
	 * <p>[功能描述]</p>
	 *
	 * @comment	[查询 IBM DA interface]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return da interface检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0140VW> findIBMDaInterfaceByCond(final SOC0121SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select C.eiid,C.civersion as version,C.cismallversion as smallversion,C.civalue ");
			    query.append(" from SOC0141 vw ");
				query.append(" join (select civersion,cismallversion,eiid,civalue ");
				query.append(" from SOC0107 C where C.cid = 'CI010100120007' and C.eid = 'CM01010012') C on ");   
				query.append(" C.eiid = srpareiid and C.civersion = srparversion and C.cismallversion = srparsmallversion where 1=1 ");
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0140VW.class);			
				List<SOC0140VW> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0140VW>) execute(action);
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(SOC0121SearchCond cond, StringBuffer query){
		
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
	}	
}
