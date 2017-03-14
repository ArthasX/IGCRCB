/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.asset.model.RehearseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RehearseSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RehearseVW;



/**
  * 概述: 科技风险相关表DAO实现
  * 功能描述:  科技风险相关表DAO实现
  * 创建记录: 2014/08/16
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class RehearseDAOImpl extends
		BaseHibernateDAOImpl<RehearseVWInfo> implements RehearseDAO {

	/**
	 * 构造函数
	 */
	public RehearseDAOImpl(){
		super(RehearseVW.class);
	}

	/**
	 * 获取 评估工作所选中的本年度风险工作覆盖情况-风险点+检查项
	 * @param cond
	 * @param start
	 * @param count
	 * @return key:ename riskcount riskesyscoding inspectcount inspectesyscoding
	 * @return 评估工作所选中的风险点&检查项  -按领域划分(按本年度过滤掉重复的风险点)
	 */
	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> searchAssessRisk(final RehearseSearchCond cond, final int start, final int count){
		
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<HashMap<String, Object>> list =null;
				query.append(session.getNamedQuery("rehearsedao.risk.inspect.assess").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				q.addScalar("ename",Hibernate.STRING) ;
				q.addScalar("riskcount",Hibernate.STRING) ;
				q.addScalar("riskesyscoding",Hibernate.STRING) ;
				q.addScalar("inspectcount",Hibernate.STRING) ;
				q.addScalar("inspectesyscoding",Hibernate.STRING) ;
				
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<HashMap<String, Object>>) execute(action);
	}
	
	/**
	 * 获取 本年度风险工作覆盖情况 风险点+检查项 
	 * @param cond
	 * @param start
	 * @param count
	 * @return key:ename riskcount riskesyscoding inspectcount inspectesyscoding
	 * @return List<HashMap<String, Object>> list 风险点&检查项 总数  -按领域划分
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> searchRiskInfo(final RehearseSearchCond cond, final int start, final int count){
		
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<HashMap<String, Object>> list =null;
				//获取问题整改sql文
				query.append(session.getNamedQuery("rehearsedao.risk.inspect").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				//风险领域名称
				q.addScalar("ename",Hibernate.STRING) ;
				//风险点数量
				q.addScalar("riskcount",Hibernate.STRING) ;
				//风险点-esyscoding
				q.addScalar("riskesyscoding",Hibernate.STRING) ;
				//检查项数量
				q.addScalar("inspectcount",Hibernate.STRING) ;
				//检查项-esyscoding
				q.addScalar("inspectesyscoding",Hibernate.STRING) ;
				
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<HashMap<String, Object>>) execute(action);
	}
	
	/**
	 * 问题整改 总数:按领域划分
	 * @param cond
	 * @param start
	 * @param count
	 * @return key:fieldvalue prcount recount
	 * @return List<HashMap<String, Object>> list 返回各个领域问题整改相关信息
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<HashMap<String, Object>> searchIssueCorrectiveInfo(final RehearseSearchCond cond, final int start, final int count){
		
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<HashMap<String, Object>> list =null;
				//获取问题整改sql文
				query.append(session.getNamedQuery("rehearsedao.issue.corrective").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				//设定返回的map-key
				q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				//领域名称
				q.addScalar("fieldvalue",Hibernate.STRING) ;
				//各个领域问题总数
				q.addScalar("prcount",Hibernate.STRING) ;
				//各个领域整改总数
				q.addScalar("recount",Hibernate.STRING) ;
				
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<HashMap<String, Object>>) execute(action);
	}
	/**
	 * 各个问题整改-详细信息by领域-钻取用
	 * @param cond
	 * @param start
	 * @param count
	 * @return List<IG500Info> list 返回各个领域的问题整改流程信息
	 */
	@SuppressWarnings("unchecked")
	public List<IG500Info> searchIssueCorrectiveByField(final RehearseSearchCond cond, final int start, final int count){
		
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<IG500Info> list =null;
				//获取各领域问题整改sql文
				query.append(session.getNamedQuery("rehearsedao.searchIssueCorrectiveByField").getQueryString());
				//添加过滤条件
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				//给sql文传递参数 
				q.setProperties(cond);
				q.addEntity(IG500TB.class);
				
				setFetchPoint(q,start, count);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IG500Info>) execute(action);
	}
	/**
	 * sql检索条件生成
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(RehearseSearchCond cond, StringBuffer query){
		//计划状态(完全匹配)
		if(StringUtils.isNotEmpty(cond.getPrstatus())){
			//当flex需要显示整改内容时
			String prstatus = cond.getPrstatus();
			if("RECTIFY".equals(prstatus)){
				//获取已关闭的问题整改流程
				query.append(" AND a.PRCLOSETIME !=''");
			}
		}
			
	}

}