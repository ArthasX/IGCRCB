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

import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.asset.model.condition.CIResultSearchCond;
import com.deliverik.framework.asset.model.entity.CIResultTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * 概述: CI变更对比结果信息表DAO实现
  * 功能描述: CI变更对比结果信息表DAO实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CIResultDAOImpl extends
		BaseHibernateDAOImpl<CIResultInfo> implements CIResultDAO {

	/**
	 * 构造函数
	 */
	public CIResultDAOImpl(){
		super(CIResultTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CIResultInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CIResultInfo findByPK(Serializable pk) {
		CIResultInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CIResultSearchCond cond){
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
	public List<CIResultInfo> findByCond(final CIResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eiid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 更新当前数据为不合理
	 *
	 * @param cond 检索条件
	 */
	public Integer updateCIResultWithout(final CIResultSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("CIResultDAO.updateCIResultWithout").getQueryString());
				
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ar",CIResultTB.class);

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
	protected DetachedCriteria getCriteria(CIResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// CI变更开始时间
		if (StringUtils.isNotEmpty(cond.getCitime_from())) {
			c.add(Expression.ge("autime", cond.getCitime_from()));
		}
		
		// CI变更结束时间
		if (StringUtils.isNotEmpty(cond.getCitime_to())) {
			c.add(Expression.le("autime", cond.getCitime_to()));
		}
		
		// 资产模型
		if (StringUtils.isNotEmpty(cond.getEsyscoding())) {
			c.add(Expression.like("esyscoding", cond.getEsyscoding() + '%'));
		}
		
		// CI变更任务
		if (StringUtils.isNotEmpty(cond.getCitdesc())) {
			String sql = "exists (select 1 from audittask at where at.autid = this_.autid and at.autdesc like '%" + cond.getCitdesc() + "%') ";
			c.add(Expression.sql(sql));
		}
		
		return c;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(CIResultSearchCond cond, StringBuffer query){
		
		// CI变更开始时间
		if( !StringUtils.isEmpty(cond.getCitime_from())){
			query.append(" AND ar.autime >= :autime_from");
		}
		
		// CI变更结束时间
		if( !StringUtils.isEmpty(cond.getCitime_to())){
			query.append(" AND ar.autime <= :autime_to");
		}
		
		// 资产模型
		if( !StringUtils.isEmpty(cond.getEsyscoding())){
			query.append(" AND ar.esyscoding like (:esyscoding || '%')");
		}
		
		// CI变更任务
		if (StringUtils.isNotEmpty(cond.getCitdesc())) {
			query.append(" AND exists (select 1 from audittask at where at.autid = ar.autid and at.autdesc like '%' || :autdesc || '%') ");
		}
		
	}
		

}