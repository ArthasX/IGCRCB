package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.PlatformManagerInfo;
import com.deliverik.framework.soc.asset.model.condition.PlatformManagerVWSearchCond;
import com.deliverik.framework.soc.asset.model.entity.PlatformManagerVW;

/**
 * 资产项关系信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class PlatformManagerDAOImpl extends BaseHibernateDAOImpl<PlatformManagerInfo> implements PlatformManagerDAO {

	/**
	 * 构造函数
	 */
	public PlatformManagerDAOImpl(){
		super(PlatformManagerVW.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	@Override
	public List<PlatformManagerInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eirid"));
		List<PlatformManagerInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param eirid 主键
	 * @return 检索结果
	 */
	@Override
	public PlatformManagerInfo findByPK(Serializable eirid) {

		PlatformManagerInfo entityitemrelation = super.findByPK(eirid);
		if(entityitemrelation == null) return null;

		return entityitemrelation;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final PlatformManagerVWSearchCond cond){
		
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				session.flush();
				StringBuffer sql = new StringBuffer();
				sql.append(session.getNamedQuery("PlatformManagerDAO.getCountPlatformManagerVW").getQueryString());
				
				sql = appendSql(sql, cond);
				
				SQLQuery q = session.createSQLQuery(sql.toString());
				
				q.setProperties(cond);
				
				Integer count = Integer.valueOf(q.uniqueResult().toString());
				session.clear();
				session.close();
				
				return count;
			}
		};
		
		return (Integer) execute(action);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<PlatformManagerInfo> findByCond(final PlatformManagerVWSearchCond cond, final int start, final int count){
		
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				session.flush();
				StringBuffer sql = new StringBuffer();
				sql.append(session.getNamedQuery("PlatformManagerDAO.searchPlatformManagerVW").getQueryString());
				
				sql = appendSql(sql, cond);
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.addEntity(PlatformManagerVW.class);
				
				q.setProperties(cond);
				setFetchPoint(q, start,count);
				List<PlatformManagerInfo> ret = q.list();
				session.clear();
				session.close();
				return ret;
			}
		};
		
		return (List<PlatformManagerInfo>)execute(action);
	}


	private StringBuffer appendSql(StringBuffer sql,PlatformManagerVWSearchCond cond){
		if(StringUtils.isNotEmpty(cond.getEiName())){
			sql.append(" and a.einame ='"+cond.getEiName()+"'");
		}
		if(StringUtils.isNotEmpty(cond.getSdate())){
			sql.append(" and a.eiinsdate >= '"+cond.getSdate()+"'");
		}
		if(StringUtils.isNotEmpty(cond.getEdate())){
			sql.append(" and a.eiinsdate <= '"+cond.getEdate()+"'");
		}
		return sql;
	}

	

	

	
}
