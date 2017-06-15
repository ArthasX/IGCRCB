/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG567Info;
import com.deliverik.framework.workflow.prd.model.condition.IG433SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG567VW;


/**
 * 概述:流程参与流程评审视图DAO实现
 * 功能描述：
 *           
 * 创建记录：宋海洋    2010/11/26
 */
public class IG567DAOImpl extends
		BaseHibernateDAOImpl<IG567Info> implements
		IG567DAO {

	/**
	 * 流程参与流程评审DAO构造函数
	 * 
	 */
	public IG567DAOImpl() {
		super(IG567VW.class);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG567Info> findByCond(final IG433SearchCond cond,final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG433DAO.searchIG433").getQueryString());
				query.append(getSearchCond(cond));
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.addEntity("IG567VW", IG567VW.class);
				setFetchPoint(q,start, count);
				List<IG567Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG567Info>) execute(action);
	}
	
	/**
	 * 根据输入查询条件拼接sql
	 * 
	 * @param cond检索条件
	 * @return 拼接好的sql
	 */
	private String getSearchCond(IG433SearchCond cond){
		String searchSql = "";
		//流程编号
		if(cond.getPrserialnum() != null && !"".equals(cond.getPrserialnum())){
			searchSql = searchSql + " AND prserialnum  LIKE '%" + cond.getPrserialnum() + "%'";
		}
		// 流程名称
		if(cond.getPrtitle() != null && !"".equals(cond.getPrtitle())){
			searchSql = searchSql + " AND prtitle LIKE '%" + cond.getPrtitle() + "%'";
		}
		// 流程发起者
		if(cond.getPrusername() != null && !"".equals(cond.getPrusername())){
			searchSql = searchSql + " AND prusername LIKE '%" + cond.getPrusername() + "%'";
		}
		// 流程紧急程度
		if(cond.getPrurgency() != null && !"".equals(cond.getPrurgency())){
			searchSql = searchSql + " AND prurgency = '" + cond.getPrurgency() + "'";
		}
		// 事件定义类型
		if(StringUtils.isNotEmpty(cond.getPrpdid())){
			searchSql = searchSql + " AND prpdid = '" + cond.getPrpdid() + "'";
		}
		// 流程类型
		if(cond.getPrtype() != null && !"".equals(cond.getPrtype())){
			searchSql = searchSql + " AND pr.prtype LIKE '%" + cond.getPrtype() + "%'";
		}
		// 评审状态
		if(cond.getAssessmentstatus() != null && !"".equals(cond.getAssessmentstatus())){
			// 评审
			if("1".equals(cond.getAssessmentstatus())){
				searchSql = searchSql + " AND pa.pastatus = '1' ";
			}
			// 未评审
			if("0".equals(cond.getAssessmentstatus())){
				searchSql = searchSql + " AND pa.paid is null ";
			}
			// 草稿
			if("2".equals(cond.getAssessmentstatus())){
				searchSql = searchSql + " AND pa.pastatus = '2' ";
			}
			
		}
		// 评审状态
		if(cond.getPropentime() != null && !"".equals(cond.getPropentime())){
			searchSql = searchSql + " AND propentime >= '" + cond.getPropentime() + "'";
		}
		// 评审状态
		if(cond.getPrclosetime() != null && !"".equals(cond.getPrclosetime())){
			searchSql = searchSql + " AND propentime <= '" + cond.getPrclosetime() + "'";
		}
		
		// 排列顺序
		if(StringUtils.isNotEmpty(cond.getOrder())){
			if("ASC".equals(cond.getSing())){
				
				searchSql = searchSql + " ORDER BY  " + cond.getOrder() + " asc ";
			}else{
				searchSql = searchSql + " ORDER BY  " + cond.getOrder() + " desc ";
			}
		}else{
			searchSql = searchSql + " ORDER BY prclosetime desc ";
		}
		return searchSql;
		
	}
}
