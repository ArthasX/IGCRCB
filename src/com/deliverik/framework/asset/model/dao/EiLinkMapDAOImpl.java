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

import com.deliverik.framework.asset.model.EiLinkMapInfo;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCond;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.asset.model.entity.EiLinkMapTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * 概述: 实体链路图DAO实现
  * 功能描述: 实体链路图DAO实现
  * 创建记录: 2011/05/24
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class EiLinkMapDAOImpl extends
		BaseHibernateDAOImpl<EiLinkMapInfo> implements EiLinkMapDAO {

	/**
	 * 构造函数
	 */
	public EiLinkMapDAOImpl(){
		super(EiLinkMapTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiLinkMapInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("linkid"));
		c.addOrder(Order.asc("linkorder"));
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EiLinkMapInfo findByPK(Serializable pk) {
		EiLinkMapInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EiLinkMapSearchCond cond){
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
	public List<EiLinkMapInfo> findByCond(final EiLinkMapSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("linkid"));
		c.addOrder(Order.asc("linkorder"));
		return findByCriteria(c, start, count);
	}
	
	/**
	 * 拓扑图链路检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<EiLinkMapInfo> queryEiLinkMapList(final EiLinkMapSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("EiLinkMapDAO.queryEiLinkMapList").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("link",EiLinkMapTB.class);

				q.setProperties(cond);
				
				setFetchPoint(q, 0, 0);

				List<EiLinkMapInfo> list = q.list();
				
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<EiLinkMapInfo>) execute(action);
	}
	
	/**
	 * 影响CI检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> queryImpactCI(final EiLinkMapSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				
				query.append("SELECT DISTINCT A.EIID FROM EILINKMAP A");
				query.append(" INNER JOIN (SELECT LINKID FROM EILINKMAP B");
				query.append(" INNER JOIN (SELECT EIDDID, MAX(VERSION) AS VERSION FROM EIDOMAINDEF WHERE EIDDID = :domainid_eq GROUP BY EIDDID) C");
				query.append("  ON (B.DOMAINID = C.EIDDID AND B.DOMAINVERSION = C.VERSION)");
				query.append(" WHERE B.EIID = :eiid_eq AND B.LINKFLAG = '1' ) D ON(A.LINKID = D.LINKID)");
				query.append(" WHERE A.ESYSCODING like (:esyscoding_eq || '%')");
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setProperties(cond);
				
				setFetchPoint(q, 0, 0);
				
				List<Integer> list = q.list();
				
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<Integer>) execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EiLinkMapSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//域ID
		if (cond.getDomainid_eq() != null && cond.getDomainid_eq() > 0) {
			c.add(Expression.eq("domainid", cond.getDomainid_eq()));
		}
		//域版本
		if (cond.getDomainversion_eq() != null && cond.getDomainversion_eq() > 0) {
			c.add(Expression.eq("domainversion", cond.getDomainversion_eq()));
		}
		//资产ID
		if (cond.getEiid_eq() != null && cond.getEiid_eq() > 0) {
			c.add(Expression.eq("eiid", cond.getEiid_eq()));
		}
		//创建时间
		if (StringUtils.isNotEmpty(cond.getCreatetime_eq())) {
			c.add(Expression.eq("createtime", cond.getCreatetime_eq()));
		}
		//绘图标记
		if (StringUtils.isNotEmpty(cond.getLinkflag_eq())) {
			c.add(Expression.eq("linkflag", cond.getLinkflag_eq()));
		}
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<EiLinkMapInfo> searchEiLinkMapByOtherEiid(
			final EiLinkMapSearchCondImpl emCond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append("select * from eilinkmap where linkid in(select linkid from eilinkmap where linkid in(select linkid from eilinkmap where ");
				query.append("domainid=:domainid_eq and domainversion=:domainversion_eq and eiid=:eiid_eq) and eiid=:otherEiid)");
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("link",EiLinkMapTB.class);

				q.setProperties(emCond);
				
				setFetchPoint(q, 0, 0);

				List<EiLinkMapInfo> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<EiLinkMapInfo>) execute(action);
	}
}