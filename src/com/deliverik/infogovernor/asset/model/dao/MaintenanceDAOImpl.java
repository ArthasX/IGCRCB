/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.dao;

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
import com.deliverik.infogovernor.asset.model.MaintenanceInfo;
import com.deliverik.infogovernor.asset.model.condition.MaintenanceSearchCond;
import com.deliverik.infogovernor.asset.model.entity.MaintenanceTB;

/**
  * 概述: 风险指标维护DAO实现
  * 功能描述: 风险指标维护DAO实现
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
public class MaintenanceDAOImpl extends
		BaseHibernateDAOImpl<MaintenanceInfo> implements MaintenanceDAO {

	/**
	 * 构造函数
	 */
	public MaintenanceDAOImpl(){
		super(MaintenanceTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MaintenanceInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MaintenanceInfo findByPK(Serializable pk) {
		MaintenanceInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final MaintenanceSearchCond cond){
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
	public List<MaintenanceInfo> findByCond(final MaintenanceSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	@SuppressWarnings("deprecation")
	protected DetachedCriteria getCriteria(MaintenanceSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//风险指标ID
		if( cond.getRIID()!=null){
			c.add(Expression.eq("RIID", cond.getRIID()));
		}
		return c;
	}




	public List<Integer> saveOrUpdateMaintenance(final MaintenanceInfo instance) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                
                query.append("select rimid from MAINTENANCE where riid = '");
                if(instance.getRIID()==null){
                	query.append("0'");
                }else{
                	query.append(instance.getRIID()+"'");
                }
                
                
                SQLQuery q = session.createSQLQuery(query.toString()); 
                List<Integer> list =(List<Integer>) q.list();
                
                session.clear();
                session.close();
                return list;
            }
        };
        return (List<Integer>)execute(action);
	}



	public MaintenanceInfo update(final MaintenanceInfo instance) {
		// TODO Auto-generated method stub
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                
                query.append("update MAINTENANCE set riid='");
                query.append(instance.getRIID()+"',rimtype='");
                query.append(instance.getRIMTYPE()+"',rimdesc='");
                query.append(instance.getRIMDESC()+"'");
                query.append(" where RIMID='"+instance.getRIMID()+"'");
                SQLQuery q = session.createSQLQuery(query.toString());
                q.executeUpdate();
                
                session.clear();
                session.close();
                return null;
            }
        };
        return (MaintenanceInfo)execute(action);
	}
	
	
	/**
	 * 条件检索处理
	 * 根据sql查询
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<Object> SearchBySQL(final MaintenanceSearchCond cond) {
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				String query =cond.getSearchSQL();
				SQLQuery q = session.createSQLQuery(query);
				q.setProperties(cond);
				List<Object> list = q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<Object>)execute(action);
	}

}