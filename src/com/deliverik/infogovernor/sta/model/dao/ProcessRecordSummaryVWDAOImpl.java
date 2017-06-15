/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.sta.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sta.model.ProcessRecordSummary;
import com.deliverik.infogovernor.sta.model.condition.ProcessRecordSummarySearchCond;
import com.deliverik.infogovernor.sta.model.entity.ProcessRecordSummaryVW;

/**
 * 检查问题统计DAO实现
 */
public class ProcessRecordSummaryVWDAOImpl extends BaseHibernateDAOImpl<ProcessRecordSummary> implements ProcessRecordSummaryVWDAO {
	/**
	 * 构造函数
	 */
	public ProcessRecordSummaryVWDAOImpl(){
		super(ProcessRecordSummaryVW.class);
	}
	
	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<ProcessRecordSummary> findByCond(final ProcessRecordSummarySearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if("1".equals(cond.getStatistictype())){// 统计项选择问题种类
					query.append(session.getNamedQuery("ProcessRecordSummaryVWDAO.examineProblemStatistics1").getQueryString());
					if(StringUtils.isNotEmpty(cond.getPcode())){
						query.append("and pr.pcode = '" + cond.getPcode() + "'");
					}
					if(StringUtils.isNotEmpty(cond.getPrassetname())){
						query.append("and pr.prassetname = '" + cond.getPrassetname() + "'");
					}
					if(StringUtils.isNotEmpty(cond.getPropentime_from())){
						query.append("and pr.propentime >= '" + cond.getPropentime_from() + " 00:00'");
					}
					if(StringUtils.isNotEmpty(cond.getPropentime_to())){
						query.append("and pr.propentime <= '" + cond.getPropentime_to() + " 23:59'");
					}
					query.append(") a group by pname,pcode) prs) prcount");
				}else if("2".equals(cond.getStatistictype())){// 统计项选择问题来源
					query.append(session.getNamedQuery("ProcessRecordSummaryVWDAO.examineProblemStatistics2").getQueryString());
					if(StringUtils.isNotEmpty(cond.getPrassetname())){
						query.append("and pr.prassetname = '" + cond.getPrassetname() + "'");
					}
					if(StringUtils.isNotEmpty(cond.getPcode())){
						query.append("and pr.pcode = '" + cond.getPcode() + "'");
					}
					if(StringUtils.isNotEmpty(cond.getPropentime_from())){
						query.append("and pr.propentime >= '" + cond.getPropentime_from() + " 00:00'");
					}
					if(StringUtils.isNotEmpty(cond.getPropentime_to())){
						query.append("and pr.propentime <= '" + cond.getPropentime_to() + " 23:59'");
					}
					query.append(") a group by prassetname) prs) prcount");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("prcount",ProcessRecordSummaryVW.class);
				setFetchPoint(q, start, count);
				List<ProcessRecordSummary> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<ProcessRecordSummary>) execute(action);
	}
	
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(ProcessRecordSummarySearchCond cond, StringBuffer query){
		//时间开始
//		if( StringUtils.isNotEmpty(cond.getDate_from()) ){
//			query.append(" AND ACINSDATE >=:date_from ");
//		}	
//		//时间结束
//		if( StringUtils.isNotEmpty(cond.getDate_to()) ){
//			query.append(" AND ACINSDATE <=:date_to ");
//		}	
	}
}
