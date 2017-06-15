/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sta.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.prr.model.entity.DispatchStatisticsVW;
import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;
import com.deliverik.infogovernor.sta.model.condition.RiskCheckProblemSuperviseVWSearchCond;
import com.deliverik.infogovernor.sta.model.entity.RiskCheckProblemSuperviseVW;

/**
  * 概述: 问题整改监督DAO实现
  * 功能描述: 问题整改监督DAO实现
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
public class RiskCheckProblemSuperviseVWDAOImpl extends
		BaseHibernateDAOImpl<RiskCheckProblemSuperviseVWInfo> implements RiskCheckProblemSuperviseVWDAO {

	/**
	 * 构造函数
	 */
	public RiskCheckProblemSuperviseVWDAOImpl(){
		super(DispatchStatisticsVW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskCheckProblemSuperviseVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskCheckProblemSuperviseVWInfo findByPK(Serializable pk) {
		RiskCheckProblemSuperviseVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskCheckProblemSuperviseVWSearchCond cond){
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
	public List<RiskCheckProblemSuperviseVWInfo> findByCond(final RiskCheckProblemSuperviseVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskCheckProblemSuperviseVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	@SuppressWarnings("unchecked")
	public List<RiskCheckProblemSuperviseVWInfo> findRiskCheckProblemSupervise(
			final RiskCheckProblemSuperviseVWSearchCond cond, final int start,final int count) {
			 HibernateCallback action = new HibernateCallback() {
		           public Object doInHibernate(Session session) throws HibernateException, SQLException {
		               session.flush();
		               StringBuffer query = new StringBuffer();
		               query.append( session.getNamedQuery("RiskCheckProblemSuperviseVWDAO.searchRiskCheckProblemSupervise").getQueryString());
		               getSql(cond, query);
		               SQLQuery q = session.createSQLQuery(query.toString());
		               q.addEntity("pr",RiskCheckProblemSuperviseVW.class);
		               setFetchPoint(q, start, count);
		               List<RiskCheckProblemSuperviseVWInfo> list = q.list();
		               session.clear();
		               return list;
		           }
		       };
			return (List<RiskCheckProblemSuperviseVWInfo>) execute(action);
		}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	public int findRiskCheckProblemSuperviseSearchCount(final RiskCheckProblemSuperviseVWSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("RiskCheckProblemSuperviseVWDAO.getCount").getQueryString());
				getSql(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}

	private void getSql(RiskCheckProblemSuperviseVWSearchCond cond, StringBuffer query){
		//问题标题
	   if(StringUtils.isNotEmpty(cond.getPrtitle())){
		    query.append(" and pr.prtitle like '%"+cond.getPrtitle()+"%'");
	   }
	   //查询条件开始时间
	   if(StringUtils.isNotEmpty(cond.getPropentime_from()) ){
		    query.append(" and pr.propentime > '"+cond.getPropentime_from()+" 00:00'");
	    }
	   //查询条件结束时间
	   if(StringUtils.isNotEmpty(cond.getPropentime_to()) ){
		    query.append(" and pr.propentime < '"+cond.getPropentime_to()+" 23:59'");
	    }
	   if(StringUtils.isNotEmpty(cond.getQuestionstatus())){
		   if("1".equals(cond.getQuestionstatus())){
		       if(StringUtils.isNotEmpty(cond.getPrstatus())){
		           query.append(" and pr.prstatus = '"+cond.getPrstatus()+"'");
		       }else{
		           query.append(" and pr.prstatus <> 'C'");
		       }
		   } else if("2".equals(cond.getQuestionstatus())){
			   query.append(" and pr.prstatus = 'C'");
		   }
	   }
	   if(StringUtils.isNotEmpty(cond.getCategory())){
	       if("1".equals(cond.getCategory())){
//	           query.append(" and pr.prpdid like '01020%'");
	           query.append(" and pr.prpdid like '01021%'");
	       } else if("2".equals(cond.getCategory())){
	           query.append(" and (pr.prpdid like '01183%' or pr.prpdid like '01206%')");
	       }
	   }else {
//	       query.append(" and (pr.prpdid like '01020%' or pr.prpdid like '01183%' or pr.prpdid like '01206%')");
	       query.append(" and (pr.prpdid like '01021%')");
	   }
	   if(StringUtils.isNotEmpty(cond.getRcclass())){
		   query.append(" and exists (select 1 from IG599 pi where pi.prid = pr.prid and pi.pivarname = '检查项类型' and pi.pivarvalue = '"+cond.getRcclass()+"')");
	   }
	   if(StringUtils.isNotEmpty(cond.getRcsourse())){
		   query.append(" and exists (select 1 from IG599 pi where pi.prid = pr.prid and pi.pivarname = '检查来源' and pi.pivarvalue = '"+cond.getRcsourse()+"')");
	   }
	}
}