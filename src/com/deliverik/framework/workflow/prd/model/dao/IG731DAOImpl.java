/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG731TB;

/**
 * 
 * 流程资产关系DAO接口实现
 *
 */
@SuppressWarnings("deprecation")
public class IG731DAOImpl extends BaseHibernateDAOImpl<IG731Info> implements IG731DAO {
	

	/**
	 * 构造函数
	 */
	public IG731DAOImpl(){
		super(IG731TB.class);
	}
	
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG731Info> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("piid"));
		List<IG731Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 主键检索处理
	 * @param pieid 主键
	 * @return 检索结果
	 */
	public IG731Info findByPK(Serializable pieid){
		
		IG731Info processStatusInfoDef = super.findByPK(pieid);
		
		if(processStatusInfoDef == null) return null;

		return processStatusInfoDef;
	}	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG731SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG731Info> findByCond(final IG731SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("piid"));
		List<IG731Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG731SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();		
		
		if( cond.getPrid() != null && cond.getPrid() != 0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		// 流程表单主键
		if( cond.getPiid() != null && cond.getPiid() != 0){
			c.add(Expression.eq("piid", cond.getPiid()));
		}
		
		if(StringUtils.isNotEmpty(cond.getTableColumnValue())){
			if("Y".equals(cond.getTableColumnValue())){
				c.add(Expression.isNull("piid"));
			}else{
				c.add(Expression.isNotNull("piid"));
			}
		}
		
		return c;
	}
	
	/**
	 * 通过场景prid查询相关的业务系统资产
	 * @param prid
	 * @return 检索结果列表
	 */
	public List<IG731Info> searchIG731InfoBySePrid(final Integer prid,final String flowType){
		 HibernateCallback action = new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException,
	                    SQLException {
	                session.flush();
	                StringBuffer query = new StringBuffer();
	                
	                query.append(session.getNamedQuery("IG731DAO.searchDrillDetailBySePrid").getQueryString());
	                //判断是否为应急指挥流程
	                query.append(" and a.pivarname = '"+flowType+"'");	
	                query.append(" and a.pivarvalue = '"+prid+"'");
	                //获取SQLQuery
	                SQLQuery q = session.createSQLQuery(query.toString());
	                q.addEntity(IG731TB.class);
	                List<IG731Info> list = q.list();
	                session.clear();
	                session.close();
	                return list;
	            }
	        };
	        return (List<IG731Info>) execute(action);
	}
	
	/**
	 * 根据流程prid查询场景的eiid
	 * @param prid 流程id
	 * @param flowType 流程类型
	 * @return
	 */
	public List<IG731Info> searchSenceBySePrid(final Integer prid,final String flowType){
		 HibernateCallback action = new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException,
	                    SQLException {
	                session.flush();
	                StringBuffer query = new StringBuffer();
	                query.append(session.getNamedQuery("IG731DAO.searchSenceBySePrid").getQueryString());
	                //判断是否为应急指挥流程
	                query.append(" and a.prid = '"+prid+"'");	
	                query.append(" and b.pivarname = '"+flowType+"'");
	                //获取SQLQuery
	                SQLQuery q = session.createSQLQuery(query.toString());
	                q.addEntity(IG731TB.class);
	                List<IG731Info> list = q.list();
	                session.clear();
	                session.close();
	                return list;
	            }
	        };
	        return (List<IG731Info>) execute(action);
	}
}
