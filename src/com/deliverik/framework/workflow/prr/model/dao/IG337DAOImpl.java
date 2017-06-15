/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG602Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG602VW;

/**
 * <p>概述:流程参与用户信息DAO实现</p>
 * <p>功能描述：1.全件检索</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.条件检索处理</p>
 * <p>          4.条件检索结果件数取得</p>
 * <p>          5.指定用户负责的流程处理角色检索处理</p>
 * <p>          5.检索条件生成</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("deprecation")
public class IG337DAOImpl extends BaseHibernateDAOImpl<IG337Info> implements IG337DAO {

	/**
	 * 功能：构造函数
	 */
	public IG337DAOImpl(){
		super(IG337TB.class);
	}

	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG337Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ppid"));
		List<IG337Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 功能：主键检索处理
	 * @param ppid 主键
	 * @return 检索结果
	 */
	public IG337Info findByPK(Serializable ppid) {

		IG337Info pp = super.findByPK(ppid);
		if(pp == null) return null;

		return pp;
	}

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG337Info> findByCond(final IG337SearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ppid"));
		List<IG337Info> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getCountByCond(final IG337SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	/**
	 * 功能：指定用户负责的流程处理角色检索处理
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG337Info> queryRolemanager(final String userid , final Integer prid){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG337DAO.queryRolemanager").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("userid", userid);
				q.setInteger("prid", prid);
				q.addEntity("pp",IG337TB.class);
				setFetchPoint(q, 0, 0);
				List<IG337Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG337Info>) execute(action);
	}
	
	/**
	 * 流程执行人检索处理
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG602Info> searchIG602Info(final String userid, final Integer prid){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG337DAO.searchProcessExecutors").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("userid", userid);
				q.setInteger("prid", prid);
				q.addEntity("IG602VW",IG602VW.class);
				setFetchPoint(q, 0, 0);
				List<IG602Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG602Info>) execute(action);
	}
	
	/**
	 * 流程可分派人检索处理
	 * @param roleid 角色ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG602Info> searchSuperAssignExecutors(final Integer roleid, final Integer prid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG337DAO.searchSuperAssignExecutors").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("roleid", roleid);
				q.setInteger("prid", prid);
				q.addEntity("IG602VW",IG602VW.class);
				setFetchPoint(q, 0, 0);
				List<IG602Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG602Info>) execute(action);
	}
	
	/**
	 * 功能：检索条件生成
	 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG337SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//====130225Begin
		if(StringUtils.isNotEmpty(cond.getPporgid_eq())){
			c.add(Expression.eq("pporgid", cond.getPporgid_eq()));
		}
		//====130225End
		//
		if( cond.getPrid() != null && cond.getPrid() != 0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		if( cond.getPproleid()!=null && cond.getPproleid() != null){
			c.add(Expression.eq("pproleid", cond.getPproleid()));
		}
		if( !StringUtils.isEmpty(cond.getPpuserid())){
			c.add(Expression.eq("ppuserid", cond.getPpuserid()));
		}
		if( !StringUtils.isEmpty(cond.getPpuserinfo())){
			c.add(Expression.eq("ppuserinfo", cond.getPpuserinfo()));
		}
		if( !StringUtils.isEmpty(cond.getPpsubstatus())){
			c.add(Expression.eq("ppsubstatus", cond.getPpsubstatus()));
		}
		if( !StringUtils.isEmpty(cond.getPpinittime())){
			c.add(Expression.eq("ppinittime", cond.getPpinittime()));
		}
		if( !StringUtils.isEmpty(cond.getPpproctime())){
			c.add(Expression.eq("ppproctime", cond.getPpproctime()));
		}
		if( !StringUtils.isEmpty(cond.getPpuserid())){
			c.add(Expression.eq("ppuserid", cond.getPpuserid()));
		}
		if( !StringUtils.isEmpty(cond.getPpstatus())){
			if("I".equals(cond.getPpstatus())){
				c.add(Expression.or(Expression.eq("ppstatus", "I"),Expression.eq("ppstatus", "D")));
			}else{
				String status = cond.getPpstatus();
				if(status.length() > 3) {
					if (status.indexOf("_") > -1) {
						c.add(Expression.eq("psdid", status.split("_")[0]));
						c.add(Expression.eq("psdnum", status.split("_")[1]));
					} else {
						c.add(Expression.eq("psdid", status));
					}
				} else {
					c.add(Expression.eq("ppstatus", status));
				}
				
			}
		}
		
		if( !StringUtils.isEmpty(cond.getPpstatus_q())){
			String status = cond.getPpstatus_q();
			if(status.length() > 3) {
				if (status.indexOf("_") > -1) {
					c.add(Expression.eq("psdid", status.split("_")[0]));
					c.add(Expression.eq("psdnum", new Integer(status.split("_")[1])));
				} else {
					c.add(Expression.eq("psdid", status));
				}
			} else {
				c.add(Expression.eq("ppstatus", status));
			}
		}
		
		
		if( cond.getPpuseridIsNull()!=null && cond.getPpuseridIsNull().equals("Y")){
			c.add(Expression.isNull("ppuserid"));
		}
		if( cond.getPpuseridIsNull()!=null && cond.getPpuseridIsNull().equals("N")){
			c.add(Expression.isNotNull("ppuserid"));
		}
		if( cond.getPpproctimeIsNull()!=null && cond.getPpproctimeIsNull().equals("Y")){
			c.add(Expression.isNull("ppproctime"));
		}
		if( cond.getPpproctimeIsNull()!=null && cond.getPpproctimeIsNull().equals("N")){
			c.add(Expression.isNotNull("ppproctime"));
		}
		if( cond.getPpidInList()!=null&&cond.getPpidInList().size()>0){
			c.add(Expression.in("ppid",cond.getPpidInList()));
		}	
		if( StringUtils.isNotEmpty(cond.getPpuserid_not())){
			c.add(Expression.ne("ppuserid",cond.getPpuserid_not()));
		}	
		//流程状态定义ID等值查询
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.like("psdid", cond.getPsdid() + "%"));
		}
		//动态分支编号等值查询
		if(cond.getPsdnum() != null && cond.getPsdnum() > 0){
			c.add(Expression.eq("psdnum", cond.getPsdnum()));
		}
		if(StringUtils.isNotBlank(cond.getPpbacktime_isNull())){
			if(cond.getPpbacktime_isNull().equals("0")){
				//不为空
				c.add(Expression.isNotNull("ppbacktime"));
			}else{
				//为空
				c.add(Expression.isNull("ppbacktime"));
			}
		}
		return c;
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG337Info> findByCondRun(final IG337SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG337DAO.findByCondRun").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("prid", cond.getPrid());
				setFetchPoint(q, 0, 0);
				q.addEntity("pptb",IG337TB.class);
				List<IG222Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG337Info>) execute(action);
	}
}
