package com.deliverik.framework.asset.model.dao;

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

import com.deliverik.framework.asset.model.IG778Info;
import com.deliverik.framework.asset.model.condition.IG778SearchCond;
import com.deliverik.framework.asset.model.entity.IG778VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 机柜信息视图DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class IG778DAOImpl extends BaseHibernateDAOImpl<IG778Info> implements IG778DAO {

	/**
	 * 构造函数
	 * 
	 */
	public IG778DAOImpl(){
		super(IG778VW.class);
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG778SearchCond cond){
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
	public List<IG778Info> findByCond(final IG778SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		//----------DELETE BY WANGXIAOQIANG 2010-07-05------------------
		//c.addOrder(Order.asc("eiid"));
		//c.addOrder(Order.asc("eilabel"));
		//----------DELETE BY WANGXIAOQIANG 2010-07-05------------------
		//----------ADD BY WANGXIAOQIANG 2010-07-05------------------
		//按照设备名称升序排列
		c.addOrder(Order.asc("room_einame"));
		c.addOrder(Order.asc("eilabel"));
		//----------ADD BY WANGXIAOQIANG 2010-07-05------------------
		List<IG778Info> ret = findByCriteria(c, start, count);
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
	public List<IG778Info> findByIG778Info(final IG778SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG778DAO.findByComputerContainer").getQueryString());
				query = getSQL(cond, query);
				query.append(" AND TABLE1.EIVERSION <> 0");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IG778VW",IG778VW.class);
				List<IG778Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IG778Info>) execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected StringBuffer getSQL(IG778SearchCond cond, StringBuffer query) {
		
		if (cond.getEiid()!=null) {
			query.append(" AND TABLE1.EIID=:eiid");
		}

		if ((cond.getRoom_eiid()!=null)){
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
	protected DetachedCriteria getCriteria(IG778SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (cond.getEiid()!=null) {
			c.add(Expression.eq("eiid", cond.getEiid()));
		}

		if ((cond.getRoom_eiid()!=null)) {
			c.add(Expression.eq("room_eiid", cond.getRoom_eiid()));
		}

		if (StringUtils.isNotEmpty(cond.getEilabel())) {
			c.add(Expression.eq("eilabel", cond.getEilabel()));
		}

		if (StringUtils.isNotEmpty(cond.getEiname())) {
			c.add(Expression.like("einame", "%" + cond.getEiname() + "%"));
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
        
		return c;
	}
}
