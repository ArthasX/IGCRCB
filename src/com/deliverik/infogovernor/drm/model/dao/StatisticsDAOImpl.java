package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.condition.StatisticsSearchCond;

@SuppressWarnings({"unchecked"})
public class StatisticsDAOImpl  extends BaseHibernateDAOImpl<Object> implements StatisticsDAO {

	/**
	 * 预案统计查询
	 * 统计预案总数,修订数量,演练数量
	 * @return
	 */
	public List<Map<String,Object>> planStatistics(StatisticsSearchCond cond ) {
		Session session = getSession();
		StringBuffer sql = new StringBuffer (session.getNamedQuery("StatisticsDAO.planStatistics").getQueryString());
		if(StringUtils.isNotEmpty(cond.getEiinstimeFrom())){
			sql = sql.insert(sql.indexOf("1=1")+3, " and eiinsdate >= '"+cond.getEiinstimeFrom()+"' ");
		}
		if(StringUtils.isNotEmpty(cond.getEiinstimeTo())){
			sql = sql.insert(sql.indexOf("1=1")+3, " and eiinsdate <= '"+cond.getEiinstimeTo()+"' ");
		}
		SQLQuery q = session.createSQLQuery(sql.toString());
		
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		q.addScalar("EID",Hibernate.STRING) ;
		q.addScalar("ENAME",Hibernate.STRING) ;
		q.addScalar("ESYSCODING",Hibernate.STRING) ;
		q.addScalar("SUMCOUNT",Hibernate.STRING) ;
		q.addScalar("MODIFYCOUNT",Hibernate.STRING) ;
		q.addScalar("DRILLCOUNT",Hibernate.STRING) ;
		q.addScalar("DRILLRATE",Hibernate.STRING) ;
		q.addScalar("MODIFYRATE",Hibernate.STRING) ;
		
		return q.list();
	}
	/**
	 * 预案统计查询-获取预案关联的“已演练”的场景的eiid集合
	 * @return
	 */
	public List<Map<String, Object>> getSceneEiids(StatisticsSearchCond cond ) {
		Session session = getSession();
		StringBuffer sql = new StringBuffer (session.getNamedQuery("StatisticsDAO.getDrillEiids").getQueryString());
		if(StringUtils.isNotEmpty(cond.getEiname())){
			sql.append(" AND S118.EINAME LIKE '"+cond.getEiname()+"%'");
		}
		SQLQuery q = session.createSQLQuery(sql.toString());
		q.setString("ESYSCODING", cond.getEsyscoding());
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		q.addScalar("EIID",Hibernate.STRING) ;
		return q.list();
	}
	
	/**
	 * 演练统计查询
	 * 演练计划统计,演练任务统计,演练执行统计
	 * @return
	 */
	public List<Map<String,Object>> drillStatistics(StatisticsSearchCond cond ){
		Session session = getSession();
		String sql =session.getNamedQuery("StatisticsDAO.drillStatistics").getQueryString();
		if(StringUtils.isNotEmpty(cond.getDrillTimeFrom())){
			sql = sql.replaceAll("1=1", "1=1 and crttime >= '"+cond.getDrillTimeFrom()+"' ");
			sql = sql.substring(0,  sql.lastIndexOf("crttime"))+ " propentime"+sql.substring( sql.lastIndexOf("crttime")+7);
		}
		if(StringUtils.isNotEmpty(cond.getDrillTimeTo())){
			sql = sql.replaceAll("1=1", "1=1 and crttime <= '"+cond.getDrillTimeTo()+"' ");
			sql = sql.substring(0,  sql.lastIndexOf("crttime"))+ " propentime"+sql.substring( sql.lastIndexOf("crttime")+7);
		
		}
		SQLQuery q = session.createSQLQuery(sql);
		
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		q.addScalar("RATENAME",Hibernate.STRING) ;
		q.addScalar("ACCOUNT",Hibernate.STRING) ;
		q.addScalar("YCOUNT",Hibernate.STRING) ;
		q.addScalar("WCOUNT",Hibernate.STRING) ;
		q.addScalar("WRATE",Hibernate.STRING) ;
		q.addScalar("YRATE",Hibernate.STRING) ;
		
		return q.list();
	}
	
	/**
	 * 演练形式统计
	 * 
	 * @return
	 */
	public List<Map<String,Object>> drillTypeStatistics(StatisticsSearchCond cond ){
		Session session = getSession();
		String sql =session.getNamedQuery("StatisticsDAO.drillTypeStatistics").getQueryString();
		if(StringUtils.isNotEmpty(cond.getDrillTimeFrom())){
			sql = sql.replaceAll("1=1", "1=1 and propentime >= '"+cond.getDrillTimeFrom()+"' ");
		}
		if(StringUtils.isNotEmpty(cond.getDrillTimeTo())){
			sql = sql.replaceAll("1=1", "1=1 and propentime <= '"+cond.getDrillTimeTo()+"' ");
		}
		SQLQuery q = session.createSQLQuery(sql);
		
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		q.addScalar("PIVARVALUE",Hibernate.STRING) ;
		q.addScalar("ACCOUNT",Hibernate.STRING) ;
		q.addScalar("NUM",Hibernate.STRING) ;
		
		return q.list();
	}
	

}
