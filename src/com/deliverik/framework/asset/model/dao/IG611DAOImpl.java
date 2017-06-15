/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.IG611Info;
import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG611SearchCond;
import com.deliverik.framework.asset.model.entity.IG611TB;
import com.deliverik.framework.asset.model.entity.IG612VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * 概述: 资产模型属性缺省值DAO实现
  * 功能描述: 资产模型属性缺省值DAO实现
  * 创建记录: 2012/07/20
  * 修改记录: 
  */
public class IG611DAOImpl extends
		BaseHibernateDAOImpl<IG611Info> implements IG611DAO {

	/**
	 * 构造函数
	 */
	public IG611DAOImpl(){
		super(IG611TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG611Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG611Info findByPK(Serializable pk) {
		IG611Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG611SearchCond cond){
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
	public List<IG611Info> findByCond(final IG611SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG611SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
	
	/**
	 * 资产属性默认值取得
	 * 
	 * @param cond 检索条件
	 * @return 资产属性默认值
	 */
	@SuppressWarnings("unchecked")
	public  List<IG612Info> searchDefaultValue(final IG611SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("IG611DAO.searchDefaultValue").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("ci",IG612VW.class);
				q.setProperties(cond);
				List<IG611Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}
				
		};
		return (List<IG612Info>) execute(action);
	}
	
	/**
	 * 资产属性初期化查询
	 * 
	 * @param cond 检索条件
	 * @return 资产属性
	 */
	@SuppressWarnings("unchecked")
	public  List<IG612Info> searchDefaultLabel(final IG611SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("IG611DAO.searchDefaultLabel").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("ci",IG612VW.class);
				q.setProperties(cond);
				List<IG611Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}
				
		};
		return (List<IG612Info>) execute(action);
	}

}