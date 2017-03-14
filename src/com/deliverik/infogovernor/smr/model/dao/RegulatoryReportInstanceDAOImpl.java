/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.ReportHistorySearchVWInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCond;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;
import com.deliverik.infogovernor.smr.model.entity.BatchExamineVW;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportInstanceTB;
import com.deliverik.infogovernor.smr.model.entity.ReportHistorySearchVW;

/**
  * 概述: 报表填报实例表DAO实现
  * 功能描述: 报表填报实例表DAO实现
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class RegulatoryReportInstanceDAOImpl extends
		BaseHibernateDAOImpl<RegulatoryReportInstanceInfo> implements RegulatoryReportInstanceDAO {

	/**
	 * 构造函数
	 */
	public RegulatoryReportInstanceDAOImpl(){
		super(RegulatoryReportInstanceTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RegulatoryReportInstanceInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RegulatoryReportInstanceInfo findByPK(Serializable pk) {
		RegulatoryReportInstanceInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RegulatoryReportInstanceSearchCond cond){
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
	public List<RegulatoryReportInstanceInfo> findByCond(final RegulatoryReportInstanceSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RegulatoryReportInstanceInfo> findByCond(final RegulatoryReportInstanceSearchCond cond){
		return findByCond(cond, 0, 0);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RegulatoryReportInstanceSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//组标识
		if( StringUtils.isNotEmpty(cond.getKey_eq())){
			c.add(Expression.eq("key", cond.getKey_eq()));
		}
		//状态
		if( StringUtils.isNotEmpty(cond.getStatus_eq())){
			c.add(Expression.eq("status", cond.getStatus_eq()));
		}
		//发起人
		if(StringUtils.isNotEmpty(cond.getUserid())){
			c.add(Expression.eq("userid", cond.getUserid()));
		}
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<AnnualReportVWInfo> findAnnualReportByCond(
			final RegulatoryReportInstanceSearchCond cond, final int start,final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("AnnualReportQuireVWDAO.searchMyAnnualReport").getQueryString());
				if(StringUtils.isNotEmpty(cond.getPrtype())){
					query.append(" and a.prtype ='"+cond.getPrtype()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getPsdname())){
					query.append(" and e.psdname ='"+cond.getPsdname()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getUserid())){
					query.append(" and ur.userid ='"+cond.getUserid()+"'");
				}
				//组标识
				if( StringUtils.isNotEmpty(cond.getKey_eq())){
					query.append(" and a.key ='"+cond.getKey_eq()+"'");
				}
				//发起人
				if(StringUtils.isNotEmpty(cond.getInituser())){
					query.append(" and a.userid ='"+cond.getInituser()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getPropentime())){
					query.append(" and a.inittime >='"+cond.getPropentime()+" 00:00'");
				}
				if(StringUtils.isNotEmpty(cond.getProclosetime())){
					query.append(" and a.inittime <='"+cond.getProclosetime()+" 23:59'");
				}
				query.append(" order by prtitle");
				if(StringUtils.isNotEmpty(cond.getOrderby())){
					query.append(" desc");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("AnnualReportVW",AnnualReportVW.class);
				setFetchPoint(q, start, count);
				List<AnnualReportVWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<AnnualReportVWInfo>) execute(action);
	}


	@SuppressWarnings("unchecked")
	public List<RegulatoryReportInstanceInfo> findSectionAnnualReportByCond(
			final RegulatoryReportInstanceSearchCond cond,final int start,final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("AnnualReportQuireVWDAO.searchSecondAnnualReport").getQueryString());
				if(StringUtils.isNotEmpty(cond.getPrtype())){
					query.append(" and a.prtype ='"+cond.getPrtype()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getPsdname())){
					query.append(" and e.psdname ='"+cond.getPsdname()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getUserid())){
					query.append(" and ur.userid ='"+cond.getUserid()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getStatus_eq())){
					query.append(" and status ='"+cond.getStatus_eq()+"'");
				}				
				query.append(" order by inittime ");
				if(StringUtils.isNotEmpty(cond.getOrderby())){
					query.append(" "+cond.getOrderby());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("RegulatoryReportInstanceTB",RegulatoryReportInstanceTB.class);
				setFetchPoint(q, start, count);
				List<RegulatoryReportInstanceInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<RegulatoryReportInstanceInfo>) execute(action);
	}

	@SuppressWarnings("unchecked")
	public List<BatchExamineVWInfo> findBatchExanmie(
			final RegulatoryReportInstanceSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("BatchExamineVWDAO.searchBatchExamine").getQueryString());
				if(cond.getInstanceid()!=null&&cond.getInstanceid()!=0){
					query.append(" and rrd.instanceid ="+cond.getInstanceid());
				}
				query.append(" group by pr.prid,pr.prpdname,pr.prstatus,pr.prpdid");
				query.append(" order by pr.prid");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("BatchExamineVW",BatchExamineVW.class);
				List<BatchExamineVWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<BatchExamineVWInfo>) execute(action);
	}

	@SuppressWarnings("unchecked")
	public List<ReportHistorySearchVWInfo> findReportHistory(
			final RegulatoryReportInstanceSearchCond cond,final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("ReportHistorySearch.searchprocess").getQueryString());
				query.append(" and pr.prclosetime > ' '");
				if(StringUtils.isNotEmpty(cond.getPrtype())){
					query.append(" and pr.prtype='"+cond.getPrtype()+"'");
				}else{
					query.append(" and pr.prtype in('WD1','WD2','WD3')");
				}
				if(StringUtils.isNotEmpty(cond.getPrtitle())){
					query.append(" and pr.prtitle like '%"+cond.getPrtitle()+"%'");
				}
				if(StringUtils.isNotEmpty(cond.getPropentime())){
					query.append(" and pr.propentime >='"+cond.getPropentime()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getProclosetime())){
					query.append(" and pr.propentime <='"+cond.getProclosetime()+"'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("ReportHistorySearchVW",ReportHistorySearchVW.class);
				setFetchPoint(q, start, count);
				List<ReportHistorySearchVWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<ReportHistorySearchVWInfo>) execute(action);
	}


	public int findReportHistoryCount(final RegulatoryReportInstanceSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select count(1) from(");
				query.append( session.getNamedQuery("ReportHistorySearch.searchprocess").getQueryString());
				query.append(" and pr.prclosetime > ' '");
				if(StringUtils.isNotEmpty(cond.getPrtype())){
					query.append(" and pr.prtype='"+cond.getPrtype()+"'");
				}else{
					query.append(" and pr.prtype in('WD1','WD2','WD3')");
				}
				if(StringUtils.isNotEmpty(cond.getPrtitle())){
					query.append(" and pr.prtitle like '%"+cond.getPrtitle()+"%'");
				}
				if(StringUtils.isNotEmpty(cond.getPropentime())){
					query.append(" and pr.propentime >='"+cond.getPropentime()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getProclosetime())){
					query.append(" and pr.propentime <='"+cond.getProclosetime()+"'");
				}
	            query.append(")temp5");  
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				session.close();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	
	}

	//删除无效的填报实例
	public static String SQL = "delete from regulatoryreportinstance a " +
			"where not exists (select b.prid from regulatoryreportdetail b " +
			"where a.instanceid = b.instanceid)";
	
	/**
	 * 删除无效填报实例
	 * 当流程均停用后，报表流程会被删除
	 * 但实例还在且无效
	 */
	public void deleteTestInstance() throws BLException {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer(SQL);
				SQLQuery q = session.createSQLQuery(query.toString());
				int i = q.executeUpdate();
				session.clear();
				session.close();
				return i;
			}
		};
		execute(action);
	}


	@SuppressWarnings("unchecked")
	public List<AnnualReportVWInfo> lookatFillIn(
			final RegulatoryReportInstanceSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("AnnualReportQuireVWDAO.LookFillIn").getQueryString());
				if(StringUtils.isNotEmpty(cond.getPrtype())){
					query.append(" and a.prtype ='"+cond.getPrtype()+"'");
				}
				//流程类型查询
				if(StringUtils.isNotEmpty(cond.getPrpdid_like())){
					query.append(" and c.prpdid like'"+cond.getPrpdid_like()+"%'");
				}
				//状态查询
				if(StringUtils.isNotEmpty(cond.getPrstatus())){
					query.append(" and c.prstatus = '"+cond.getPrstatus()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getPsdname())){
					query.append(" and e.psdname ='"+cond.getPsdname()+"'");
				}
				//组标识
				if( StringUtils.isNotEmpty(cond.getKey_eq())){
					query.append(" and a.key ='"+cond.getKey_eq()+"'");
				}
				//季度查询
				if( StringUtils.isNotEmpty(cond.getQuarter())){
					query.append(" and a.quarter ='"+cond.getQuarter()+"'");
				}
				//季度查询
				if( StringUtils.isNotEmpty(cond.getYear())){
					query.append(" and a.year ='"+cond.getYear()+"'");
				}
				//季度查询
				if( StringUtils.isNotEmpty(cond.getYear_GtEq())){
					query.append(" and a.year >='"+cond.getYear_GtEq()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getPropentime())){
					query.append(" and a.inittime >='"+cond.getPropentime()+" 00:00'");
				}
				if(StringUtils.isNotEmpty(cond.getProclosetime())){
					query.append(" and a.inittime <='"+cond.getProclosetime()+" 23:59'");
				}
				if(StringUtils.isNotEmpty(cond.getOrderby_quarter())){
					query.append(" order by ").append(cond.getOrderby_quarter());
				}else{
					query.append(" order by c.prpdname");
				}
				
				if(StringUtils.isNotEmpty(cond.getOrderby())){
					query.append(" desc");
				}
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("AnnualReportVW",AnnualReportVW.class);
				List<AnnualReportVWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<AnnualReportVWInfo>) execute(action);

	}
}