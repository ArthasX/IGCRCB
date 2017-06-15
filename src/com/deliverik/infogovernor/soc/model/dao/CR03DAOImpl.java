/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.model.CR03Info;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;
import com.deliverik.infogovernor.soc.model.condition.CR03SearchCond;
import com.deliverik.infogovernor.soc.model.entity.CR03TB;
import com.deliverik.infogovernor.soc.model.entity.CR03VW;

/**
  * 概述: 配置原数据与主机关系表DAO实现
  * 功能描述: 配置原数据与主机关系表DAO实现
  * 创建记录: 2013/04/08
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CR03DAOImpl extends
		BaseHibernateDAOImpl<CR03Info> implements CR03DAO {
	
	static Log log = LogFactory.getLog(CR03DAOImpl.class);
	
	/**
	 * 构造函数
	 */
	public CR03DAOImpl(){
		super(CR03TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CR03Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CR03Info findByPK(Serializable pk) {
		CR03Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CR03SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CR03Info> findByCond(final CR03SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	
	/**
	 * 条件检索处理[最大日期的导入]
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<CR03Info> findByCondMax(final CR03SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
								
				query.append("SELECT a.* FROM cr03 a,(SELECT max(collecttime) collecttime,host,servername,ip,status FROM cr03 where 1=1 ");
				
				query.append("and status in("+ArrayToString(cond.getStatus())+")");
				
				query.append(" group by host,servername,ip,status ) b  where a.collecttime=b.collecttime and a.host=b.host and a.servername=b.servername and a.ip=b.ip");
				
				if (StringUtils.isNotEmpty(cond.getCollecttimeFrom())) {
					query.append(" and b.collecttime >= '" + cond.getCollecttimeFrom() + "'");
				}
				if (StringUtils.isNotEmpty(cond.getCollecttimeTo())) {
					query.append(" and b.collecttime <= '" + cond.getCollecttimeTo() + "'");
				}
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity(CR03TB.class);
				
				session.clear();
				
				return q.list();
			}
		};
		return (List<CR03Info>) execute(action);
	}
	/**
	 * 条件检索处理[最大日期的导入和type]
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<CR03VWInfo> findByCondMaxAndEsyscoding(final CR03SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				query.append(" select cr.host,cr.ip,cr.maxctime,cr.minctime,cr.status,cr.type,cr.servername,cr.tablename,c.imptypename from ( ");
				query.append(" select host,ip,max(collecttime) maxctime,min(collecttime) minctime,");
				query.append(" max(status) status,type,max(tablename) tablename,servername from cr03");
				query.append(" group by host,ip,type,servername) cr ");
				query.append(" left join soc0113 c  on cr.type =c.imptypeid where 1=1 ");
				
				getSQL(cond, query);
				
				query.append(" order by cr.type,cr.maxctime,cr.servername,cr.ip,cr.host ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(CR03VW.class);
				setFetchPoint(q, start, count);
				session.clear();
				return q.list();
			}
		};
		return (List<CR03VWInfo>) execute(action);
	}
	
	/**
	 * 
	 * @param cond
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CR03VWInfo> getRciVersions(final CR03SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
//				query.append(" select * from( ");
//				query.append(" select max(host) as host,max(ip) as ip,max(tablename) as tablename, ");
//				query.append(" max(status) as status,min(type) as type,'' as imptypename, ");
//				query.append(" max(collecttime) maxctime,min(collecttime) minctime from( ");
//				query.append(" select * from cr03 where 1=1 ");
//				getSQL_version2(cond, query,1);
//				query.append(" ) cr group by substr(collecttime,0,9) ");
//				query.append(" ) A where 1=1 ");
//				getSQL_version2(cond, query,2);
//				query.append(" order by minctime desc ");
				
				query.append(" select t1.servername , t1.host ,t1.ip ,t1.tablename ,t1.status , ");
				query.append(" t1.type , t2.imptypename as imptypename,  t1.collecttime as maxctime, ");
				query.append(" t1.collecttime as minctime ");
				query.append(" from cr03 t1, soc0113 t2 ");
				query.append(" where 1=1 ");
				query.append(" and t1.type = t2.imptypeid ");
				getSQL_version2(cond, query,1);
				getSQL_version2(cond, query,2);
				query.append(" order by t1.collecttime desc ");
				log.info(query.toString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(CR03VW.class);
				setFetchPoint(q, start, count);
				session.clear();
				return q.list();
			}
		};
		return (List<CR03VWInfo>) execute(action);
	}
	
	protected void getSQL_version2(CR03SearchCond cond, StringBuffer query , int location){
		if(location == 1){
			if(StringUtils.isNotEmpty(cond.getHost())){
				query.append(" and host='"+cond.getHost()+"' ");
			}
			if(StringUtils.isNotEmpty(cond.getIp())){
				query.append(" and ip='"+cond.getIp()+"' ");
			}
			if(StringUtils.isNotEmpty(cond.getType())){
				query.append(" and type="+cond.getType()+" ");
			}
			if(StringUtils.isNotEmpty(cond.getServername())){
				query.append(" and servername= '"+cond.getServername()+"' ");
			}
		}
		if(location == 2){
			if(StringUtils.isNotEmpty(cond.getCollecttimeFrom())){
				query.append(" and collecttime >= '"+cond.getCollecttimeFrom()+"' ");
			}
			if(StringUtils.isNotEmpty(cond.getCollecttimeTo())){
				query.append(" and collecttime <= '"+cond.getCollecttimeTo()+"' ");
			}
			if(StringUtils.isNotEmpty(cond.getCollecttime())){
				query.append(" and collecttime = '"+cond.getCollecttime()+"' ");
			}
		}
	}
	
	protected void getSQL_version(CR03SearchCond cond, StringBuffer query){
		
		if(StringUtils.isNotEmpty(cond.getHost())){
			query.append(" and host='"+cond.getHost()+"' ");
		}
		if(StringUtils.isNotEmpty(cond.getIp())){
			query.append(" and ip='"+cond.getIp()+"' ");
		}
		if(StringUtils.isNotEmpty(cond.getType())){
			query.append(" and type="+cond.getType()+" ");
		}
		if(StringUtils.isNotEmpty(cond.getStatus())){
			query.append(" and status= '"+cond.getStatus()+"' ");
		}
		if(StringUtils.isNotEmpty(cond.getServername())){
			query.append(" and servername='"+cond.getServername()+"' ");
		}
		if(StringUtils.isNotEmpty(cond.getCollecttimeFrom())){
			query.append(" and minctime >= '"+cond.getCollecttimeFrom()+"' ");
		}
		if(StringUtils.isNotEmpty(cond.getCollecttimeTo())){
			query.append(" and minctime <= '"+cond.getCollecttimeTo()+"' ");
		}
	}
	
	/**
	 * 条件检索结果件数取得[最大日期的导入和type]
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCountByCondMaxAndEsyscoding(final CR03SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select count(cr.*) from ( ");
				query.append(" select host,ip,max(collecttime) maxctime,min(collecttime) minctime,");
				query.append(" max(status) status,type,max(tablename) tablename,servername from cr03");
				query.append(" group by host,ip,type,servername) cr ");
				query.append(" left join soc0113 c  on cr.type =c.imptypeid where 1=1 ");

				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CR03SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getHost())){
			c.add(Expression.eq("host", cond.getHost()));
		}
		if(StringUtils.isNotEmpty(cond.getStatus())){
			List<String> l = new ArrayList<String>();
			for(String str:cond.getStatus().split(",")){
				l.add(str);
			}
			c.add(Expression.in("status", l));
			c.addOrder(Order.asc("type"));
			c.addOrder(Order.asc("status"));
			c.addOrder(Order.asc("collecttime"));
		}
		if(StringUtils.isNotEmpty(cond.getTablename())){
			c.add(Expression.eq("tablename", cond.getTablename()));
		}
		if(StringUtils.isNotEmpty(cond.getCollecttime())){
			c.add(Expression.eq("collecttime", cond.getCollecttime()));
		}
		if(StringUtils.isNotEmpty(cond.getOrderFlag())){
			String[] orinfo = cond.getOrderFlag().split("_#_");
			if("asc".equals(orinfo[0].toLowerCase())){
				c.addOrder(Order.asc(orinfo[1]));
			}else{
				c.addOrder(Order.desc(orinfo[1]));
			}
		}
		if(StringUtils.isNotEmpty(cond.getCollecttimeFrom())){
			c.add(Expression.ge("collecttime", cond.getCollecttimeFrom()));
		}
		if(StringUtils.isNotEmpty(cond.getCollecttimeTo())){
			c.add(Expression.le("collecttime", cond.getCollecttimeTo()));
		}
		return c;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(CR03SearchCond cond, StringBuffer query) {

		if(cond!=null){
			if(StringUtils.isNotEmpty(cond.getCollecttimeFrom())){
				query.append(" AND cr.minctime >= :collecttimeFrom");
			}
			if(StringUtils.isNotEmpty(cond.getCollecttimeTo())){
				query.append(" AND cr.minctime <= :collecttimeTo");
			}
			if(StringUtils.isNotEmpty(cond.getHost())){
				query.append(" AND cr.host like ('%'||:host||'%')");
			}
			if(StringUtils.isNotEmpty(cond.getEsyscoding())){
				query.append(" AND c.fingerprint like (:esyscoding||'%')");
			}
			if(StringUtils.isNotEmpty(cond.getIp())){
				query.append(" AND cr.ip = :ip");
			}
		}
	}
	/**
	 * 检索条件特殊情况处理
	 * 
	 * @param cond检索条件
	 * @return 检索用检索条件类
	 */
	protected String ArrayToString(String array){
		//status：1,2  TO '1','2'
		StringBuffer sb = new StringBuffer();
		for(String str : array.split(",")){
			sb.append("'").append(str).append("'").append(",");
		}
		return sb.substring(0,sb.length()-1).toString();
		
	}
}