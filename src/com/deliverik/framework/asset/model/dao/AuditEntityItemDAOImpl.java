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

import com.deliverik.framework.asset.model.AuditEntityItemInfo;
import com.deliverik.framework.asset.model.condition.AuditEntityItemSearchCond;
import com.deliverik.framework.asset.model.entity.AuditEntityItemTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * 概述: 审计资产表DAO实现
  * 功能描述: 审计资产表DAO实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class AuditEntityItemDAOImpl extends
		BaseHibernateDAOImpl<AuditEntityItemInfo> implements AuditEntityItemDAO {

	/**
	 * 构造函数
	 */
	public AuditEntityItemDAOImpl(){
		super(AuditEntityItemTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AuditEntityItemInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eiid"));
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AuditEntityItemInfo findByPK(Serializable pk) {
		AuditEntityItemInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AuditEntityItemSearchCond cond){
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
	public List<AuditEntityItemInfo> findByCond(final AuditEntityItemSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(AuditEntityItemSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// 审计资产类型
		if(StringUtils.isNotEmpty(cond.getAucmptype())){
			// 新增
			if("1".equals(cond.getAucmptype())){
				c.add(Expression.sql(" not exists (select 1 from entityitem ei where ei.eiid = this_.eiid)"));
			}
			// 修改
			if("2".equals(cond.getAucmptype())){
				c.add(Expression.sql(" exists (select 1 from entityitem ei where ei.eiid = this_.eiid)"));
			}
		}
		
		//顶级CI标识
		if(cond.getTopCIList()!=null && cond.getTopCIList().size()>0){
			c.add(Expression.in("einame", cond.getTopCIList()));
		}
		
		
		
		return c;
	}

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteAuditEntityItem(){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("AuditEntityItemDAO.deleteAuditEntityItem").getQueryString());
				
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