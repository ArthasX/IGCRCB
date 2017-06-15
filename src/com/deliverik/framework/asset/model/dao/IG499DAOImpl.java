/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

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

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG499SearchCond;
import com.deliverik.framework.asset.model.entity.IG499VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * 概述: 合同资产信息视图DAO实现
  * 功能描述: 合同资产信息视图DAO实现
  * 创建记录: 2012/04/10
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG499DAOImpl extends
		BaseHibernateDAOImpl<IG499Info> implements IG499DAO {

	/**
	 * 构造函数
	 */
	public IG499DAOImpl(){
		super(IG499VW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG499Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG499Info findByPK(Serializable pk) {
		IG499Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG499SearchCond cond){
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
	@SuppressWarnings("unchecked")
	public List<IG499Info> findByCond(final IG499SearchCond cond, final int start, final int count){
		final String payed = cond.getPayed();
		if("0".equals(payed)||"1".equals(payed)){//0:付款未完毕  1：付款完毕
			HibernateCallback action = new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();

					StringBuffer query = new StringBuffer();
					
					if("0".equals(payed)){
						query.append(session.getNamedQuery("IG499DAO.searchImprestByCond1").getQueryString());
						getSQL(cond, query);
						query.append(session.getNamedQuery("IG499DAO.searchImprestByCondEnd").getQueryString());
						//System.out.println("付款未完毕SQL："+query.toString());
					}
					if("1".equals(payed)){
						query.append(session.getNamedQuery("IG499DAO.searchImprestByCond2").getQueryString());
						getSQL(cond, query);
						//System.out.println("付款已完毕SQL："+query.toString());
					}
					query.append(" ORDER BY EILABEL DESC");
					
					SQLQuery q = session.createSQLQuery(query.toString());
					
					q.addEntity("ei",IG499VW.class);

					setFetchPoint(q, start, count);
					
					List<IG499Info> list = q.list();
					
					session.clear();
					session.close();
					
					return list;
				}
			};
			return (List<IG499Info>) execute(action);
		}
		
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("eilabel"));
		return findByCriteria(c, start, count);
	}
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchImprestCount(final IG499SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("IG499DAO.getSearchImprestCountStart").getQueryString());
				
				getSQL(cond, query);
				
				query.append(session.getNamedQuery("IG499DAO.findImprestByCondEnd").getQueryString());
				
				query.append(" ) uu ORDER BY EILABEL DESC");
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.setProperties(cond);

				session.clear();
				session.close();
				return getCount(q.list());
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
	public List<IG499Info> findImprestByCond(final IG499SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append(session.getNamedQuery("IG499DAO.findImprestByCondStart").getQueryString());
				
				
				getSQL(cond, query);
				
				query.append(session.getNamedQuery("IG499DAO.findImprestByCondEnd").getQueryString());
				
				query.append(" order by eilabel desc");
				
				//System.out.println("当前SQL："+query.toString());
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ei",IG499VW.class);
				
				q.setProperties(cond);
				
				setFetchPoint(q, start, count);
				
				List<IG688Info> list = q.list();
				
				session.clear();
				session.close();
				
				return list;
			}
		};
		return (List<IG499Info>) execute(action);
	}

	/**
	 * 检索条件生成
	 * @param cond
	 * @param query
	 */
	protected void getSQL(IG499SearchCond cond, StringBuffer query) {
		query.append(" ");
		//合同类别
		if(StringUtils.isNotEmpty(cond.getCompacttype())){
			query.append(" and u.compacttype='"+cond.getCompacttype()+"' ");
		}
		//合同名称
		if(StringUtils.isNotEmpty(cond.getEiname())){
			query.append(" and u.einame like '%"+cond.getEiname()+"%' ");
		}
		//服务商
		if(StringUtils.isNotEmpty(cond.getFacilitator())){
			query.append(" and u.facilitator like '%"+cond.getFacilitator()+"%' ");
		}
		//查询时间点
		if(StringUtils.isNotEmpty(cond.getDatetime())){
			query.append(" and u.expectday <='"+cond.getDatetime()+"' ");
		}
		//合同编号
		if(StringUtils.isNotEmpty(cond.getEilabel())){
			query.append(" and u.eilabel like '%"+cond.getEilabel()+"%' ");
		}
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG499SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//合同类别
		if(StringUtils.isNotEmpty(cond.getCompacttype())){
			c.add(Expression.eq("compacttype", cond.getCompacttype()));
		}
		//服务商
		if(StringUtils.isNotEmpty(cond.getFacilitator())){
			c.add(Expression.like("facilitator", "%"+cond.getFacilitator()+"%"));
		}
		//经手人
		if(StringUtils.isNotEmpty(cond.getOperator())){
			c.add(Expression.like("operator", "%"+cond.getOperator()+"%"));
		}
		//合同名称
		if(StringUtils.isNotEmpty(cond.getEiname())){
			c.add(Expression.like("einame", "%"+cond.getEiname()+"%"));
		}
		//合同编号
		if(StringUtils.isNotEmpty(cond.getEilabel())){
			c.add(Expression.like("eilabel", "%"+cond.getEilabel()+"%"));
		}
		//签订时间
		if(StringUtils.isNotEmpty(cond.getCondudetime_from())){
			c.add(Expression.ge("condudetime", cond.getCondudetime_from()));
		}
		if(StringUtils.isNotEmpty(cond.getCondudetime_to())){
			c.add(Expression.le("condudetime", cond.getCondudetime_to()));
		}
		if(StringUtils.isNotEmpty(cond.getEiid())){
			c.add(Expression.eq("eiid", Integer.parseInt(cond.getEiid())));
		}
		if(StringUtils.isNotEmpty(cond.getEiusername())){
			c.add(Expression.like("eiusername", "%"+cond.getEiusername()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getEiorgsyscoding_in())){
			c.add(Expression.sql(" eiorgsyscoding in ('"+cond.getEiorgsyscoding_in()+"')"));
		}
		return c;
	}

}