/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG485Info;
import com.deliverik.framework.workflow.prr.model.condition.IG485SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG224VW;
import com.deliverik.framework.workflow.prr.model.entity.IG485TB;
import com.deliverik.framework.workflow.prr.model.entity.IG485VW;

/**
  * 概述: 流程组关联关系实例表DAO实现
  * 功能描述: 流程组关联关系实例表DAO实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
@SuppressWarnings("unchecked")
public class IG485DAOImpl extends BaseHibernateDAOImpl<IG485Info> implements IG485DAO {

	/**
	 * 构造函数
	 */
	public IG485DAOImpl(){
		super(IG485TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG485Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG485Info findByPK(Serializable pk) {
		IG485Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG485SearchCond cond){
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
	public List<IG485Info> findByCond(final IG485SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG485SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//参考流程ID
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		//状态
		if(StringUtils.isNotEmpty(cond.getPgrrstatus())){
			c.add(Restrictions.eq("pgrrstatus", cond.getPgrrstatus()));
		}
		return c;
	}
	
	/**
	 * 根据指定流程和状态，查询流程组关系实例表中，
	 * 该流程的参考流程和参考状态的记录
	 * @param pgrid 流程组ID
	 * @param pgdid 流程组定义ID
	 * @param ipsdid 影响状态ID
	 * @return 参考流程列表
	 */
	public List<Object[]> checkPend(final Integer pgrid, final String pgdid, final String ipsdid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append("select a.rpsdid, b.pgrrstatus from ig482 a ");
				query.append("left outer join ig485 b on (a.pgreid = b.pgreid and b.pgrid = :pgrid) ");
				query.append("where a.ipsdid = :ipsdid and a.pgdid = :pgdid");
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("pgrid", pgrid);
				q.setString("pgdid", pgdid);
				q.setString("ipsdid", ipsdid);
				q.addScalar("rpsdid", Hibernate.STRING).addScalar("pgrrstatus", Hibernate.STRING); 
				List<Object[]> lst = q.list();
				session.clear();
				session.close();
				return lst;
			}
		};
		return (List<Object[]>)execute(action);
	}
	
	/**
	 * 根据指定流程组和状态，查询状态相关的挂起流程中，
	 * @param pgrid 流程组实例ID
	 * @param ipsdid 影响状态ID
	 * @return 影响流searchPendPrid程ID列表
	 */
	public List<IG224VW> searchPendPrid(final Integer pgrid, final String ipsdid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append("select c.prid,c.pendpsdid,c.pendpsdnum,c.psdid,c.psdnum,c.rslid from ig483 a ");
				query.append("inner join ig484 b on (a.pgrid = b.pgrid) ");
				query.append("inner join ig591 c on (b.prid = c.PRID and c.PSDID = :ipsdid and c.PEND = '0') ");
				query.append("where a.pgrid = :pgrid");
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("pgrid", pgrid);
				q.setString("ipsdid", ipsdid);
				q.addEntity(IG224VW.class);
				List<IG224VW> lst = q.list();
				session.clear();
				session.close();
				return lst;
			}
		};
		return (List<IG224VW>)execute(action);
	}
	
	/**
	 * 查询关联关系实例未处理记录
	 * @param prid 参考流程ID
	 * @param rpsdid 参考流程状态ID
	 * @return 未处理记录
	 */
	public List<IG485VW> searchNotDone(final Integer prid, final String rpsdid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append("select a.*, b.rtpsdid, b.ipsdid, b.transferhandler, b.ipdid from ig485 a ");
				query.append("inner join ig482 b on (a.pgreid = b.pgreid) ");
				query.append("where a.prid = :prid and a.pgrrstatus = '0' and b.rpsdid = :rpsdid");
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("prid", prid);
				q.setString("rpsdid", rpsdid);
				q.addEntity(IG485VW.class);
				List<IG485VW> lst = q.list();
				session.clear();
				session.close();
				return lst;
			}
		};
		return (List<IG485VW>)execute(action);
	}
	
}