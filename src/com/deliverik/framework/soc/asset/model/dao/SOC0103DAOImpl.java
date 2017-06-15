/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.SOC0137Info;
import com.deliverik.framework.soc.asset.SOC0137TB;
import com.deliverik.framework.soc.asset.model.SOC0103Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0103SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0103TB;

/**
  * 概述: 审计对比结果信息表DAO实现
  * 功能描述: 审计对比结果信息表DAO实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class SOC0103DAOImpl extends
		BaseHibernateDAOImpl<SOC0103Info> implements SOC0103DAO {

	/**
	 * 构造函数
	 */
	public SOC0103DAOImpl(){
		super(SOC0103TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0103Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0103Info findByPK(Serializable pk) {
		SOC0103Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0103SearchCond cond){
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
	public List<SOC0103Info> findByCond(final SOC0103SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eiid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 更新当前数据为不合理
	 *
	 * @param cond 检索条件
	 */
	public Integer updateSOC0103Without(final SOC0103SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("AuditResultDAO.updateAuditResultWithout").getQueryString());
				
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ar",SOC0103TB.class);

				q.setProperties(cond);
				
				int i = q.executeUpdate();
				
				session.clear();
				
				return Integer.valueOf(i);
			}
				
		};
		return  (Integer) execute(action);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0137Info> findByCondOne(final SOC0103SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("AuditResultDAO.findByCondOne").getQueryString());
				
				getSQL(cond, query);
				
				query.append(" group by ar.autid,ar.eiid,ar.eiversion," +
						"ar.eismallversion,ar.einame,ar.aucmptype,ar.esyscoding,ar.auflag,ar.autime");
				query.append(" order by ar.eiid asc");
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setProperties(cond);

				q.addEntity("ar",SOC0137TB.class);

				List<SOC0137TB> list = q.list();
				
				session.clear();
				
				return list;
			}
				
		};
		return  (List<SOC0137Info>) execute(action);
	}
	

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0103SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// 资产模型
		if (StringUtils.isNotEmpty(cond.getEsyscoding())) {
			c.add(Expression.like("esyscoding", cond.getEsyscoding() + '%'));
		}
		
		// 审计任务ID
		if (cond.getAutid() != null && cond.getAutid() != 0){
			c.add(Expression.eq("autid", cond.getAutid()));
		}
		
		//资产eiid
		if(cond.getEiid()!=null&&cond.getEiid()!=0){
			c.add(Expression.eq("eiid", cond.getEiid()));
		}
		
		return c;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(SOC0103SearchCond cond, StringBuffer query){
		
		// 资产模型
		if( !StringUtils.isEmpty(cond.getEsyscoding())){
			query.append(" AND ar.esyscoding like (:esyscoding || '%')");
		}
		
		// 审计任务ID
		if (cond.getAutid() != null && cond.getAutid() != 0){
			query.append(" AND ar.autid = " + cond.getAutid());
		}
		
	}
		

}