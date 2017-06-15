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
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0101Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0101SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0101TB;

/**
  * 概述: 审计资产属性表DAO实现
  * 功能描述: 审计资产属性表DAO实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class SOC0101DAOImpl extends
		BaseHibernateDAOImpl<SOC0101Info> implements SOC0101DAO {

	/**
	 * 构造函数
	 */
	public SOC0101DAOImpl(){
		super(SOC0101TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0101Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0101Info findByPK(Serializable pk) {
		SOC0101Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0101SearchCond cond){
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
	public List<SOC0101Info> findByCond(final SOC0101SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0101SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

	/**
	 * 检索资产属性及属性对比分类
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0101Info> searchSOC0101ForAucmptype(final Integer eiid){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("AuditConfigItemDAO.getConfigAucmptype").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("eiid", eiid);
				q.addEntity("ac", SOC0101TB.class);
				List<SOC0101Info> list = q.list();
				
				session.clear();
				
				return list;
			}
				
		};
		return  (List<SOC0101Info>) execute(action);
	}

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteSOC0101(){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("AuditConfigItemDAO.deleteAuditConfigItem").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				int i = q.executeUpdate();
				
				session.clear();
				
				return Integer.valueOf(i);
			}
				
		};
		return  (Integer) execute(action);
	}

}