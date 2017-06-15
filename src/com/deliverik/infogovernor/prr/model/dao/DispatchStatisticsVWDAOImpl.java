/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model.dao;

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
import com.deliverik.infogovernor.prr.model.DispatchStatisticsVWInfo;
import com.deliverik.infogovernor.prr.model.condition.DispatchStatisticsVWSearchCond;
import com.deliverik.infogovernor.prr.model.entity.DispatchStatisticsVW;

/**
  * 概述: 发文流程统计DAO实现
  * 功能描述: 发文流程统计DAO实现
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
public class DispatchStatisticsVWDAOImpl extends
		BaseHibernateDAOImpl<DispatchStatisticsVWInfo> implements DispatchStatisticsVWDAO {

	/**
	 * 构造函数
	 */
	public DispatchStatisticsVWDAOImpl(){
		super(DispatchStatisticsVW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<DispatchStatisticsVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public DispatchStatisticsVWInfo findByPK(Serializable pk) {
		DispatchStatisticsVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DispatchStatisticsVWSearchCond cond){
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
	public List<DispatchStatisticsVWInfo> findByCond(final DispatchStatisticsVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(DispatchStatisticsVWSearchCond cond){
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
	public List<DispatchStatisticsVWInfo> findDispatchStatistics(
			final DispatchStatisticsVWSearchCond cond, final int start,final int count) {
			 HibernateCallback action = new HibernateCallback() {
		           public Object doInHibernate(Session session) throws HibernateException, SQLException {
		               session.flush();
		               StringBuffer query = new StringBuffer();
		               query.append( session.getNamedQuery("DispatchStatisticsVWDAO.findDispatchStatistics1").getQueryString());
		       		   //用户名
		       		   if(StringUtils.isNotEmpty(cond.getDsusername())){
		       			    query.append(" and ds.ppusername like '%"+cond.getDsusername()+"%'");
		       		   }
		       		   //查询条件开始时间
		       		   if(StringUtils.isNotEmpty(cond.getPropentime_from()) ){
		       			    query.append(" and ds.propentime > '"+cond.getPropentime_from()+"'");
		       		    }
		       		   //查询条件结束时间
		       		   if(StringUtils.isNotEmpty(cond.getPropentime_to()) ){
		       			    query.append(" and ds.propentime < '"+cond.getPropentime_to()+"'");
		       		    }
		       		   query.append(" )da GROUP BY dsuserid,dsusername");
		               SQLQuery q = session.createSQLQuery(query.toString());
		               q.addEntity("DispatchStatisticsVW",DispatchStatisticsVW.class);
		               setFetchPoint(q, start, count);
		               List<DispatchStatisticsVWInfo> list = q.list();
		               session.clear();
		               return list;
		           }
		       };
			return (List<DispatchStatisticsVWInfo>) execute(action);
		}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	public int findDispatchStatisticsSearchCount(
			final DispatchStatisticsVWSearchCond cond) {
			 HibernateCallback action = new HibernateCallback() {
		           public Object doInHibernate(Session session) throws HibernateException, SQLException {
		               session.flush();
		               StringBuffer query = new StringBuffer();
		               query.append("select count(*) from (");
		               query.append( session.getNamedQuery("DispatchStatisticsVWDAO.findDispatchStatistics1").getQueryString());
		       		   //用户名
		       		   if(StringUtils.isNotEmpty(cond.getDsusername())){
		       			    query.append(" and ds.ppusername like '%"+cond.getDsusername()+"%'");
		       		   }
		       		   //查询条件开始时间
		       		   if(StringUtils.isNotEmpty(cond.getPropentime_from()) ){
		       			    query.append(" and ds.propentime > '"+cond.getPropentime_from()+"'");
		       		    }
		       		   //查询条件结束时间
		       		   if(StringUtils.isNotEmpty(cond.getPropentime_to()) ){
		       			    query.append(" and ds.propentime < '"+cond.getPropentime_to()+"'");
		       		    }
		       		   query.append(" )da GROUP BY dsuserid,dsusername)");
		               SQLQuery q = session.createSQLQuery(query.toString());		               
		               q.setProperties(cond);
		               session.clear();
		               return getCount(q.list());
		           }
		       };
		       return (Integer) execute(action);
		}

}