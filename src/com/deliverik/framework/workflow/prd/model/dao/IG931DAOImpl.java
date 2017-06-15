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
import com.deliverik.framework.workflow.prd.model.IG931Info;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG931TB;

/**
  * 概述: 缺省状态参与者关联流程类型定义表DAO实现
  * 功能描述: 缺省状态参与者关联流程类型定义表DAO实现
  * 创建记录: 2012/10/18
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG931DAOImpl extends
		BaseHibernateDAOImpl<IG931Info> implements IG931DAO {

	/**
	 * 构造函数
	 */
	public IG931DAOImpl(){
		super(IG931TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG931Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG931Info findByPK(Serializable pk) {
		IG931Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG931SearchCond cond){
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
	public List<IG931Info> findByCond(final IG931SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG931SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPdid())){
            c.add(Expression.eq("pdid", cond.getPdid()));
        }
        if(StringUtils.isNotEmpty(cond.getPsdid())){
            c.add(Expression.eq("psdid", cond.getPsdid()));
        }
		return c;
	}
	/**
     * dpsprpid主键值取得
     * 
     * @param 流程状态ID
     * @return psprpid主键值
     */
    @SuppressWarnings("rawtypes")
	public String getDpsprpidSequenceNextValue(String psdid) {
        String sql =  "SELECT MAX(ppd.dpsprpid) FROM IG931TB ppd WHERE ppd.dpsprpid LIKE :psdid";
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
     * 相关发起流程状态为启用状态的默认权限的相关发起信息取得
     * 
     * @param cond检索条件
     * @return 检索结果列表
     */
    @SuppressWarnings("unchecked")
    public List<IG931Info> getIg931RelevantPdidfindByCond(final IG931SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session)
            throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG931DAO.searchIG931RelevantPdid").getQueryString());
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                q.addEntity("IG931TB", IG931TB.class);
                setFetchPoint(q, 0, 0);
                List<IG931Info> list = q.list();
                session.clear();
                return list;
            }
        };
        return (List<IG931Info>) execute(action);
    }
    
    /**
     * 相关发起可发起流程的流程定义信息取得（根据IG931关联取得IG380的信息）
     * 
     * @param cond检索条件
     * @return 检索结果列表
     */
    @SuppressWarnings("unchecked")
    public List<IG380Info> getIg380InfoByIg931Cond(final IG931SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session)
            throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG931DAO.searchIG380Info").getQueryString());
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
    
    /**
     * 相关发起流程状态为启用状态的默认权限的相关发起信息条数取得
     * @param cond 检索条件
     * @return 检索结果
     */
    public int getIg931RelevantPdidCount(final IG931SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG931DAO.countIG931RelevantPdid").getQueryString());
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                session.clear();
                return getCount(q.list());
            }
        };
        return (Integer)execute(action);
    }
}