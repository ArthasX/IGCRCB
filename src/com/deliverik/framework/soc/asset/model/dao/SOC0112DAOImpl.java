/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0112SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0112TB;

/**
  * 概述: 资产域明细表DAO实现
  * 功能描述: 资产域明细表DAO实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class SOC0112DAOImpl extends
		BaseHibernateDAOImpl<SOC0112Info> implements SOC0112DAO {

	/**
	 * 构造函数
	 */
	public SOC0112DAOImpl(){
		super(SOC0112TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0112Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0112Info findByPK(Serializable pk) {
		SOC0112Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0112SearchCond cond){
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
	public List<SOC0112Info> findByCond(final SOC0112SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
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
	public List<SOC0112Info> findBySQL(final SOC0112SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){

			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				StringBuffer query  = new StringBuffer();
				query.append(session.getNamedQuery("EiDomainDetailDAO.findBySQL").getQueryString());
				getSQL(cond, query);				
				SQLQuery q = session.createSQLQuery(query.toString());	
				q.addEntity("ei",SOC0112TB.class);
				List<SOC0112TB> list = q.list();
				return list;
			}		
		};
		return (List<SOC0112Info>)execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0112SearchCond cond){
		
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getEiddid()!=null && cond.getEiddid()!=0){			
			c.add(Expression.eq("eiddid", cond.getEiddid()));
		}
	    if(cond.getEiddversion()!=null){
	    	c.add(Expression.eq("eiddversion", cond.getEiddversion()));			
		}
	    if(cond.getDeleteflag()!=null){
	    	c.add(Expression.eq("deleteflag", cond.getDeleteflag()));			
		}
		return c;
	}
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(SOC0112SearchCond cond, StringBuffer query){
		
		if(cond.getEiddid()!=null && cond.getEiddid()!=0){			
			query.append(" and ei.eiddid = "+cond.getEiddid());
		}
	    if(cond.getEiddversion()!=null){
	    	query.append(" and ei.eiddversion = "+cond.getEiddversion());		
		}
	    if(cond.getDeleteflag()!=null){
	    	query.append(" and ei.deleteflag = '"+cond.getDeleteflag()+"'");			
		}
	}

}