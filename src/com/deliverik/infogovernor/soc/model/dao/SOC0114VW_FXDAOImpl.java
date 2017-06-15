/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.model.SOC0114VWInfo;
import com.deliverik.infogovernor.soc.model.condition.SOC0114VW_FXSearchCond;
import com.deliverik.infogovernor.soc.model.entity.SOC0114VW;

/**
  * 概述: SOC0114VW_FXDAO实现
  * 功能描述: SOC0114VW_FXDAO实现
  * 创建记录: 2013/10/26
  * 修改记录: 
  */
public class SOC0114VW_FXDAOImpl extends
		BaseHibernateDAOImpl<SOC0114VWInfo> implements SOC0114VW_FXDAO {

	/**
	 * 构造函数
	 */
	public SOC0114VW_FXDAOImpl(){
		super(SOC0114VW.class);
	}
	
	/**
	 * 检索byCond
	 *
	 * @return 检索结果集
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0114VWInfo> findByCond(final SOC0114VW_FXSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				String eiid = cond.getEiid().toString();
				String eiversion = cond.getEiversion().toString();
				String eiversmallversion = cond.getEismallversion().toString();
				String domainid = cond.getDomainid().toString();
				String domainversion = cond.getDomainversion().toString();
				query.append("select a.domainid,a.domainversion,a.linkid,'' resourceid,a.linkorder,a.eiid,a.einame,a.esyscoding,a.eiversion,a.eismallversion,b.eirootmark hostEiid,c.eiversion hostVersion,c.esyscoding hostesyscoding,c.eismallversion hostSmallVersion,d.civalue hostIP ");
				query.append("from soc0114 a ");
				query.append("left join soc0118 b on (a.eiid=b.eiid and a.eiversion=b.eiversion and a.eismallversion=b.eismallversion) ");
				query.append("left join soc0118 c on (b.eirootmark=c.eiid)");
				query.append("left join soc0107 d on (b.eirootmark=d.eiid and c.eiversion=d.civersion and c.eismallversion=d.cismallversion and d.cid='CI010100010005') ");
				query.append("where a.linkid in (select linkid from soc0114 where domainid="+domainid+" and domainversion="+domainversion+" and eiid="+eiid+" and eiversion ="+eiversion+" and eismallversion="+eiversmallversion+" and fingerprint='1') ");
				query.append("order by linkid,linkorder");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0114VW.class);
				List<SOC0114VWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0114VWInfo>) execute(action);
	}
/*	public List<SOC0114VWInfo> findByCond(final SOC0114VW_FXSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				String eiid = cond.getEiid().toString();
				String eiversion = cond.getEiversion().toString();
				String eiversmallversion = cond.getEismallversion().toString();
				String domainid = cond.getDomainid().toString();
				String domainversion = cond.getDomainversion().toString();
				query.append("select a.domainid,a.domainversion,a.eiid,a.einame,a.esyscoding,a.eiversion,a.eismallversion,a.linkid,a.linkorder,b.civalue as hostIP,c.eiid as hostEiid");
				query.append(",d.eiversion as hostversion,d.eismallversion as hostsmallversion,'' as resourceid");
				query.append(" from soc0114 a left join soc0107 b on(a.eiid=b.eiid and a.eiversion=b.civersion and a.eismallversion=b.cismallversion"); 
				query.append(" and b.cid in ('CI020200010002','CI020200020006','CI020100010003','CI020100020001','CI030100010016','CI020400050015','CI020400010002','CI020500020001'");
				query.append(",'CI020500030004','CI020300010001','CI020300020006','CI030100050007'))");
				query.append(" left join soc0107 c on(b.civalue=c.civalue and c.eid='CM01010001')"); 
				query.append(" left join soc0118 d on(c.eiid=d.eiid)"); 
				query.append(" where a.linkid in (select linkid from soc0114 where a.domainid="+domainid+" and a.domainversion="+domainversion);
				query.append(" and eiid="+eiid+" and eiversion ="+eiversion+" and eismallversion="+eiversmallversion+" and fingerprint='1') order by linkid,linkorder");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0114VW.class);
				List<SOC0114VWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0114VWInfo>) execute(action);
	}*/

	/**
	 * 检索byCond
	 *
	 * @return 检索结果集
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0114VWInfo> findByCondForBJ(final SOC0114VW_FXSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				String eiid = cond.getEiid().toString();
				String eiversion = cond.getEiversion().toString();
				String eiversmallversion = cond.getEismallversion().toString();
				String domainid = cond.getDomainid().toString();
				String domainversion = cond.getDomainversion().toString();
				query.append("select a.domainid,a.domainversion,a.eiid,a.einame,a.esyscoding,a.eiversion,a.eismallversion,a.linkid,a.linkorder"); 
				query.append(",b.civalue as hostip,c.eiid as hosteiid,d.eiversion as hostversion,d.eismallversion as hostsmallversion,e.civalue as resourceid"); 
				query.append(" from soc0114 a"); 
				query.append(" left join soc0107 b on(a.eiid=b.eiid and a.eiversion=b.civersion and a.eismallversion=b.cismallversion "); 
				query.append(" and b.cid in ('CI020200010002','CI020200020006','CI020100010003','CI020100020001','CI030100010016','CI020400050015','CI020400010002','CI020500020001'");
				query.append(",'CI020500030004','CI020300010001','CI020300020006','CI030100050006'))");
				query.append(" left join soc0107 c on(b.civalue=c.civalue and c.eid='CM01010001')"); 
				query.append(" left join soc0118 d on(c.eiid=d.eiid)"); 
				query.append(" left join soc0107 e on(a.eiid=e.eiid and a.eiversion=e.civersion and a.eismallversion=e.cismallversion "); 
				query.append(" and e.cid in('CI020100010005','CI020100020016','CI020200010014','CI020200020007'))"); 
				query.append(" where a.linkid in (select linkid from soc0114 where a.domainid="+domainid+" and a.domainversion="+domainversion);
				query.append(" and eiid="+eiid+" and eiversion ="+eiversion+" and eismallversion="+eiversmallversion+" and fingerprint='1') order by linkid,linkorder");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0114VW.class);
				List<SOC0114VWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0114VWInfo>) execute(action);
	}
	
	/**
	 * 根据主机eiid获取环境类型
	 */
	public String getEitype(final String eiid) {
		HibernateCallback action = new HibernateCallback() {
			@SuppressWarnings("unchecked")
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("SELECT a.civalue FROM SOC0145 a where a.cid='CI010100010071' ");
				if(StringUtils.isNotEmpty(eiid)){
					query.append("and a.eiid = "+eiid+"");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				
				List<String> list = q.list();
				session.clear();
				return list.size()>0?list.get(0):"";
			}
		};
		return (String) execute(action);
	}
}