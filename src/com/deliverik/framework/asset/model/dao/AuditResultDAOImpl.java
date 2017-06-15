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

import com.deliverik.framework.asset.model.AuditResultInfo;
import com.deliverik.framework.asset.model.condition.AuditResultSearchCond;
import com.deliverik.framework.asset.model.entity.AuditResultTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * 概述: 审计对比结果信息表DAO实现
  * 功能描述: 审计对比结果信息表DAO实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class AuditResultDAOImpl extends
		BaseHibernateDAOImpl<AuditResultInfo> implements AuditResultDAO {

	/**
	 * 构造函数
	 */
	public AuditResultDAOImpl(){
		super(AuditResultTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AuditResultInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AuditResultInfo findByPK(Serializable pk) {
		AuditResultInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AuditResultSearchCond cond){
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
	public List<AuditResultInfo> findByCond(final AuditResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eiid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 更新当前数据为不合理
	 *
	 * @param cond 检索条件
	 */
	public Integer updateAuditResultWithout(final AuditResultSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("AuditResultDAO.updateAuditResultWithout").getQueryString());
				
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ar",AuditResultTB.class);

				q.setProperties(cond);
				
				int i = q.executeUpdate();
				
				session.clear();
				session.close();
				return Integer.valueOf(i);
			}
				
		};
		return  (Integer) execute(action);
	}
	

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(AuditResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// 资产模型
		if (StringUtils.isNotEmpty(cond.getEsyscoding())) {
			c.add(Expression.like("esyscoding", cond.getEsyscoding() + '%'));
		}
		
		// 审计任务ID
		if (cond.getAutid() != null && cond.getAutid() != 0){
			c.add(Expression.eq("autid", cond.getAutid()));
		}
		
		return c;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(AuditResultSearchCond cond, StringBuffer query){
		
		// 资产模型
		if( !StringUtils.isEmpty(cond.getEsyscoding())){
			query.append(" AND ar.esyscoding like (:esyscoding || '%')");
		}
		
		// 审计任务ID
		if (cond.getAutid() != null && cond.getAutid() != 0){
			query.append(" AND ar.autid = " + cond.getAutid());
		}
		
	}
		

}