/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.com.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.com.model.condition.ProcessInHandVWInfoSearchCond;
import com.deliverik.infogovernor.com.model.condition.ProcessInHandVWInfoSearchCondImpl;
import com.deliverik.infogovernor.com.model.entity.ProcessInHandVW;

/**
 * 
 * 首页DAO实现
 * 
 */
public class ProcessInHandSingleVWDAOImpl extends
		BaseHibernateDAOImpl<ProcessInHandVWInfo> implements
		ProcessInHandSingleVWDAO {

	/**
	 * 构造函数
	 */
	public ProcessInHandSingleVWDAOImpl() {
		super(ProcessInHandVW.class);
	}

	/**
	 * 我的工作检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<ProcessInHandVWInfo> searchProcessInhand(
			final ProcessInHandVWInfoSearchCond cond,final int start, final int count, final boolean desc) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<ProcessInHandVWInfo> list = null;
				
				String userid = cond.getUserid();
				
				if(StringUtils.isEmpty(userid)){
					return null;
				}
				query.append(" select t.* from (");
				query.append(" select");
				query.append(" row_number() over() as rid,");
				query.append(" (CASE WHEN C.PIVARVALUE  = '紧急变更' THEN 1 ELSE 0 END) as pivarvalue, ");
				query.append(" a.prid,");
				query.append(" a.prusername,");
				query.append(" a.prurgency,");
				query.append(" a.prserialnum,");
				query.append(" a.prtitle,");
				query.append(" a.prpdid,");
				query.append(" a.prpdname,");
				query.append(" a.prtype,");
				query.append(" a.propentime,");
				query.append(" a.prclosetime,");
				query.append(" a.ppusername,");
				query.append(" a.pprolename,");
				query.append(" a.prstatus,");
				query.append(" a.psdid,");
				query.append(" a.prstrategyversion,");
				query.append(" a.pprolename as prrolename,");
				query.append(" d.psdname as orderstatus");
				query.append(" from ig677 a ");
				query.append(" inner join ig591 b on a.prid = b.prid and a.psdid = b.psdid ");
				query.append(" left join ig599 c ON a.prid = c.prid and c.PIVARLABEL='变更类别' ");
				query.append(" left join ig333 d on a.prpdid = d.pdid and a.prstatus=d.psdcode ");
				query.append(" where (prclosetime is null or PRCLOSETIME = '') and (ppproctime is null or ppproctime = '') and ppuserid = '");
				query.append(userid);
				query.append("' group by ");
				
				query.append(" a.prid,");
				query.append(" a.prusername,");
				query.append(" a.prurgency,");
				query.append(" a.prserialnum,");
				query.append(" a.prtitle,");
				query.append(" a.prpdid,");
				query.append(" a.prpdname,");
				query.append(" a.prtype,");
				query.append(" a.propentime,");
				query.append(" a.prclosetime,");
				query.append(" a.ppusername,");
				query.append(" a.pprolename,");
				query.append(" a.prstatus,");
				query.append(" a.psdid,");
				query.append(" a.prstrategyversion,");
				query.append(" pivarvalue,");
				query.append(" a.pprolename,");
				query.append(" d.psdname");
				query.append(")  t ");
				query.append(" order by pivarvalue desc,propentime desc");
				SQLQuery q = session.createSQLQuery(query.toString());
			
				q.addEntity("ProcessInHandVW", ProcessInHandVW.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
					
				return list;
			}
		};
		return (List<ProcessInHandVWInfo>) execute(action);
	}
	
	
	/**
	 * 相关工作检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<ProcessInHandVWInfo> searchProcessInhandGroup(
			final ProcessInHandVWInfoSearchCond cond,final int start,final int count, final boolean desc) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<ProcessInHandVWInfo> list = null;
				
				String userid = cond.getUserid();
				
				if(StringUtils.isEmpty(userid)){
					return null;
				}
				
				query.append(" select * from (");
				query.append(" select");
				query.append(" row_number() over() as rid,");
				query.append(" a.prid,");
				query.append(" a.prusername,");
				query.append(" a.prurgency,");
				query.append(" a.prserialnum,");
				query.append(" a.prtitle,");
				query.append(" a.prpdid,");
				query.append(" a.prpdname,");
				query.append(" a.prtype,");
				query.append(" a.propentime,");
				query.append(" a.prclosetime,");
				query.append(" '' as ppusername,");
				query.append(" a.pprolename,");
				query.append(" a.prstatus,");
				query.append(" a.psdid,");
				query.append(" a.prstrategyversion,");
				query.append(" a.pprolename as prrolename, ");
				query.append(" d.psdname as orderstatus");
				query.append(" from ig677 a ");
				query.append(" inner join ig591 b on a.prid = b.prid and a.psdid = b.psdid ");
				query.append(" left join ig333 d on a.prpdid = d.pdid and a.prstatus=d.psdcode ");
				query.append(" where  (prclosetime is null or PRCLOSETIME = '') and  (ppproctime is null and ppuserid is null or ppuserid <> '");
				query.append(userid);
				query.append("') and pproleid in (select roleid from userrole where userid = '");
				query.append(userid);
				query.append("') and a.prid not in ");
				query.append("(select distinct(a.prid) from ig677 a  inner join ig591 b on a.prid = b.prid and a.psdid = b.psdid   where ppuserid = '" );
				query.append(userid);
				query.append("' and ppproctime is null) ");
				query.append(" group by ");
				query.append(" a.prid,");
				query.append(" a.prusername,");
				query.append(" a.prurgency,");
				query.append(" a.prserialnum,");
				query.append(" a.prtitle,");
				query.append(" a.prpdid,");
				query.append(" a.prpdname,");
				query.append(" a.prtype,");
				query.append(" a.propentime,");
				query.append(" a.prclosetime,");
				query.append(" a.pprolename,");
				query.append(" a.prstatus,");
				query.append(" a.psdid,");
				query.append(" a.prstrategyversion,");
				query.append(" a.pprolename,");
				query.append(" d.psdname");
				query.append(")  where rid <= 10 ");
				if(desc){
					query.append(" order by propentime desc");
				}else{
					query.append(" order by propentime asc");
				}
				
				SQLQuery q = session.createSQLQuery(query.toString());
			
				q.addEntity("ProcessInHandVW", ProcessInHandVW.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();

				return list;
			}
		};
		return (List<ProcessInHandVWInfo>) execute(action);
	}

	/**
	 * 中止工作检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<ProcessInHandVWInfo> searchProcessInhandDiscontinue(
			final ProcessInHandVWInfoSearchCondImpl cond, final boolean desc) {

		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<ProcessInHandVWInfo> list = null;
				
				String userid = cond.getUserid();
				
				if(StringUtils.isEmpty(userid)){
					return null;
				}
				
				query.append(" select * from (");
				query.append(" select");
				query.append(" row_number() over() as rid,");
				query.append(" a.prid,");
				query.append(" a.prusername,");
				query.append(" a.prurgency,");
				query.append(" a.prserialnum,");
				query.append(" a.prtitle,");
				query.append(" a.prpdid,");
				query.append(" a.prpdname,");
				query.append(" a.prtype,");
				query.append(" a.propentime,");
				query.append(" a.prclosetime,");
				query.append(" a.ppusername,");
				query.append(" a.pprolename,");
				query.append(" a.prstatus,");
				query.append(" a.psdid,");
				query.append(" a.prstrategyversion,");
				query.append(" a.pprolename as prrolename, ");
				query.append(" d.psdname as orderstatus");
				query.append(" from ig677 a ");
				query.append(" left join ig333 d on a.prpdid = d.pdid and a.prstatus=d.psdcode ");
				query.append(" where prstatus = '#' and pruserid = '");
				query.append(userid);
				query.append("' ");
				query.append(" group by ");
				query.append(" a.prid,");
				query.append(" a.prusername,");
				query.append(" a.prurgency,");
				query.append(" a.prserialnum,");
				query.append(" a.prtitle,");
				query.append(" a.prpdid,");
				query.append(" a.prpdname,");
				query.append(" a.prtype,");
				query.append(" a.propentime,");
				query.append(" a.prclosetime,");
				query.append(" a.ppusername,");
				query.append(" a.pprolename,");
				query.append(" a.prstatus,");
				query.append(" a.psdid,");
				query.append(" a.prstrategyversion,");
				query.append(" a.pprolename,");
				query.append(" d.psdname");
				query.append(")  where rid <= 10 ");
				if(desc){
					query.append(" order by propentime desc");
				}else{
					query.append(" order by propentime asc");
				}
				
				SQLQuery q = session.createSQLQuery(query.toString());
			
				q.addEntity("ProcessInHandVW", ProcessInHandVW.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();

				return list;
			}
		};
		return (List<ProcessInHandVWInfo>) execute(action);
	
	}

	
}
