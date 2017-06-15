/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.DrillplanInfo;
import com.deliverik.infogovernor.drm.model.DrillplanVWInfo;
import com.deliverik.infogovernor.drm.model.condition.DrillplanSearchCond;
import com.deliverik.infogovernor.drm.model.condition.DrillplanVWSearchCond;
import com.deliverik.infogovernor.drm.model.entity.DrillplanTB;
import com.deliverik.infogovernor.drm.model.entity.DrillplanVW;

/**
  * 概述: 演练计划DAO实现
  * 功能描述: 演练计划DAO实现
  * 创建记录: 2015/02/28
  * 修改记录: 
  */
@SuppressWarnings("unchecked")
public class DrillplanDAOImpl extends
		BaseHibernateDAOImpl<DrillplanInfo> implements DrillplanDAO {

	/**
	 * 构造函数
	 */
	public DrillplanDAOImpl(){
		super(DrillplanTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
    public List<DrillplanInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	@Override
    public DrillplanInfo findByPK(Serializable pk) {
		DrillplanInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DrillplanSearchCond cond){
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
	public List<DrillplanInfo> findByCond(final DrillplanSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
       
        c.addOrder(Order.desc("dserial"));
		return findByCriteria(c, start, count);
	}
	/**
	 * 统计演练计划已演练的条目的检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 */
		public List<Map<String,Object>> searchDrilledPlanByCond(final DrillplanSearchCond cond, final int start, final int count) {
			
			Session session = getSession();
			
			String sql = "";
			sql = session.getNamedQuery("DrillplanDAO.searchDrilledPlanByCond").getQueryString();
			
			if(StringUtils.isNotEmpty(cond.getDname())){
				
				sql+= "  AND DP.DNAME LIKE '%"+cond.getDname()+"%' ";
			}
//			if(StringUtils.isNotEmpty(cond.getCrttimestart())){
//				
//				sql+= "  AND DP.CRTTIME LIKE '%"+cond.getCrttimestart()+"%' ";
//			}
			
			if(StringUtils.isNotEmpty(cond.getDserial())){
				sql+= " AND DP.DSERIAL like '%"+cond.getDserial()+"%'";
			}
			if(StringUtils.isNotEmpty(cond.getPropentime())){
				sql+= " AND DP.CRTTIME >= '"+cond.getPropentime()+"'";
			}
			if(StringUtils.isNotEmpty(cond.getPrclosetime())){
				sql+= " AND DP.CRTTIME <= '"+cond.getPrclosetime()+"'";
				
			}
			sql+= " ORDER BY DP.DSERIAL DESC";
			SQLQuery q = session.createSQLQuery(sql);
			//q.setFirstResult(start);
			//q.setFetchSize(count);
			if(start >= 0){
				q.setFirstResult(start);
			}
			if(count > 0){
				q.setMaxResults(count);
			}
			q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			q.addScalar("TOTALITEM", Hibernate.STRING);
			q.addScalar("DID", Hibernate.STRING);
			q.addScalar("DUSERID", Hibernate.STRING);
			q.addScalar("DUSERNAME", Hibernate.STRING);
			q.addScalar("CRTTIME", Hibernate.STRING);
			q.addScalar("JUDGETIME", Hibernate.STRING);
			q.addScalar("DSERIAL", Hibernate.STRING);
			q.addScalar("DNAME", Hibernate.STRING);
			q.addScalar("JUDGESTATUS", Hibernate.STRING);
			q.addScalar("DEPICT", Hibernate.STRING);
			q.addScalar("DOPINION", Hibernate.STRING);
			q.addScalar("FINGERPRINT", Hibernate.STRING);
			q.addScalar("JUDGEUSERID", Hibernate.STRING);
			q.addScalar("JUDGEUSERNAME", Hibernate.STRING);
			q.addScalar("COMPLETECOUNT", Hibernate.STRING);
			q.addScalar("DRILLINGCOUNT", Hibernate.STRING);
			return q.list();
		}
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(DrillplanSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		 if (StringUtils.isNotEmpty(cond.getCrttimeend())) {
	            c.add(Restrictions.le("crttime", cond.getCrttimeend()));
	        }
	        if (StringUtils.isNotEmpty(cond.getCrttimestart())) {
	            c.add(Restrictions.ge("crttime", cond.getCrttimestart()));
	        }
	        if (StringUtils.isNotEmpty(cond.getDname())) {
	            c.add(Restrictions.like("dname", "%"+cond.getDname()+"%"));
	        }
	        if (StringUtils.isNotEmpty(cond.getDserial())) {
	            c.add(Restrictions.like("dserial", "%"+cond.getDserial()+"%"));
	        }
	        if (StringUtils.isNotEmpty(cond.getDuserid())) {
	            c.add(Restrictions.like("duserid", "%"+cond.getDuserid()+"%"));
	        }
	        if (StringUtils.isNotEmpty(cond.getDusername())) {
	            c.add(Restrictions.like("dusername", "%"+cond.getDusername()+"%"));
	        }
	        if (StringUtils.isNotEmpty(cond.getJudgetimeend())) {
	            c.add(Restrictions.le("judgetime", cond.getJudgetimeend()));
	        }
	        if (StringUtils.isNotEmpty(cond.getJudgetimestart())) {
	            c.add(Restrictions.ge("judgetime", cond.getJudgetimestart()));
	        }
	        if (StringUtils.isNotEmpty(cond.getJudgeuserid())) {
	            c.add(Restrictions.like("judgeuserid", "%"+cond.getJudgeuserid()+"%"));
	        }
	        if (StringUtils.isNotEmpty(cond.getJudgeusername())) {
	            c.add(Restrictions.like("judgeusername", "%"+cond.getJudgeusername()+"%"));
	        }
	        if (StringUtils.isNotEmpty(cond.getJudgestatus())) {
	            c.add(Restrictions.eq("judgestatus", cond.getJudgestatus()));
	        }
	        if (cond.getDid()!=null&& !(0 ==cond.getDid().intValue())) {
	            c.add(Restrictions.eq("did", cond.getDid()));
	        }
	        if (StringUtils.isNotEmpty(cond.getJudgestatus_ne())) {
	            c.add(Restrictions.ne("judgestatus", cond.getJudgestatus_ne()));
	        }
		return c;
	}
	/**
     * 查询演练计划条目视图
     * @param cond
     * @return
     */
	public List<DrillplanVWInfo> getDrillPlanVW(final DrillplanVWSearchCond cond,final int start,final int count){
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("DrillplanDAO.drillVW").getQueryString());
                getSql(query,cond);
                //获取SQLQuery
                SQLQuery q = session.createSQLQuery(query.toString());
                q.addEntity(DrillplanVW.class);
                setFetchPoint(q, start, count);
                List<DrillplanVWInfo> list = q.list();
//                List list = q.list();
                session.clear();
                session.close();
                return list;
            }
        };
        return (List<DrillplanVWInfo>) execute(action);
    }

    /**
     * 查询演练个数
     * @param cond
     * @return
     */
    public Integer getDrillPlanVWCount(final DrillplanVWSearchCond cond){
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("DrillplanDAO.drillVWCount").getQueryString());
                getSql(query,cond);
                //获取SQLQuery
                SQLQuery q = session.createSQLQuery(query.toString());
                int reint = getCount(q.list());
                session.clear();
                session.close();
                return reint;
            }
        };
        return (Integer) execute(action);
    }
    /** 
     * @Title: getSql 演练查询VW查询条件拼装
     * @param query
     * @param cond    
     * void    
     * @throws 
     */
    protected void getSql(StringBuffer query, DrillplanVWSearchCond cond) {
        if(StringUtils.isNotEmpty(cond.getCrttimeend())){
           query.append(" and d.crttime < '"+cond.getCrttimeend()+"'");
        }
        if(StringUtils.isNotEmpty(cond.getCrttimestart())){
            query.append(" and d.crttime like '"+cond.getCrttimestart()+"%'");
        }
        if(StringUtils.isNotEmpty(cond.getDidutyorg())){
            query.append(" and i.didutyorg like '%"+cond.getDidutyorg()+"%'");
        }
        if(StringUtils.isNotEmpty(cond.getDiname())){
            query.append(" and i.diname like '%"+cond.getDiname()+"%'");
        }
        if(StringUtils.isNotEmpty(cond.getDname())){
            query.append(" and d.dname like '%"+cond.getDname()+"%'");
        }
        if(StringUtils.isNotEmpty(cond.getDserial())){
            query.append(" and d.dserial like '%"+cond.getDserial()+"%'");
        }
        if(StringUtils.isNotEmpty(cond.getDuserid())){
            query.append(" and d.duserid like '%"+cond.getDuserid()+"%'");
        }
        if(StringUtils.isNotEmpty(cond.getDusername())){
            query.append(" and d.dusername like '%"+cond.getDusername()+"%'");
        }
        if(StringUtils.isNotEmpty(cond.getExpecttimeend())){
            query.append(" and i.expecttime < '"+cond.getExpecttimeend()+"'");
        }
        if(StringUtils.isNotEmpty(cond.getExpecttimestart())){
            query.append(" and i.expecttime > '"+cond.getExpecttimestart()+"'");
        }
        if(StringUtils.isNotEmpty(cond.getJudgestatus())){
            query.append(" and d.judgestatus = '"+cond.getJudgestatus()+"'");
        }
        if(StringUtils.isNotEmpty(cond.getJudgetimeend())){
            query.append(" and d.judgetime < '"+cond.getJudgetimeend()+"'");
        }
        if(StringUtils.isNotEmpty(cond.getJudgetimestart())){
            query.append(" and d.judgetime > '"+cond.getJudgetimestart()+"'");
        }
        if(StringUtils.isNotEmpty(cond.getJudgeuserid())){
            query.append(" and d.judgeuserid like '%"+cond.getJudgeuserid()+"%'");
        }
        if(StringUtils.isNotEmpty(cond.getJudgeusername())){
            query.append(" and d.judgeusername like '%"+cond.getJudgeusername()+"%'");
        }
        if(StringUtils.isNotEmpty(cond.getPartorg())){
            query.append(" and i.partorg like '%"+cond.getPartorg()+"%'");
        }
        if(cond.getDid()!=null&&0!=cond.getDid().intValue()){
            query.append(" and i.did = "+cond.getDid());
        }
        if (StringUtils.isNotEmpty(cond.getJudgestatus_ne())) {
        	query.append(" and d.judgestatus <> '"+ cond.getJudgestatus_ne()+"'");
        }
    }
    
    /**
     * 根据diid获取计划条目视图
     * @param diid
     * @return
     */
    public DrillplanVWInfo getDrillPlanVWByDiid(final int diid){
    	HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("DrillplanDAO.drillVWByDiid").getQueryString());
                //获取SQLQuery
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setInteger("diid", diid);
                q.addEntity(DrillplanVW.class);
                List<DrillplanVWInfo> list = q.list();
                session.clear();
                session.close();
                return list.get(0);
            }
        };
        return (DrillplanVWInfo) execute(action);
    }
}