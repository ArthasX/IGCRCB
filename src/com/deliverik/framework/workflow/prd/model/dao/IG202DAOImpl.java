/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

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
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG202TB;

/**
 * <p>概述:流程共通变量DAO实现</p>
 * <p>功能描述：1.全件检索</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.条件检索记录数</p>
 * <p>          4.条件检索处理</p>
 * <p>          5.检索条件生成</p>
 * <p>          6.条件检索结果件数取得</p>
 * <p>          7.检索条件生成（全部结果）</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("deprecation")
public class IG202DAOImpl extends BaseHibernateDAOImpl<IG202Info> implements IG202DAO{

	/**
	 * 功能：构造函数
	 */
	public IG202DAOImpl(){
		super(IG202TB.class);
	}
	
	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG202Info> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("pidid"));
		List<IG202Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 功能：主键检索处理
	 * @param pdaid 主键
	 * @return 检索结果
	 */
	public IG202Info findByPK(Serializable pidid){
		
		IG202Info processInfoDefGeneral = super.findByPK(pidid);
		
		if(processInfoDefGeneral == null) return null;

		return processInfoDefGeneral;
	}
	

	/**
	 * 功能：条件检索记录数
	 * @return 条件检索记录数
	 */
	public int searchIG202InfoCount(final IG202SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG202DAO.searchIG202Count").getQueryString());

				getSQL(cond, query);
				
				query.append(" )");
				
				SQLQuery q = session.createSQLQuery(query.toString());

				//q.setProperties(cond);
				
				session.clear();

				return getCount(q.list());

			}
		};
		return (Integer) execute(action);
	}
	
	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG202Info> searchIG202Info(final IG202SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG202DAO.searchIG202").getQueryString());
				
				getSQL(cond, query);
				
				query.append(" ) ORDER BY pg.pidid desc");
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("pg",IG202TB.class);

				//q.setProperties(cond);
				
				setFetchPoint(q, start, count);

				
				List<IG202Info> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<IG202Info>) execute(action);
	}
	
	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(IG202SearchCond cond, StringBuffer query){
		if(StringUtils.isNotEmpty(cond.getPdid())){
			query.append(" And pdid = ").append(cond.getPdid());
		}
		
		
	}
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG202SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG202Info> findByCond(final IG202SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		List<IG202Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG202SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();		
		if (cond.getPidid_notlike() != null && cond.getPidid_notlike() > 0) {
			c.add(Expression.ne("pidid", cond.getPidid_notlike()));
		}
		if (!StringUtils.isEmpty(cond.getPidlabel())) {
			c.add(Expression.eq("pidlabel", cond.getPidlabel()));
		}
		return c;
	}
	
}
