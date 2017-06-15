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
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;
import com.deliverik.infogovernor.prr.model.condition.CopyReadUserSearchCond;
import com.deliverik.infogovernor.prr.model.entity.CopyReadUserTB;

/**
  * 概述: 抄阅人表DAO实现
  * 功能描述: 抄阅人表DAO实现
  * 创建记录: 2013/02/25
  * 修改记录: 
  */
public class CopyReadUserDAOImpl extends
		BaseHibernateDAOImpl<CopyReadUserInfo> implements CopyReadUserDAO {

	/**
	 * 构造函数
	 */
	public CopyReadUserDAOImpl(){
		super(CopyReadUserTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CopyReadUserInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CopyReadUserInfo findByPK(Serializable pk) {
		CopyReadUserInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CopyReadUserSearchCond cond){
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
	public List<CopyReadUserInfo> findByCond(final CopyReadUserSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CopyReadUserSearchCond cond){
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
	public List<CopyReadUserInfo> getCopyReadUserInfo(
			final CopyReadUserSearchCond cond, final int start,final int count) {
			 HibernateCallback action = new HibernateCallback() {
		           public Object doInHibernate(Session session) throws HibernateException, SQLException {
		               session.flush();
		               StringBuffer query = new StringBuffer();
		               query.append( session.getNamedQuery("CopyReadUserDAO.getCopyReadUserInfo").getQueryString());
		               //处理人id
		       		   if(StringUtils.isNotEmpty(cond.getPruserid()) ){
		       			    query.append(" and cru.pruserid='"+cond.getPruserid()+"'");
		       		    }
		       		   //流程名称
		       		   if(StringUtils.isNotEmpty(cond.getPrtitle())){
		       			    query.append(" and cru.prtitle like '%"+cond.getPrtitle()+"%'");
		       		   }
		       		   //是否已查看
		       		   if(StringUtils.isNotEmpty(cond.getIslook())){
		       			    query.append(" and cru.islook='"+cond.getIslook()+"'");
		       		   }
		       		   //流程主键
		       		   if(cond.getPrid()!=null){
		       			    query.append(" and cru.prid="+cond.getPrid());
		       		   }
		       		   query.append(" order by cru.prstarttime");
		               SQLQuery q = session.createSQLQuery(query.toString());
		               q.addEntity("CopyReadUserTB",CopyReadUserTB.class);
		               setFetchPoint(q, start, count);
//		               System.out.println(query.toString());
		               List<CopyReadUserInfo> list = q.list();
		               session.clear();
		               return list;
		           }
		       };
			return (List<CopyReadUserInfo>) execute(action);
		}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	@SuppressWarnings("unchecked")
	public List<CopyReadUserInfo> getCopyReadUserInfoDesc(
			final CopyReadUserSearchCond cond, final int start,final int count) {
			 HibernateCallback action = new HibernateCallback() {
		           public Object doInHibernate(Session session) throws HibernateException, SQLException {
		               session.flush();
		               StringBuffer query = new StringBuffer();
		               query.append( session.getNamedQuery("CopyReadUserDAO.getCopyReadUserInfo").getQueryString());
		               //处理人id
		       		   if(StringUtils.isNotEmpty(cond.getPruserid()) ){
		       			    query.append(" and cru.pruserid='"+cond.getPruserid()+"'");
		       		    }
		       		   //流程名称
		       		   if(StringUtils.isNotEmpty(cond.getPrtitle())){
		       			    query.append(" and cru.prtitle like '%"+cond.getPrtitle()+"%'");
		       		   }
		       		   //是否已查看
		       		   if(StringUtils.isNotEmpty(cond.getIslook())){
		       			    query.append(" and cru.islook='"+cond.getIslook()+"'");
		       		   }
		       		   //流程主键
		       		   if(cond.getPrid()!=null){
		       			    query.append(" and cru.prid="+cond.getPrid());
		       		   }
		       		   query.append(" order by cru.prstarttime desc");
		               SQLQuery q = session.createSQLQuery(query.toString());
		               q.addEntity("CopyReadUserTB",CopyReadUserTB.class);
		               setFetchPoint(q, start, count);
//		               System.out.println(query.toString());
		               List<CopyReadUserInfo> list = q.list();
		               session.clear();
		               return list;
		           }
		       };
			return (List<CopyReadUserInfo>) execute(action);
		}
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public int getCopyReadUserCount( final CopyReadUserSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				query.append("select count(*) from(");
				query.append( session.getNamedQuery("CopyReadUserDAO.getCopyReadUserInfo").getQueryString());												
				//处理人id
	       		   if(StringUtils.isNotEmpty(cond.getPruserid()) ){
	       			    query.append(" and cru.pruserid='"+cond.getPruserid()+"'");
	       		    }
	       		   //流程名称
	       		   if(StringUtils.isNotEmpty(cond.getPrtitle())){
	       			    query.append(" and cru.prtitle like '%"+cond.getPrtitle()+"%'");
	       		   }
	       		   //是否已查看
	       		   if(StringUtils.isNotEmpty(cond.getIslook())){
	       			    query.append(" and cru.islook='"+cond.getIslook()+"'");
	       		   }
	       		 //流程主键
	       		   if(cond.getPrid()!=null){
	       			    query.append(" and cru.prid="+cond.getPrid());
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
}