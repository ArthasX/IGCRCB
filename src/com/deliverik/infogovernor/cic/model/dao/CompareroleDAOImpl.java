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
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareroleSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareroleTB;

/**
  * 概述: 对比规则DAO实现
  * 功能描述: 对比规则DAO实现
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class CompareroleDAOImpl extends
		BaseHibernateDAOImpl<CompareroleInfo> implements CompareroleDAO {

	/**
	 * 构造函数
	 */
	public CompareroleDAOImpl(){
		super(CompareroleTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
	public List<CompareroleInfo> findAll() {
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
	public CompareroleInfo findByPK(Serializable pk) {
		CompareroleInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CompareroleSearchCond cond){
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
	public List<CompareroleInfo> findByCond(final CompareroleSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CompareroleSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getCrtype())){
			c.add(Expression.eq("crtype", cond.getCrtype()));
		}
		if(cond.getCrsystemid()!=null&& cond.getCrsystemid()>1){
			c.add(Expression.eq("crsystemid", cond.getCrsystemid()));
		}
		
		return c;
	}

	
	/**
     * 根据关系表查询规则及对象
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    @SuppressWarnings("unchecked")
    public List<CompareroleInfo> searchCompareroleByRelation(final CompareroleSearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                
                query.append(session.getNamedQuery("CompareroleDAO.searchComparerolebyRelation").getQueryString());
                // 拼接查询条件
                getSql(query, cond);
                SQLQuery q = session.createSQLQuery(query.toString());
                
                q.setProperties(cond);
                q.addEntity("t3",CompareroleTB.class);
                
                setFetchPoint(q, 0, 0);
                List<CompareroleInfo> list = q.list();
                session.clear();
                session.close();
                return list;
            }
        };
        return (List<CompareroleInfo>) execute(action);
    }
    
    //  查询条件
    private void getSql(StringBuffer query, CompareroleSearchCond cond){
        
        if (cond.getCpid() != null) {
            query.append(" and t3.cpid = :cpid ");
           
        }
    }
}