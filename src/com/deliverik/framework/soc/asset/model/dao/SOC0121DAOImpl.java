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
import com.deliverik.framework.soc.asset.model.SOC0121Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0121TB;

/**
  * 概述: 快照关系表DAO实现
  * 功能描述: 快照关系表DAO实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class SOC0121DAOImpl extends
		BaseHibernateDAOImpl<SOC0121Info> implements SOC0121DAO {

	/**
	 * 构造函数
	 */
	public SOC0121DAOImpl(){
		super(SOC0121TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0121Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0121Info findByPK(Serializable pk) {
		SOC0121Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0121SearchCond cond){
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
	public List<SOC0121Info> findByCond(final SOC0121SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0121SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//域ID
		if (StringUtils.isNotEmpty(cond.getSrdomainid_eq())) {
			c.add(Expression.eq("srdomainid", Integer.parseInt(cond.getSrdomainid_eq())));
		}
		//域版本
		if (StringUtils.isNotEmpty(cond.getSrdomainversion_eq())) {
			c.add(Expression.eq("srdomainversion", Integer.parseInt(cond.getSrdomainversion_eq())));
		}
		//删除标志
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			c.add(Expression.eq("deleteflag", cond.getDeleteflag_eq()));
		}
		//源资产ID
		if(StringUtils.isNotEmpty(cond.getSrpareiid_eq())){
			c.add(Expression.eq("srpareiid", Integer.parseInt(cond.getSrpareiid_eq())));
		}
		//源资产大版本
		if(StringUtils.isNotEmpty(cond.getSrparversion_eq())){
			c.add(Expression.eq("srparversion", Integer.parseInt(cond.getSrparversion_eq())));
		}
		//源资产小版本
		if(StringUtils.isNotEmpty(cond.getSrparsmallversion_eq())){
			c.add(Expression.eq("srparsmallversion", Integer.parseInt(cond.getSrparsmallversion_eq())));
		}
		//目的资产ID
		if(StringUtils.isNotEmpty(cond.getSrcldeiid_eq())){
			c.add(Expression.eq("srcldeiid", Integer.parseInt(cond.getSrcldeiid_eq())));
		}
		//目的资产大版本
		if(StringUtils.isNotEmpty(cond.getSrcldversion_eq())){
			c.add(Expression.eq("srcldversion", Integer.parseInt(cond.getSrcldversion_eq())));
		}
		//目的资产小版本
		if(StringUtils.isNotEmpty(cond.getSrcldsmallversion_eq())){
			c.add(Expression.eq("srcldsmallversion", Integer.parseInt(cond.getSrcldsmallversion_eq())));
		}
		//创建时间
		if(StringUtils.isNotEmpty(cond.getSrcreatetime_eq())){
			c.add(Expression.eq("srcreatetime", cond.getSrcreatetime_eq()));
		}
		//关系类型
		if(StringUtils.isNotEmpty(cond.getSrassetrelation_eq())){
			c.add(Expression.eq("srassetrelation", cond.getSrassetrelation_eq()));
		}
		//扩展算法类型
		if(StringUtils.isNotEmpty(cond.getSrarithmetictype_eq())){
			c.add(Expression.eq("srarithmetictype", cond.getSrarithmetictype_eq()));
		}
		
		if(cond.getSrpareiids()!=null&&cond.getSrpareiids().length>0){
			c.add(Expression.in("srpareiid", cond.getSrpareiids()));
		}
		
		if(cond.getSrcldeiids()!=null&&cond.getSrcldeiids().length>0){
			c.add(Expression.in("srcldeiid", cond.getSrcldeiids()));
		}
		return c;
	}
	
	/**
	 * 出图用拓扑关系
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0121Info> searchShowStorageIOSnapshotRelation() {
		HibernateCallback action = new HibernateCallback(){  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();		
				query.append(session.getNamedQuery("SnapshotRelationDAO.searchShowStorageIOSnapshotRelation").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0121TB.class);
				List<SOC0121Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0121Info>) execute(action);
	}


}