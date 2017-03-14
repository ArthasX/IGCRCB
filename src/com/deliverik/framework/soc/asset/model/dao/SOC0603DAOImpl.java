/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0603Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0603SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0603VW;

/**
 * 机柜信息视图DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class SOC0603DAOImpl extends BaseHibernateDAOImpl<SOC0603Info> implements SOC0603DAO {

	/**
	 * 构造函数
	 * 
	 */
	public SOC0603DAOImpl(){
		super(SOC0603VW.class);
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0603SearchCond cond){
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
	public List<SOC0603Info> findByCond(final SOC0603SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		//----------DELETE BY WANGXIAOQIANG 2010-07-05------------------
		//c.addOrder(Order.asc("eiid"));
		//c.addOrder(Order.asc("eilabel"));
		//----------DELETE BY WANGXIAOQIANG 2010-07-05------------------
		//----------ADD BY WANGXIAOQIANG 2010-07-05------------------
		//按照设备名称升序排列
		//c.addOrder(Order.asc("room_einame"));
		//c.addOrder(Order.asc("eilabel"));
		//----------ADD BY WANGXIAOQIANG 2010-07-05------------------
		List<SOC0603Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 条件检索处理：检索空调和UPS
	 * 
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0603Info> findBySOC0603Info(final SOC0603SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("SOC0603DAO.findByComputerContainer").getQueryString());
				query = getSQL(cond, query);
				query.append(" AND TABLE1.EIVERSION <> 0");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("SOC0603VW",SOC0603VW.class);
				List<SOC0603Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<SOC0603Info>) execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected StringBuffer getSQL(SOC0603SearchCond cond, StringBuffer query) {
		
		if (cond.getEiid()!=null) {
			query.append(" AND TABLE1.EIID=:eiid");
		}

		if (cond.getRoom_eiid()!=null) {
			query.append(" AND TABLE1.ROOM_EIID=:room_eiid");
		}

		if (StringUtils.isNotEmpty(cond.getEilabel())) {
			query.append(" AND TABLE1.EILABEL=:eilabel");
		}

		if (StringUtils.isNotEmpty(cond.getEiname())) {
			query.append(" AND TABLE1.EINAME LIKE ('%'||:einame||'%')");
		}

		if (StringUtils.isNotEmpty(cond.getU_total())) {
			query.append(" AND TABLE1.U_TOTAL=:u_total");
		}

        if(StringUtils.isNotEmpty(cond.getGraphstatus())){
        	if ("0".equals(cond.getGraphstatus())) {//未上架
        		query.append(" AND (TABLE1.GRAPHSTATUS IS NULL OR TABLE1.GRAPHSTATUS=:graphstatus OR TABLE1.GRAPHSTATUS='')");
        	}else{//已上架
        		query.append(" AND TABLE1.GRAPHSTATUS=:graphstatus");
        	}
		}
        
        if (StringUtils.isNotEmpty(cond.getContainertype())) {
        	query.append(" AND TABLE1.CONTAINERTYPE=:containertype");
		}
        
		return query;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0603SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (cond.getEiid()!=null) {
			c.add(Expression.eq("eiid", cond.getEiid()));
		}

		if (cond.getRoom_eiid()!=null) {
			c.add(Expression.eq("room_eiid", cond.getRoom_eiid()));
		}

		if (StringUtils.isNotEmpty(cond.getEilabel())) {
			c.add(Expression.eq("eilabel", cond.getEilabel()));
		}

		if (StringUtils.isNotEmpty(cond.getEiname())) {
			c.add(Expression.like("einame", "%" + cond.getEiname() + "%").ignoreCase());
		}
		if (StringUtils.isNotEmpty(cond.getEilabel_like())) {
		    c.add(Expression.like("eilabel", cond.getEilabel_like(),MatchMode.ANYWHERE).ignoreCase());
		}

		if (StringUtils.isNotEmpty(cond.getU_total())) {
			c.add(Expression.eq("u_total", cond.getU_total()));
		}
		
		if(StringUtils.isNotEmpty(cond.getGraphstatus())){
			c.add(Expression.eq("graphstatus", cond.getGraphstatus()));
		}
		
        if (StringUtils.isNotEmpty(cond.getContainertype())) {
			c.add(Expression.eq("containertype", cond.getContainertype()));
		}
        
        if (StringUtils.isNotEmpty(cond.getU_last())) {
            c.add(Expression.ge("u_last", Integer.valueOf(cond.getU_last())));
        }
        
        if (StringUtils.isNotEmpty(cond.getLoad_last())) {
            c.add(Expression.ge("load_last", Integer.valueOf(cond.getLoad_last())));
        }
        
        if (StringUtils.isNotEmpty(cond.getPower_last())) {
            c.add(Expression.ge("power_last", Integer.valueOf(cond.getPower_last())));
        }
        
		return c;
	}
}
