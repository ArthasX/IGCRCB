/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.KnowledgeStatisticsInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeStatisticsSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeStatisticsVW;

/**
 * 概述: 知识库统计DAO实现
 * 功能描述：知识库统计DAO实现
 * 创建记录：wanglei 2014/3/13
 * 修改记录：
 */
public class KnowLedgeStatisticsDAOImpl extends BaseHibernateDAOImpl<KnowLedgeInfo>
		implements KnowLedgeStatisticsDAO {
	/**
	 * 构造函数
	 */
	public KnowLedgeStatisticsDAOImpl() {
		super(KnowledgeStatisticsVW.class);
	}

	/**
	 * 条件检索处理(按贡献人)
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<KnowledgeStatisticsInfo> findByKnprofferCond(final KnowledgeStatisticsSearchCond cond,
			final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select row_number( ) over(order by a.klscount)  as klsid,klscount,knproffer,knproffername,knclass,knclassname ");
				query.append("from ( ");
				query.append("select count(k.knproffer) as klscount,k.knproffer,k.knproffername,null as knclass,null as knclassname ");
				query.append("from ( ");
				query.append("select knid,knproffer,knproffername,knclass,knclassname from Knowledge where knstatus = '1'  ");
				query.append("group by knid,knproffer,knproffername,knclass,knclassname )k ");
				query.append("group by k.knproffer,k.knproffername) a");
//				StringBuffer sql = getCriteria(cond);
//				query.append(sql);
				SQLQuery q = session.createSQLQuery(query.toString());
//				q.setProperties(cond);
				q.addEntity("KnowledgeStatisticsVW",KnowledgeStatisticsVW.class);
				
				setFetchPoint(q, start, count);
				List<KnowledgeStatisticsInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<KnowledgeStatisticsInfo>) execute(action);
	}
	
	/**
	 * 条件检索处理(按分类)
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<KnowledgeStatisticsInfo> findByKnclassCond(final KnowledgeStatisticsSearchCond cond,
			final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select row_number( ) over(order by a.klscount) as klsid,klscount,knproffer,knproffername,knclass,knclassname ");
				query.append("from ( ");
				query.append("select count(k.knclass) as klscount,null as knproffer,null as knproffername,k.knclass,k.knclassname ");
				query.append("from ( ");
				query.append("select knid,knproffer,knproffername,knclass,knclassname from Knowledge where knstatus = '1' ");
				query.append("group by knid,knproffer,knproffername,knclass,knclassname )k ");
				query.append("group by k.knclass,k.knclassname)a");
//				StringBuffer sql = getCriteria(cond);
//				query.append(sql);
				SQLQuery q = session.createSQLQuery(query.toString());
//				q.setProperties(cond);
				q.addEntity("KnowledgeStatisticsVW",KnowledgeStatisticsVW.class);
				
				setFetchPoint(q, start, count);
				List<KnowledgeStatisticsInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<KnowledgeStatisticsInfo>) execute(action);
	}
	
	/**
	 * 约束条件sql拼写
	 * @param cond
	 * @return StringBuffer
	 */
	protected StringBuffer getCriteria(KnowledgeStatisticsSearchCond cond) {
		StringBuffer sql = new StringBuffer();
		
//		if(StringUtils.isNotEmpty(cond.getKnclass())){
//			sql.append(" and Upper(j.knclass)= Upper(:knclass)");
//		}
		return sql;
	}
}
