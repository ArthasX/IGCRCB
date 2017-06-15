/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.asset.model.IG342Info;
import com.deliverik.infogovernor.asset.model.condition.IG342SearchCond;
import com.deliverik.infogovernor.asset.model.entity.IG342VW;

/**
  * 概述: IG342DAO实现
  * 功能描述: IG342DAO实现
  * 创建记录: 2012/08/03
  * 修改记录: 
  */
public class IG342DAOImpl extends
		BaseHibernateDAOImpl<IG342Info> implements IG342DAO {

	/**
	 * 构造函数
	 */
	public IG342DAOImpl(){
		super(IG342VW.class);
	}


	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG342Info> findByCond(final IG342SearchCond cond, final int start, final int count){
		return findByCriteria(cond, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	@SuppressWarnings("unchecked")
	public List<IG342Info> findByCriteria(final IG342SearchCond cond, final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws

			HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("EntityItemAndConfigItemVWDAO.searchUsageStatistics").getQueryString());
				//根据服务商登记起始时间查询
				if(StringUtils.isNotEmpty(cond.getBeginTime_q())){
//					query.append(" and eiinsdate >= '" + cond.getBeginTime_q() +"'");
					query.append(" and eiupdtime >= '" + cond.getBeginTime_q() +" 00:00'");
				}
				//根据服务商登记中止时间查询
				if(StringUtils.isNotEmpty(cond.getEndTime_q())){
//					query.append(" and eiinsdate <= '" + cond.getEndTime_q() +"'");
					query.append(" and eiupdtime <= '" + cond.getEndTime_q() +" 23:59'");
				}  
				query.append(" and civalue like '是'");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("prcount",IG342VW.class);
				setFetchPoint(q, start, count);
				List<IG342Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG342Info>) execute(action);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	@SuppressWarnings("unchecked")
	public int getSearchCount(final IG342SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("EntityItemAndConfigItemVWDAO.searchUsageStatistics").getQueryString());
				//根据服务商登记起始时间查询
				if(StringUtils.isNotEmpty(cond.getBeginTime_q())){
					query.append(" and eiupdtime >= '" + cond.getBeginTime_q() +" 00:00'");
				}
				//根据服务商登记中止时间查询
				if(StringUtils.isNotEmpty(cond.getEndTime_q())){
					query.append(" and eiupdtime <= '" + cond.getEndTime_q() +" 23:59'");
				}  
				query.append(" and civalue like '是'");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("prcount",IG342VW.class);
				List<IG342Info> list = q.list();
				session.clear();
				return list.size();
			}
		};
		return (Integer) execute(action);
	}
}