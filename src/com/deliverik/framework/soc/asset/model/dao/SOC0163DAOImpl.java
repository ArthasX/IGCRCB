package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0163Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0163SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0163VW;


/**
 * 用户资产项视图DAO实现
 * 
 */
public class SOC0163DAOImpl extends BaseHibernateDAOImpl<SOC0163Info> implements SOC0163DAO {

	static Log log = LogFactory.getLog(SOC0163DAOImpl.class);

	/**
	 * 资产项视图构造函数
	 * 
	 */
	public SOC0163DAOImpl(){
		super(SOC0163VW.class);
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0163SearchCond cond){
		
		Session session = getSession();
		
		StringBuffer sb = new StringBuffer(session.getNamedQuery("SOC0163DAO.searchQuery").getQueryString());
		
		SQLQuery q = session.createSQLQuery(getSql(cond, sb));
		
		return q.list().size();

	}


	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0163Info> findByCond(final SOC0163SearchCond cond, final int start, final int count){
		
		Session session = getSession();
		
		StringBuffer sb = new StringBuffer(session.getNamedQuery("SOC0163DAO.searchQuery").getQueryString());
		
		
		SQLQuery q = session.createSQLQuery(getSql(cond, sb));
		
		q.addEntity(SOC0163VW.class);
		
		setFetchPoint(q, start, count);
		
		return q.list();
	}
	
	/**
	 * 条件检索网络设备处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0163Info> findByCondForNetAsset(final SOC0163SearchCond cond, final int start, final int count){
		
		Session session = getSession();
		
		StringBuffer sb = new StringBuffer(session.getNamedQuery("SOC0163DAO.searchNetAssetQuery").getQueryString());
		
		
		SQLQuery q = session.createSQLQuery(getSql(cond, sb));
		
		q.addEntity(SOC0163VW.class);
		
		setFetchPoint(q, start, count);
		
		return q.list();
	}
	
	/**
	 * 条件检索网络设备结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCountForNetAsset(final SOC0163SearchCond cond){
		
		Session session = getSession();
		
		StringBuffer sb = new StringBuffer(session.getNamedQuery("SOC0163DAO.searchNetAssetQuery").getQueryString());
		
		SQLQuery q = session.createSQLQuery(getSql(cond, sb));
		
		return q.list().size();

	}

	protected String getSql(SOC0163SearchCond cond,StringBuffer sql){
		if(StringUtils.isNotEmpty(cond.getEsyscoding())){
			sql.append(" and esyscoding = '"+cond.getEsyscoding()+"'");
		}
		if(StringUtils.isNotEmpty(cond.getEsyscoding_like())){
			sql.append(" and esyscoding like '"+cond.getEsyscoding_like()+"%'");
		}
		
		if(StringUtils.isNotEmpty(cond.getEiname())){
			sql.append(" and einame like '%"+cond.getEiname()+"%'");
		}
		
		if(StringUtils.isNotEmpty(cond.getEiupdtime_from())){
			sql.append(" and eiupdtime >= '"+cond.getEiupdtime_from()+"'");
		}
		if(StringUtils.isNotEmpty(cond.getEiupdtime_to())){
			sql.append(" and eiupdtime <= '"+cond.getEiupdtime_to()+" 23:59'");
		}
		if(StringUtils.isNotEmpty(cond.getIp())){
			sql.append(" and ip = '"+cond.getIp()+"'");
		}
		
		return sql.toString();
	}

	
	protected DetachedCriteria getCriteria(SOC0163SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if(StringUtils.isNotEmpty(cond.getEsyscoding())){
			c.add(Expression.eq("esyscoding", cond.getEsyscoding()));
		}
		
		if(StringUtils.isNotEmpty(cond.getEsyscoding_like())){
			c.add(Expression.like("esyscoding", cond.getEsyscoding_like()+"%"));
		}
		
		if(StringUtils.isNotEmpty(cond.getEiname())){
			c.add(Expression.like("einame", "%"+cond.getEiname()+"%"));
		}
		
		if(StringUtils.isNotEmpty(cond.getEiupdtime_from())){
			c.add(Expression.ge("eiupdtime", cond.getEiupdtime_from()));
		}
		if(StringUtils.isNotEmpty(cond.getEiupdtime_to())){
			c.add(Expression.lt("eipudtime", cond.getEiupdtime_to()));
		}
		if(StringUtils.isNotEmpty(cond.getIp())){
			c.add(Expression.eq("ip", cond.getIp()));
		}
		
		return c;
	}
	
}
