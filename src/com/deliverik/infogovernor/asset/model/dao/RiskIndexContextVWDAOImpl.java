/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;
import com.deliverik.infogovernor.asset.model.RiskIndexShowVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexContextVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexContextVW;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexShowVW;

/**
  * 概述: 风险指标展示内容查询DAO实现
  * 功能描述: 风险指标展示内容查询DAO实现
  * 创建记录: 2014/07/26
  * 修改记录: 
  */
public class RiskIndexContextVWDAOImpl extends
		BaseHibernateDAOImpl<RiskIndexContextVWInfo> implements RiskIndexContextVWDAO {

	/**
	 * 构造函数
	 */
	public RiskIndexContextVWDAOImpl(){
		super(RiskIndexContextVW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskIndexContextVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskIndexContextVWInfo findByPK(Serializable pk) {
		RiskIndexContextVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskIndexContextVWSearchCond cond){
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
	@SuppressWarnings("unchecked")
	public List<RiskIndexContextVWInfo> findByCond(final RiskIndexContextVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskIndexContextVWDAOImpl.SEARCH").getQueryString());
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("riskshow",RiskIndexContextVW.class);
				List<RiskIndexContextVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<RiskIndexContextVWInfo>)execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskIndexContextVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}