/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG911Info;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG911TB;

/**
  * 概述: 状态参与者关联流程类型定义表DAO实现
  * 功能描述: 状态参与者关联流程类型定义表DAO实现
  * 创建记录: 2012/10/18
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG911DAOImpl extends
		BaseHibernateDAOImpl<IG911Info> implements IG911DAO {

	/**
	 * 构造函数
	 */
	public IG911DAOImpl(){
		super(IG911TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG911Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG911Info findByPK(Serializable pk) {
		IG911Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG911SearchCond cond){
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
	public List<IG911Info> findByCond(final IG911SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG911SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPdid())){
            c.add(Expression.eq("pdid", cond.getPdid()));
        }
		if(StringUtils.isNotEmpty(cond.getPsdid())){
            c.add(Expression.eq("psdid", cond.getPsdid()));
        }
		if( cond.getRoleid() != null && cond.getRoleid() != 0){
            c.add(Expression.eq("roleid", cond.getRoleid()));
        }
		return c;
	}

	 /**
     * psprpid主键值取得
     * 
     * @param 流程状态ID
     * @return psprpid主键值
     */
    @SuppressWarnings("rawtypes")
	public String getPsprpidSequenceNextValue(String psdid) {
        String sql =  "SELECT MAX(ppd.psprpid) FROM IG911TB ppd WHERE ppd.psprpid LIKE :psdid";
        NamedParamMap p = getNamedParamMap();
        p.setString("psdid", psdid + "%");
        List l = findByNamedParamMap(sql, p);
        if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
            return psdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
        } else {
            String id = (String)l.get(0);
            return psdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(psdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
        }
    }
    
    /**
     * 相关发起流程状态为启用状态的状态参与者相关发起信息取得
     * 
     * @param cond检索条件
     * @return 检索结果列表
     */
    @SuppressWarnings("unchecked")
    public List<IG911Info> getIg911RelevantPdidfindByCond(final IG911SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session)
            throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG911DAO.searchIG911RelevantPdid").getQueryString());
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                q.addEntity("IG911TB", IG911TB.class);
                setFetchPoint(q, 0, 0);
                List<IG911Info> list = q.list();
                session.clear();
                return list;
            }
        };
        return (List<IG911Info>) execute(action);
    }
    
    /**
     * 相关发起流程状态为启用状态的状态参与者相关发起信息条数取得
     * @param cond 检索条件
     * @return 检索结果
     */
    public int getIg911RelevantPdidCount(final IG911SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG911DAO.countIG911RelevantPdid").getQueryString());
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                session.clear();
                return getCount(q.list());
            }
        };
        return (Integer)execute(action);
    }
    
    /**
     * 相关发起可发起流程的流程定义信息取得（根据IG911关联取得IG380的信息）
     * 
     * @param cond检索条件
     * @return 检索结果列表
     */
    @SuppressWarnings("unchecked")
    public List<IG380Info> getIg380InfoByIg911Cond(final IG911SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session)
            throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG911DAO.searchIG380Info").getQueryString());
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                q.addEntity("IG380TB", IG380TB.class);
                setFetchPoint(q, 0, 0);
                List<IG380Info> list = q.list();
                session.clear();
                return list;
            }
        };
        return (List<IG380Info>) execute(action);
    }
}