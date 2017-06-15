/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.model.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程通用查询实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ProcessQueryDAOImpl extends HibernateDaoSupport implements ProcessQueryDAO{

	/**
	 * 取得查询数量
	 * @param sql 执行sql
	 * @return 查询数量
	 */
	public int getSearchCount(String sql) {
		//取得session
		Session session = this.getSession();
		session.flush();
		StringBuffer query = new StringBuffer();
//		query.append(" select count(1) from ( ");
		query.append(sql);
//		query.append(") ");
		SQLQuery q = session.createSQLQuery(query.toString());
//		Integer count = ((Number)q.list().get(0)).intValue();
		Integer count = q.list().size();
		session.clear();
		return count;
	}
	
	/**
	 * 流程查询操作
	 * @param sql 执行sql
	 * @param start 起始页码
	 * @param count 显示数量
	 * @return 流程信息集合
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> searchProcessRecordInfo(String sql, int start, int count) {
		//取得session
		Session session = this.getSession();
		session.flush();
		StringBuffer sb = new StringBuffer(sql);
		if(start >= 0){
			sb.append(" and rownum > " +start);
//			
//			q.setFirstResult(start);
		}
		if(count > 0){
			sb.append(" and rownum <= "+(start+count) );
//			q.setMaxResults(count);
		}
		SQLQuery q = session.createSQLQuery(sb.toString());
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Object>> list = q.list();
		session.clear();
		return list;
	}
}
