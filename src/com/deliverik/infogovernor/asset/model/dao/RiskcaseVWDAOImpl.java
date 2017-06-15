/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.dao;

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
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskcaseVWTB;

/**
  * 概述: 风险事件DAO实现
  * 功能描述: 风险事件DAO实现
  * 创建记录: 2014/07/18
  * 修改记录: 
  */

public class RiskcaseVWDAOImpl extends
		BaseHibernateDAOImpl<RiskcaseVWInfo> implements RiskcaseVWDAO {

	/**
	 * 构造函数
	 */
	public RiskcaseVWDAOImpl(){
		super(RiskcaseVWTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskcaseVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskcaseVWInfo findByPK(Serializable pk) {
		RiskcaseVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskcaseVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("RiskcaseVWDAO.getSearchCount").getQueryString());
				query.append(" where 1=1 ");
				query = getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				Integer count = getCount(q.list());
				session.clear();
				return count;
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<RiskcaseVWInfo> findByCond(final RiskcaseVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("RiskcaseVWDAO.SearchRiskcaseVW").getQueryString());
				
				query.append(" where 1=1 ");
				
				query = getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("RCTB",RiskcaseVWTB.class);

				setFetchPoint(q, start, count);

				List<RiskcaseVWInfo> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<RiskcaseVWInfo>) execute(action);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<RiskcaseVWInfo> findByCondByVersion(final RiskcaseVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("RiskcaseVWDAO.SearchRiskcaseByVersion").getQueryString());
				
				query.append(" where 1=1 ");
				
				query = getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("RCTB",RiskcaseVWTB.class);


				List<RiskcaseVWInfo> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<RiskcaseVWInfo>) execute(action);
	}
	
	/**
	 * 风险事件应对策略查询
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<RiskcaseVWInfo> findByCond(final RiskcaseVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("RiskcaseVWDAO.SearchRiskPolicys").getQueryString());
				
				query.append(" where 1=1 ");
				
				query = getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("RCTB",RiskcaseVWTB.class);

				List<RiskcaseVWInfo> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<RiskcaseVWInfo>) execute(action);
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskcaseVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @param query sql
	 * @return 检索用检索条件类
	 */
	protected StringBuffer getSQL(RiskcaseVWSearchCond cond, StringBuffer query){
		//查询最新版本
		if("0".equals(cond.getVersion())){
			
		}else{//查询历史版本
			query = new StringBuffer(query.toString().replaceAll("REP_VERSION",  "and CIVERSION = '"+cond.getVersion()+"'"));
		}
		//风险事件ID
		if( cond.getEiid()!=null){
			query.append(" AND a.EIID = "+cond.getEiid());
		}
		//风险事件名称
		if(!StringUtils.isEmpty(cond.getFcname())){
			query.append(" AND fcname like '%"+cond.getFcname()+"%'");
		}
		//风险事件来源
		if(!StringUtils.isEmpty(cond.getFcorigin())){
			query.append(" AND fcorigin = '"+cond.getFcorigin()+"'");
		}
		//风险事件所属领域
		if(!StringUtils.isEmpty(cond.getFccategory())){
			query.append(" AND fccategory = '"+cond.getFccategory()+"'");
		}
		//风险事件识别时间从
		if(!StringUtils.isEmpty(cond.getRiskcatchtime_from())){
			query.append(" AND riskcatchtime >= '"+cond.getRiskcatchtime_from()+"'");
		}
		//风险事件识别时间到
		if(!StringUtils.isEmpty(cond.getRiskcatchtime_to())){
			query.append(" AND riskcatchtime <= '"+cond.getRiskcatchtime_to()+"'");
		}
		//风险点ID
		if(!StringUtils.isEmpty(cond.getRiskid())){
			query.append(" AND riskid = '"+cond.getRiskid()+"'");
		}
		//风险事件应对策略
		if(!StringUtils.isEmpty(cond.getFcpolicy())){
			query.append(" AND fcpolicy = '"+cond.getFcpolicy()+"'");
		}
		//风险事件评审结果
		if(!StringUtils.isEmpty(cond.getRiskreviewresult())){
			query.append(" AND riskreviewresult = '"+cond.getRiskreviewresult()+"'");
		}
		if(StringUtils.isNotEmpty(cond.getEISTATUS())){
			query.append(" AND EISTATUS = '"+cond.getEISTATUS()+"'");
		}
		return query;
	}

}