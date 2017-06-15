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
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.EiBelongRelationInfo;
import com.deliverik.framework.asset.model.EiBelongRelationVWInfo;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.condition.EiBelongRelationSearchCond;
import com.deliverik.framework.asset.model.condition.EiBelongRelationVWSearchCond;
import com.deliverik.framework.asset.model.entity.EiBelongRelationTB;
import com.deliverik.framework.asset.model.entity.EiBelongRelationVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * 概述: 配置所属关系表DAO实现
  * 功能描述: 配置所属关系表DAO实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class EiBelongRelationDAOImpl extends
		BaseHibernateDAOImpl<EiBelongRelationInfo> implements EiBelongRelationDAO {

	/**
	 * 构造函数
	 */
	public EiBelongRelationDAOImpl(){
		super(EiBelongRelationTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiBelongRelationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EiBelongRelationInfo findByPK(Serializable pk) {
		EiBelongRelationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EiBelongRelationSearchCond cond){
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
	public List<EiBelongRelationInfo> findByCond(final EiBelongRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EiBelongRelationSearchCond cond){
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
		
		return c;
	}
	
	/**
	 * 配置包含最大版本关系检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<EiBelongRelationVWInfo> searchEiBelongRelationVW(final EiBelongRelationVWSearchCond cond) {
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<IG013Info> list = null;
				query.append(session.getNamedQuery("EiBelongRelationDAO.searchEiBelongRelationVW").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(EiBelongRelationVW.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<EiBelongRelationVWInfo>) execute(action);
	}
	
	/**
	 * 配置包含关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<EiBelongRelationInfo> searchMaxEiBelongRelation(final EiBelongRelationSearchCond cond) {
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<IG013Info> list = null;
				query.append(session.getNamedQuery("EiBelongRelationDAO.searchMaxEiBelongRelationVW1").getQueryString());
				if(StringUtils.isNotEmpty(cond.getBrpareiid())) {
					query.append(" AND brpareiid = :brpareiid ");
					query.append(" AND brparversion = :brparversion ");
					query.append(" AND brparsmallversion = :brparsmallversion ");
				} else if(StringUtils.isNotEmpty(cond.getBrcldeiid())) {
					query.append(" AND brcldeiid = :brcldeiid ");
					query.append(" AND brcldversion = :brcldversion ");
					query.append(" AND brcldsmallversion = :brcldsmallversion ");
				}
				query.append(session.getNamedQuery("EiBelongRelationDAO.searchMaxEiBelongRelationVW2").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(EiBelongRelationTB.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<EiBelongRelationInfo>) execute(action);
	}

}