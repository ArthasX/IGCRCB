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
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0127Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0127SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0110TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0127VW;

/**
  * 概述: 配置所属关系表DAO实现
  * 功能描述: 配置所属关系表DAO实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class SOC0110DAOImpl extends
		BaseHibernateDAOImpl<SOC0110Info> implements SOC0110DAO {

	/**
	 * 构造函数
	 */
	public SOC0110DAOImpl(){
		super(SOC0110TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0110Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0110Info findByPK(Serializable pk) {
		SOC0110Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0110SearchCond cond){
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
	public List<SOC0110Info> findByCond(final SOC0110SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0110SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//源资产ID
		if (StringUtils.isNotEmpty(cond.getBrpareiid())) {
			c.add(Expression.eq("brpareiid", Integer.parseInt(cond.getBrpareiid())));
		}
		//源资产大版本
		if (StringUtils.isNotEmpty(cond.getBrparversion())) {
			c.add(Expression.eq("brparversion", Integer.parseInt(cond.getBrparversion())));
		}
		//源资产小版本
		if (StringUtils.isNotEmpty(cond.getBrparsmallversion())) {
			c.add(Expression.eq("brparsmallversion", Integer.parseInt(cond.getBrparsmallversion())));
		}
		//目的资产ID
		if (StringUtils.isNotEmpty(cond.getBrcldeiid())) {
			c.add(Expression.eq("brcldeiid", Integer.parseInt(cond.getBrcldeiid())));
		}
		//目的资产大版本
		if (StringUtils.isNotEmpty(cond.getBrcldversion())) {
			c.add(Expression.eq("brcldversion", Integer.parseInt(cond.getBrcldversion())));
		}
		//目的资产小版本
		if (StringUtils.isNotEmpty(cond.getBrcldsmallversion())) {
			c.add(Expression.eq("brcldsmallversion", Integer.parseInt(cond.getBrcldsmallversion())));
		}
		//删除标志
		if (StringUtils.isNotEmpty(cond.getDeleteflag())) {
			c.add(Expression.eq("deleteflag", cond.getDeleteflag()));
		}
		//资产所属树根节点实体标识
		if (StringUtils.isNotEmpty(cond.getEirootmark())) {
			c.add(Expression.eq("eirootmark", Integer.parseInt(cond.getEirootmark())));
		}
		//资产关系码
		if (StringUtils.isNotEmpty(cond.getBrassetrelation())) {
			c.add(Expression.eq("brassetrelation", cond.getBrassetrelation()));
		}
		
		if (StringUtils.isNotEmpty(cond.getBrassetrelation_not())) {
			c.add(Expression.sql("brassetrelation!='"+cond.getBrassetrelation_not()+"'"));
		}
		
		return c;
	}
	
	/**
	 * 配置包含最大版本关系检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0127Info> searchEiBelongRelationVW(final SOC0127SearchCond cond) {
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<SOC0118Info> list = null;
				query.append(session.getNamedQuery("SOC0110DAO.searchEiBelongRelationVW").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(SOC0127VW.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0127Info>) execute(action);
	}
	
	/**
	 * 配置包含最大版本关系检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0127Info> searchEiBelongRelationVW2(final SOC0127SearchCond cond) {
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<SOC0118Info> list = null;
				query.append(session.getNamedQuery("SOC0110DAO.searchEiBelongRelationVW2").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(SOC0127VW.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0127Info>) execute(action);
	}
	
	/**
	 * 配置包含关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0110Info> searchMaxEiBelongRelation(final SOC0110SearchCond cond) {
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<SOC0118Info> list = null;
				query.append(session.getNamedQuery("SOC0110DAO.searchMaxEiBelongRelationVW1").getQueryString());
				if(StringUtils.isNotEmpty(cond.getBrpareiid())) {
					if (StringUtils.isNotEmpty(cond.getEirootmark())) {
						query.append(" AND eirootmark = "+cond.getEirootmark());
					}
					query.append(" AND brpareiid = "+cond.getBrpareiid());
					query.append(" AND brparversion = "+cond.getBrparversion());
					query.append(" AND brparsmallversion = "+cond.getBrparsmallversion());
				} else if(StringUtils.isNotEmpty(cond.getBrcldeiid())) {
					if (StringUtils.isNotEmpty(cond.getEirootmark())) {
						query.append(" AND eirootmark = "+cond.getEirootmark());
					}
					query.append(" AND brcldeiid = "+cond.getBrcldeiid());
					query.append(" AND brcldversion = "+cond.getBrcldversion());
					query.append(" AND brcldsmallversion = "+cond.getBrcldsmallversion());
				}
				if(StringUtils.isNotEmpty(cond.getBrassetrelation())){
					query.append(" and brassetrelation ='"+cond.getBrassetrelation()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getBrassetrelation_in())){
					query.append(" AND brassetrelation in ("+cond.getBrassetrelation_in()+")");
				}
				query.append(session.getNamedQuery("SOC0110DAO.searchMaxEiBelongRelationVW2").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(SOC0110TB.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0110Info>) execute(action);
	}
	
	/**
	 * 根据父查询所有存在的关系码
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchBrassetrelationByBrpareiid(final SOC0110SearchCond cond) {
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<SOC0118Info> list = null;
				query.append("select brassetrelation from SOC0110 where 1=1 ");
				query.append(" AND brpareiid = "+cond.getBrpareiid());
				query.append(" AND brparversion = "+cond.getBrparversion());
				query.append(" AND brparsmallversion = "+cond.getBrparsmallversion());
				if(StringUtils.isNotEmpty(cond.getBrassetrelation_in())){
					query.append(" AND brassetrelation in ("+cond.getBrassetrelation_in()+")");
				}
				query.append(" GROUP BY brassetrelation ");
				query.append(" ORDER BY brassetrelation "); 
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<String>) execute(action);
	}

	/**
	 * 根据顶级设备查询该类型码数据
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0110Info> searchInBrassetrelationByEirootmark(final SOC0110SearchCondImpl cond){
		HibernateCallback action = new HibernateCallback()
		
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<SOC0110Info> list = null;
				query.append("select * from SOC0110 where 1=1 ");
				query.append(" AND brassetrelation in ("+cond.getBrassetrelation_in()+")");
				query.append(" AND eirootmark = "+cond.getEirootmark());
				query.append(" AND brparversion = "+cond.getBrparversion());
				query.append(" AND brparsmallversion = "+cond.getBrparsmallversion());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(SOC0110TB.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0110Info>) execute(action);
	}

	public void delByEiid(Integer eiid) {
		String sql = "delete from soc0110 where brpareiid = :eiid or brcldeiid = :eiid";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameter("eiid", eiid);
		q.executeUpdate();
	}
}