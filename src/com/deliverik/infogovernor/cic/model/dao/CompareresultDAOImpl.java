/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.cic.model.CompareresultInfo;
import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareresultSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareresultTB;
import com.deliverik.infogovernor.cic.model.entity.CompareresultVW;

/**
  * 概述: 比对结果DAO实现
  * 功能描述: 比对结果DAO实现
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CompareresultDAOImpl extends
		BaseHibernateDAOImpl<CompareresultInfo> implements CompareresultDAO {

	/**
	 * 构造函数
	 */
	public CompareresultDAOImpl(){
		super(CompareresultTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
	public List<CompareresultInfo> findAll() {
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
	public CompareresultInfo findByPK(Serializable pk) {
		CompareresultInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CompareresultSearchCond cond){
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
	public List<CompareresultInfo> findByCond(final CompareresultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CompareresultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (cond.getCoid_eq() != null) {
		    c.add(Restrictions.eq("fkCoid", cond.getCoid_eq()));
		}
		return c;
	}

	/**
	 * 根据对象比对结果标题List
	 * 
	 * @param cond 检索条件
	 * @param version 版本
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> getEnameList(final CompareresultSearchCond cond) {
	    HibernateCallback action = new HibernateCallback() {
	        public Object doInHibernate(Session session) throws HibernateException, SQLException {
	            session.flush();
	            StringBuffer query = new StringBuffer();
	            
	            query.append(session.getNamedQuery("CompareresultDAO.getEname").getQueryString());
	            // 拼接查询条件
	            getSql(query, cond);
	            query.append(" group by t5.fkcoid, t5.pename, t5.esyscoding  order by t5.esyscoding");
	            SQLQuery q = session.createSQLQuery(query.toString());
	            
	            q.setProperties(cond);
//	            q.addEntity("t5",CompareresultVW.class);
	            
	            setFetchPoint(q, 0, 0);
	            List<Object[]> list = q.list();
	            session.clear();
	            session.close();
	            return list;
	        }
	    };
	    return (List<Object[]>) execute(action);
	}
	
	/**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    @SuppressWarnings("unchecked")
    public List<CompareresultVWInfo> searchCompareresultVW(final CompareresultSearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                
                query.append(session.getNamedQuery("CompareresultDAO.searchCompareresultVW").getQueryString());
                // 拼接查询条件
                getSql(query, cond);
                query.append(" order by t5.esyscoding");
                SQLQuery q = session.createSQLQuery(query.toString());
                
                q.setProperties(cond);
                q.addEntity("t5",CompareresultVW.class);
                
                setFetchPoint(q, 0, 0);
                List<CompareresultVWInfo> list = q.list();
                session.clear();
                session.close();
                return list;
            }
        };
        return (List<CompareresultVWInfo>) execute(action);
    }
    
    //  查询条件
    private void getSql(StringBuffer query, CompareresultSearchCond cond){
        if (cond.getCoid_eq() != null) {
            query.append(" and t5.fkcoid= :coid_eq");
        }
        
        if (null != cond.getIsBase()) {
            query.append(" and t5.isbase= :isBase");
        }
        
        if(null!=cond.getCpid_eq()&&cond.getCpid_eq()>0){
        	query.append(" and t5.fkcpid = :cpid_eq");
        }
        if(StringUtils.isNotEmpty(cond.getEid())){
        	query.append(" and t5.eid = :eid");
        }
    }
}