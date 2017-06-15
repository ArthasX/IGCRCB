/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.model.dao;

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
import com.deliverik.infogovernor.soc.model.CR01VWInfo;
import com.deliverik.infogovernor.soc.model.condition.CR01SearchCond;
import com.deliverik.infogovernor.soc.model.entity.CR01VW;

/**
 * 配置采集源数据操作类
 * 王省 2013.07.17
 *
 */
public class CR01DAOImpl extends BaseHibernateDAOImpl<CR01VWInfo> implements CR01DAO{
	
	static Log log = LogFactory.getLog(CR01DAOImpl.class);
	
	/**
	 * 构造方法
	 */
	public CR01DAOImpl(){
		super(CR01VW.class);
	}
	
	/**
	 * 采集结果查询
	 * @param cond 查询条件
	 * @param start 起始页码
	 * @param length 显示条数
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
//	public List<CR01VWInfo> searchCR01VWInfoList(final CR01SearchCond cond,final int start,final int length){
//		HibernateCallback action = new HibernateCallback() {
//			public Object doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				session.flush();
//				StringBuffer query = new StringBuffer();
//				query.append(" select host,collecttime,command,cdataorder,cdata,inserttime,category,keys,fingerprint from ");
//				query.append(cond.getTablename());
//				query.append(" where 1=1 ");
//				if(StringUtils.isNotEmpty(cond.getHost())){
//					query.append(" and host = :host ");
//				}
//				if(StringUtils.isNotEmpty(cond.getCollecttime())){
//					query.append(" and collecttime = :collecttime ");
//				}
//				if(StringUtils.isNotEmpty(cond.getCommand())){
//					query.append(" and command = :command ");
//				}
//				query.append(" order by command ,cdataorder");
//				SQLQuery q = session.createSQLQuery(query.toString());
//				q.setProperties(cond);
//				q.addEntity(CR01VW.class);
//				setFetchPoint(q, start, length);
//				return q.list();
//			}
//		};
//		return (List<CR01VWInfo>) execute(action);
//	}
	public List<CR01VWInfo> searchCR01VWInfoList(final CR01SearchCond cond,final int start,final int length){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select * from ");
				query.append(cond.getTablename());
				query.append(" where 1=1 ");
				getSQL(cond,query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(CR01VW.class);
				setFetchPoint(q, start, length);
				return q.list();
			}
		};
		return (List<CR01VWInfo>) execute(action);
	}
	
	protected void getSQL(CR01SearchCond cond, StringBuffer query){
		if(StringUtils.isNotEmpty(cond.getHost())){
			query.append(" and host = '"+checkStr(cond.getHost())+"' ");
		}
		if(StringUtils.isNotEmpty(cond.getCollecttime())){
			query.append(" and collecttime = '"+cond.getCollecttime()+ "' ");
		}
		if(StringUtils.isNotEmpty(cond.getIp())){
			query.append(" and ip = '"+cond.getIp()+"' ");
		}
		if(StringUtils.isNotEmpty(cond.getServertype())){
			query.append(" and servertype = "+cond.getServertype()+" ");
		}
		if(StringUtils.isNotEmpty(cond.getServername())){
			query.append(" and servername = '"+cond.getServername()+"' ");
		}else if(StringUtils.isNotEmpty(cond.getServername())){
			query.append(" and servername = '"+cond.getServername()+"' ");
		}
		if(StringUtils.isNotEmpty(cond.getCommand())){
			query.append(" and command = '"+checkStr(cond.getCommand())+"' ");
		}
	}
	
	private String checkStr(String str){
		if(str.indexOf("'") != -1)
			return str.replaceAll("'", "''");
		return str;
	}
}
