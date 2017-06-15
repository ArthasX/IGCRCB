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

import com.deliverik.framework.asset.model.CIConfigItemInfo;
import com.deliverik.framework.asset.model.condition.CIConfigItemSearchCond;
import com.deliverik.framework.asset.model.entity.CIConfigItemTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * 概述: CI变更资产属性表DAO实现
  * 功能描述: CI变更资产属性表DAO实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class CIConfigItemDAOImpl extends
		BaseHibernateDAOImpl<CIConfigItemInfo> implements CIConfigItemDAO {

	/**
	 * 构造函数
	 */
	public CIConfigItemDAOImpl(){
		super(CIConfigItemTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CIConfigItemInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CIConfigItemInfo findByPK(Serializable pk) {
		CIConfigItemInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CIConfigItemSearchCond cond){
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
	public List<CIConfigItemInfo> findByCond(final CIConfigItemSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CIConfigItemSearchCond cond){
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
	public List<CIConfigItemInfo> searchCIConfigItemForAucmptype(final Integer eiid){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("CIConfigItemDAO.getConfigAucmptype").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("eiid", eiid);
				q.addEntity("ac", CIConfigItemTB.class);
				List<CIConfigItemInfo> list = q.list();
				
				session.clear();
				session.close();
				return list;
			}
				
		};
		return  (List<CIConfigItemInfo>) execute(action);
	}

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteCIConfigItem(){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("CIConfigItemDAO.deleteCIConfigItem").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				int i = q.executeUpdate();
				
				session.clear();
				session.close();
				return Integer.valueOf(i);
			}
				
		};
		return  (Integer) execute(action);
	}

}